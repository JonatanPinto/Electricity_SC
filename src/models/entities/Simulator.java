package models.entities;

import java.util.List;

public class Simulator {

	private List<Device> devices;
	private double kiloWatsCost;
	private int simulationDays;

	public Simulator(List<Device> devices, int simulationDays,
			double kiloWatsCost) {
		this.devices = devices;
		this.kiloWatsCost = kiloWatsCost;
		this.simulationDays = simulationDays;
	}

	public void start() {

	}

}