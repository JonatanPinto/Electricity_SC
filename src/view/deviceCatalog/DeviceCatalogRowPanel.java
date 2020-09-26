package view.deviceCatalog;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import view.components.ShutdownButton;
import view.properties.ConstantGUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import models.entities.Device;
import models.entities.DeviceType;
import models.entities.EnergyScale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;

import controller.CatalogController;

public class DeviceCatalogRowPanel extends JPanel implements ActionListener,
		MouseListener {

	private static final long serialVersionUID = -5578655020070513211L;
	private CatalogController controller;
	private Device device;
	private JLabel lblName;
	private JLabel lblIndex;
	private JButton btnEdit;
	private JButton btnRemove;
	private JPanel panel;
	private JLabel lblTradeMark;
	private JLabel lblModel;
	private JLabel lblEnergyScale;
	private JLabel lblDeviceType;
	private JLabel lblSeparator1;
	private JPanel panel_3;
	private JLabel lblDay0;
	private JLabel lblDay1;
	private JLabel lblDay2;
	private JLabel lblDay3;
	private JLabel lblDay4;
	private JLabel lblDay5;
	private JLabel lblDay6;
	private JPanel panelControls;
	private JPanel panel_1;
	private JLabel lblConsuptionStandBy;
	private JLabel lblConsumptionOn;

	public DeviceCatalogRowPanel(CatalogController controller, int index,
			Device device) {
		this.controller = controller;
		initProperties();
		initComponents();
		setDevice(index, device);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src instanceof ShutdownButton) {

		}
	}

	public Device getDevice() {
		return device;
	}

	private void initComponents() {
		lblIndex = new JLabel();
		lblIndex.setPreferredSize(new Dimension(50, 10));
		lblIndex.setBorder(new EmptyBorder(0, 5, 0, 5));
		lblIndex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblIndex, BorderLayout.WEST);

		JPanel panelData = new JPanel();
		panelData.setOpaque(false);
		add(panelData, BorderLayout.CENTER);
		panelData.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setOpaque(false);
		panelData.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		lblEnergyScale = new JLabel();
		lblEnergyScale.setOpaque(true);
		lblEnergyScale.setVisible(false);
		lblEnergyScale.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblEnergyScale.setBackground(new Color(237, 238, 239));
		panel.add(lblEnergyScale);

		lblSeparator1 = new JLabel("");
		lblSeparator1.setBorder(new EmptyBorder(5, 5, 5, 0));
		panel.add(lblSeparator1);

		lblDeviceType = new JLabel();
		lblDeviceType.setOpaque(true);
		lblDeviceType.setVisible(false);
		lblDeviceType.setIcon(ConstantGUI.ICON_FLASH_16);
		lblDeviceType.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblDeviceType.setBackground(new Color(237, 238, 239));
		panel.add(lblDeviceType);

		lblName = new JLabel();
		lblName.setBorder(new EmptyBorder(0, 5, 0, 0));
		lblName.setForeground(new Color(89, 103, 128));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblName);

		lblTradeMark = new JLabel();
		lblTradeMark.setBorder(new EmptyBorder(0, 5, 0, 0));
		lblTradeMark.setForeground(new Color(205, 162, 190));
		lblTradeMark.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblTradeMark);

		lblModel = new JLabel();
		lblModel.setBorder(new EmptyBorder(0, 5, 0, 0));
		lblModel.setForeground(Color.LIGHT_GRAY);
		lblModel.setForeground(new Color(205, 162, 190));
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblModel);

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panelData.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		lblConsumptionOn = new JLabel();
		lblConsumptionOn.setPreferredSize(new Dimension(150, 14));
		lblConsumptionOn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblConsumptionOn);

		lblConsuptionStandBy = new JLabel();
		lblConsuptionStandBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsuptionStandBy.setPreferredSize(new Dimension(150, 14));
		panel_1.add(lblConsuptionStandBy);

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setPreferredSize(new Dimension(200, 10));
		panel_3.setOpaque(false);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		lblDay0 = new JLabel();
		lblDay0.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay0);

		lblDay1 = new JLabel();
		lblDay1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay1);

		lblDay2 = new JLabel();
		lblDay2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay2);

		lblDay3 = new JLabel();
		lblDay3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay3);

		lblDay4 = new JLabel();
		lblDay4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay4);

		lblDay5 = new JLabel();
		lblDay5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay5);

		lblDay6 = new JLabel();
		lblDay6.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblDay6);

		JPanel panelEast = new JPanel();
		panelEast.setPreferredSize(new Dimension(100, 10));
		panelEast.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelEast.setOpaque(false);
		add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BorderLayout(0, 0));

		panelControls = new JPanel();
		panelControls.setOpaque(false);
		panelEast.add(panelControls, BorderLayout.EAST);
		panelControls.setLayout(new GridLayout(0, 2, 0, 0));

		btnEdit = new JButton();
		panelControls.add(btnEdit);
		btnEdit.addMouseListener(this);
		btnEdit.setFocusPainted(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.addActionListener(controller);
		btnEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnEdit.setIcon(ConstantGUI.ICON_PENCIL_GRAY_16);
		btnEdit.setBackground(Color.LIGHT_GRAY);

		btnRemove = new JButton();
		panelControls.add(btnRemove);
		btnRemove.addMouseListener(this);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(Color.LIGHT_GRAY);
		btnRemove.setContentAreaFilled(false);
		btnRemove.addActionListener(controller);
		btnRemove.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnRemove.setIcon(ConstantGUI.ICON_TRASH_GRAY_16);
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.removeCatalogDevice(device.getId());
			}
		});
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRemove.setContentAreaFilled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRemove.setContentAreaFilled(false);
			}
		});
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.editCatalogDevice(device);
			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setContentAreaFilled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setContentAreaFilled(false);
			}
		});
	}

	private void initProperties() {
		addMouseListener(this);
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(new Color(250, 251, 252));
		setPreferredSize(new Dimension(525, 33));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(new LineBorder(Color.LIGHT_GRAY));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(new EmptyBorder(1, 1, 1, 1));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	public void setDevice(int index, Device device) {
		this.device = device;
		lblIndex.setText("" + index);
		setOpaque(index % 2 != 0);
		if (device != null) {
			lblName.setText(device.getName());
			lblTradeMark.setText(device.getTradeMark());
			lblModel.setText(device.getModel());
			setEnergyScale(device.getEnergyScale());
			setDeviceType(device.getDeviceType());
			int[] hoursOfUsePerDay = device.getHoursOfUsePerDay();
			lblDay0.setText("" + hoursOfUsePerDay[0]);
			lblDay1.setText("" + hoursOfUsePerDay[1]);
			lblDay2.setText("" + hoursOfUsePerDay[2]);
			lblDay3.setText("" + hoursOfUsePerDay[3]);
			lblDay4.setText("" + hoursOfUsePerDay[4]);
			lblDay5.setText("" + hoursOfUsePerDay[5]);
			lblDay6.setText("" + hoursOfUsePerDay[6]);
			lblConsumptionOn.setText("" + device.getConsumptionOn() + " kWh");
			lblConsuptionStandBy.setText("" + device.getConsumptionStandBy()
					+ " kWh");
		}
	}

	private void setDeviceType(DeviceType deviceType) {
		if (deviceType != null) {
			lblDeviceType.setVisible(true);
			lblDeviceType.setToolTipText("Tipo de dispositivo ("
					+ deviceType.getName() + ")");
			Icon deviceTypeIcon = null;
			switch (deviceType) {
			case ELECTRONIC:
				deviceTypeIcon = ConstantGUI.ICON_FLASH_16;
				break;
			case HEAT_PRODUCER:
				deviceTypeIcon = ConstantGUI.ICON_FLAME_16;
				break;
			case ILUMINATION:
				deviceTypeIcon = ConstantGUI.ICON_LIGHTBULB_16;
				break;
			case RUN_BY_MOTOR:
				deviceTypeIcon = ConstantGUI.ICON_GEAR_16;
				break;
			}
			lblDeviceType.setIcon(deviceTypeIcon);
		}
	}

	private void setEnergyScale(EnergyScale energyScale) {
		if (energyScale != null) {
			lblEnergyScale.setVisible(true);
			lblEnergyScale.setText(energyScale.getName());
			lblEnergyScale.setToolTipText("Escala de energia (" + energyScale
					+ ")");
		}
	}

}