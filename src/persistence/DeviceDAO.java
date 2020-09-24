package persistence;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import utilities.files.FilesManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.entities.Device;

public class DeviceDAO {

	private static final String DEVICES_FILE_PATH = "media\\files\\devices.json";

	public void addDevice(Device device) throws IOException {
		List<Device> devices = getDevices();
		devices.add(device);
		saveDevices(devices);
	}

	public List<Device> getDevices() throws IOException {
		String json = FilesManager.readFile(DEVICES_FILE_PATH);
		Type listType = new TypeToken<List<Device>>() {
		}.getType();
		return new Gson().fromJson(json, listType);
	}

	public void removeDevice(String deviceID) throws IOException {
		List<Device> devices = getDevices();
		for (int i = 0; i < devices.size(); i++) {
			if (devices.get(i).getId().equals(deviceID)) {
				devices.remove(i);
				break;
			}
		}
		saveDevices(devices);
	}

	public void updateDevice(String deviceID, Device device) throws IOException {
		device.setId(deviceID);
		List<Device> devices = getDevices();
		for (int i = 0; i < devices.size(); i++) {
			if (devices.get(i).getId().equals(deviceID)) {
				devices.set(i, device);
				break;
			}
		}
		saveDevices(devices);
	}

	private void saveDevices(List<Device> devices) {
		FilesManager.writeFile(DEVICES_FILE_PATH, new GsonBuilder()
				.setPrettyPrinting().create().toJson(devices));
	}

}