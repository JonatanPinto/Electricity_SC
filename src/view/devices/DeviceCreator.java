package view.devices;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import view.components.TextField;
import view.properties.ConstantGUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import models.entities.Device;
import models.entities.DeviceType;
import models.entities.EnergyScale;

import javax.swing.SpinnerNumberModel;

public class DeviceCreator extends JDialog implements ActionListener {

	private static final long serialVersionUID = -433841757497840469L;
	private JComboBox<String> boxDeviceTypes;
	private JComboBox<String> boxEnergyScales;
	private JButton btnCreate;
	private Device device;
	private JSpinner spnConsumptionOn;
	private JSpinner spnConsumptionStandBy;
	private TextField txtName;
	private TextField txtTradeMark;
	private TextField txtModel;

	public DeviceCreator() {
		initProperties();
		initComponents();
		setDeviceTypes();
		setEnergyScales();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnCreate)) {
			this.device = buildDevice();
		}
		setVisible(false);
	}

	private Device buildDevice() {
		String id = UUID.randomUUID().toString();
		boolean state = false;
		DeviceType deviceType = DeviceType.values()[boxDeviceTypes
				.getSelectedIndex()];
		String tradeMark = txtTradeMark.getText();
		String model = txtModel.getText();
		String name = txtName.getText();
		EnergyScale energyScale = EnergyScale.values()[boxEnergyScales
				.getSelectedIndex()];
		double consumptionOff = 0;
		double consumptionStandBy = (double) spnConsumptionStandBy.getValue();
		double consumptionOn = (double) spnConsumptionOn.getValue();
		return new Device(id, state, deviceType, tradeMark, model, name,
				energyScale, consumptionOff, consumptionStandBy, consumptionOn,
				new int[7]);
	}

	public Device getDevice() {
		return device;
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblName = new JLabel();
		lblName.setText("Nombre:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblName);

		txtName = new TextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setPlaceholder("Ingresa el nombre del dispositivo");
		panel.add(txtName);

		JLabel lblDevicetype = new JLabel();
		lblDevicetype.setText("Tipo de dispositivo:");
		lblDevicetype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDevicetype);

		boxDeviceTypes = new JComboBox<String>();
		boxDeviceTypes.setBackground(Color.WHITE);
		boxDeviceTypes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(boxDeviceTypes);

		JLabel lblEnergyScale = new JLabel();
		lblEnergyScale.setText("Escana de energía:");
		lblEnergyScale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblEnergyScale);

		boxEnergyScales = new JComboBox<String>();
		boxEnergyScales.setBackground(Color.WHITE);
		boxEnergyScales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(boxEnergyScales);

		JLabel lblTradeMark = new JLabel();
		lblTradeMark.setText("Marca comercial:");
		lblTradeMark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTradeMark);

		txtTradeMark = new TextField();
		txtTradeMark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTradeMark.setPlaceholder("Ingresa la marca "
				+ "comercial del dispositivo");
		panel.add(txtTradeMark);

		JLabel lblModel = new JLabel();
		lblModel.setText("Modelo:");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblModel);

		txtModel = new TextField();
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtModel.setPlaceholder("Ingresa el modelo del dispositivo");
		panel.add(txtModel);

		JLabel lblConsumptionOn = new JLabel();
		lblConsumptionOn.setText("Consumo(vatios/hora) en modo prendido:");
		lblConsumptionOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConsumptionOn);

		spnConsumptionOn = new JSpinner();
		spnConsumptionOn.setModel(new SpinnerNumberModel(new Double(0),
				new Double(0), null, new Double(1)));
		spnConsumptionOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(spnConsumptionOn);

		JLabel lblConsumptionStandBy = new JLabel();
		lblConsumptionStandBy
				.setText("Consumo(vatios/hora) en modo descanso: ");
		lblConsumptionStandBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConsumptionStandBy);

		spnConsumptionStandBy = new JSpinner();
		spnConsumptionStandBy.setModel(new SpinnerNumberModel(new Double(0),
				new Double(0), null, new Double(1)));
		spnConsumptionStandBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(spnConsumptionStandBy);

		JPanel panelControls = new JPanel();
		getContentPane().add(panelControls, BorderLayout.SOUTH);

		btnCreate = new JButton();
		btnCreate.setText("Crear dispositivo");
		btnCreate.setFocusPainted(false);
		btnCreate.addActionListener(this);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(ConstantGUI.COLOR_PRIMARY);
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelControls.add(btnCreate);

		JButton btnCancel = new JButton();
		btnCancel.setText("Cerrar");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(this);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(ConstantGUI.COLOR_SECONDARY);
		panelControls.add(btnCancel);
	}

	private void initProperties() {
		setModal(true);
		setSize(350, 550);
		setLocationRelativeTo(null);
		setTitle("Creador de dispositivos");
		setIconImage(((ImageIcon) ConstantGUI.ICON_ADD_WHITE_16).getImage());
		getContentPane().setLayout(new BorderLayout(0, 0));
	}

	public void setDevice(Device device) {
		txtName.setText(device.getName());
		DeviceType deviceType = device.getDeviceType();
		if (deviceType != null) {
			boxDeviceTypes.setSelectedItem(deviceType.getName());
		}
		EnergyScale energyScale = device.getEnergyScale();
		if (energyScale != null) {
			boxEnergyScales.setSelectedItem(energyScale.getName());
		}
		txtTradeMark.setText(device.getTradeMark());
		txtModel.setText(device.getModel());
		spnConsumptionOn.setValue(device.getConsumptionOn());
		spnConsumptionStandBy.setValue(device.getConsumptionStandBy());
	}

	private void setDeviceTypes() {
		DeviceType[] deviceTypes = DeviceType.values();
		for (DeviceType deviceType : deviceTypes) {
			boxDeviceTypes.addItem(deviceType.getName());
		}
	}

	private void setEnergyScales() {
		EnergyScale[] energyScales = EnergyScale.values();
		for (EnergyScale energyScale : energyScales) {
			boxEnergyScales.addItem(energyScale.getName());
		}
	}

}