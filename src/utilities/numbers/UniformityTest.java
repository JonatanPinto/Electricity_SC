package utilities.numbers;

import java.io.IOException;
import java.util.List;

import utilities.files.Chi2Manager;

/**
 * Esta clase permite realizar una prueba de uniformidad a un conjunto de datos
 * Ri. Véase los métodos generateIterations() y testUniformity();
 * 
 * @author Fredy Gamba
 *
 */
public class UniformityTest {

	/**
	 * Este método permite contar los números que se encuentra un intervalo
	 * dentro de un conjunto de datos pedidos por parámetro.
	 * 
	 * @param dataset
	 *            Conjunto de datos Ri
	 * @param initial
	 *            Valor inicial del intervalo
	 * @param vFinal
	 *            Valor finald el intervalo
	 * @return Número de valores que se han encontrado dentro del intervalos
	 *         valores del conjunto de datos Ri.
	 */
	private int calculateFrecuency(List<Double> dataset, double initial,
			double vFinal) {
		int frecuency = 0;
		for (int i = 0; i < dataset.size(); i++) {
			double value = dataset.get(i);
			if (initial <= value && value <= vFinal) {
				frecuency++;
			}
		}
		return frecuency;
	}

	/**
	 * Este método permite encontrar el valor mínimo dentro de una lista datos
	 * decimales.
	 * 
	 * @param dataset
	 *            Conjunto de datos decimales.
	 * @return Valor mínimo encontrado.
	 */
	private double findMinor(List<Double> dataset) {
		double minor = dataset.get(0);
		for (int i = 0; i < dataset.size(); i++) {
			if (dataset.get(i) < minor) {
				minor = dataset.get(i);
			}
		}
		return minor;
	}

	/**
	 * Este método permite encontrar el valor máximo de una lista da de datos
	 * decimales.
	 * 
	 * @param dataset
	 *            Conjunto de datos decimiales.
	 * @return Valor máximo encontrado.
	 */
	private int findMayor(List<Double> dataset) {
		double mayor = dataset.get(0);
		int mayorIndex = 0;
		for (int i = 0; i < dataset.size(); i++) {
			if (dataset.get(i) > mayor) {
				mayor = dataset.get(i);
				mayorIndex = i;
			}
		}
		return mayorIndex;
	}

	public boolean test(List<Double> dataset) throws IOException {
		int intervals = 8;
		double minor = findMinor(dataset);
		double mayor = dataset.get(findMayor(dataset));
		double initial = minor;
		double vFinal = 0;
		double frequencyObtained = 0;
		double expectedFrequency = dataset.size() / (double) intervals;
		double sumChi2 = 0;
		double chi2Inv = new Chi2Manager().getChiInv(0.05, intervals - 1);
		for (int i = 0; i < intervals; i++) {
			vFinal = (i == intervals - 1) ? mayor : initial
					+ ((mayor - minor) / intervals);
			frequencyObtained = calculateFrecuency(dataset, initial, vFinal);
			sumChi2 += Math.pow(frequencyObtained - expectedFrequency, 2)
					/ expectedFrequency;
			initial = vFinal;
		}
		return sumChi2 < chi2Inv;
	}

}