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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
	private TextField txtDay1;
	private TextField txtDay2;
	private TextField txtDay3;
	private TextField txtDay4;
	private TextField txtDay5;
	private TextField txtDay6;
	private TextField txtDay7;

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
		boolean state = device != null ? device.getState() : true;
		DeviceType deviceType = DeviceType.values()[boxDeviceTypes
				.getSelectedIndex()];
		String tradeMark = txtTradeMark.getText();
		String model = txtModel.getText();
		String name = txtName.getText();
		EnergyScale energyScale = EnergyScale.values()[boxEnergyScales
				.getSelectedIndex()];
		double consumptionStandBy = (double) spnConsumptionStandBy.getValue();
		double consumptionOn = (double) spnConsumptionOn.getValue();
		int[] hourOfUsePerDay = new int[7];
		hourOfUsePerDay[0] = txtDay1.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay1.getText());
		hourOfUsePerDay[1] = txtDay2.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay2.getText());
		hourOfUsePerDay[2] = txtDay3.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay3.getText());
		hourOfUsePerDay[3] = txtDay4.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay4.getText());
		hourOfUsePerDay[4] = txtDay5.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay5.getText());
		hourOfUsePerDay[5] = txtDay6.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay6.getText());
		hourOfUsePerDay[6] = txtDay7.getText().isEmpty() ? 0 : Integer
				.parseInt("" + txtDay7.getText());
		if (device != null) {

		}
		return new Device(id, state, deviceType, tradeMark, model, name,
				energyScale, consumptionStandBy, consumptionOn, hourOfUsePerDay);
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
		lblConsumptionOn.setText("Consumo (kWh) en modo prendido:");
		lblConsumptionOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConsumptionOn);

		spnConsumptionOn = new JSpinner();
		spnConsumptionOn.setModel(new SpinnerNumberModel(new Double(0),
				new Double(0), null, new Double(1)));
		spnConsumptionOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(spnConsumptionOn);

		JLabel lblConsumptionStandBy = new JLabel();
		lblConsumptionStandBy.setText("Consumo (kWh) en modo descanso: ");
		lblConsumptionStandBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConsumptionStandBy);

		spnConsumptionStandBy = new JSpinner();
		spnConsumptionStandBy.setModel(new SpinnerNumberModel(new Double(0),
				new Double(0), null, new Double(1)));
		spnConsumptionStandBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(spnConsumptionStandBy);

		JLabel lblConsumptionperdays = new JLabel("Consumo por d\u00EDas:");
		lblConsumptionperdays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConsumptionperdays);

		JPanel daysLabels = new JPanel();
		panel.add(daysLabels);
		daysLabels.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblD);

		JLabel lblL = new JLabel("L");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblL);

		JLabel lblM = new JLabel("M");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblM);

		JLabel lblMi = new JLabel("Mi");
		lblMi.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblMi);

		JLabel lblJ = new JLabel("J");
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblJ);

		JLabel lblV = new JLabel("V");
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblV);

		JLabel lblS = new JLabel("S");
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		daysLabels.add(lblS);

		JPanel panelDaysConsumption = new JPanel();
		panel.add(panelDaysConsumption);
		panelDaysConsumption.setLayout(new GridLayout(1, 0, 0, 0));

		txtDay1 = new TextField();
		txtDay1.setText("0");
		txtDay1.setNumberMode(true);
		txtDay1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay1.setBorder(new LineBorder(new Color(171, 173, 179)));
		panelDaysConsumption.add(txtDay1);
		txtDay1.setColumns(10);

		txtDay2 = new TextField();
		txtDay2.setText("0");
		txtDay2.setNumberMode(true);
		panelDaysConsumption.add(txtDay2);
		txtDay2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay2.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtDay2.setColumns(10);

		txtDay3 = new TextField();
		txtDay3.setText("0");
		txtDay3.setNumberMode(true);
		txtDay3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay3.setBorder(new LineBorder(new Color(171, 173, 179)));
		panelDaysConsumption.add(txtDay3);
		txtDay3.setColumns(10);

		txtDay4 = new TextField();
		txtDay4.setText("0");
		txtDay4.setNumberMode(true);
		txtDay4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay4.setBorder(new LineBorder(new Color(171, 173, 179)));
		panelDaysConsumption.add(txtDay4);
		txtDay4.setColumns(10);

		txtDay5 = new TextField();
		txtDay5.setText("0");
		txtDay5.setNumberMode(true);
		txtDay5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay5.setBorder(new LineBorder(new Color(171, 173, 179)));
		panelDaysConsumption.add(txtDay5);
		txtDay5.setColumns(10);

		txtDay6 = new TextField();
		txtDay6.setText("0");
		txtDay6.setNumberMode(true);
		txtDay6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay6.setBorder(new LineBorder(new Color(171, 173, 179)));
		panelDaysConsumption.add(txtDay6);
		txtDay6.setColumns(10);

		txtDay7 = new TextField();
		txtDay7.setText("0");
		txtDay7.setNumberMode(true);
		txtDay7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDay7.setBorder(new LineBorder(new Color(171, 173, 179)));
		panelDaysConsumption.add(txtDay7);
		txtDay7.setColumns(10);

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
		getContentPane().setLayout(new BorderLayout(0, 0));
		setIconImage(((ImageIcon) ConstantGUI.ICON_ADD_WHITE_16).getImage());
	}

	public void setDevice(Device device) {
		this.device = device;
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
		int[] hourOfUsePerDay = device.getHoursOfUsePerDay();
		txtDay1.setText("" + hourOfUsePerDay[0]);
		txtDay2.setText("" + hourOfUsePerDay[1]);
		txtDay3.setText("" + hourOfUsePerDay[2]);
		txtDay4.setText("" + hourOfUsePerDay[3]);
		txtDay5.setText("" + hourOfUsePerDay[4]);
		txtDay6.setText("" + hourOfUsePerDay[5]);
		txtDay7.setText("" + hourOfUsePerDay[6]);
		btnCreate.setText("Editar dispositivo");
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