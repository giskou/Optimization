/**
 * 
 */
package libs.functions;

import libs.Point;

/**
 * @author iskoulis
 *
 */
public class Rosenbrock implements Function {

	@Override
	public double f(Point x) {
		double ex = Math.pow(x.p[0], 2);
		double a = Math.pow(1-x.p[0], 2);
		double b = Math.pow(x.p[1]-ex, 2);
		return a + (100*b);
	}
}
