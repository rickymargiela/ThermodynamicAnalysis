package growthGaNUsingGaHx.paramSetter;

public interface IZoneParam {
	IZoneParam setParam(double[] p);

	double[][] getDvp();

	double[][] getDvm();

	double[] getVp();

	double[] getVm();
}
