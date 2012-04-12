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
public interface AcceptanceFunction {
	
	public double A(Function f, Point x, Point y, double t);
}
