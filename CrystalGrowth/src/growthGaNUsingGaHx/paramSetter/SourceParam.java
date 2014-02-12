package growthGaNUsingGaHx.paramSetter;

public class SourceParam implements IZoneParam {
	private int			equationNumber;
	private int			kNumber;
	private double[]	p0;

	private double[]	k;
	private double[]	vp;
	private double[]	vm;
	private double[][]	dvp;
	private double[][]	dvm;
	private double		temperatureK;
	private double		f;

	InitialParam		initialParam	= new InitialParam();
	SourceMixingParam	sourceMixing	= new SourceMixingParam();
	SourceKFittingParam	kFittingParam	= new SourceKFittingParam();

	@Override
	public double[][] getDvm() {
		return dvm;
	}

	@Override
	public double[][] getDvp() {
		return dvp;
	}

	@Override
	public double[] getVm() {
		return vm;
	}

	@Override
	public double[] getVp() {
		return vp;
	}

	public void setDvm(double[][] dvm) {
		this.dvm = dvm;
	}

	public void setDvp(double[][] dvp) {
		this.dvp = dvp;
	}

	@Override
	public SourceParam setParam(double[] p) {
		sourceMixing = new SourceMixingParam();
		kFittingParam = new SourceKFittingParam();

		equationNumber = initialParam.getSourceEquationNumber();
		kNumber = initialParam.getSourceKNumber();
		p0 = sourceMixing.getP0();
		k = new double[kNumber];
		vp = new double[equationNumber];
		vm = new double[equationNumber];

		f = (p0[0] + 0.5 * p0[1]) / (p0[0] + 0.5 * p0[1] + p0[2]);

		temperatureK = 273.15 + initialParam.getSourceTemperature();

		for (int i = 0; i < kNumber; i++) {
			k[i] = Math
					.pow(10.0,
							(kFittingParam.getSourceKFittingParam()[i][0]
									+ (kFittingParam.getSourceKFittingParam()[i][1] / temperatureK) + (kFittingParam
									.getSourceKFittingParam()[i][2] * Math
									.log10(temperatureK))));
		}

		vp[0] = initialParam.getPall();
		vp[1] = f * (0.5 * p[1] + p[2] + 1.5 * p[3] + 0.5 * p[5] + p[4] + p[6]);
		vp[2] = k[4] * Math.pow(p[4], 1.5);
		vp[3] = k[0] * p[0] * p[5];
		vp[4] = k[1] * p[1] * p[5];
		vp[5] = k[2] * p[2] * p[5];
		vp[6] = k[3] * Math.pow(p[4], 0.5);

		vm[0] = p[0] + p[1] + p[2] + p[3] + p[4] + p[5] + p[6];
		vm[1] = 0.5 * p[1] + p[2] + 1.5 * p[3] + 0.5 * p[5] + p[4];
		vm[2] = p[3];
		vm[3] = p[1];
		vm[4] = p[2];
		vm[5] = p[3];
		vm[6] = p[5];

		setDvp(new double[][] { { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0.5 * f, f, 1.5 * f, f, 0.5 * f, f },
				{ 0, 0, 0, 0, 0, 1.5 * k[4] * p[0] * Math.pow(p[4], 0.5), 0 },
				{ k[0] * p[5], 0, 0, 0, 0, k[0] * p[0], 0 },
				{ 0, k[1] * p[5], 0, 0, 0, k[1] * p[1], 0 },
				{ 0, 0, k[2] * p[5], 0, 0, k[2] * p[2], 0 },
				{ 0, 0, 0, 0, 0.5 * k[3] * Math.pow(p[4], -0.5), 0, 0 } });

		setDvm(new double[][] { { 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0.5, 1, 1.5, 1, 0.5, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0 } });

		return this;
	}
}
