/**
 * 
 */
package libs.functions;

import libs.Point;

/**
 * @author iskoulis
 *
 */
public class Ackley implements Function {
	
	private int a;
	private double b;
	private double c;
	private double d;

	public Ackley(int a, double b, double c, double d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Override
	public double f(Point x) {
		double sum1 = 0;
		double sum2 = 0;
		for (int i = 0; i < x.dim; i++) {
			sum1 += Math.pow(x.p[i], 2);
			sum2 += Math.cos(c*x.p[i]);
		}
		return a + Math.exp(1) + d - a*Math.exp(-b*Math.sqrt(sum1/x.dim)) - Math.exp(sum2/x.dim);
	}

}
