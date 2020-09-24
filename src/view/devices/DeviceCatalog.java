package view.devices;

import javax.swing.JDialog;

public class DeviceCatalog extends JDialog {

	private static final long serialVersionUID = 4902612989049174248L;

	public DeviceCatalog() {
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