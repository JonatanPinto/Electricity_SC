package view.deviceCatalog;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JButton;

import models.entities.Device;
import controller.CatalogController;
import view.properties.ConstantGUI;

import java.awt.Font;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class DeviceCatalog extends JPanel {

	private static final long serialVersionUID = 4902612989049174248L;
	private CatalogController controller;
	private JPanel containerDevices;

	public DeviceCatalog(CatalogController controller) {
		this.controller = controller;
		initProperties();
		initComponents();
	}

	private void initComponents() {
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelNorth.setLayout(new BorderLayout(0, 0));
		add(panelNorth, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelNorth.add(panel, BorderLayout.WEST);

		JButton btnCreateDevice = new JButton();
		btnCreateDevice.setFocusPainted(false);
		btnCreateDevice.setForeground(Color.WHITE);
		btnCreateDevice.setText("Crear dispositivo");
		btnCreateDevice.addActionListener(controller);
		btnCreateDevice.setBackground(new Color(0, 123, 255));
		btnCreateDevice.setIcon(ConstantGUI.ICON_ADD_WHITE_16);
		btnCreateDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateDevice.setActionCommand(ConstantGUI.C_DEVICE_CREATOR_OPEN);
		panel.add(btnCreateDevice);

		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		panelCenter.setLayout(new BorderLayout(0, 0));
		add(panelCenter);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panelCenter.add(scrollPane, BorderLayout.CENTER);

		JPanel auxContainerDevices = new JPanel();
		auxContainerDevices.setOpaque(false);
		scrollPane.setViewportView(auxContainerDevices);
		auxContainerDevices.setLayout(new BorderLayout(0, 0));

		containerDevices = new JPanel();
		containerDevices.setOpaque(false);
		auxContainerDevices.add(containerDevices, BorderLayout.NORTH);
		containerDevices.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelTitles = new JPanel();
		panelTitles.setOpaque(false);
		panelTitles.setPreferredSize(new Dimension(100, 33));
		panelCenter.add(panelTitles, BorderLayout.NORTH);
		panelTitles.setLayout(new BorderLayout(0, 0));

		JLabel lblTitleIndex = new JLabel();
		lblTitleIndex.setText("#");
		lblTitleIndex.setPreferredSize(new Dimension(50, 10));
		lblTitleIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleIndex.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitleIndex.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelTitles.add(lblTitleIndex, BorderLayout.WEST);

		JPanel panelTitlesCenter = new JPanel();
		panelTitlesCenter.setOpaque(false);
		panelTitles.add(panelTitlesCenter, BorderLayout.CENTER);
		panelTitlesCenter.setLayout(new BorderLayout(0, 0));

		JLabel lblTitleDevice = new JLabel("Dispositivo");
		panelTitlesCenter.add(lblTitleDevice);
		lblTitleDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panelTitlesCenter.add(panel_1, BorderLayout.EAST);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
				
				JLabel lblConsumptionOn = new JLabel("Prendido");
				lblConsumptionOn.setPreferredSize(new Dimension(150, 14));
				lblConsumptionOn.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel_1.add(lblConsumptionOn);
				
				JLabel lblConsuptionstandby = new JLabel("Descansando");
				lblConsuptionstandby.setPreferredSize(new Dimension(150, 14));
				lblConsuptionstandby.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel_1.add(lblConsuptionstandby);
		
				JPanel panelExtraTitles = new JPanel();
				panel_1.add(panelExtraTitles);
				panelExtraTitles.setBorder(new EmptyBorder(0, 0, 0, 0));
				panelExtraTitles.setPreferredSize(new Dimension(200, 10));
				panelExtraTitles.setOpaque(false);
				panelExtraTitles.setLayout(new GridLayout(1, 0, 0, 0));
				
						JLabel lblDay0 = new JLabel("D");
						lblDay0.setHorizontalAlignment(SwingConstants.CENTER);
						lblDay0.setFont(new Font("Tahoma", Font.BOLD, 15));
						panelExtraTitles.add(lblDay0);
						
								JLabel lblDay1 = new JLabel("L");
								lblDay1.setHorizontalAlignment(SwingConstants.CENTER);
								lblDay1.setFont(new Font("Tahoma", Font.BOLD, 15));
								panelExtraTitles.add(lblDay1);
								
										JLabel lblDay2 = new JLabel("M");
										lblDay2.setHorizontalAlignment(SwingConstants.CENTER);
										lblDay2.setFont(new Font("Tahoma", Font.BOLD, 15));
										panelExtraTitles.add(lblDay2);
										
												JLabel lblDay3 = new JLabel("Mi");
												lblDay3.setHorizontalAlignment(SwingConstants.CENTER);
												lblDay3.setFont(new Font("Tahoma", Font.BOLD, 15));
												panelExtraTitles.add(lblDay3);
												
														JLabel lblDay4 = new JLabel("J");
														lblDay4.setHorizontalAlignment(SwingConstants.CENTER);
														lblDay4.setFont(new Font("Tahoma", Font.BOLD, 15));
														panelExtraTitles.add(lblDay4);
														
																JLabel lblDay5 = new JLabel("V");
																lblDay5.setHorizontalAlignment(SwingConstants.CENTER);
																lblDay5.setFont(new Font("Tahoma", Font.BOLD, 15));
																panelExtraTitles.add(lblDay5);
																
																		JLabel lblDay6 = new JLabel("S");
																		lblDay6.setHorizontalAlignment(SwingConstants.CENTER);
																		lblDay6.setFont(new Font("Tahoma", Font.BOLD, 15));
																		panelExtraTitles.add(lblDay6);

		JPanel panelExtraSpace = new JPanel();
		panelExtraSpace.setPreferredSize(new Dimension(100, 10));
		panelExtraSpace.setOpaque(false);
		panelTitles.add(panelExtraSpace, BorderLayout.EAST);
	}

	private void initProperties() {
		setSize(800, 500);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
	}

	public void setDevices(List<Device> devices) {
		containerDevices.removeAll();
		for (int i = 0; i < devices.size(); i++) {
			containerDevices.add(new DeviceCatalogRowPanel(controller, i + 1,
					devices.get(i)));
		}
		containerDevices.setVisible(false);
		containerDevices.setVisible(true);
	}

}