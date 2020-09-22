package models.entities;

public enum DeviceType {

	/**
	 *  <h1>Iluminacion </h1>
	 * En esta categoría están contemplados todos los bombillos luz blanca, cálida y led
	 */
	ILUMINATION(""),
	
	/**
	 * <h1>Electrónicos </h1>
	 * En esta categoría están: <br><br>
	 *         <b>0</b>: Televisores<br>
	 *         <b>1</b>: Hornos microondas<br>
	 *         <b>2</b>: Equipos de sonido<br>
	 *         <b>3</b>: Computadores de mesa y portátiles<br>
	 *         <b>4</b>: Consolas de videojuegos<br>
	 *         <b>5</b>: Grabadoras y radios<br>
	 *         <b>6</b>: Cargadores de celular<br>
	 */
	ELECTRONIC(""),
	
	/**
	 *  <h1>Electrodomésticos productores de calor </h1>
	 * En esta categoría están: <br><br>
	 *         <b>0</b>: Tinas<br>
	 *         <b>1</b>: Duchas eléctricas<br>
	 *         <b>2</b>: Planchas de ropa<br>
	 *         <b>3</b>: Hornos y estufa<br>
	 *         <b>4</b>: Ollas arroceras<br>
	 *         <b>5</b>: Cafeteras<br>
	 *         <b>6</b>: Secadores de pelo<br>
	 *         <b>7</b>: Tostadoras<br>
	 */
	HEAT_PRODUCER(""),
	
	/**
	 * <h1>Electrodomésticos que funcionan con motor </h1>
	 * En esta categoría están: <br><br>
	 *         <b>0</b>: Neveras<br>
	 *         <b>1</b>: Ventiladores<br>
	 *         <b>2</b>: Lavadoras<br>
	 *         <b>3</b>: Licuadoras<br>
	 *         <b>4</b>: Batidoras<br>
	 *         <b>5</b>: Aspiradoras<br>
	 *         <b>6</b>: Máquinas de coser<br>
	 *         <b>7</b>: Aires Acondicionados<br>
	 */
	RUN_BY_MOTOR("");
	
	private String name;
	
	private DeviceType(String name) {
		
	}

	public String getName() {
		return name;
	}
	
	
}
