package view.deviceSelector;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import view.properties.ConstantGUI;
import models.entities.Device;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeviceSelector extends JDialog implements ActionListener {

	private static final long serialVersionUID = 9132690814599659698L;
	private JPanel containerDevices;
	private JButton btnAdd;
	private List<Device> devices;

	public DeviceSelector(List<Device> devices) {
		intiProperties();
		initComponents();
		setDevices(devices);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnAdd)) {
			this.devices = buildSelectedDevices();
		}
		setVisible(false);
	}

	private List<Device> buildSelectedDevices() {
		List<Device> devices = new ArrayList<Device>();
		Component[] components = containerDevices.getComponents();
		for (Component component : components) {
			if (component instanceof DeviceSelectorRow) {
				devices.addAll(((DeviceSelectorRow) component).getDevices());
			}
		}
		return devices;
	}

	public List<Device> getSelectedDevices() {
		return devices;
	}

	private void initComponents() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		scrollPane.setViewportView(panel);

		containerDevices = new JPanel();
		containerDevices.setLayout(new BoxLayout(containerDevices,
				BoxLayout.Y_AXIS));
		panel.add(containerDevices, BorderLayout.NORTH);

		JPanel panelControls = new JPanel();
		getContentPane().add(panelControls, BorderLayout.SOUTH);

		btnAdd = new JButton();
		btnAdd.setText("Agregar");
		btnAdd.setFocusPainted(false);
		btnAdd.addActionListener(this);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(ConstantGUI.COLOR_PRIMARY);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelControls.add(btnAdd);

		JButton btnCancel = new JButton();
		btnCancel.setText("Cancelar");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(this);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(ConstantGUI.COLOR_SECONDARY);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelControls.add(btnCancel);
	}

	private void intiProperties() {
		setModal(true);
		setSize(450, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Selector de dispositivos");
		getContentPane().setLayout(new BorderLayout(0, 0));
		setIconImage(((ImageIcon) ConstantGUI.ICON_ADD_WHITE_16).getImage());
	}

	private void setDevices(List<Device> devices) {
		for (Device device : devices) {
			containerDevices.add(new DeviceSelectorRow(device));
		}
	}

}