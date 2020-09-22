package models.entities;

import java.util.Date;

public class EnergyBill {

	private int id;
	private Date date;
	private double mensualConsumption;
	private double kWattPrice;
	
	/**
	 * 
	 * @param id
	 * @param home
	 * @param date
	 * @param mensualConsumption
	 * @param kWattPrice
	 */
	public EnergyBill(int id, Date date, double mensualConsumption, double kWattPrice) {
		super();
		this.id = id;
		this.date = date;
		this.mensualConsumption = mensualConsumption;
		this.kWattPrice = kWattPrice;
	}

	/**
	 *
	 * @param id
	 * @param home
	 * @param mensualConsumption
	 * @param kWattPrice
	 */
	public EnergyBill(int id, double mensualConsumption, double kWattPrice) {
		super();
		this.id = id;
		this.date = new Date();
		this.mensualConsumption = mensualConsumption;
		this.kWattPrice = kWattPrice;
	}
	
	
	//--------------------   Setters and Getters   --------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMensualConsumption() {
		return mensualConsumption;
	}

	public void setMensualConsumption(double mensualConsumption) {
		this.mensualConsumption = mensualConsumption;
	}

	public double getkWattPrice() {
		return kWattPrice;
	}

	public void setkWattPrice(double kWattPrice) {
		this.kWattPrice = kWattPrice;
	}
}
