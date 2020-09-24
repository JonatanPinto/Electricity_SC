package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.DeviceDAO;
import models.entities.Device;
import models.entities.Season;
import models.entities.Simulator;
import view.MainFrame;
import view.SettingsDialog;
import view.deviceCatalog.DeviceCatalogCreator;
import view.deviceSelector.DeviceSelector;
import view.properties.ConstantGUI;

public class Controller implements ActionListener {

	private double kiloWattCost = 572.1319;
	private MainFrame mainFrame;
	private List<Device> selectedDevices;
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
		case ConstantGUI.C_DEVICE_SELECTOR_OPEN:
			openDeviceSelector();
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
		DeviceCatalogCreator deviceCatalogCreator = new DeviceCatalogCreator();
		deviceCatalogCreator.setDevice(device);
		deviceCatalogCreator.setVisible(true);
		String deviceID = device.getId();
		Device newDevice = deviceCatalogCreator.getDevice();
		if (newDevice != null) {
			newDevice.setId(deviceID);
			try {
				new DeviceDAO().updateDeviceOnCatalog(deviceID, newDevice);
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
		this.mainFrame.setVisible(true);
	}

	private void openDeviceCatalog() {
	}

	private void openDeviceCreator() {
		DeviceCatalogCreator deviceCatalogCreator = new DeviceCatalogCreator();
		deviceCatalogCreator.setVisible(true);
		Device device = deviceCatalogCreator.getDevice();
		if (device != null) {
			saveDeviceOnCatalog(device);
		}
	}

	private void openDeviceSelector() {
		List<Device> devices;
		try {
			devices = new DeviceDAO().getDevicesOnCatalog();
			DeviceSelector deviceSelector = new DeviceSelector(devices);
			deviceSelector.setVisible(true);
			List<Device> selectedDevices = deviceSelector.getSelectedDevices();
			if (selectedDevices != null) {
				if (this.selectedDevices == null) {
					this.selectedDevices = new ArrayList<Device>();
				}
				this.selectedDevices.addAll(selectedDevices);
				setSelectedDevices(this.selectedDevices);
			}
		} catch (IOException e) {
			e.printStackTrace();
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

	private void saveDeviceOnCatalog(Device device) {
		try {
			new DeviceDAO().addDeviceOnCatalog(device);
			readCatalogDevices();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveDeviceOnPreferences(Device device) {
		try {
			new DeviceDAO().addDeviceOnPreferences(device);
			readCatalogDevices();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSelectedDevices(List<Device> devices) {
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
					System.out.println(selectedDevices);
					mainFrame.setEnabled(false);
					new Simulator(controller, Season.WINTER, selectedDevices,
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
					new DeviceDAO().getDevicesOnCatalog());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeCatalogDevice(String deviceID) {
		if (JOptionPane.showConfirmDialog(null,
				"¿Estás seguro de eliminar el dispositivo?") == 0) {
			try {
				new DeviceDAO().removeDeviceOnCatalog(deviceID);
				readCatalogDevices();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateDevices(int day) {
		this.mainFrame.updateDevices(day, this.selectedDevices);
	}

}