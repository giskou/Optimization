/**
 * 
 */
package methods.swarm;

import libs.*;
import methods.Method;
import methods.swarm.Network.Neighborhood;

/**
 * @author giskou
 *
 */
public class PSO extends Method{
	
	public static Result run(Input input){
		PSOInput in = (PSOInput) input;
		int steps = 0;
		Swarm sw = new Swarm(in.swarmSize, in);
		Particle best = sw.particles[0];
		do{
			for (int i = 1; i < sw.size; i++) {
				Neighborhood n = in.net.getNeighborhood(sw, sw.particles[i], i);
				sw.particles[i].setNBest(n.best());
				sw.particles[i].move(in.cc, in.c1, in.c2);
				double value = sw.particles[i].update(in.func); steps++;
				if (value < best.value) {
					best = sw.particles[i];
				}
			}
			
		} while (steps < in.steps && best.bestValue > in.prec);
		
		Result res = new Result(new Point(best.ownBest), best.bestValue, steps);
		return res;
	}
}
