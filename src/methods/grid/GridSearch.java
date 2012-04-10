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
public class GridSearch extends Method {
	
	public static Result run(Input input) {
		int s = 0;
		double dx = Math.abs(input.range.min[0] - input.range.max[0]);
		double dy = Math.abs(input.range.min[1] - input.range.max[1]);
		double ny = Math.sqrt((input.steps*dy)/dx);
		double nx = input.steps / ny;
		
		double a[] = {input.range.min[0], input.range.min[1]};
		Point minp = new Point(a);
		double min = input.func.f(minp); s++;
		
		double sx = dx / Math.round(nx-1);
		double sy = dy / Math.round(ny-1);
		double minx = input.range.min[0];
		double maxx = input.range.max[0];
		double miny = input.range.min[1];
		double maxy = input.range.max[1];
		for (double i = minx; i <= maxx; i += sx) {
			for (double j = miny; j <= maxy; j += sy) {
				double x[] = {i,j};
				double tmp = input.func.f(new Point(x)); s++;
				if (min > tmp) {
					min = tmp;
					minp = new Point(x);
				}
			}
		}
		Result res = new Result(minp, min, s);
		return res;
	}
}
