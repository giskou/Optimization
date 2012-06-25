/**
 * 
 */
package methods.swarm.aco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

import libs.Input;
import libs.Point;
import libs.Result;

/**
 * @author giskou
 *
 */
public class ACOMinMax {
	
	private static class Pheromone {
		TreeMap<Integer, Float[]> map;
		float min, max;
		public Pheromone(int dim, int[] domain) {
			map = new TreeMap<Integer, Float[]>();
			this.min = in.phMin;
			this.max = in.phMax;
			for (int i = 0; i < domain.length; i++) {
				Float[] f = new Float[dim];
				Arrays.fill(f, (float)1);
				map.put(domain[i], f);
			}
		}
	}
	public static class Pair<F, S> {
		private F value;
		private S point;
	}

	private static ACOMMInput in;
	private static Pheromone ph;
	private static Pair<Double, Point> best;
	private static int counter;
	
	public static Result run(Input input){
		in = (ACOMMInput) input;
		ph = new Pheromone(in.dim, in.domain);
		int steps = 0;
		ArrayList<Point> sols;
		best = new Pair<Double, Point>();
		best.value = Double.MAX_VALUE;
		do {
			sols = constructSolution(in.colSize);
			updatePheromone(sols);
			steps += sols.size();
		} while((in.steps > steps) && (best.value > in.prec));
		
		Result res = new Result(best.point, best.value, steps);
		return res;
	}
	
	private static ArrayList<Point> constructSolution(int size) {
		ArrayList<Point> res = new ArrayList<Point>();
		ArrayList<Integer> used = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) { // for each solution
			int[] sol = new int[in.dim];
			TreeMap<Float, Integer> probs = new TreeMap<Float, Integer>();
			double sum = 0;
			for (int j = 0; j < in.dim; j++) { // for each coefficient
				Iterator<Integer> it = ph.map.keySet().iterator();
				while(it.hasNext()) { // for each number in domain
					int d = it.next();
					if (used.contains(d)) continue;
					sum += Math.pow(ph.map.get(d)[j], in.a);
					probs.put((float) sum, d);
				}
				float key = probs.ceilingKey((float) (Math.random()*sum));
				sol[j] = probs.get(key);
				used.add(sol[j]);
				probs.clear();
			}
			res.add(new Point(sol));
			used.clear();
		}
		return res;
	}

	private static void updatePheromone(ArrayList<Point> sols) {
		for (int j = 0; j < in.dim; j++) {
			Iterator<Integer> it = ph.map.keySet().iterator();
			while(it.hasNext()) { // for each number in domain
				int d = it.next();
				ph.map.get(d)[j] *= (1-in.p);
				if (ph.map.get(d)[j] < ph.min) {
					ph.map.get(d)[j] = ph.min;
				}
			}
		}
		for (int i = 0; i < sols.size(); i++) {
			Point p = sols.get(i);
			double r = in.func.f(p);
//			if (i == 0) {
//				best.value = r;
//				best.point = sols.get(i);
//			}
			if (r <= best.value) {
				if (r < best.value) {
					best.value = r;
					best.point = sols.get(i);
				}
				if (!in.AS)
				for (int j = 0; j < in.dim; j++) {
					ph.map.get(p.ip[j])[j] += in.p*in.dt;
					if (ph.map.get(p.ip[j])[j] < ph.max) {
						ph.map.get(p.ip[j])[j] = ph.max;
					}
				}
				counter = 0;
			} else if (counter > in.steps/50){
				/* if 1/40 of the computations passes without a new best
				 * we reset the pheromones */
				ph = new Pheromone(in.dim, in.domain);
				counter = 0;
			} else {
				counter++;
			}
			if (in.AS)
			for (int j = 0; j < in.dim; j++) {
				ph.map.get(p.ip[j])[j] += in.p*in.dt;
				if (ph.map.get(p.ip[j])[j] < ph.max) {
					ph.map.get(p.ip[j])[j] = ph.max;
				}
			}
		}
	}
}
