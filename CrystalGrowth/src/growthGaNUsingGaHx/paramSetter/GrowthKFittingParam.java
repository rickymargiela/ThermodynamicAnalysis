package growthGaNUsingGaHx.paramSetter;

public class GrowthKFittingParam {

	private final double[][] growthKFittingParam;
	InitialParam             initialParam;

	public GrowthKFittingParam() {
		growthKFittingParam = new double[][] {
		        { -11.30848, 16570.97311, 2.41778 },//GaNÇÃê¨í∑ÇÃÇ∆Ç´
		        //{0.53521,-11196.13826,0.70615},//H2ï™âÇÃÇ∆Ç´
		        { -0.43057, 2310.2, -2.3892 },
		        { -1.2439, 2268.0, -0.15972 },
		        { 1.9334, 9549.3, 2.2388 },
		        { -11.733, 3524.9, 1.8883 },
		        { 2.7551, -23523, 1.2059 } };
	}

	public double[][] getGrowthKFittingParam() {
		return growthKFittingParam;
	}
}
