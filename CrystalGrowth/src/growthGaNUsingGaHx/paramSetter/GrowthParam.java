package growthGaNUsingGaHx.paramSetter;

public class GrowthParam implements IZoneParam {
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
	GrowthMixingParam	growthMixing;
	GrowthKFittingParam	kFittingParam;

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
	public GrowthParam setParam(double[] p) {
		equationNumber = initialParam.getGrowthEquationNumber();
		kNumber = initialParam.getGrowthKNumber();
		growthMixing = new GrowthMixingParam(initialParam.getSourceP());
		kFittingParam = new GrowthKFittingParam();
		p0 = growthMixing.getP0();

		k = new double[kNumber];
		vp = new double[equationNumber];
		vm = new double[equationNumber];

		f = (0.5 * p0[1] + p0[2] + 1.5 * p0[3] + 0.5 * p0[4] + p0[5] + 1.5 * p0[6])
				/ (0.5 * p0[1] + p0[2] + 1.5 * p0[3] + 0.5 * p0[4] + p0[5]
						+ 1.5 * p0[6] + p0[7]);

		temperatureK = 273.15 + initialParam.getGrowthTemperature();

		for (int i = 0; i < kNumber; i++) {
			k[i] = Math
					.pow(10.0,
							kFittingParam.getGrowthKFittingParam()[i][0]
									+ (kFittingParam.getGrowthKFittingParam()[i][1] / temperatureK)
									+ (kFittingParam.getGrowthKFittingParam()[i][2] * Math
											.log10(temperatureK)));
		}

		vp[0] = initialParam.getPall();
		vp[1] = f
				* (0.5 * p[1] + p[2] + 1.5 * p[3] + 0.5 * p[4] + p[5] + p[6]
						+ 1.5 * p[7] + p[8]);
		vp[2] = initialParam.getP0III() + p[6] + p[7];
		vp[3] = k[0] * p[0] * p[7];// GaN�̐����̏ꍇ
		// vi[3] = Keq[0] * Math.pow(pi[5], 0.5);//0.5H2=H�̎��̏ꍇ
		vp[4] = k[1] * p[0] * Math.pow(p[5], 0.5);
		vp[5] = k[2] * p[2] * Math.pow(p[5], 0.5);
		vp[6] = k[3] * p[3] * p[7];
		vp[7] = k[4] * p[1] * Math.pow(p[5], 0.5);
		vp[8] = k[5] * p[7];

		vm[0] = p[0] + p[1] + p[2] + p[3] + p[4] + p[5] + p[6] + p[7] + p[8];
		vm[1] = 0.5 * p[1] + p[2] + 1.5 * p[3] + 0.5 * p[4] + p[5] + p[6] + 1.5
				* p[7];
		vm[2] = p[0] + p[1] + p[2] + p[3] + p0[6];
		// v_i[3] = Math.pow(pi[5], 1.5);//GaN�̐����̏ꍇ
		vm[3] = p[4];// 0.5H2=H�̎��̏ꍇ
		vm[4] = p[1];
		vm[5] = p[3];
		vm[6] = Math.pow(p[5], 3);
		vm[7] = p[2];
		vm[8] = p[6] * p[4];

		setDvp(new double[][] {
				{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				{ 0.0, 0.5 * f, f, 1.5 * f, 0.5 * f, f, f, 1.5 * f, f },
				{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 },
				{ k[0] * p[7], 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, k[0] * p[0], 0.0 },// GaN�̐����̏ꍇ
				// {0.0,0.0,0.0,0.0,0.0,0.5*Math.pow(pi[5],-0.5),0.0,0.0,0.0},//0.5H2=H�̎��̏ꍇ
				{ k[1] * Math.pow(p[5], 0.5), 0.0, 0.0, 0.0, 0.0,
						k[1] * p[0] * 0.5 * Math.pow(p[5], -0.5), 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, k[2] * Math.pow(p[5], 0.5), 0.0, 0.0,
						k[2] * p[2] * 0.5 * Math.pow(p[5], -0.5), 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, 0.0, k[3] * p[7], 0.0, 0.0, 0.0, k[3] * p[3], 0.0 },
				{ 0.0, k[4] * Math.pow(p[5], 0.5), 0.0, 0.0, 0.0,
						k[4] * p[1] * 0.5 * Math.pow(p[5], -0.5), 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, k[5], 0.0 } });

		setDvm(new double[][] {
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0.0, 0.5, 1.0, 1.5, 0.5, 1.0, 1.0, 1.5, 0.0 },
				{ 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				// {0.0,0.0,0.0,0.0,0.0,1.0*Math.pow(pi[5],0.5),0.0,0.0,0.0},
				{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 },
				{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, 0.0, 0.0, 0.0, 3 * Math.pow(p[5], 2.0), 0.0, 0.0,
						0.0 }, { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, 0.0, 0.0, p[6], 0.0, p[4], 0.0, 0.0 } });

		// for debug

		return this;
	}
}
