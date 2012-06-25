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
import methods.Method;

/**
 * @author giskou
 *
 */
public class ACO extends Method {
	
	private static class Pheromone {
		TreeMap<Integer, Float[]> map;
		public Pheromone(int dim, int[] domain) {
			map = new TreeMap<Integer, Float[]>();
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

	private static ACOInput in;
	private static Pheromone ph;
	private static Pair<Double, Point> best;
	
	public static Result run(Input input){
		in = (ACOInput) input;
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
				for (int j = 0; j < in.dim; j++) {
					ph.map.get(p.ip[j])[j] += in.p*in.dt;
				}
			}
//			for (int j = 0; j < in.dim; j++) {
//				ph.map.get(p.ip[j])[j] += in.p*in.dt;
//			}
		}
	}
}
