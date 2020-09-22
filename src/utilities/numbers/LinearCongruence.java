package utilities.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase permite generar n�meros pseudoaleatorios, haciendo uso de la
 * t�cnica de congruencia lineal. V�ase el m�todo generate(int).
 * 
 * @author Fredy Gamba
 *
 */
public class LinearCongruence {

	/**
	 * Este m�todo permite generar n�meros pseudoaleatorios, haciendo uso de la
	 * t�cnica de congruencia lineal.
	 * @param amount Cantidad de n�meros a generar
	 * @return Lista de n�meros pseudoaleatorio entre 0 a 1
	 */
	public List<Double> generate(int amount) {
		List<Double> dataset = new ArrayList<Double>();
		int seed = (int) (Math.random() * 1000.0);
		double k = 4; // TO DO
		double c = 6; // TO DO
		double g = 7; // TO DO
		double a = 1 + (2 * k);
		double m = (double) Math.pow(2, g);
		for (int i = 0; i < amount; i++) {
			double Xi = ((a * seed) + c) % m;
			dataset.add(Xi / (m - 1));
			seed = (int) Xi;
		}
		return dataset;
	}

}