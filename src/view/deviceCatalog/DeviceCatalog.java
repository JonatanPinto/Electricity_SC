package view.deviceCatalog;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JButton;

import models.entities.Device;
import controller.Controller;
import view.properties.ConstantGUI;

import java.awt.Font;
import java.util.List;
import java.awt.GridLayout;

public class DeviceCatalog extends JPanel {

	private static final long serialVersionUID = 4902612989049174248L;
	private Controller controller;
	private JPanel containerDevices;

	public DeviceCatalog(Controller controller) {
		this.controller = controller;
		initProperties();
		initComponents();
	}

	private void initComponents() {
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelNorth.setLayout(new BorderLayout(0, 0));
		add(panelNorth, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelNorth.add(panel, BorderLayout.WEST);

		JButton btnCreateDevice = new JButton();
		btnCreateDevice.setFocusPainted(false);
		btnCreateDevice.setForeground(Color.WHITE);
		btnCreateDevice.setText("Crear dispositivo");
		btnCreateDevice.addActionListener(controller);
		btnCreateDevice.setBackground(new Color(0, 123, 255));
		btnCreateDevice.setIcon(ConstantGUI.ICON_ADD_WHITE_16);
		btnCreateDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateDevice.setActionCommand(ConstantGUI.C_DEVICE_CREATOR_OPEN);
		panel.add(btnCreateDevice);

		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		panelCenter.setLayout(new BorderLayout(0, 0));
		add(panelCenter);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panelCenter.add(scrollPane, BorderLayout.CENTER);

		JPanel auxContainerDevices = new JPanel();
		auxContainerDevices.setOpaque(false);
		scrollPane.setViewportView(auxContainerDevices);
		auxContainerDevices.setLayout(new BorderLayout(0, 0));

		containerDevices = new JPanel();
		auxContainerDevices.add(containerDevices, BorderLayout.NORTH);
		containerDevices.setLayout(new GridLayout(0, 1, 0, 0));
	}

	private void initProperties() {
		setSize(800, 500);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
	}

	public void setDevices(List<Device> devices) {
		containerDevices.removeAll();
		for (int i = 0; i < devices.size(); i++) {
			containerDevices.add(new DeviceCatalogRowPanel(controller, i + 1,
					devices.get(i)));
		}
		containerDevices.setVisible(false);
		containerDevices.setVisible(true);
	}

}