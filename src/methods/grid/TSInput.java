/**
 * 
 */
package methods.grid;

import libs.*;
import libs.functions.Function;

/**
 * @author iskoulis
 *
 */
public class TSInput extends Input {
	
	int listSize;
	int ppc;
	int gridSize;
	double fStar;
	double prec;

	public TSInput(Function func, Range range, double steps, double fStar, double prec, int gridSize, int listSize, int pointsPerCell) {
		super(func, range, steps);
		this.listSize = listSize;
		this.ppc = pointsPerCell;
		this.gridSize = gridSize;
		this.fStar = fStar;
		this.prec = prec;
	}
}
