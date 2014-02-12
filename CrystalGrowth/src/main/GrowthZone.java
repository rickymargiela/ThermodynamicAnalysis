package main;

import generator.GenerationFirstP;
import growthGaNUsingGaHx.paramSetter.InitialParam;
import sSystem.SSystemMain;

public class GrowthZone {
	GenerationFirstP		generationFirstP	= new GenerationFirstP();
	InitialParam			initialParam		= new InitialParam();
	SSystemMain				sSystemMain			= new SSystemMain();
	private double[]		p;
	private final String	zoneSelector		= "growth";

	public double[] pGrowthZone() {
		p = sSystemMain.calcP(generationFirstP.generateFirstP(initialParam
				.getGrowthEquationNumber()), zoneSelector);
		return p;
	}
}
