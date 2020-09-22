package utilities.numbers;

import java.io.IOException;
import java.util.List;

import utilities.files.Chi2Manager;

/**
 * Esta clase permite realizar una prueba de varianzas a un conjunto de datos
 * Ri. Véase los métodos generateResults() y testVarianceTest();
 * @author Fredy Gamba
 *
 */
public class VarianceTest {

	/**
	 * Este método permite calcular la media a un conjunto de datos decimales.
	 * @param dataset Conjunto de valores decimales.
	 * @return Media calculada con el conjunto de datos decimales, pedida como
	 *         parámetro.
	 */
	private double calculateMean(List<Double> dataset) {
		double mean = 0;
		for (Double ri : dataset) {
			mean += ri;
		}
		return mean / dataset.size();
	}

	/**
	 * Este método permite calcular la media a un conjunto de datos decimales.
	 * @param dataset Conjunto de valores decimales
	 * @param mean Valor media de los datos
	 * @return Varianza calculada del conjunto de datos decimales ingresados por
	 *         parámetro.
	 */
	private double calculateVariance(List<Double> dataset, double mean) {
		double variance = 0;
		for (Double data : dataset) {
			variance += Math.pow(data - mean, 2);
		}
		return variance / (dataset.size() - 1);
	}

	/**
	 * Este método permite generar los resultados que se pueden obtener al
	 * realizar una prueba de varianzas sobre un conjunto de datos y un
	 * porcentaje de aceptación.
	 * @param dataset Conjunto de valores Ri
	 * @param acceptancePercentage Porcentaje de aceptación
	 * @return Resultados obtenidos al aplicar la prueba de varianzas sobre el
	 *         conjunto de datos Ri (dataset). El resultado es una lista de
	 *         decimales.<br>
	 *         A continuación, se identifica la representación de cada posición
	 *         del vector de decimales:<br>
	 *         [0] -> Porcentaje de aceptación<br>
	 *         [1] -> Error porcentual 1<br>
	 *         [2] -> Número de datos<br>
	 *         [3] -> Media<br>
	 *         [4] -> Varianza<br>
	 *         [5] -> Error porcentual 2<br>
	 *         [6] -> Error porcentual 3<br>
	 *         [7] -> Valor X1<br>
	 *         [8] -> Valor X2<br>
	 *         [9] -> Límite inferior<br>
	 *         [10] -> Límite superior
	 * @throws IOException
	 *             El método utiliza la carga de valor de distribución de Chi
	 *             cuadrado mediante el uso de un archivo de texto. Esta
	 *             excepción se genera cuando el archivo de texto no se
	 *             encuentra o se ha tenido un error en la lectura del archivo.
	 */
	public boolean test(List<Double> dataset) throws IOException {
		double acceptancePercentage = 95.0;
		Chi2Manager chi2Manager = new Chi2Manager();
		double error = (100 - acceptancePercentage) / 100;
		double n = dataset.size();
		double mean = calculateMean(dataset);
		double variance = calculateVariance(dataset, mean);
		double error2 = error / 2.0;
		double error3 = 1 - error2;
		double X1 = chi2Manager.getChiInv(error2, (int) n - 1);
		double X2 = chi2Manager.getChiInv(error3, (int) n - 1);
		double lowerLimit = X1 / (12.0 * (n - 1));
		double upperLimit = X2 / (12.0 * (n - 1));
		return lowerLimit <= variance && variance <= upperLimit || upperLimit <= variance && variance <= lowerLimit;
	}

	public static void main(String[] args) {
		
	}
}