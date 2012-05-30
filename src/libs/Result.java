/**
 * 
 */
package libs;

/**
 * @author iskoulis
 *
 */
public class Result {
	Point res;
	double value;
	long steps;
	
	public Result(Point res, double value, long steps) {
		this.res = res;
		this.value = value;
		this.steps = steps;
	}
	
	@Override
	public String toString() {
		return this.value + " at " + this.res + " after " + this.steps;
//		return this.value + " " + this.steps;
	}
	
	public Point getRes(){
		return res;
	}
	
	public long getSteps() {
		return this.steps;
	}
}
