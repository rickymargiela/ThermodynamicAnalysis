package growthGaNUsingGaHx.paramSetter;

public class GrowthMixingParam {
	private final double[] p0;
	private double         pAll;
	private final double   p0III;
	private final double   f0;
	private final double   alpha;
	InitialParam           initialParam = new InitialParam();

	public GrowthMixingParam(double[] p) {
		p0 = new double[initialParam.getGrowthP0Number()];
		pAll = initialParam.getPall();
		p0III = p[0] + p[1] + p[2] + p[3];
		f0 = initialParam.getF0();
		alpha = initialParam.getAlpha();
		p0[0] = p[0];
		p0[1] = p[1];
		p0[2] = p[2];
		p0[3] = p[3];
		p0[4] = p[5];
		p0[6] = initialParam.getVIII() * p0III * (1 - alpha);
		p0[5] = (p[4] + (pAll - p0[6]) * f0 + 1.5 * p0III * initialParam.getVIII() * alpha);
		p0[7] = (p[6] + (pAll - p0[6] * (1 - f0) + 0.5 * p0III * initialParam.getVIII() * alpha));

		for (int i = 0; i < initialParam.getGrowthP0Number(); i++) {
			pAll += p0[i];
		}
		initialParam.setPall(pAll);

		for (int i = 0; i < initialParam.getGrowthP0Number(); i++) {
			p0[i] = p0[i] / pAll;
		}
	}

	public double[] getP0() {
		return p0;
	}
}
