package growthGaNUsingGaHx.paramSetter;

public class SourceKFittingParam {

	private final double[][] sourceKFittingParam;
	InitialParam             initialParam = new InitialParam();

	public SourceKFittingParam() {
		sourceKFittingParam = new double[][] {
		        { -1.01137, 13511.18846, -3.08203 },
		        { -12.29849, 14724.8096, 1.1908 },
		        { -2.0517, 13489.85011, -0.78395 },
		        { 0.53521, -11196, 0.70615 },
		        { -7.11656, -5846.3041, -0.84255 } };
	}

	public double[][] getSourceKFittingParam() {
		return sourceKFittingParam;
	}
}
