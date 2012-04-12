/**
 * 
 */
package libs.functions.acceptance;

import libs.Point;
import libs.functions.Function;

/**
 * @author iskoulis
 *
 */
public class Barkley implements AcceptanceFunction {

	@Override
	public double A(Function f, Point x, Point y, double t) {
		return 1 / (1 + Math.exp( (f.f(y) - f.f(x)) / t ));
	}
}
