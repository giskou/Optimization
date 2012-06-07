/**
 * 
 */
package methods.evolution.differential;

import java.util.Iterator;

import libs.Input;
import libs.Result;
import methods.Method;
import methods.evolution.Citizen;
import methods.evolution.GenericEvolution;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class DifferentialEvolution extends Method{
	public static Result run(Input input){
		DEInput in = (DEInput) input;
		int steps = 0;
		Population old = GenericEvolution.initialize(in.func, in.range, in.pSize, in.dim);
		Citizen best = old.best();
//		System.out.println(pop);
		steps += in.pSize;
		while((in.steps > steps) && (best.getValue() > in.prec)) {
//			System.out.println("Mutating");
			Population next = in.m.mutate(old);
//			System.out.println(pop);
			
//			System.out.println("Recombining");
			next = in.r.recombine(next, old, in);
//			System.out.println(pop);

//			System.out.println("Evaluating");
			next = evaluate(next, old, in);
//			System.out.println(pop);
			steps += in.pSize;
			if (next.best().getValue() < best.getValue()) {
				best = old.best();
//				System.out.println(best);
			}
			old = next;
//			System.out.println("---------------------");
		}
		
		Result res = new Result(best.point(), best.getValue(), steps);
		return res;
	}

	private static Population evaluate(Population p, Population old, Input in) {
		Population pop = new Population();
		Iterator<Citizen> itNew = p.getItems().iterator();
		Iterator<Citizen> itOld = old.getItems().iterator();
		for (int i = 0; i < p.size(); i++) {
			Citizen cNew = itNew.next();
			Citizen cOld = itOld.next();
			double v = in.func.f(cNew.point());
			if (v < cOld.getValue()) {
				cNew.setValue(v);
				pop.add(cNew.point(), v);
			} else {
				pop.add(cOld);
			}
		}
		return pop;
	}
}
