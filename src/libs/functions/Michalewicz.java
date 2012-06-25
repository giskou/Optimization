/**
 * 
 */
package libs.functions;

import libs.Point;

/**
 * @author giskou
 *
 */
public class Michalewicz implements Function {

	private int m;
	
	public Michalewicz(int m){
		this.m = m;
	}
	
	@Override
	public double f(Point x) {
		double sum = 0;
		for (int i = 0; i < x.dim; i++) {
			sum -= Math.sin(x.p[i]) * Math.pow(Math.sin((i+1)*Math.pow(x.p[i], 2)/Math.PI), 2*m);
		}
		return sum;
	}
}
