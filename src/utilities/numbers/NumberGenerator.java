package utilities.numbers;

import java.io.IOException;
import java.util.List;

/**
 * Esta clase permite generar n�meros pseudoaleatorios mediante la t�cnica de
 * congruencia lineal.
 * 
 * @author Fredy Gamba
 *
 */
public class NumberGenerator {

	/**
	 * Lista de n�meros pseudoaleatorios Ri.
	 */
	private List<Double> riNumbers;
	/**
	 * Iteranci�n de la lista riNumbers.
	 */
	private int iterator;
	/**
	 * Cantidad de n�meros pseudoaleatorios a generar.
	 */
	private int amount;

	/**
	 * M�todo constructur. Al iniciar el objeto {@link NumberGenerator}, generar
	 * 50 n�meros pseudoaleatorios.
	 */
	public NumberGenerator() {
		iterator = 0;
		this.amount = 50;
		generateRiNumbers(this.amount);
	}

	/**
	 * M�todo constructur. Al iniciar el objeto {@link NumberGenerator}, generar
	 * 50 n�meros pseudoaleatorios.
	 */
	public NumberGenerator(int amount) {
		iterator = 0;
		this.amount = amount;
		generateRiNumbers(this.amount);
	}

	/**
	 * Este m�todo permite obtener un byte pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            M�nimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            M�ximo valor a obtener pseudoaleatoriamente.
	 * @return N�mero de tipo byte generado pseudoaleatoriamente.
	 */
	public byte generateByte(double min, double max) {
		return (byte) Math.round(getPseudoRandomNumber(min, max));
	}

	/**
	 * Este m�todo permite obtener un double pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            M�nimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            M�ximo valor a obtener pseudoaleatoriamente.
	 * @return N�mero de tipo double generado pseudoaleatoriamente.
	 */
	public double generateDouble(double min, double max) {
		return getPseudoRandomNumber(min, max);
	}

	/**
	 * Este m�todo permite obtener un float pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            M�nimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            M�ximo valor a obtener pseudoaleatoriamente.
	 * @return N�mero de tipo float generado pseudoaleatoriamente.
	 */
	public float generateFloat(double min, double max) {
		return (float) getPseudoRandomNumber(min, max);
	}

	/**
	 * Este m�todo permite obtener un int pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            M�nimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            M�ximo valor a obtener pseudoaleatoriamente.
	 * @return N�mero de tipo int generado pseudoaleatoriamente.
	 */
	public int generateInt(double min, double max) {
		return (int) Math.round(getPseudoRandomNumber(min, max));
	}

	/**
	 * Este m�todo, genera una lista de n�meros pseudoaleatoriamente, utilizando
	 * el m�todo de congruencia lineal. Internamente, incluye una validaci�n de
	 * los n�meros a travez de las pruebas de uniformidad, medias y variancias
	 * para n�meros pseudoaletorios.
	 * 
	 * @param amount
	 *            Cantidad de n�mero pseudoaleatorios a generar.
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
	 * Este m�todo permite obtener un short pseudoaleatoriamente entre un rango
	 * (min y max).
	 * 
	 * @param min
	 *            M�nimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            M�ximo valor a obtener pseudoaleatoriamente.
	 * @return N�mero de tipo short generado pseudoaleatoriamente.
	 */
	public short generateShort(int min, int max) {
		return (short) Math.round(getPseudoRandomNumber(min, max));
	}

	/**
	 * Este m�todo, toma un valor dentro de la lista interna de n�meros
	 * pseudoaleatorios generados por la clase {@link NumberGenerator}. Utiliza
	 * un iterador (<b>iterator</b>) para pasar por todos los n�meros. Al
	 * momento de que ha terminado de tomar todos los valores, utiliza el m�todo
	 * generateRiNumbers() para generar m�s n�meros pseudoaletorios para su
	 * pr�ximo uso. A dem�s de esto, utiliza el n�mero pseudoaleatorio para
	 * aplicarle una normalizaci�n al valor, en busqueda de un valor que se
	 * encuentre dentro de un rango espec�fico (<b>min</b> y <b>max</b>).
	 * 
	 * @param min
	 *            M�nimo valor a obtener pseudoaleatoriamente.
	 * @param max
	 *            M�ximo valor a obtener pseudoaleatoriamente.
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