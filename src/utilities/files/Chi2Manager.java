package utilities.files;

import java.io.IOException;
import java.util.List;

public class Chi2Manager {

	private static final String CHI_INV_FILE = "media\\files\\Chi2.txt";
	private double[] degreesOfFreedom = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 45, 50, 55, 60, 65,
			70, 75, 80, 85, 90, 95, 100, 120, 140, 160, 180, 200, 250, 300,
			500, 600 };
	public static double[] probabilities = { 0.001, 0.0025, 0.005, 0.01, 0.025,
			0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.5, 0.55, 0.6,
			0.65, 0.7, 0.75, 0.8, 0.85, 0.9, 0.95, 0.975, 0.99, 0.995, 0.9975,
			0.999, };

	/**
	 * Este método permite obtener el valor de la distribución Chi cuadrado
	 * inversa, a partir de la probabilidad y los grados de libertad. En caso de
	 * que no se encuentre, específicamente la misma probabilidad o los mismos
	 * grados de libertad, el método utilizará una probabilidad o unos grados de
	 * libertad cercanos a los ingresados para encontrar la distribución de Chi
	 * cuadrado inversa.
	 * 
	 * @param probability
	 *            Probabilidad
	 * @param degreesOfFreedom
	 *            Grados de libertad
	 * @return Distribución Chi cuadrada inversa encontrada según la
	 *         probabilidad y los grados de libertad que se hayan ingresado por
	 *         parámetro.
	 * @throws IOException
	 *             Los datos de la distribución de Chi cuadrado inversa, se
	 *             encuentran en un archivo de texto. Esta excepción se genera
	 *             si el archivo de texto no se ha encontrado o se ha tenido
	 *             problemas al leerlo.
	 */
	public double getChiInv(double probability, int degreesOfFreedom)
			throws IOException {
		List<String> lines = FilesManager.readFileLines(CHI_INV_FILE);
		String[] data = lines.get(searchRow(degreesOfFreedom)).split(" ");
		return Double.parseDouble(data[searchColumn(probability)].replace(",",
				"."));
	}

	private int searchColumn(double probability) {
		int column = 0;
		for (int i = 0; i < probabilities.length; i++) {
			if (probabilities[i] >= probability) {
				column = (probability - probabilities[i - 1] <= probabilities[i]
						- probability) ? i - 1 : i;
				break;
			}
		}
		return column;
	}

	private int searchRow(double degreesOfFreedom) {
		int row = 0;
		for (int i = 0; i < this.degreesOfFreedom.length; i++) {
			if (this.degreesOfFreedom[i] >= degreesOfFreedom) {
				row = (degreesOfFreedom - this.degreesOfFreedom[i - 1] <= this.degreesOfFreedom[i]
						- degreesOfFreedom) ? i - 1 : i;
				break;
			}
		}
		return row;
	}

}