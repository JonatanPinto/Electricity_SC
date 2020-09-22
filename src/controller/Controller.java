package controller;

import java.util.ArrayList;
import java.util.List;

import models.entities.Device;
import view.MainFrame;

public class Controller {

	private MainFrame mainFrame;

	public Controller() {
		this.mainFrame = new MainFrame();
	}

	public void initApp() {
		this.mainFrame.setVisible(true);
		List<Device> devices = new ArrayList<Device>();
		devices.add(new Device(0, false, null, "Samsung", "G-3000",
				"Televisor", null, 0, 0, 0, 0));
		devices.add(new Device(0, false, null, "LG", "Z157", "Lavadora", null,
				0, 0, 0, 0));
		update(devices);
		start();
	}

	public void update(List<Device> devices) {
		this.mainFrame.setDevices(devices);
	}

	private void start() {
		// double kiloWatsCost;
		// int simulationDays;
		// List<Device> devices;
		// new Simulator(devices, simulationDays, kiloWatsCost).start();
	}

}