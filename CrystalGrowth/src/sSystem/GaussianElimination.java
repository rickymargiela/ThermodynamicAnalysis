package sSystem;

public class GaussianElimination {
	private double forwardCof, backwardCof, arrangeCof;
	double         objectTemp1, objectTemp2, objectTemp3, objectTemp4, objectTemp5, objectTemp6;

	public double[][] gaussianElimination(int rowNumber, int columnNumber,
	        double[][] object) {

		/////////////////////Pivot Choice///////////////////////
		for (int i = 0; i < rowNumber - 1; i++) {
			int temp = i;
			for (int j = i; j < rowNumber - 1; j++) {
				if (Math.abs(object[temp][i]) < Math.abs(object[j + 1][i])) {
					temp = j + 1;
				}
			}
			for (int k = 0; k < columnNumber; k++) {
				objectTemp1 = object[temp][k];
				object[temp][k] = object[i][k];
				object[i][k] = objectTemp1;
			}
		}

		////////////////////Forward Elimination///////////////////
		for (int i = 0; i < rowNumber - 1; i++) {
			for (int j = i + 1; j < rowNumber; j++) {
				forwardCof = object[j][i] / object[i][i];
				for (int k = i; k < columnNumber - 1; k++) {
					objectTemp1 = object[i][k];
					objectTemp2 = objectTemp1 * forwardCof;
					objectTemp3 = object[j][k] - objectTemp2;
					object[j][k] = objectTemp3;
				}
				objectTemp4 = object[i][columnNumber - 1];
				objectTemp5 = objectTemp4 * forwardCof;
				objectTemp6 = object[j][columnNumber - 1] - objectTemp5;
				object[j][columnNumber - 1] = objectTemp6;
			}
		}

		///////////////////Backward Elimination/////////////////////////
		for (int i = rowNumber - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				backwardCof = object[j][i] / object[i][i];
				for (int k = i; k >= 0; k--) {
					objectTemp1 = object[i][k];
					objectTemp2 = objectTemp1 * backwardCof;
					objectTemp3 = object[j][k] - objectTemp2;
					object[j][k] = objectTemp3;
				}
				objectTemp4 = object[i][columnNumber - 1];
				objectTemp5 = objectTemp4 * backwardCof;
				objectTemp6 = object[j][columnNumber - 1] - objectTemp5;
				object[j][columnNumber - 1] = objectTemp6;
				backwardCof = 0;
			}
		}

		//////////////////////Arrange/////////////////////////////////
		for (int i = 0; i < rowNumber; i++) {
			arrangeCof = object[i][i];
			for (int j = 0; j < columnNumber; j++) {
				objectTemp1 = object[i][j];
				objectTemp2 = objectTemp1 / arrangeCof;
				object[i][j] = objectTemp2;
			}
		}

		return object;
	}

	public double[][] gaussianEliminationTest(int rowNumber, int columnNumber,
	        double[][] object) {

		/////////////////////Pivot Choice///////////////////////
		for (int i = 0; i < rowNumber - 1; i++) {
			int temp = i;
			for (int j = i; j < rowNumber - 1; j++) {
				if (Math.abs(object[temp][i]) < Math.abs(object[j + 1][i])) {
					temp = j + 1;
				}
			}
			for (int k = 0; k < columnNumber; k++) {
				objectTemp1 = object[temp][k];
				object[temp][k] = object[i][k];
				object[i][k] = objectTemp1;
			}
		}

		////////////////////Forward Elimination///////////////////
		for (int i = 0; i < rowNumber - 1; i++) {
			for (int j = i + 1; j < rowNumber; j++) {
				forwardCof = object[j][i] / object[i][i];
				for (int k = i; k < columnNumber - 1; k++) {
					objectTemp1 = object[i][k];
					objectTemp2 = objectTemp1 * forwardCof;
					objectTemp3 = object[j][k] - objectTemp2;
					object[j][k] = objectTemp3;
				}
				objectTemp4 = object[i][columnNumber - 1];
				objectTemp5 = objectTemp4 * forwardCof;
				objectTemp6 = object[j][columnNumber - 1] - objectTemp5;
				object[j][columnNumber - 1] = objectTemp6;
			}
		}

		///////////////////Backward Elimination/////////////////////////
		for (int i = rowNumber - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				backwardCof = object[j][i] / object[i][i];
				for (int k = i; k >= 0; k--) {
					objectTemp1 = object[i][k];
					objectTemp2 = objectTemp1 * backwardCof;
					objectTemp3 = object[j][k] - objectTemp2;
					object[j][k] = objectTemp3;
				}
				objectTemp4 = object[i][columnNumber - 1];
				objectTemp5 = objectTemp4 * backwardCof;
				objectTemp6 = object[j][columnNumber - 1] - objectTemp5;
				object[j][columnNumber - 1] = objectTemp6;
				backwardCof = 0;
			}
		}

		//////////////////////Arrange/////////////////////////////////
		for (int i = 0; i < rowNumber; i++) {
			arrangeCof = object[i][i];
			for (int j = 0; j < columnNumber; j++) {
				objectTemp1 = object[i][j];
				objectTemp2 = objectTemp1 / arrangeCof;
				object[i][j] = objectTemp2;
			}
		}

		return object;
	}
}
