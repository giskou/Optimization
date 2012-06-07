/**
 * 
 */
package methods.swarm;

import libs.Input;
import libs.Range;
import libs.functions.Function;

/**
 * @author giskou
 *
 */
public class PSOInput extends Input {

	int swarmSize;
	float cc, c1, c2;
	double prec;
	Network net;
	
	public PSOInput(Function func, Range range, double steps, double prec, int swarmSize, float cc, float c1, float c2, Network net) {
		super(func, range, steps);
		this.prec = prec;
		this.swarmSize = swarmSize;
		this.cc = cc;
		this.c1 = c1;
		this.c2 = c2;
		this.net = net;
	}
}
