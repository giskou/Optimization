/**
 * 
 */
package methods.grid;

import libs.Input;
import libs.Point;
import libs.Result;
import methods.Method;


/**
 * @author iskoulis
 *
 */
public class RandomJump extends Method {

	public static Result run(Input input) {
		long s = 0;
		double a[] = {input.range.min[0], input.range.min[1]};
		Point minp = new Point(a);
		double min = input.func.f(minp); s++;
		double dx = input.range.max[0] - input.range.min[0];
		double dy = input.range.max[1] - input.range.min[1];
		for (long i = 0; i < input.steps-1; i++) {
			double x = Math.random()*dx + input.range.min[0];
			double y = Math.random()*dy + input.range.min[1];
			double p[] = {x,y};
			double tmp = input.func.f(new Point(p)); s++;
			if (min > tmp) {
				min = tmp;
				minp = new Point(p);
			}
		}
		Result res = new Result(minp, min, s);
		return res;
	}
}
