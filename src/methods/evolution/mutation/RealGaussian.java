/**
 * 
 */
package methods.evolution.mutation;

import java.util.Random;

import libs.Range;

/**
 * @author giskou
 *
 */
public class RealGaussian extends Mutation {

	float scale;
	float factor;
	int rep;
	
	public RealGaussian(Range range, float pr, float factor) {
		super(range, pr);
		this.factor = factor;
		this.scale = 1;
		this.rep = 0;
	}

	protected double mut(double v, int dim) {
		Random r = new Random(System.nanoTime());
		double dj = Math.min(v-range.min[dim], range.max[dim]-v);
		double sigma = dj/3.0;
		double x = v+(sigma*scale)*r.nextGaussian();
		rep ++;
//		switch (rep) {
//			case 1000:
//			case 2000:
//			case 2500:
				this.scale *= this.factor;
//			case 3000:
//				this.scale = 1;
//				rep = 0;
//				break;
//			default: break;
//		}
		return x;
	}
}
