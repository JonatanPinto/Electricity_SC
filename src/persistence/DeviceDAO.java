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

	private static final String DEVICES_CATALOG_FILE_PATH = "media\\files\\DeviceCatalog.json";
	private static final String DEVICES_PREFERENCES_FILE_PATH = "media\\files\\DevicePreferences.json";

	public void addDeviceOnCatalog(Device device) throws IOException {
		List<Device> devices = getDevicesOnCatalog();
		devices.add(device);
		saveDevicesOnCatalog(devices);
	}

	public List<Device> getDevicesOnCatalog() throws IOException {
		String json = FilesManager.readFile(DEVICES_CATALOG_FILE_PATH);
		Type listType = new TypeToken<List<Device>>() {
		}.getType();
		return new Gson().fromJson(json, listType);
	}

	public void removeDeviceOnCatalog(String deviceID) throws IOException {
		List<Device> devices = getDevicesOnCatalog();
		for (int i = 0; i < devices.size(); i++) {
			if (devices.get(i).getId().equals(deviceID)) {
				devices.remove(i);
				break;
			}
		}
		saveDevicesOnCatalog(devices);
	}

	public void updateDeviceOnCatalog(String deviceID, Device device)
			throws IOException {
		device.setId(deviceID);
		List<Device> devices = getDevicesOnCatalog();
		for (int i = 0; i < devices.size(); i++) {
			if (devices.get(i).getId().equals(deviceID)) {
				devices.set(i, device);
				break;
			}
		}
		saveDevicesOnCatalog(devices);
	}

	private void saveDevicesOnCatalog(List<Device> devices) {
		FilesManager.writeFile(DEVICES_CATALOG_FILE_PATH, new GsonBuilder()
				.setPrettyPrinting().create().toJson(devices));
	}

	public void addDeviceOnPreferences(Device device) throws IOException {
		List<Device> devices = getDevicesOnPreferences();
		devices.add(device);
		saveDevicesOnPreferences(devices);
	}

	public List<Device> getDevicesOnPreferences() throws IOException {
		String json = FilesManager.readFile(DEVICES_PREFERENCES_FILE_PATH);
		Type listType = new TypeToken<List<Device>>() {
		}.getType();
		return new Gson().fromJson(json, listType);
	}

	public void removeDeviceOnPreferences(String deviceID) throws IOException {
		List<Device> devices = getDevicesOnPreferences();
		for (int i = 0; i < devices.size(); i++) {
			if (devices.get(i).getId().equals(deviceID)) {
				devices.remove(i);
				break;
			}
		}
		saveDevicesOnPreferences(devices);
	}

	public void updateDeviceOnPreferences(String deviceID, Device device)
			throws IOException {
		device.setId(deviceID);
		List<Device> devices = getDevicesOnPreferences();
		for (int i = 0; i < devices.size(); i++) {
			if (devices.get(i).getId().equals(deviceID)) {
				devices.set(i, device);
				break;
			}
		}
		saveDevicesOnPreferences(devices);
	}

	private void saveDevicesOnPreferences(List<Device> devices) {
		FilesManager.writeFile(DEVICES_CATALOG_FILE_PATH, new GsonBuilder()
				.setPrettyPrinting().create().toJson(devices));
	}

}