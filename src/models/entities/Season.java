package models.entities;

public enum Season {

	WINTER(DeviceType.HEAT_PRODUCER, 0.2), SUMMER(null, 0), SPRING(null, 0), FALL(
			null, 0);

	private DeviceType deviceType;
	private double usageIncreasePercentage;

	private Season(DeviceType deviceType, double usageIncreasePercentage) {
		this.deviceType = deviceType;
		this.usageIncreasePercentage = usageIncreasePercentage;
	}

	public DeviceType getDeviceType() {
		return deviceType;
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