package view.devices;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PreferencesController;
import view.properties.ConstantGUI;

public class NoDevicesPanel extends JPanel {

	private static final long serialVersionUID = 8010053067789184734L;
	private PreferencesController controller;

	public NoDevicesPanel(PreferencesController controller) {
		this.controller = controller;
		initProperties();
		initComponents();
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);

		JPanel panelIcon = new JPanel();
		panelIcon.setOpaque(false);
		panel.add(panelIcon);

		JLabel lblEmptyBoxIcon = new JLabel();
		lblEmptyBoxIcon.setIcon(ConstantGUI.ICON_EMPTY_BOX_128);
		panelIcon.add(lblEmptyBoxIcon);

		JPanel panelTitle = new JPanel();
		panelTitle.setOpaque(false);
		panel.add(panelTitle);

		JLabel lblNoDeviceTitle = new JLabel();
		lblNoDeviceTitle.setText("Sin dispositivos");
		lblNoDeviceTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelTitle.add(lblNoDeviceTitle);

		JPanel panelAddDevice = new JPanel();
		panelAddDevice.setOpaque(false);
		panel.add(panelAddDevice);

		JButton button = new JButton();
		button.setFocusPainted(false);
		button.setForeground(Color.WHITE);
		button.addActionListener(controller);
		button.setText("Agregar dispositivo");
		button.setBackground(ConstantGUI.COLOR_PRIMARY);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setActionCommand(ConstantGUI.C_DEVICE_SELECTOR_OPEN);
		panelAddDevice.add(button);
	}

	private void initProperties() {
		setOpaque(false);
		setLayout(new GridBagLayout());
	}

}
