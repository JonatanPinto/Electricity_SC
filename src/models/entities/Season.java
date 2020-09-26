package models.entities;

public enum Season {

	WINTER("Invierno", DeviceType.HEAT_PRODUCER, 0.2), SUMMER("Verano", null, 0), SPRING(
			"Primavera", null, 0), FALL("Otoño", null, 0);

	private DeviceType deviceType;
	private String name;
	private double usageIncreasePercentage;

	private Season(String name, DeviceType deviceType,
			double usageIncreasePercentage) {
		this.deviceType = deviceType;
		this.name = name;
		this.usageIncreasePercentage = usageIncreasePercentage;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public String getName() {
		return name;
	}

	public double getUsageIncreasePercentage() {
		return usageIncreasePercentage;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public void setUsageIncreasePercentage(double usageIncreasePercentage) {
		this.usageIncreasePercentage = usageIncreasePercentage;
	}

}