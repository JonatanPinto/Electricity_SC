package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import models.entities.Device;
import view.devices.DevicesContainer;

import java.awt.Color;
import java.util.List;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 8456560429229699542L;
	private DevicesContainer devicesContainer;

	public MainFrame() {
		getContentPane().setBackground(Color.WHITE);
		initProperties();
		initComponents();
	}

	private void initComponents() {
		this.devicesContainer = new DevicesContainer();
		getContentPane().add(devicesContainer, BorderLayout.CENTER);
	}

	private void initProperties() {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
	}
	
	public void setDevices(List<Device> devices){
		this.devicesContainer.setDevices(devices);
	}

}