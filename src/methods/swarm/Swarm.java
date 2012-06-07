/**
 * 
 */
package methods.swarm;

import libs.Input;

/**
 * @author giskou
 *
 */
public class Swarm {
	int size;
	Particle[] particles;
	
	public Swarm(int size, Input in) {
		this.size = size;
		particles = new Particle[size];
		initialize(in);
	}
	
	private void initialize(Input in) {
		for (int i = 0; i < this.size; i++) {
			particles[i] = new Particle(in);
		}
	}
	
	int getParIndex(Particle p) {
		for (int i = 0; i < this.size; i++) {
			if (particles[i].equals(p)){
				return i;
			}
		}
		return -1;
	}
}
