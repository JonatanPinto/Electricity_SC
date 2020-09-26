package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistence.DeviceDAO;
import view.deviceSelector.DeviceSelector;
import view.devices.DevicesContainer;
import view.properties.ConstantGUI;
import models.entities.Device;

public class PreferencesController implements ActionListener {

	private List<Device> devicesToSimulate;
	private DevicesContainer devicesContainer;

	public PreferencesController() {
		this.devicesToSimulate = new ArrayList<Device>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantGUI.C_DEVICE_SELECTOR_OPEN:
			openDeviceSelector();
			break;
		default:
			break;
		}
	}

	public List<Device> getDevicesToSimulate() {
		return devicesToSimulate;
	}

	public void loadPreferredDevices() {
		// TODO Auto-generated method stub

	}

	private void openDeviceSelector() {
		List<Device> devices;
		try {
			devices = new DeviceDAO().getDevicesOnCatalog();
			DeviceSelector deviceSelector = new DeviceSelector(devices);
			deviceSelector.setVisible(true);
			List<Device> selectedDevices = deviceSelector.getSelectedDevices();
			if (selectedDevices != null) {
				if (this.devicesToSimulate == null) {
					this.devicesToSimulate = new ArrayList<Device>();
				}
				this.devicesToSimulate.addAll(selectedDevices);
				setSelectedDevices(this.devicesToSimulate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDevicesContainer(DevicesContainer devicesContainer) {
		this.devicesContainer = devicesContainer;
	}

	public void setSelectedDevices(List<Device> devices) {
		if (devicesContainer != null) {
			devicesContainer.setDevices(devices);
		}
	}

}