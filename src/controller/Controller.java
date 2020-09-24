package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import view.SettingsDialog;
import view.devices.DeviceCatalog;
import view.properties.ConstantGUI;

public class Controller implements ActionListener {

	private List<Device> devices;
	private MainFrame mainFrame;
	private double kiloWattCost = 572.1319;
	private int simulationSpeed = 1000;

	public Controller() {
		this.mainFrame = new MainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantGUI.C_DEVICE_CATALOG_OPEN:
			openDeviceCatalog();
			break;
		case ConstantGUI.C_SETTINGS_OPEN:
			openSettings();
			break;
		case ConstantGUI.C_SIMULATE:
			start();
			break;
		default:
			break;
		}
	}

	public void endSimulation() {
		this.mainFrame.setEnabled(true);
		JOptionPane.showMessageDialog(null, "¡Simulación finalizada!");
	}

	public void initApp() {
		loadDevices();
		setDevices(this.devices);
		this.mainFrame.setVisible(true);
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

	private void openDeviceCatalog() {
		DeviceCatalog deviceCatalog = new DeviceCatalog();
		deviceCatalog.setVisible(true);
	}

	private void openSettings() {
		SettingsDialog settingsDialog = new SettingsDialog(simulationSpeed,
				kiloWattCost);
		settingsDialog.setVisible(true);
		if (settingsDialog.isToSave()) {
			this.kiloWattCost = settingsDialog.getKiWattCost();
			this.simulationSpeed = settingsDialog.getSimulationSpeed();
		}
	}

	public void setDevices(List<Device> devices) {
		this.mainFrame.setDevices(devices);
	}

	private void start() {
		int simulationDays = this.mainFrame.getDevicesContainer()
				.getSimulationDays();
		Controller controller = this;
		if (simulationDays > 0) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					mainFrame.setEnabled(false);
					new Simulator(controller, Season.WINTER, devices,
							simulationDays, kiloWattCost, simulationSpeed)
							.start();
				}
			}).start();
		} else {
			JOptionPane.showMessageDialog(null, "Estas simulando 0 días.");
		}
	}

	public void updateDevices(int day) {
		this.mainFrame.updateDevices(day, this.devices);
	}

}