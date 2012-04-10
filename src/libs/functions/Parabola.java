/**
 * 
 */
package libs.functions;

import libs.Point;

/**
 * @author iskoulis
 *
 */
public class Parabola implements Function{
	
	private double step;
	
	public Parabola(double step) {
		this.step = step;
	}

	@Override
	public double f(Point x) {
		return Math.pow(x.p[0] + step, 2);
	}
}
