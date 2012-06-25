/**
 * 
 */
package methods.evolution.harmony;

import java.util.Iterator;
import java.util.Random;

import libs.Input;
import libs.Point;
import libs.Range;
import libs.Result;
import libs.functions.Function;
import methods.Method;
import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author iskoulis
 *
 */
public class HarmonySearch extends Method {
	
	private static HSInput in;
	private static Population pop;
	
	public static Result run(Input input){
		in = (HSInput) input;
		float HMCR = in.HMCR;
		float w = in.w;
		int steps = 0, counter = 0;;
		pop = initialize(in.func, in.range, in.mSize, in.dim);
		Citizen best = pop.best();
		steps += in.mSize;
		while((in.steps > steps) && (best.getValue() > in.prec)) {
			Population newPop = buildNewHarmony(in.newSize);
			newPop = evaluateNewHarmony(newPop);
			steps += in.newSize;
			updateHarmonyMemory(newPop);
			if (pop.best().getValue() < best.getValue()) {
				/* every time we get a new best HMCR is getting smaller */
				best = pop.best();
				in.HMCR *= in.cf;
				counter = 0;
			} else if (counter > in.steps/40){
				/* if 1/40 of the computations passes without a new best
				 * we reset the HMCR */
				in.HMCR = HMCR;
				in.w = w;
				counter = 0;
			} else {
				counter++;
			}
			if(steps % (in.steps/100) == 0) {
				/* w gets smaller as time passes */
				in.w *= in.cf;
			}
		}
		
		Result res = new Result(best.point(), best.getValue(), steps);
		return res;
	}

	/**
	 * Initialize Memory
	 *
	 */
	private static Population initialize(Function f, Range r, int size, int dim) {
		Random rand = new Random(System.currentTimeMillis());
		Population pop = new Population();
		for (int i = 0; i < size; i++) {
			double[] p = new double[dim];
			for (int j = 0; j < dim; j++) {
				p[j] = rand.nextDouble()*(r.max[j]-r.min[j]) + r.min[j];
			}
			Point pt = new Point(p);
			double value = f.f(pt);
			pop.add(pt, value);
		}
		return pop;
	}
	
	private static Population buildNewHarmony(int size) {
		Population newPop = new Population();
		Object[] mem = pop.getItems().toArray();
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < size; i++) {
			double[] c = new double[in.dim];
			for (int j = 0; j < in.dim; j++) {
				if (rand.nextFloat() <= in.HMCR) { // combine
					c[j] = ((Citizen)mem[rand.nextInt(pop.size())]).point().p[j];
				} else {
					c[j] = rand.nextDouble() * (in.range.max[j] - in.range.min[j]);
				}
				if (rand.nextFloat() <= in.PAR) { // mutate
					double q = rand.nextFloat()*2 - 1;
			//		double q = rand.nextGaussian();
					c[j] += q*in.w;
				}
			}
			newPop.add(new Point(c), 0);
		}
		return newPop;
	}
	
	private static Population evaluateNewHarmony(Population pop) {
		Population newPop = new Population();
		Iterator<Citizen> it = pop.getItems().iterator();
		for (int i = 0; i < pop.size(); i++) {
			Citizen c = it.next();
			double v = in.func.f(c.point());
			newPop.add(c.point(), v);
		}
		return newPop;
	}
	
	private static void updateHarmonyMemory(Population newPop) {
		Iterator<Citizen> it = newPop.getItems().iterator();
		while(it.hasNext()) {
			Citizen cit = it.next();
			if (cit.getValue() < pop.getItems().last().getValue()) {
				pop.getItems().remove(pop.getItems().last());
				pop.add(cit);
			}
		}
	}
}
