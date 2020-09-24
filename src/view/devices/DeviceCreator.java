package view.devices;

import javax.swing.JDialog;

public class DeviceCreator extends JDialog {

	private static final long serialVersionUID = -433841757497840469L;

	public DeviceCreator() {
		initProperties();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub

	}

	private void initProperties() {
		setModal(true);
		setSize(800, 500);
		setLocationRelativeTo(null);
	}

}