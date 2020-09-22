package utilities.numbers;

import java.io.IOException;
import java.util.List;

/**
 * Esta clase permite generar números pseudoaleatorios mediante la técnica de
 * congruencia lineal.
 * 
 * @author Fredy Gamba
 *
 */
public class NumberGenerator {

	/**
	 * Lista de números pseudoaleatorios Ri.
	 */
	private List<Double> riNumbers;
	/**
	 * Iteranción de la lista riNumbers.
	 */
	private int iterator;
	/**
	 * Cantidad de números pseudoaleatorios a generar.
	 */
	private int amount;

	/**
	 * Método constructur. Al iniciar el objeto {@link NumberGenerator}, generar
	 * 50 números pseudoaleatorios.
	 */
	public NumberGenerator() {
		iterator = 0;
		this.amount = 50;
		generateRiNumbers(this.amount);
	}

	/**
	 * Método constructur. Al iniciar el objeto {@link NumberGenerator}, generar
	 * 50 números pseudoaleatorios.
	 */
	public NumberGenerator(int amount) {
		iterator = 0;
		this.amount = amount;
		generateRiNumbers(this.amount);
	}

	/**
	 * Este método permite obtener un byte pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            Mínimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            Máximo valor a obtener pseudoaleatoriamente.
	 * @return Número de tipo byte generado pseudoaleatoriamente.
	 */
	public byte generateByte(double min, double max) {
		return (byte) Math.round(getPseudoRandomNumber(min, max));
	}

	/**
	 * Este método permite obtener un double pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            Mínimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            Máximo valor a obtener pseudoaleatoriamente.
	 * @return Número de tipo double generado pseudoaleatoriamente.
	 */
	public double generateDouble(double min, double max) {
		return getPseudoRandomNumber(min, max);
	}

	/**
	 * Este método permite obtener un float pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            Mínimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            Máximo valor a obtener pseudoaleatoriamente.
	 * @return Número de tipo float generado pseudoaleatoriamente.
	 */
	public float generateFloat(double min, double max) {
		return (float) getPseudoRandomNumber(min, max);
	}

	/**
	 * Este método permite obtener un int pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            Mínimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            Máximo valor a obtener pseudoaleatoriamente.
	 * @return Número de tipo int generado pseudoaleatoriamente.
	 */
	public int generateInt(double min, double max) {
		return (int) Math.round(getPseudoRandomNumber(min, max));
	}

	/**
	 * Este método, genera una lista de números pseudoaleatoriamente, utilizando
	 * el método de congruencia lineal. Internamente, incluye una validación de
	 * los números a travez de las pruebas de uniformidad, medias y variancias
	 * para números pseudoaletorios.
	 * 
	 * @param amount
	 *            Cantidad de número pseudoaleatorios a generar.
	 */
	private void generateRiNumbers(int amount) {
		riNumbers = new LinearCongruence().generate(amount);
		UniformityTest uniformityTest = new UniformityTest();
		MeansTest meansTest = new MeansTest();
		VarianceTest varianceTest = new VarianceTest();
		try {
			while (!uniformityTest.test(riNumbers)
					|| !meansTest.test(riNumbers)
					|| !varianceTest.test(riNumbers)) {
				riNumbers = new LinearCongruence().generate(amount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método permite obtener un short pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            Mínimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            Máximo valor a obtener pseudoaleatoriamente.
	 * @return Número de tipo short generado pseudoaleatoriamente.
	 */
	public short generateShort(int min, int max) {
		return (short) Math.round(getPseudoRandomNumber(min, max));
	}

	/**
	 * Este método, toma un valor dentro de la lista interna de números
	 * pseudoaleatorios generados por la clase {@link NumberGenerator}. Utiliza
	 * un iterador (<b>iterator</b>) para pasar por todos los números. Al
	 * momento de que ha terminado de tomar todos los valores, utiliza el método
	 * generateRiNumbers() para generar más números pseudoaletorios para su
	 * próximo uso. A demás de esto, utiliza el número pseudoaleatorio para
	 * aplicarle una normalización al valor, en busqueda de un valor que se
	 * encuentre dentro de un rango específico (<b>min</b> y <b>max</b>).
	 * 
	 * @param min
	 *            Mínimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            Máximo valor a obtener pseudoaleatoriamente.
	 * @return
	 */
	private double getPseudoRandomNumber(double min, double max) {
		double number = 0;
		if (riNumbers.size() > 0) {
			number = riNumbers.get(iterator);
			iterator++;
			if (iterator == riNumbers.size()) {
				iterator = 0;
				generateRiNumbers(this.amount);
			}
		}
		return min + ((max - min) * number);
	}

}