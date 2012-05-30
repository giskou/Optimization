/**
 * 
 */
package libs.functions.cooling;

import java.util.LinkedList;

import libs.Point;

/**
 * @author iskoulis
 *
 */
public interface CoolingSchedule {
	public double U(LinkedList<Point> z);
}
