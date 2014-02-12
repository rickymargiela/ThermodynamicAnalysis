package generator;

import java.util.Random;

public class GenerationFirstP {
	public double[] generateFirstP(int equationNumber) {
		long seed = System.currentTimeMillis();
		double[] p = new double[equationNumber];

		Random factorOfRandom = new Random(seed);
		for (int i = 0; i < equationNumber - 1; i++) {
			p[i] = Math.pow(10, (-10.0) * factorOfRandom.nextDouble() - 5.0);
		}

		p[equationNumber - 1] = Math.pow(10,
				(-2.0) * factorOfRandom.nextDouble());// IG
		return p;
	}
}
