package sSystem;

import generator.GenerationFirstP;
import growthGaNUsingGaHx.paramSetter.GrowthParam;
import growthGaNUsingGaHx.paramSetter.IZoneParam;
import growthGaNUsingGaHx.paramSetter.InitialParam;
import growthGaNUsingGaHx.paramSetter.SourceParam;

public class SSystemMain {
	private double[]	b;
	private double[]	p;
	private int			equationNumber;
	private int			flag;
	private IZoneParam	paramSelector;
	InitialParam		initialParam		= new InitialParam();
	SourceParam			sourceParam			= new SourceParam();
	GrowthParam			growthParam			= new GrowthParam();
	SSystemCalc			sSystemCalc			= new SSystemCalc();
	ConvergenceTest		convTest			= new ConvergenceTest();
	GenerationFirstP	generationFirstP	= new GenerationFirstP();

	public double[] calcP(double[] p, String zoneSelector) {
		flag = 0;
		switch (zoneSelector) {
		case "source":
			paramSelector = sourceParam;
			equationNumber = initialParam.getSourceEquationNumber();
			this.p = p;
			break;

		case "growth":
			paramSelector = growthParam;
			equationNumber = initialParam.getGrowthEquationNumber();
			this.p = p;
			break;
		}

		do {
			this.b = sSystemCalc.calculateB(paramSelector.setParam(this.p),
					this.p, equationNumber);
			for (int i = 0; i < equationNumber; i++) {
				System.out.println("b" + i + "= " + b[i]);
			}

			if (convTest.checkConvergence(this.p, this.b, equationNumber)) {
				flag++;
			}

			for (int i = 0; i < equationNumber; i++) {
				this.p[i] = Math.exp(this.b[i]);
			}

		} while (flag < 3);
		return this.p;
	}
}
