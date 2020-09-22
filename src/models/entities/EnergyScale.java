package models.entities;

public enum EnergyScale {

	A3("A+++",	0.15,	0.25), 
	A2("A++",	0.25,	0.35), 
	A1("A+",	0.35,	0.45), 
	A("A",		0.45,	0.55), 
	B("B", 		0.55, 	0.75), 
	C("C", 		0.75,	0.99), 
	D("D",		0.99,	1), 
	E("E",		1,		1.1), 
	F("F",		1.1,	1.25),
	G("G",		1.25,	2),
	N("NE", 1, 1);
	
	private String name;
	private double energyEfficiencyMin;
	private double energyEfficiencyMax;
	
	private EnergyScale(String name, double energyEfficiencyMin, double energyEfficiencyMax){
		this.name = name;
		this.energyEfficiencyMin = energyEfficiencyMin;
		this.energyEfficiencyMax = energyEfficiencyMax;
	}
	
	public String getName() {
		return name;
	}

	public double getEnergyEfficiencyMin() {
		return energyEfficiencyMin;
	}

	public double getEnergyEfficiencyMax() {
		return energyEfficiencyMax;
	}
}
