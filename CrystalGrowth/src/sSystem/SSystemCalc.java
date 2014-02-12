package sSystem;

import growthGaNUsingGaHx.paramSetter.IZoneParam;

public class SSystemCalc {
	private double[][]	g, h, c, dvp, dvm;
	private double[]	vp, vm, b, sumOfB;
	private int			rowNumber, columnNumber;
	GaussianElimination	gE	= new GaussianElimination();

	public double[] calculateB(IZoneParam zoneParam, double[] p,
			int equationNumber) {
		g = new double[equationNumber][equationNumber];
		h = new double[equationNumber][equationNumber];
		c = new double[equationNumber][equationNumber];
		b = new double[equationNumber];
		sumOfB = new double[equationNumber];

		vp = zoneParam.getVp();
		vm = zoneParam.getVm();
		dvp = zoneParam.getDvp();
		dvm = zoneParam.getDvm();
		rowNumber = equationNumber;
		columnNumber = equationNumber + 1;

		for (int i = 0; i < rowNumber; i++) {
			for (int j = 0; j < rowNumber; j++) {
				g[i][j] = dvp[i][j] * (p[j] / vp[i]);
				h[i][j] = dvm[i][j] * (p[j] / vm[i]);
			}
		}
		for (int i = 0; i < rowNumber; i++) {
			for (int j = 0; j < equationNumber; j++) {
				c[i][j] = g[i][j] - h[i][j];
			}
		}

		for (int i = 0; i < rowNumber; i++) {
			for (int j = 0; j < rowNumber; j++) {
				sumOfB[i] += c[i][j] * Math.log(p[j]);
			}
			b[i] = Math.log(vm[i] / vp[i]) + sumOfB[i];
		}

		double[][] temp = new double[rowNumber][columnNumber];
		for (int i = 0; i < rowNumber; i++) {
			temp[i][rowNumber] = b[i];
			for (int j = 0; j < rowNumber; j++) {
				temp[i][j] = c[i][j];
			}
		}

		temp = gE.gaussianElimination(rowNumber, columnNumber, temp);

		for (int i = 0; i < rowNumber; i++) {
			b[i] = temp[i][equationNumber];
		}

		return b;
	}

}
