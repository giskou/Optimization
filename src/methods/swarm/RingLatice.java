/**
 * 
 */
package methods.swarm;


/**
 * @author giskou
 *
 */
public class RingLatice extends Network{
	
	int range;
	
	public RingLatice(int range) {
		this.range = range;
	}

	public Neighborhood getNeighborhood(Swarm s, Particle p, int index) {
		Neighborhood n = new Neighborhood((range*2)+1);
		for (int j = 0, i = index-range; j < (range*2)+1; i++, j++) {
			int nb = (i%s.size);
			if (nb < 0) nb = s.size + nb;
			n.n[j] = s.particles[nb];
			if (j == 0 || n.best.value < n.n[j].value) {
				n.best = n.n[j];
			}
		}
		return n;
	}

}
