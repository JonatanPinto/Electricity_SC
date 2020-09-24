package models.entities;

public class Device {

	private int id;
	private boolean state;
	private DeviceType deviceType;
	private String tradeMark;
	private String model;
	private String name;
	private EnergyScale energyScale;
	private double ConsumptionOff;
	private double ConsumptionStandBy;
	private double ConsumptionOn;
	// private int useTime;
	private int[] hourOfUsePerDay;
	private int useTime;
	private double wattsConsumed;

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
	 * @param hourOfUsePerDay
	 *            sistema de medición en horas
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, double consumptionOff,
			double consumptionStandBy, double consumptionOn,
			int[] hourOfUsePerDay) {
		super();
		this.state = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = EnergyScale.N;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = consumptionStandBy;
		ConsumptionOn = consumptionOn;
		this.hourOfUsePerDay = hourOfUsePerDay;
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
	 * @param hourOfUsePerDay
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, EnergyScale energyScale,
			double consumptionOff, double consumptionOn, int[] hourOfUsePerDay) {
		super();
		this.state = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = energyScale;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = 0;
		ConsumptionOn = consumptionOn;
		this.hourOfUsePerDay = hourOfUsePerDay;
	}

	/**
	 * 
	 * @param id
	 * @param deviceType
	 * @param tradeMark
	 * @param model
	 * @param energyScale
	 * @param consumptionOn
	 * @param hourOfUsePerDay
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, EnergyScale energyScale,
			double consumptionOn, int[] hourOfUsePerDay) {
		super();
		this.state = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = energyScale;
		ConsumptionOff = 0;
		ConsumptionStandBy = 0;
		ConsumptionOn = consumptionOn;
		this.hourOfUsePerDay = hourOfUsePerDay;
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
	 * @param hourOfUsePerDay
	 */
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, EnergyScale energyScale,
			double consumptionOff, double consumptionStandBy,
			double consumptionOn, int[] hourOfUsePerDay) {
		super();
		this.state = stade;
		this.id = id;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.energyScale = energyScale;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = consumptionStandBy;
		ConsumptionOn = consumptionOn;
		this.hourOfUsePerDay = hourOfUsePerDay;
	}

	// Constructor con el atributo name
	public Device(int id, boolean stade, DeviceType deviceType,
			String tradeMark, String model, String name,
			EnergyScale energyScale, double consumptionOff,
			double consumptionStandBy, double consumptionOn,
			int[] hourOfUsePerDay) {
		this.id = id;
		this.state = stade;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.name = name;
		this.energyScale = energyScale;
		ConsumptionOff = consumptionOff;
		ConsumptionStandBy = consumptionStandBy;
		ConsumptionOn = consumptionOn;
		this.hourOfUsePerDay = hourOfUsePerDay;
	}

	public void use(int day, Season season) {
		if (state) {
			double useHours = hourOfUsePerDay[day];
			if (season != null && season.equals(Season.WINTER)
					&& season.getDeviceType().equals(this.deviceType)) {
				useHours += useHours * season.getUsageIncreasePercentage();
			}
			this.wattsConsumed += (useHours * ConsumptionOn)
					+ ((24 - useHours) * ConsumptionStandBy);
			this.useTime += useHours;
		}
	}

	// -------------------- Setters and Getters --------------------

	public int getId() {
		return id;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setWattsConsumed(double wattsConsumed) {
		this.wattsConsumed = wattsConsumed;
	}

	public double getConsumptionOn() {
		return ConsumptionOn;
	}

	public int[] getHourOfUsePerDay() {
		return hourOfUsePerDay;
	}

	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}

	public double getWattsConsumed() {
		return wattsConsumed;
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
