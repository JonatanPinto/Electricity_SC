package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.DeviceDAO;
import models.entities.Device;
import models.entities.Season;
import models.entities.Simulator;
import view.MainFrame;
import view.SettingsDialog;
import view.devices.DeviceCreator;
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
		case ConstantGUI.C_DEVICE_CREATOR_OPEN:
			openDeviceCreator();
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

	public void editCatalogDevice(Device device) {
		DeviceCreator deviceCreator = new DeviceCreator();
		deviceCreator.setDevice(device);
		deviceCreator.setVisible(true);
		String deviceID = device.getId();
		Device newDevice = deviceCreator.getDevice();
		if (newDevice != null) {
			newDevice.setId(deviceID);
			try {
				new DeviceDAO().updateDevice(deviceID, newDevice);
				readCatalogDevices();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void endSimulation() {
		this.mainFrame.setEnabled(true);
		JOptionPane.showMessageDialog(null, "¡Simulación finalizada!");
	}

	public void initApp() {
		readCatalogDevices();
		setDevices(this.devices);
		this.mainFrame.setVisible(true);
	}

	private void openDeviceCatalog() {
	}

	private void openDeviceCreator() {
		DeviceCreator deviceCreator = new DeviceCreator();
		deviceCreator.setVisible(true);
		Device device = deviceCreator.getDevice();
		if (device != null) {
			saveDevice(device);
		}
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

	private void saveDevice(Device device) {
		try {
			new DeviceDAO().addDevice(device);
			readCatalogDevices();
		} catch (IOException e) {
			e.printStackTrace();
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

	private void readCatalogDevices() {
		try {
			this.mainFrame.getDeviceCatalog().setDevices(
					new DeviceDAO().getDevices());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeCatalogDevice(String deviceID) {
		if (JOptionPane.showConfirmDialog(null,
				"¿Estás seguro de eliminar el dispositivo?") == 0) {
			try {
				new DeviceDAO().removeDevice(deviceID);
				readCatalogDevices();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateDevices(int day) {
		this.mainFrame.updateDevices(day, this.devices);
	}

}