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
		p = sSystemMain.calcP(generationFirstP.generateFirstP(initialParam
				.getSourceEquationNumber()), zoneSelector);
		return p;
	}
}
