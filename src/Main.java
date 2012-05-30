import libs.*;
import libs.functions.*;
import libs.functions.acceptance.*;
import libs.functions.cooling.*;
import methods.*;
import methods.grid.*;
import methods.walk.*;


public class Main {

	/**
	 * @author iskoulis
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		Function f;
		Input i;
		Result res;
		
//		f = new Parabola(1);
//		double min[] = {-4.0};
//		double max[] = {30.0};
//		double dir[] = {1};
//		Range range = new Range(min, max);
//		i = new GSInput(f, range, 100, Math.pow(10, -6), new Point(dir));
//		
//		res = GoldenSection.run(i);
//		System.out.println(res);
		
//---------------------------------------------------
		
//		f = new Rosenbrock();
//		double start[] = {-3.62, -4.23};
//		double stop[] = {6.37, 5.77};
//		Range range = new Range(start, stop);
//		
//		for (int j = 0; j < 3; j++) {
//			i = new Input(f, range, (long) Math.pow(10, 3+j));
//			res = GridSearch.run(i);
//			System.out.println(res);
//			res = RandomJump.run(i);
//			System.out.println(res + "\n");
//		}
		
//---------------------------------------------------
		
//		f = new Rosenbrock();
//		double min[] = {-3.62, -4.23};
//		double max[] = {6.37, 5.77};
//		Range range = new Range(min, max);
//
//		for (int j = 0; j < 3; j++) {
//			i = new RWInput(f, range, Math.pow(10, 3+j), 0.2, Math.pow(10,-4), 100);
//			res = RandomWalk.run(i);
//			System.out.println(res);
//		}
		
//---------------------------------------------------
		
//		f = new Rosenbrock();
//		double min[] = {-3.62, -4.23};
//		double max[] = {6.37, 5.77};
//		Range range = new Range(min, max);
//		for (int j = 0; j < 3; j++) {
//			i = new RWEInput(f, range, Math.pow(10, 3+j), 20);
//			res = RandomWalkExploit.run(i);
//			System.out.println(res);
//		}
		
//---------------------------------------------------
		
//		f = new Rastrigin(10, 2);
//		double fStar = 0;
//		double min[] = {-5.12, -5.12};
//		double max[] = {5.12, 5.12};
//		Range range = new Range(min, max);
//		AcceptanceFunction af = new Metropolis();
//		CoolingSchedule cs = new Bohachevsky(f, fStar, 0.5, 1);
//		i = new SAInput(f, range, Math.pow(10, 5), af, cs, 1, fStar, Math.pow(10, -2));
//		
//		System.out.println();
//		for (int j = 0; j < 30; j++) {
//			res = SimAnnealing.run(i);
//			System.out.println(res);
//		}
//		
//		af = new Barker();
//		System.out.println();
//		
//		for (int j = 0; j < 30; j++) {
//			res = SimAnnealing.run(i);
//			System.out.println(res);
//		}
//		
//		i = new SAInput(f, range, Math.pow(10, 5), af, cs, 0, fStar, Math.pow(10, -4));
//		af = new Metropolis();
//		System.out.println();
//		
//		for (int j = 0; j < 30; j++) {
//			res = SimAnnealing.run(i);
//			System.out.println(res);
//		}
//		
//		af = new Barker();
//		System.out.println();
//		
//		for (int j = 0; j < 30; j++) {
//			res = SimAnnealing.run(i);
//			System.out.println(res);
//		}
		
//---------------------------------------------------
		
//		f = new Rastrigin(10, 2);
//		double min[] = {-5.12, -5.12};
//		double max[] = {5.12, 5.12};
//		Range range = new Range(min, max);
//		i = new TSInput(f, range, Math.pow(10, 5), 0, Math.pow(10, -3), 10, 10, 100);
//		
//		for (int j = 0; j < 30; j++) {
//			res = TabuSearch.run(i);
//			System.out.println(res);
//		}
	}
}
