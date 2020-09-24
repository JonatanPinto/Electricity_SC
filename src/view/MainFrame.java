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
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;

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
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setOpaque(true);
		tabbedPane.setFocusable(false);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		this.devicesContainer = new DevicesContainer(controller);
		devicesContainer.setBackground(Color.WHITE);
		devicesContainer.setOpaque(true);
		tabbedPane.addTab("Simulador", null, devicesContainer, null);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Catálogo", null, panel, null);
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