package sSystem;

public class ConvergenceTest {
	private double[] condition;
	private int      convChecker;
	private boolean  convResult;

	public boolean checkConvergence(double[] p, double[] b, int equationNumber) {
		convChecker = 0;
		convResult = false;
		condition = new double[equationNumber];

		for (int i = 0; i < equationNumber; i++) {
			condition[i] = Math.abs(Math.exp(b[i]) - p[i]) / p[i];
		}
		for (int i = 0; i < equationNumber; i++) {
			if (condition[i] > 1e-10) {
				convChecker += 1;
			}
		}

		if (convChecker == 0) {
			convResult = true;
		}
		return convResult;
	}
}
