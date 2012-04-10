/**
 * 
 */
package methods.walk;

import libs.Input;
import libs.Point;
import libs.Result;
import methods.Method;

/**
 * @author iskoulis
 *
 */
public class RandomWalk extends Method {
	
	public static Result run(Input in) {
		RWInput input = (RWInput) in;
		double x0[] = new double[in.dim];
		for (int i = 0; i < in.dim; i++) {
			double range = in.range.max[i] - in.range.min[i];
			x0[i] = Math.random()*range + in.range.min[i];
		}
		Point pRand = null, pNew, pOld = new Point(x0);
		double fNew, fOld = in.func.f(pOld);
		long steps = 1;
		double iter = 0;
		boolean newRand = true;
		try{
			do{
				if (newRand) pRand = rand(in.dim);
				pNew = Point.add(pOld, pRand.mull(input.l));
				fNew = input.func.f(pNew); steps++;
				if (fNew >= fOld) {
					iter++;
					if (iter >= input.iter) {
						input.l /= 2;
						if (input.l < input.lmin) {
							Result res = new Result(pOld, fOld, steps);
							return res;
						} else {
							iter = 0;
							newRand = false;
						}
					} else {
						newRand = true;
					}
				} else {
					fOld = fNew;
					pOld = pNew;
					iter = 0;
					newRand = true;
				}
			}while (steps < in.steps);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		Result res = new Result(pOld, fOld, steps);
		return res;
	}
	
	protected static Point rand(int dim) {
		Point p;
		double x[] = new double[dim];
		do{
			for (int i = 0; i < dim; i++) {
				x[i] = Math.random()*2 -1;
			}
			p = new Point(x);
		}while(p.norm() > 1);
		return p.mull(1.0/p.norm());
	}
}
