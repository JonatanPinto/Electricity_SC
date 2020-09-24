package view.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import models.entities.Device;
import view.properties.ConstantGUI;

public class ShutdownButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 4093466157606197442L;
	private Device device;
	private boolean turnedOn;

	public ShutdownButton() {
		initProperties();
		turnOff();
	}

	private void initProperties() {
		setFocusPainted(false);
		setForeground(Color.WHITE);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changeState(!turnedOn);
	}

	public void changeState(boolean condition) {
		if (condition) {
			turnOn();
		} else {
			turnOff();
		}
		if (this.device != null) {
			this.device.setState(turnedOn);
		}
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public void setTurnedOn(boolean condition) {
		changeState(condition);
	}

	public void turnOff() {
		setText("OFF");
		this.turnedOn = false;
		setBackground(ConstantGUI.COLOR_SECONDARY);
	}

	public void turnOn() {
		setText("ON");
		this.turnedOn = true;
		setBackground(ConstantGUI.COLOR_PRIMARY);
	}

}