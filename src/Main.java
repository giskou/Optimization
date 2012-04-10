import libs.*;
import libs.functions.*;
import methods.*;
import methods.grid.*;
import methods.walk.*;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Result res;
		
//		Function f = new Parabola(1);
//		double min[] = {-5.0};
//		double max[] = {5.0};
//		double dir[] = {1};
//		Range range = new Range(min, max);
//		Input i = new GSInput(f, range, 1000, Math.pow(10, -10), new Point(dir));
//		
//		res = GoldenSection.run(i);
		
//		Function f = new Rosenbrock();
//		double start[] = {0, 0};
//		double stop[] = {2, 2};
//		double dir[] = {1,1};
//		Point p = new Point(dir);
//		p = p.mull(1.0/p.norm());
//		Point st = new Point(start);
//		Point end = new Point(stop);
//		Range range = new Range(st.p, end.p);
//		Input i = new GSInput(f, range, 1000, Math.pow(10, -9), p);
//		
//		res = GoldenSection.run(i);
		
//		res = GridSearch.run(i);
		
//		res = RandomJump.run(i);
		
//		Function f = new Rosenbrock();
//		double min[] = {-3.62, -4.23};
//		double max[] = {6.37, 5.77};
//		Range range = new Range(min, max);
//		Input i = new RWInput(f, range, Math.pow(10, 4),0.2,0.0000001,100);
//		
//		res = RandomWalk.run(i);
		
		Function f = new Rosenbrock();
		double min[] = {-3.62, -4.23};
		double max[] = {6.37, 5.77};
		Range range = new Range(min, max);
		Input i = new RWEInput(f, range, Math.pow(10, 5), 40);
		
		res = RandomWalkExploit.run(i);
		
		System.out.println(res);
	}
}
