package view.devices;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.components.ButtonOpaquer;
import view.components.TextField;
import view.properties.ConstantGUI;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.border.LineBorder;

import models.entities.Device;

import javax.swing.BoxLayout;

import java.awt.Dimension;

import javax.swing.JProgressBar;

import controller.Controller;

public class DevicesContainer extends JPanel {

	private static final long serialVersionUID = 3895035509595275724L;
	private Controller controller;
	private JPanel containerDevices;
	private JPanel panelDevices;
	private JPanel panelNoDevices;
	private JProgressBar progressBarDays;
	private double totalWattsConsumed;
	private TextField txtSimulationDays;
	private JButton btnSimulate;
	private JPanel panelHeader;

	public DevicesContainer(Controller controller) {
		this.controller = controller;
		initProperties();
		initComponents();
	}

	public int getSimulationDays() {
		String sDays = this.txtSimulationDays.getText();
		return sDays.isEmpty() ? 0 : Integer.parseInt(sDays);
	}

	private void initComponents() {
		panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new BorderLayout(0, 0));
		add(panelHeader, BorderLayout.NORTH);

		JPanel panelAddDevice = new JPanel();
		panelAddDevice.setOpaque(false);
		panelHeader.add(panelAddDevice, BorderLayout.WEST);

		JButton btnAddDevice = new JButton();
		btnAddDevice.setFocusPainted(false);
		btnAddDevice.setForeground(Color.WHITE);
		btnAddDevice.addActionListener(controller);
		btnAddDevice.setText("Agregar dispositivo");
		btnAddDevice.setIcon(ConstantGUI.ICON_ADD_WHITE_16);
		btnAddDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddDevice.setBackground(ConstantGUI.COLOR_PRIMARY);
		btnAddDevice.setActionCommand(ConstantGUI.C_DEVICE_CATALOG_OPEN);
		panelAddDevice.add(btnAddDevice);

		JPanel panelGeneralInfo = new JPanel();
		panelGeneralInfo.setOpaque(false);
		panelHeader.add(panelGeneralInfo, BorderLayout.EAST);

		JButton btnSettings = new ButtonOpaquer();
		btnSettings.addActionListener(controller);
		btnSettings.setIcon(ConstantGUI.ICON_GEAR_GRAY_16);
		btnSettings.setActionCommand(ConstantGUI.C_SETTINGS_OPEN);
		panelGeneralInfo.add(btnSettings);

		JPanel panelSimulationOptions = new JPanel();
		panelSimulationOptions.setOpaque(false);
		add(panelSimulationOptions, BorderLayout.SOUTH);
		panelSimulationOptions.setLayout(new BorderLayout(0, 0));

		progressBarDays = new JProgressBar();
		progressBarDays.setStringPainted(true);
		progressBarDays.setForeground(Color.GRAY);
		progressBarDays.setLayout(new BorderLayout());
		progressBarDays.setPreferredSize(new Dimension(146, 37));
		progressBarDays.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelSimulationOptions.add(progressBarDays, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		progressBarDays.add(panel, BorderLayout.EAST);

		JLabel lblDays = new JLabel("D\u00EDas a simular:");
		panel.add(lblDays);
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panelDaysPanel = new JPanel();
		panel.add(panelDaysPanel);
		panelDaysPanel.setOpaque(false);
		panelDaysPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDaysPanel.setLayout(new GridLayout(0, 1, 0, 0));

		txtSimulationDays = new TextField();
		txtSimulationDays.setText("20");
		txtSimulationDays.setBorder(new EmptyBorder(3, 3, 3, 3));
		txtSimulationDays.setColumns(5);
		txtSimulationDays.setNumberMode(true);
		txtSimulationDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSimulationDays.setHorizontalAlignment(SwingConstants.CENTER);
		panelDaysPanel.add(txtSimulationDays);

		btnSimulate = new JButton();
		btnSimulate.setText("Simular");
		btnSimulate.setFocusPainted(false);
		btnSimulate.setForeground(Color.WHITE);
		btnSimulate.addActionListener(controller);
		btnSimulate.setBackground(new Color(0, 123, 255));
		btnSimulate.setActionCommand(ConstantGUI.C_SIMULATE);
		btnSimulate.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnSimulate);

		panelDevices = new JPanel();
		panelDevices.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDevices.setOpaque(false);
		panelDevices.setLayout(new BorderLayout(0, 0));
		add(panelDevices, BorderLayout.CENTER);

		JPanel panelDevicesTitles = new JPanel();
		panelDevicesTitles.setPreferredSize(new Dimension(523, 33));
		panelDevicesTitles.setOpaque(false);
		panelDevices.add(panelDevicesTitles, BorderLayout.NORTH);
		panelDevicesTitles.setLayout(new BorderLayout(0, 0));

		JLabel lblTitleindex = new JLabel("#");
		lblTitleindex.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleindex.setPreferredSize(new Dimension(50, 10));
		lblTitleindex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDevicesTitles.add(lblTitleindex, BorderLayout.WEST);

		JLabel lblDevicestitle = new JLabel("Dispositivos");
		lblDevicestitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDevicesTitles.add(lblDevicestitle);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panelDevices.add(scrollPane);

		JPanel auxDevicesPanel = new JPanel();
		auxDevicesPanel.setOpaque(false);
		auxDevicesPanel.setLayout(new BorderLayout(0, 0));
		scrollPane.setViewportView(auxDevicesPanel);

		containerDevices = new JPanel();
		containerDevices.setOpaque(false);
		auxDevicesPanel.add(containerDevices, BorderLayout.NORTH);
		containerDevices.setLayout(new BoxLayout(containerDevices,
				BoxLayout.Y_AXIS));

		panelNoDevices = new NoDevicesPanel();
		// add(panelNoDevices, BorderLayout.CENTER);
	}

	private void initProperties() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
	}

	private void refreshWatts() {
		Component[] components = containerDevices.getComponents();
		for (Component component : components) {
			if (component instanceof DeviceRowPanel) {
				DeviceRowPanel deviceRowPanel = (DeviceRowPanel) component;
				deviceRowPanel
						.setWattsPercentage((int) ((deviceRowPanel.getDevice()
								.getWattsConsumed() * 100) / totalWattsConsumed));
			}
		}
	}

	public void setDevices(List<Device> devices) {
		containerDevices.removeAll();
		this.totalWattsConsumed = 0;
		boolean thereAreDevices = devices != null && devices.size() > 0;
		if (thereAreDevices) {
			for (int i = 0; i < devices.size(); i++) {
				Device device = devices.get(i);
				this.totalWattsConsumed += device.getWattsConsumed();
				DeviceRowPanel deviceRowPanel = new DeviceRowPanel(null, i + 1,
						device);
				containerDevices.add(deviceRowPanel);
			}
			refreshWatts();
		}
		setEmptyMode(!thereAreDevices);
	}

	private void setEmptyMode(boolean condition) {
		progressBarDays.setVisible(!condition);
		panelHeader.setVisible(!condition);
		if (condition) {
			remove(panelDevices);
			add(panelNoDevices, BorderLayout.CENTER);
		} else {
			remove(panelNoDevices);
			add(panelDevices, BorderLayout.CENTER);
		}
	}

	@Override
	public void setEnabled(boolean enabled) {
		btnSimulate.setEnabled(enabled);
		Component[] components = containerDevices.getComponents();
		for (Component component : components) {
			if (component instanceof DeviceRowPanel) {
				((DeviceRowPanel) component).setEnabled(enabled);
			}
		}
	}

	public void updateProgressDays(int day) {
		int days = Integer.parseInt(txtSimulationDays.getText());
		int percentage = (day * 100) / days;
		progressBarDays.setValue(percentage);
		progressBarDays.setString(percentage + "% (Día " + day + ")");
	}

}