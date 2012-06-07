/**
 * 
 */
package methods.swarm;

import libs.Point;

/**
 * @author giskou
 *
 */
public abstract class Network {
	
	Point best;
	
	public abstract Neighborhood getNeighborhood(Swarm s, Particle p, int index);
	
	public class Neighborhood {
		
		int size;
		Particle[] n;
		Particle best;
		
		public Neighborhood(int size) {
			this.size = size;
			this.n = new Particle[size];
		}
		
		public double[] best() {
			Particle best = n[0];
			for (int i = 1; i < this.size; i++) {
				if (n[i].bestValue < best.bestValue) {
					best = n[i];
				}
			}
			return best.ownBest;
		}
	}
}
