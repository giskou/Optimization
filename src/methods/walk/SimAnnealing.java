/**
 * 
 */
package methods.walk;

import java.util.LinkedList;

import com.sun.org.apache.bcel.internal.generic.FSTORE;

import libs.*;

/**
 * @author iskoulis
 *
 */
public class SimAnnealing extends RandomWalkExploit {

	public static Result run(Input input) {
		LinkedList<Point> z = new LinkedList<Point>();
		SAInput in = (SAInput) input;
		double x0[] = new double[in.dim];
		for (int i = 0; i < in.dim; i++) {
			double range = in.range.max[i] - in.range.min[i];
			x0[i] = Math.random()*range + in.range.min[i];
		}
		long steps = 1;
		double t = 1;
		Point pRand = null, pNew, pOld = new Point(x0);
		try {
			while (steps < in.steps) {
				steps++;
				pRand = rand(in.dim);
				double step = bestStep(pOld, pRand, input, 1000);
				pNew = Point.add(pOld, pRand.mull(step));
				if (Math.random() < in.af.A(in.func, pOld, pNew, t)) {
					pOld = pNew;
				}
				steps += 2;
				z.push(pOld);
				t = in.cs.U(z); steps++;
			}
			steps++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		double value = in.func.f(pOld); steps++;
		Result res = new Result(pOld, value, steps);
		return res;
	}
}

