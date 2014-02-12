package growthGaNUsingGaHx.paramSetter;

public class InitialParam {

	private final int		sourceEquationNumber;
	private final int		growthEquationNumber;
	private final int		sourceKNumber;
	private final int		growthKNumber;
	private final int		sourceP0Number;
	private final int		growthP0Number;
	private double			pAll;
	private double			f0;
	private double			p0III;
	private double			VIII;
	private double			sourceTemperature;
	private double			growthTemperature;
	private double			alpha;
	private double			beta;

	private static double	sourceP[];

	public InitialParam() {
		sourceEquationNumber = 7;
		growthEquationNumber = 9;

		sourceKNumber = 5;
		growthKNumber = 6;

		sourceP0Number = 4;
		growthP0Number = 8;

		pAll = 1.0;
		f0 = 0.5;
		p0III = 1e-5;
		VIII = 100.0;
		sourceTemperature = 500.0;
		growthTemperature = 1000.0;

		alpha = 0.02;
		beta = 0.80;

	}

	public double getAlpha() {
		return alpha;
	}

	public double getBeta() {
		return beta;
	}

	public double getF0() {
		return f0;
	}

	public int getGrowthEquationNumber() {
		return growthEquationNumber;
	}

	public int getGrowthKNumber() {
		return growthKNumber;
	}

	public int getGrowthP0Number() {
		return growthP0Number;
	}

	public double getGrowthTemperature() {
		return growthTemperature;
	}

	public double getP0III() {
		return p0III;
	}

	public double getPall() {
		return pAll;
	}

	public int getSourceEquationNumber() {
		return sourceEquationNumber;
	}

	public int getSourceKNumber() {
		return sourceKNumber;
	}

	public double[] getSourceP() {
		return sourceP;
	}

	public int getSourceP0Number() {
		return sourceP0Number;
	}

	public double getSourceTemperature() {
		return sourceTemperature;
	}

	public double getVIII() {
		return VIII;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public void setF0(double f0) {
		this.f0 = f0;
	}

	public void setGrowthTemperature(double growthTemperature) {
		this.growthTemperature = growthTemperature;
	}

	public void setP0III(double p0iii) {
		p0III = p0iii;
	}

	public void setPall(double pAll) {
		this.pAll = pAll;
	}

	public void setSourceP(double sourceP[]) {
		InitialParam.sourceP = sourceP;
	}

	public void setSourceTemperature(double sourceTemperature) {
		this.sourceTemperature = sourceTemperature;
	}

	public void setVIII(double vIII) {
		VIII = vIII;
	}

}