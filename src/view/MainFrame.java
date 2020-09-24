package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import models.entities.Device;
import view.devices.DevicesContainer;
import view.properties.ConstantGUI;

import java.awt.Color;
import java.util.List;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 8456560429229699542L;
	private Controller controller;
	private DevicesContainer devicesContainer;

	public MainFrame(Controller controller) {
		this.controller = controller;
		initProperties();
		initComponents();
	}

	public DevicesContainer getDevicesContainer() {
		return devicesContainer;
	}

	private void initComponents() {
		this.devicesContainer = new DevicesContainer(controller);
		getContentPane().add(devicesContainer, BorderLayout.CENTER);
	}

	private void initProperties() {
		setSize(1200, 700);
		setTitle("Simulador");
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		setIconImage(((ImageIcon) ConstantGUI.APP_ICON_32).getImage());
	}

	public void setDevices(List<Device> devices) {
		this.devicesContainer.setDevices(devices);
		this.devicesContainer.setVisible(false);
		this.devicesContainer.setVisible(true);
	}

	@Override
	public void setEnabled(boolean b) {
		this.devicesContainer.setEnabled(b);
	}

	public void updateDevices(int day, List<Device> devices) {
		setDevices(devices);
		this.devicesContainer.updateProgressDays(day);
	}

}