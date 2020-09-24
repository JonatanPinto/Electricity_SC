package models.entities;

import java.util.List;

import controller.Controller;

public class Simulator {

	private Controller controller;
	private List<Device> devices;
	private double kiloWatsCost;
	private Season season;
	private int simulationDays;

	public Simulator(Controller controller, Season season,
			List<Device> devices, int simulationDays, double kiloWatsCost) {
		this.controller = controller;
		this.devices = devices;
		this.kiloWatsCost = kiloWatsCost;
		this.season = season;
		this.simulationDays = simulationDays;
	}

	public void start() {
		for (int i = 0, j = 0; i < simulationDays; i++, j++) {
			for (Device device : devices) {
				device.use(j, season);
			}
			if (j == 6) {
				j = -1;
			}
			controller.updateDevices(i + 1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		controller.endSimulation();
	}

}