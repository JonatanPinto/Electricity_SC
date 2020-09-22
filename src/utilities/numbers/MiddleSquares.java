package utilities.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Permite calcular cuadrados medios. Véase calculateMiddelSquares(int, int,
 * int).
 * 
 * @author User
 *
 */
public class MiddleSquares {

	public List<Double> generate(int amount) {
		List<Double> dataset = new ArrayList<Double>();
		int seed = (int) (Math.random() * 10000);
		System.out.println(seed);
		for (int i = 0; i < amount; i++) {
			int Xi2 = (int) Math.pow(seed, 2);
			int extraction = Integer.parseInt(splice(Xi2, 8).substring(2, 6));
			seed = extraction;
			dataset.add((double) extraction / 10000.0);
		}
		return dataset;
	}

	/**
	 * Permite empalmar un número (agregar ceros a la izquierda) basado en el
	 * número de dígitos que se desea tener como resultado.
	 * 
	 * @param number Número a empalmar
	 * @param digits Número de dígitos que se desea tener como resultado.
	 * @return Cadena de texto que contiene el empalme realizado.
	 */
	private String splice(int number, int digits) {
		String sNumber = "" + number;
		int length = sNumber.length();
		if (length < 8) {
			for (int i = length; i < digits; i++) {
				sNumber = "0" + sNumber;
			}
		}
		return sNumber;
	}

}