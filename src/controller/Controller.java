package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import models.entities.Device;
import models.entities.DeviceType;
import models.entities.EnergyScale;
import models.entities.Season;
import models.entities.Simulator;
import view.MainFrame;

public class Controller {

	private List<Device> devices;
	private MainFrame mainFrame;

	public Controller() {
		this.mainFrame = new MainFrame();
	}

	public void endSimulation() {
		JOptionPane.showMessageDialog(null, "¡Simulación finalizada!");
	}

	public void initApp() {
		loadDevices();
		setDevices(this.devices);
		this.mainFrame.setVisible(true);
		start();
	}

	private void loadDevices() {
		this.devices = new ArrayList<Device>();
		devices.add(new Device(1, true, DeviceType.ELECTRONIC, "Samsung",
				"G-3000", "Televisor", EnergyScale.A2, 5, 20, 7,
				generateHourOfUsePerDayRandom()));
		devices.add(new Device(2, true, DeviceType.HEAT_PRODUCER, "LG", "Z157",
				"Lavadora", EnergyScale.A3, 5, 20, 7,
				generateHourOfUsePerDayRandom()));
		devices.add(new Device(3, true, DeviceType.ILUMINATION, "LG", "Z157",
				"Lavadora", EnergyScale.A1, 5, 20, 7,
				generateHourOfUsePerDayRandom()));
		devices.add(new Device(4, true, DeviceType.RUN_BY_MOTOR, "LG", "Z157",
				"Lavadora", EnergyScale.B, 5, 20, 7,
				generateHourOfUsePerDayRandom()));
	}

	private int[] generateHourOfUsePerDayRandom() {
		int[] days = new int[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Random().nextInt(24);
		}
		return days;
	}

	public void setDevices(List<Device> devices) {
		this.mainFrame.setDevices(devices);
	}

	private void start() {
		double kiloWatsCost = 572.1319;
		int simulationDays = 20;
		Controller controller = this;
		new Thread(new Runnable() {

			@Override
			public void run() {
				new Simulator(controller, Season.WINTER, devices,
						simulationDays, kiloWatsCost).start();
			}
		}).start();
	}

	public void updateDevices(int day) {
		this.mainFrame.updateDevices(day, this.devices);
	}

}