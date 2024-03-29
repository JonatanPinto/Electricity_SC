package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import models.entities.Device;
import persistence.DeviceDAO;
import view.deviceCatalog.DeviceCatalog;
import view.devices.DeviceCreator;
import view.properties.ConstantGUI;

public class CatalogController implements ActionListener {

	private DeviceCatalog deviceCatalog;

	public CatalogController() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantGUI.C_DEVICE_CREATOR_OPEN:
			openDeviceCreator();
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
				new DeviceDAO().updateDeviceOnCatalog(deviceID, newDevice);
				loadCatalogDevices();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadCatalogDevices() {
		if (deviceCatalog != null) {
			try {
				deviceCatalog.setDevices(new DeviceDAO().getDevicesOnCatalog());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void openDeviceCreator() {
		DeviceCreator deviceCreator = new DeviceCreator();
		deviceCreator.setVisible(true);
		Device device = deviceCreator.getDevice();
		if (device != null) {
			saveDeviceOnCatalog(device);
		}
	}

	public void removeCatalogDevice(String deviceID) {
		if (JOptionPane.showConfirmDialog(null,
				"�Est�s seguro de eliminar el dispositivo?") == 0) {
			try {
				new DeviceDAO().removeDeviceOnCatalog(deviceID);
				loadCatalogDevices();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveDeviceOnCatalog(Device device) {
		try {
			new DeviceDAO().addDeviceOnCatalog(device);
			loadCatalogDevices();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDeviceCatalog(DeviceCatalog deviceCatalog) {
		this.deviceCatalog = deviceCatalog;
	}

}