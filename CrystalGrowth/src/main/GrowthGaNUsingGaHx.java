package main;

import generator.VariableSelector.VariableParam;
import generator.VariableSelector.VariableType;
import growthGaNUsingGaHx.paramSetter.InitialParam;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GrowthGaNUsingGaHx {// \t
	public static void main(String[] args) {
		final String calcName = "GaNUsingGaHx";
		final String saveDirectory = "/Users/Yu/Documents/calcResult/";
		final String fileFormat = ".csv";
		int convdCounter;
		boolean isConvd;

		final VariableType varType = VariableType.linearScale;
		final VariableParam varParam = VariableParam.sourceTemperature;
		final double varRange1 = 500.0;
		final double varRange2 = 1000.0;
		final int stepNumber = 200;

		int xLoopIndex;
		double varValue = 0.0;
		double[] sourceP;
		double[] growthP;

		SourceZone sourceZone = new SourceZone();
		GrowthZone growthZone = new GrowthZone();

		try {
			PrintStream out = new PrintStream(saveDirectory + calcName
					+ fileFormat);
			System.setOut(out);
			long timeMillisEnd = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy/MM/dd/ HH:mm:ss.SSS");

			InitialParam initialParam = new InitialParam();
			System.out
					.println("********************************** CALCULATION RESULT **********************************");

			System.out.println(",Calc.Date:,"
					+ sdf.format(new Date(timeMillisEnd)));

			System.out
					.println(",--------------- INPUT PARAMETER ---------------");

			System.out.println(",Pall = ," + initialParam.getPall());

			System.out.println(",sourceP0III = ," + initialParam.getP0III());

			System.out.println(",growthP0III= ," + initialParam.getP0III());

			System.out.println(",sourceF0 = ," + initialParam.getF0());

			System.out.println(",growthF0 = ," + initialParam.getF0());

			System.out.println(",VIII = ," + initialParam.getVIII());

			System.out.println(",alpha = ," + initialParam.getAlpha());

			System.out.println(",beta = ," + initialParam.getBeta());

			System.out
					.println(",-----------------------------------------------");
			System.out.println();

			System.out.println("[VARIABLE],[SOURCE ZONE],,,,,,,[GROWTH ZONE]");

			System.out.print(varParam.toString() + ",");
			System.out.print("pGa,");
			System.out.print("pGaH,");
			System.out.print("pGaH2,");
			System.out.print("pGaH3,");
			System.out.print("pH2,");
			System.out.print("pH,");
			System.out.print("pIG,");
			System.out.print("pGa,");
			System.out.print("pGaH,");
			System.out.print("pGaH2,");
			System.out.print("pGaH3,");
			System.out.print("pH,");
			System.out.print("pH2,");
			System.out.print("pNH2,");
			System.out.print("pNH3,");
			System.out.print("pIG,");
			System.out.print("dPIII,");
			System.out.print("dPIII/dP0III,");
			System.out.println();

			for (xLoopIndex = 0; xLoopIndex < stepNumber; xLoopIndex++) {
				switch (varType) {
				case linearScale:
					double _temp = (varRange2 - varRange1) / (stepNumber - 1);
					varValue = varRange1 + _temp * xLoopIndex;
					break;
				case logScale:
					double _temp2 = (Math.log10(varRange2) - Math
							.log10(varRange1)) / (stepNumber - 1);
					varValue = Math.pow(10, Math.log10(varRange1) + _temp2
							* xLoopIndex);
					break;
				}

				switch (varParam) {
				case pAll:
					initialParam.setPall(varValue);
					break;
				case VIII:
					initialParam.setVIII(varValue);
					break;
				case alpha:
					initialParam.setAlpha(varValue);
					break;
				case beta:
					initialParam.setBeta(varValue);
					break;
				case f0:
					initialParam.setF0(varValue);
					break;
				case sourceTemperature:
					initialParam.setSourceTemperature(varValue);
					break;
				case growthTemperature:
					initialParam.setGrowthTemperature(varValue);
					break;
				default:
					break;
				}

				sourceP = new double[initialParam.getSourceEquationNumber()];
				growthP = new double[initialParam.getGrowthEquationNumber()];

				do {
					convdCounter = 0;
					isConvd = true;

					sourceP = sourceZone.pSourceZone();

					for (int i = 0; i < initialParam.getSourceEquationNumber(); i++) {
						if (!Double.isNaN(sourceP[i])
								&& !Double.isInfinite(sourceP[i])) {
							convdCounter += 1;
						}
					}
					if (convdCounter == initialParam.getSourceEquationNumber()) {
						isConvd = false;
					}
				} while (isConvd);

				System.out.print(varValue + ",");
				for (int i = 0; i < initialParam.getSourceEquationNumber(); i++) {
					System.out.print(sourceP[i] + ",");
				}
				initialParam.setSourceP(sourceP);

				do {
					convdCounter = 0;
					isConvd = true;

					growthP = growthZone.pGrowthZone();

					for (int i = 0; i < initialParam.getGrowthEquationNumber(); i++) {
						if (!Double.isNaN(growthP[i])
								&& !Double.isInfinite(growthP[i])) {
							convdCounter += 1;
						}
					}
					if (convdCounter == initialParam.getGrowthEquationNumber()) {
						isConvd = false;
					}
				} while (isConvd);

				for (int i = 0; i < initialParam.getGrowthEquationNumber(); i++) {
					System.out.print(growthP[i] + ",");
				}
				System.out.println();

			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
