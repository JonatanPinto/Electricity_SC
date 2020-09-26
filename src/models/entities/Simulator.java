package models.entities;

import java.util.List;

import utilities.numbers.NumberGenerator;
import controller.Controller;

public class Simulator {

	private Controller controller;
	private List<Device> devices;
	@SuppressWarnings("unused")
	private double kiloWatsCost;
	private Season season;
	private int simulationDays;
	private int simulationSpeed;

	public Simulator(Controller controller, Season season,
			List<Device> devices, int simulationDays, double kiloWattCost,
			int simulationSpeed) {
		this.controller = controller;
		this.devices = devices;
		this.kiloWatsCost = kiloWattCost;
		this.season = season;
		this.simulationDays = simulationDays;
		this.simulationSpeed = simulationSpeed;
	}

	public void start() {
		NumberGenerator numberGenerator = new NumberGenerator();
		for (int i = 0, j = 0; i < this.simulationDays; i++, j++) {
			for (Device device : this.devices) {
				device.use(j, this.season, numberGenerator);
			}
			if (j == 6) {
				j = -1;
			}
			this.controller.updateDevices(i + 1);
			try {
				Thread.sleep(this.simulationSpeed);
			} catch (InterruptedException e) {
			}
		}
		this.controller.endSimulation();
	}

}