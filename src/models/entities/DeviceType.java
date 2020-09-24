package models.entities;

public enum DeviceType {

	/**
	 * <h1>Iluminacion</h1> En esta categorï¿½a estï¿½n contemplados todos los
	 * bombillos luz blanca, cï¿½lida y led
	 */
	ILUMINATION("Iluminación"),

	/**
	 * <h1>Electrï¿½nicos</h1> En esta categorï¿½a estï¿½n: <br>
	 * <br>
	 * <b>0</b>: Televisores<br>
	 * <b>1</b>: Hornos microondas<br>
	 * <b>2</b>: Equipos de sonido<br>
	 * <b>3</b>: Computadores de mesa y portï¿½tiles<br>
	 * <b>4</b>: Consolas de videojuegos<br>
	 * <b>5</b>: Grabadoras y radios<br>
	 * <b>6</b>: Cargadores de celular<br>
	 */
	ELECTRONIC("Electrónico"),

	/**
	 * <h1>Electrodomï¿½sticos productores de calor</h1> En esta categorï¿½a
	 * estï¿½n: <br>
	 * <br>
	 * <b>0</b>: Tinas<br>
	 * <b>1</b>: Duchas elï¿½ctricas<br>
	 * <b>2</b>: Planchas de ropa<br>
	 * <b>3</b>: Hornos y estufa<br>
	 * <b>4</b>: Ollas arroceras<br>
	 * <b>5</b>: Cafeteras<br>
	 * <b>6</b>: Secadores de pelo<br>
	 * <b>7</b>: Tostadoras<br>
	 */
	HEAT_PRODUCER("Produce calor"),

	/**
	 * <h1>Electrodomï¿½sticos que funcionan con motor</h1> En esta categorï¿½a
	 * estï¿½n: <br>
	 * <br>
	 * <b>0</b>: Neveras<br>
	 * <b>1</b>: Ventiladores<br>
	 * <b>2</b>: Lavadoras<br>
	 * <b>3</b>: Licuadoras<br>
	 * <b>4</b>: Batidoras<br>
	 * <b>5</b>: Aspiradoras<br>
	 * <b>6</b>: Mï¿½quinas de coser<br>
	 * <b>7</b>: Aires Acondicionados<br>
	 */
	RUN_BY_MOTOR("Funciona con motor");

	private String name;

	private DeviceType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
