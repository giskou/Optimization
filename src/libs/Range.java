/**
 * 
 */
package libs;

/**
 * @author iskoulis
 *
 */
public class Range {
	public double min[];
	public double max[];
	
	public Range(double min[], double max[]) {
		this.min = min.clone();
		this.max = max.clone();
	}
}
