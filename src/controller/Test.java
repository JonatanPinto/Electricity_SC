package controller;

import java.util.ArrayList;

import models.entities.Device;
import models.entities.EnergyBill;
import utilities.numbers.NumberGenerator;

public class Test {

	@SuppressWarnings("unused")
	private ArrayList<Device> devices;
	@SuppressWarnings("unused")
	private ArrayList<EnergyBill> energyBills;

	public Test() {
		// devices = new ArrayList<Device>();
		// devices.add(new Device(1, true, DeviceType.ELECTRONIC,
		// "Smart-TV 1001", "Panasonic", EnergyScale.A, 0.15, 180));
		// energyBills = new ArrayList<EnergyBill>();

	}

	public static void main(String[] args) {
		NumberGenerator generator = new NumberGenerator();
		System.out.println(generator.generateInt(1, 10));
	}

}
