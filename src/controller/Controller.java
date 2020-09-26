package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import models.entities.Device;
import models.entities.Season;
import models.entities.Simulator;
import view.MainFrame;
import view.SettingsDialog;
import view.properties.ConstantGUI;

public class Controller implements ActionListener {

	private CatalogController catalogController;
	private double kiloWattCost = 572.1319;
	private MainFrame mainFrame;
	private PreferencesController preferencesController;
	private List<Device> selectedDevices;
	private int simulationSpeed = 1000;

	public Controller() {
		this.catalogController = new CatalogController();
		this.preferencesController = new PreferencesController();
		this.mainFrame = new MainFrame(catalogController, preferencesController);
		this.catalogController.setDeviceCatalog(this.mainFrame
				.getDeviceCatalog());
		this.preferencesController.setDevicesContainer(this.mainFrame
				.getDevicesContainer());
		loadData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
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
		this.mainFrame.setVisible(true);
	}

	private void loadData() {
		this.catalogController.loadCatalogDevices();
		this.preferencesController.loadPreferredDevices();
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

	private void start() {
		int simulationDays = this.mainFrame.getDevicesContainer()
				.getSimulationDays();
		Controller controller = this;
		if (simulationDays > 0) {
			new Thread(new Runnable() {

				@Override
				public void run() {
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

	public void updateDevices(int day) {
		this.mainFrame.updateDevices(day, this.selectedDevices);
	}

}