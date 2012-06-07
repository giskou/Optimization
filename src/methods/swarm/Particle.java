/**
 * 
 */
package methods.swarm;

import libs.Input;
import libs.Point;
import libs.functions.Function;
/**
 * @author giskou
 *
 */
public class Particle extends Point{

	double[] v;
	double[] ownBest;
	double[] nBest;
	double bestValue;
	double value;
	
	public Particle(Input in) {
		super(in.dim);
		ownBest = new double[dim];
		v = new double[dim];
		for (int i = 0; i < super.dim; i++) {
			p[i] = Math.random()*(in.range.max[i] - in.range.min[i]) + in.range.min[i];
			ownBest[i] = p[i];
			v[i] = 0;
		}
		this.value = in.func.f(this);
		this.bestValue = this.value;
	}
	
	public void setNBest(double[] neighborBest) {
		this.nBest = neighborBest;
	}
	
	public void move(float cc, float c1, float c2) {
		for (int i = 0; i < super.dim; i++) {
			double r1 = Math.random();
			double r2 = Math.random();
			v[i] = cc*(v[i] + c1*r1*(ownBest[i] - p[i]) + c2*r2*(nBest[i] - p[i]));
			p[i] += v[i];
		}
	}
	
	public double update(Function f) {
		this.value = f.f(this);
		if (this.value < bestValue) {
			bestValue = this.value;
			for (int i = 0; i < super.dim; i++) {
				ownBest[i] = p[i];
			}
		}
		return bestValue;
	}
}
