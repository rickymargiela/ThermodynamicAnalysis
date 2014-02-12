package growthGaNUsingGaHx.paramSetter;

public class SourceMixingParam {
	private final double[]	p0;
	private final double	pAll;
	private final double	f0;
	private final double	beta;
	InitialParam			initialParam	= new InitialParam();

	public SourceMixingParam() {
		p0 = new double[initialParam.getSourceP0Number()];
		pAll = initialParam.getPall();
		f0 = initialParam.getF0();
		beta = initialParam.getBeta();
		p0[0] = (pAll * f0 * (1 - beta)) * (pAll / (1 + beta) * pAll);
		p0[1] = (pAll * f0 * 2 * beta) * (pAll / (1 + beta) * pAll);
		p0[2] = (pAll * (1 - f0)) * (pAll / (1 + beta) * pAll);
	}

	public double[] getP0() {
		return p0;
	}
}
