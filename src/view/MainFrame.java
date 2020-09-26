package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.CatalogController;
import controller.Controller;
import controller.PreferencesController;
import models.entities.Device;
import view.deviceCatalog.DeviceCatalog;
import view.devices.DevicesContainer;
import view.properties.ConstantGUI;

import java.awt.Color;
import java.util.List;

import javax.swing.JTabbedPane;

import java.awt.Font;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 8456560429229699542L;
	private CatalogController catalogController;
	private Controller controller;
	private PreferencesController preferencesController;
	private DeviceCatalog deviceCatalog;
	private DevicesContainer devicesContainer;

	public MainFrame(Controller controller,
			CatalogController catalogController,
			PreferencesController preferencesController) {
		this.controller = controller;
		this.catalogController = catalogController;
		this.preferencesController = preferencesController;
		initProperties();
		initComponents();
	}

	public DeviceCatalog getDeviceCatalog() {
		return deviceCatalog;
	}

	public DevicesContainer getDevicesContainer() {
		return devicesContainer;
	}

	private void initComponents() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(true);
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		this.devicesContainer = new DevicesContainer(controller,
				preferencesController);
		tabbedPane.addTab("Simulador", null, devicesContainer, null);

		this.deviceCatalog = new DeviceCatalog(catalogController);
		tabbedPane.addTab("Catálogo", null, deviceCatalog, null);
	}

	private void initProperties() {
		setSize(1200, 700);
		setTitle("Simulador");
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		setIconImage(((ImageIcon) ConstantGUI.APP_ICON_32).getImage());
	}

	@Override
	public void setEnabled(boolean b) {
		this.devicesContainer.setEnabled(b);
	}

	public void updateDevices(int day, List<Device> devices) {
		this.devicesContainer.setDevices(devices);
		this.devicesContainer.updateProgressDays(day);
		this.devicesContainer.setVisible(false);
		this.devicesContainer.setVisible(true);
	}

}