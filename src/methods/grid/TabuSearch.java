/**
 * 
 */
package methods.grid;

import java.util.LinkedList;
import java.util.ListIterator;

import libs.*;
import methods.Method;

/**
 * @author iskoulis
 *
 */
public class TabuSearch extends Method {
	
	private static TabuList tList;

	public static Result run(Input input) {
		TSInput in = (TSInput)input;
		tList = new TabuList(in.listSize);
		long steps = 0;
		double x0[] = new double[in.dim];
		double d[] = new double[in.dim];
		double s[] = new double[in.dim];
		for (int i = 0; i < in.dim; i++) {
			double range = in.range.max[i] - in.range.min[i];
			x0[i] = Math.random()*range + in.range.min[i];
			d[i] = Math.abs(input.range.min[i] - input.range.max[i]);
			s[i] = d[i] / Math.round(in.gridSize);
		}
		Point pNew, pOld = new Point(x0);
		double fNew, fOld = in.func.f(pOld); steps++;
		int cell[] = new int[in.dim];
		while ((steps < in.steps) && ( (fOld-in.fStar) > in.prec )) {
			for (int i = 0; i < in.dim; i++) {
				cell[i] = (int) (Math.random()*in.listSize);
			}
			if (!tList.contains(cell)) {
				tList.add(cell);
				for (int i = 0; i < in.ppc; i++) {
					double p[] = new double[in.dim];
					for (int j = 0; j < in.dim; j++) {
						p[j] = (Math.random()*s[j]) + in.range.min[0] + (s[j]*cell[0]);
					}
					pNew = new Point(p);
					fNew = in.func.f(pNew); steps++;
					if (fNew < fOld) {
						pOld = pNew;
						fOld = fNew;
					}
				}
			}
		}
		Result res = new Result(pOld, fOld, steps);
		return res;
	}
	
	@SuppressWarnings("serial")
	public static class TabuList extends LinkedList<int[]> {
		
		private int tSize;
		
		public TabuList(int size) {
			this.tSize = size;
		}
		
		public boolean add(int[] a) {
			if (super.size() == tSize){
				super.removeLast();
			}
			int n[] = {a[0], a[1]};
			super.add(n);
			return true;
		}
		
		public boolean contains(int[] a) {
			ListIterator<int[]> itr = tList.listIterator();
			while(itr.hasNext()) {
				int b[] = itr.next();
				if (b[0] == a[0] && b[1] == a[1]){
					return true;
				}
			}
			return false;
		}
	}
}
