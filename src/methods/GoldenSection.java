/**
 * 
 */
package methods;

import libs.Input;
import libs.Point;
import libs.Result;

/**
 * @author iskoulis
 *
 */
public class GoldenSection extends Method {
	
	public final static double phi = (1.0+Math.sqrt(5.0))/2.0;

	public static Result run(Input input) {
		GSInput in = (GSInput)input;
		int j = 0;
		double dist, step, f1 = 0, f2 = 0;
		Point x1 = null, x2 = null, x3 ,x4;
		x3 = new Point(in.range.min);
		x4 = new Point(in.range.max);
		dist = x3.dist(x4);
		try {
			do {
				step = dist/Math.pow(phi, 2.0);
				x1 = Point.add(x3, in.dir.mull(step));
				f1 = in.func.f(x1); j++;
				x2 = Point.add(x4, in.dir.mull(-step));
				f2 = in.func.f(x2); j++;
				if (f1 < f2) {
					x4 = x2;
				} else if (f1 > f2){
					x3 = x1;
				} else {
					x3 = x1;
					x4 = x2;
				}
				dist = x3.dist(x4);
			} while ((j < in.steps) && (dist >= in.prec));
			Point res = Point.mid(x3, x4);
			double value = in.func.f(res); j++;
			return new Result(res, value, j);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}


