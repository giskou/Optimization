/**
 * 
 */
package libs.functions.cooling;

import java.util.LinkedList;

import libs.Point;
import libs.functions.Function;

/**
 * @author iskoulis
 *
 */
public class Bohachevsky implements CoolingSchedule {

	double B, a, fStar;
	Function f;
	
	public Bohachevsky(Function f, double fStar, double B, double a) {
		this.B = B;
		this.a = a;
		this.f = f;
		this.fStar = fStar;
	}
	@Override
	public double U(LinkedList<Point> z) {
		return this.B * Math.pow(f.f(z.getFirst())-fStar , this.a);
	}

}
