package growthGaNUsingGaHx.paramSetter;

public class InitialParam {

	private final int		sourceEquationNumber	= 7;
	private final int		growthEquationNumber	= 9;
	private final int		sourceKNumber			= 5;
	private final int		growthKNumber			= 6;
	private final int		sourceP0Number			= 4;
	private final int		growthP0Number			= 8;
	private static double	pAll					= 1.0;
	private static double	f0						= 0.5;
	private static double	p0III					= 1e-5;
	private static double	VIII					= 100.0;
	private static double	sourceTemperature		= 1000.0;
	private static double	growthTemperature		= 1500.0;
	private static double	alpha					= 0.02;
	private static double	beta					= 0.80;

	private static double	sourceP[];

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
		InitialParam.alpha = alpha;
	}

	public void setBeta(double beta) {
		InitialParam.beta = beta;
	}

	public void setF0(double f0) {
		InitialParam.f0 = f0;
	}

	public void setGrowthTemperature(double growthTemperature) {
		InitialParam.growthTemperature = growthTemperature;
	}

	public void setP0III(double p0iii) {
		InitialParam.p0III = p0iii;
	}

	public void setPall(double pAll) {
		InitialParam.pAll = pAll;
	}

	public void setSourceP(double sourceP[]) {
		InitialParam.sourceP = sourceP;
	}

	public void setSourceTemperature(double sourceTemperature) {
		InitialParam.sourceTemperature = sourceTemperature;
	}

	public void setVIII(double vIII) {
		InitialParam.VIII = vIII;
	}

}