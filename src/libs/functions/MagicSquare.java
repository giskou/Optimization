/**
 * 
 */
package libs.functions;

import libs.Point;

/**
 * @author giskou
 *
 */
public class MagicSquare implements Function {

	@Override
	public double f(Point x) {
		int[] p = x.ip;
		int n = (int) Math.sqrt(x.dim);
		int magic = n*(n*n + 1)/2;
		int error = 0;
		for (int i = 0; i < n; i++) {
			int sRow = 0;
			int sCol = 0;
			for (int j = 0; j < n; j++) {
				sRow += p[i*n + j];
				sCol += p[j*n + i];
			}
			error += Math.abs(sRow - magic);
			error += Math.abs(sCol - magic);
		}
		int sum = 0;
		for (int i = 0, j = 0; i < n; i++, j++) {
			sum += p[i*n + j];
		}
		error += Math.abs(sum - magic);
		sum = 0;
		for (int i = 0, j = n-1; i < n; i++, j--) {
			sum += p[i*n + j];
		}
		error += Math.abs(sum - magic);
		return error;
	}

}
