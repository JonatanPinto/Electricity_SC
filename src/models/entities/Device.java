package models.entities;

public class Device {

	private int id;
	private boolean stade;
	private DeviceType deviceType;
	private String tradeMark;
	private String model;
	private EnergyScale energyScale;
	private double ConsumptionOff;
	private double ConsumptionStandBy;
	private double ConsumptionOn;
	private int useTime;

	// - <-------- UseTime -------> +

	/**
	 * 
	 * @param id
	 * @param deviceType
	 * @param tradeMark
	 * @param model
	 * @param consumptionOff
	 * @param consumptionStandBy
	 * @param consumptionOn
	 * @param useTime
	 *            sistema de medición en horas
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, double consumptionOff,
			double consumptionStandBy, double consumptionOn, int useTime) {
		super();
		this.stade = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = EnergyScale.N;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = consumptionStandBy;
		ConsumptionOn = consumptionOn;
		this.useTime = useTime;
	}

	/**
	 * 
	 * @param id
	 * @param deviceType
	 * @param tradeMark
	 * @param model
	 * @param energyScale
	 * @param consumptionOff
	 * @param consumptionOn
	 * @param useTime
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, EnergyScale energyScale,
			double consumptionOff, double consumptionOn, int useTime) {
		super();
		this.stade = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = energyScale;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = 0;
		ConsumptionOn = consumptionOn;
		this.useTime = useTime;
	}

	/**
	 * 
	 * @param id
	 * @param deviceType
	 * @param tradeMark
	 * @param model
	 * @param energyScale
	 * @param consumptionOn
	 * @param useTime
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, EnergyScale energyScale,
			double consumptionOn, int useTime) {
		super();
		this.stade = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = energyScale;
		ConsumptionOff = 0;
		ConsumptionStandBy = 0;
		ConsumptionOn = consumptionOn;
		this.useTime = useTime;
	}

	/**
	 * 
	 * @param id
	 * @param deviceType
	 * @param tradeMark
	 * @param model
	 * @param energyScale
	 * @param consumptionOff
	 * @param consumptionStandBy
	 * @param consumptionOn
	 * @param useTime
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, EnergyScale energyScale,
			double consumptionOff, double consumptionStandBy,
			double consumptionOn, int useTime) {
		super();
		this.stade = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = energyScale;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = consumptionStandBy;
		ConsumptionOn = consumptionOn;
		this.useTime = useTime;
	}

	public void use(long hours) {
		// Calcular watts consumidos.
		// this.wattsConsumidos += hours * ConsumptionOn;

		// Calcular tiempo de uso.
		// tiempoDeUso += hours;
		this.stade = true;
	}

	// -------------------- Setters and Getters --------------------

	public int getId() {
		return id;
	}

	public boolean isStade() {
		return stade;
	}

	public void setStade(boolean stade) {
		this.stade = stade;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public String getTradeMark() {
		return tradeMark;
	}

	public String getModel() {
		return model;
	}

	public EnergyScale getEnergyScale() {
		return energyScale;
	}

	public double getConsumptionOff() {
		return ConsumptionOff;
	}

	public double getConsumptionStandBy() {
		return ConsumptionStandBy;
	}

	public double getConsumptionOn() {
		return ConsumptionOn;
	}

	public int getUseTime() {
		return useTime;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", deviceType=" + deviceType
				+ ", tradeMark=" + tradeMark + ", model=" + model
				+ ", energyScale=" + energyScale + ", ConsumptionOff="
				+ ConsumptionOff + ", ConsumptionStandBy=" + ConsumptionStandBy
				+ ", ConsumptionOn=" + ConsumptionOn + "]";
	}

}
