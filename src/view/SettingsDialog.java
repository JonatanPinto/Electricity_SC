package view;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import view.components.TextField;
import view.properties.ConstantGUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class SettingsDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 4333492082030324369L;
	private JButton btnSave;
	private JSlider slider;
	private boolean toSave;
	private TextField txtKiloWattCost;

	public SettingsDialog(int simulationSpeed, double kiloWattCost) {
		initProperties();
		initComponents();
		setKiloWattCost(kiloWattCost);
		setSimulationSpeed(simulationSpeed);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnSave)) {
			this.toSave = true;
		}
		setVisible(false);
	}

	public double getKiWattCost() {
		String sKiloWattCost = txtKiloWattCost.getText();
		return sKiloWattCost.isEmpty() ? 0 : Double.parseDouble(sKiloWattCost);
	}

	public int getSimulationSpeed() {
		return slider.getValue();
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblSimulationspeed = new JLabel();
		lblSimulationspeed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSimulationspeed
				.setText("Velocidad de simulaci\u00F3n (ms/d\u00EDa):");
		panel.add(lblSimulationspeed);

		slider = new JSlider();
		slider.setMaximum(1000);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(100);
		panel.add(slider);

		JLabel lblKiloWattCost = new JLabel("Costo por Kilo Watt:");
		lblKiloWattCost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblKiloWattCost);

		JPanel panelKiloWattCost = new JPanel();
		panelKiloWattCost.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.add(panelKiloWattCost);
		panelKiloWattCost.setLayout(new BorderLayout(0, 0));

		txtKiloWattCost = new TextField();
		txtKiloWattCost.setBorder(null);
		txtKiloWattCost.setDecimalMode(true);
		panelKiloWattCost.add(txtKiloWattCost);

		JLabel lblCurrency = new JLabel("$");
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrency.setOpaque(true);
		lblCurrency.setBackground(Color.WHITE);
		lblCurrency.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelKiloWattCost.add(lblCurrency, BorderLayout.WEST);

		JPanel panelControls = new JPanel();
		getContentPane().add(panelControls, BorderLayout.SOUTH);

		btnSave = new JButton("Guardar");
		btnSave.setFocusPainted(false);
		btnSave.addActionListener(this);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBackground(ConstantGUI.COLOR_PRIMARY);
		panelControls.add(btnSave);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(this);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(ConstantGUI.COLOR_SECONDARY);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelControls.add(btnCancel);

		JLabel lblTitle = new JLabel("Ajustes");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblTitle, BorderLayout.NORTH);
	}

	private void initProperties() {
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);

		setModal(true);
		setSize(350, 300);
		setTitle("Ajustes");
		setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(((ImageIcon) ConstantGUI.ICON_GEAR_WHITE_16).getImage());
	}

	public boolean isToSave() {
		return toSave;
	}

	private void setKiloWattCost(double kiloWattCost) {
		txtKiloWattCost.setText("" + kiloWattCost);
	}

	private void setSimulationSpeed(int speed) {
		slider.setValue(speed);
	}

}