package models.entities;

import java.util.Arrays;

public class Device {

	private String id;
	private boolean state;
	private DeviceType deviceType;
	private String tradeMark;
	private String model;
	private String name;
	private EnergyScale energyScale;
	private double ConsumptionStandBy;
	private double ConsumptionOn;
	private int[] hourOfUsePerDay;
	private int useTime;
	private double wattsConsumed;

	// Constructor con el atributo name
	public Device(String id, boolean state, DeviceType deviceType,
			String tradeMark, String model, String name,
			EnergyScale energyScale, double consumptionStandBy,
			double consumptionOn, int[] hourOfUsePerDay) {
		this.id = id;
		this.state = state;
		this.deviceType = deviceType;
		this.tradeMark = tradeMark;
		this.model = model;
		this.name = name;
		this.energyScale = energyScale;
		ConsumptionStandBy = consumptionStandBy;
		ConsumptionOn = consumptionOn;
		this.hourOfUsePerDay = hourOfUsePerDay;
	}

	public Device clone() {
		return new Device(id, state, deviceType, tradeMark, model, name,
				energyScale, this.ConsumptionStandBy, this.ConsumptionOn,
				hourOfUsePerDay);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public double getConsumptionStandBy() {
		return ConsumptionStandBy;
	}

	public void setWattsConsumed(double wattsConsumed) {
		this.wattsConsumed = wattsConsumed;
	}

	public double getConsumptionOn() {
		return ConsumptionOn;
	}

	public int[] getHoursOfUsePerDay() {
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
		return "Device [id=" + id + ", state=" + state + ", deviceType="
				+ deviceType + ", tradeMark=" + tradeMark + ", model=" + model
				+ ", name=" + name + ", energyScale=" + energyScale
				+ ", ConsumptionStandBy=" + ConsumptionStandBy
				+ ", ConsumptionOn=" + ConsumptionOn + ", hourOfUsePerDay="
				+ Arrays.toString(hourOfUsePerDay) + ", useTime=" + useTime
				+ ", wattsConsumed=" + wattsConsumed + "]";
	}

}