package view.deviceSelector;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import models.entities.Device;
import models.entities.DeviceType;
import models.entities.EnergyScale;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import view.components.TextField;
import view.properties.ConstantGUI;

public class DeviceSelectorRow extends JPanel {

	private static final long serialVersionUID = -7089117400471602489L;
	private Device device;
	private JLabel lblName;
	private JLabel lblTitleName;
	private JLabel lblDeviceType;
	private JLabel lblEnergyScale;
	private JLabel lblTradeMark;
	private JLabel lblModel;
	private JLabel lblConsumptionOn;
	private JLabel lblConsumptionStandBy;
	private JLabel lblCollapse;
	private JPanel panelDescription;
	private JPanel panel;
	private JPanel panel_1;
	private TextField txtAmount;

	public DeviceSelectorRow(Device device) {
		this.device = device;
		initProperties();
		initComponents();
		setDevice(device);
		collapse(true);
	}

	public void collapse(boolean condition) {
		panelDescription.setVisible(!condition);
		lblCollapse.setText(condition ? "\u25BC" : "\u25B2");
	}

	public List<Device> getDevices() {
		List<Device> devices = new ArrayList<Device>();
		String sAmount = txtAmount.getText();
		int amount = sAmount.isEmpty() ? 0 : Integer.parseInt(sAmount);
		for (int i = 0; i < amount; i++) {
			Device deviceClone = device.clone();
			deviceClone.setState(true);
			devices.add(deviceClone);
		}
		return devices;
	}

	private void initComponents() {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.CENTER);

		JPanel panelTitles = new JPanel();
		panelTitles.setLayout(new BorderLayout(0, 0));
		panelTitles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(panelTitles, BorderLayout.NORTH);

		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelTitles.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(5, 5));

		lblTitleName = new JLabel();
		panel_1.add(lblTitleName, BorderLayout.CENTER);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				collapse(panelDescription.isVisible());
			}
		});
		lblTitleName.setFont(new Font("Tahoma", Font.BOLD, 15));

		lblCollapse = new JLabel("\u25B2");
		panel_1.add(lblCollapse, BorderLayout.EAST);
		lblCollapse.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblCollapse.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtAmount = new TextField();
		txtAmount.setSelectionColor(Color.LIGHT_GRAY);
		txtAmount.setText("0");
		txtAmount.setColumns(3);
		txtAmount.setNumberMode(true);
		txtAmount.setBackground(ConstantGUI.COLOR_PRIMARY);
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtAmount.setForeground(Color.WHITE);
		panelTitles.add(txtAmount, BorderLayout.EAST);

		panelDescription = new JPanel();
		panel.add(panelDescription, BorderLayout.CENTER);
		panelDescription.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDescription.setLayout(new BoxLayout(panelDescription,
				BoxLayout.Y_AXIS));

		lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblName);

		lblDeviceType = new JLabel();
		lblDeviceType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblDeviceType);

		lblEnergyScale = new JLabel();
		lblEnergyScale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblEnergyScale);

		lblTradeMark = new JLabel();
		lblTradeMark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblTradeMark);

		lblModel = new JLabel();
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblModel);

		lblConsumptionOn = new JLabel();
		lblConsumptionOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblConsumptionOn);

		lblConsumptionStandBy = new JLabel();
		lblConsumptionStandBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDescription.add(lblConsumptionStandBy);
	}

	private void initProperties() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new LineBorder(Color.LIGHT_GRAY));
	}

	private void setDevice(Device device) {
		lblTitleName.setText(device.getName());
		lblName.setText("Nombre: " + device.getName());
		DeviceType deviceType = device.getDeviceType();
		if (deviceType != null) {
			lblDeviceType.setText("Tipo de dispositivo: "
					+ deviceType.getName());
		}
		EnergyScale energyScale = device.getEnergyScale();
		if (energyScale != null) {
			lblEnergyScale.setText("Escala de energia: "
					+ energyScale.getName());
		}
		lblTradeMark.setText("Marca comercial: " + device.getTradeMark());
		lblModel.setText("Modelo: " + device.getModel());
		lblConsumptionOn.setText("Consumo en modo prendido: "
				+ device.getConsumptionOn());
		lblConsumptionStandBy.setText("Consumo en modo espera: "
				+ device.getConsumptionStandBy());
	}

}