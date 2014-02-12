package main;

import generator.GenerationFirstP;
import growthGaNUsingGaHx.paramSetter.InitialParam;
import sSystem.SSystemMain;

public class SourceZone {
	GenerationFirstP		generationFirstP	= new GenerationFirstP();
	InitialParam			initialParam		= new InitialParam();
	SSystemMain				sSystemMain			= new SSystemMain();
	private double[]		p					= new double[initialParam
														.getSourceEquationNumber()];
	private final String	zoneSelector		= "source";

	public double[] pSourceZone() {
		// p[0] = 1.1208500651052093E-11;
		// p[1] = 2.514563698560248E-6;
		// p[2] = 3.6607620425705806E-8;
		// p[3] = 7.713053568815406E-12;
		// p[4] = 1.0496702572584173E-5;
		// p[5] = 3.24725404413577E-7;
		// p[6] = 0.11835582799514412;

		p = sSystemMain.calcP(generationFirstP.generateFirstP(initialParam
				.getSourceEquationNumber()), zoneSelector);
		return p;
	}
}
