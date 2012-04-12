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
public class Metropolis implements AcceptanceFunction {

	@Override
	public double A(Function f, Point x, Point y, double t) {
		return Math.min(1, Math.exp(- ((f.f(y)-f.f(x)) / t ) ) );
	}
	
}
