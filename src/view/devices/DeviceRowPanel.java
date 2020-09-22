package view.devices;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import view.properties.ConstantGUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import models.entities.Device;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

public class DeviceRowPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = -5578655020070513211L;
	private ActionListener actionListener;
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
	private JProgressBar progressBar;
	private JToggleButton tglbtnOn;
	private JLabel lblTime;
	private JPanel panel_1;

	public DeviceRowPanel() {
		initProperties();
		initComponents();
	}

	public DeviceRowPanel(ActionListener actionListener, int index,
			Device device) {
		this.actionListener = actionListener;
		initProperties();
		initComponents();
		setDevice(index, device);
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
		panelData.setLayout(new GridLayout(1, 0, 0, 0));
		add(panelData, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setOpaque(false);
		panelData.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		lblEnergyScale = new JLabel("A++");
		lblEnergyScale.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblEnergyScale.setBackground(new Color(237, 238, 239));
		lblEnergyScale.setOpaque(true);
		panel.add(lblEnergyScale);

		lblSeparator1 = new JLabel("");
		lblSeparator1.setBorder(new EmptyBorder(5, 5, 5, 0));
		panel.add(lblSeparator1);

		lblDeviceType = new JLabel();
		lblDeviceType.setOpaque(true);
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

		JPanel panelControls = new JPanel();
		panelControls.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelControls.setOpaque(false);
		add(panelControls, BorderLayout.EAST);

		btnEdit = new JButton();
		btnEdit.addMouseListener(this);
		btnEdit.setFocusPainted(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.addActionListener(actionListener);
		btnEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnEdit.setIcon(ConstantGUI.ICON_PENCIL_GRAY_16);
		btnEdit.setBackground(Color.LIGHT_GRAY);
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
		panelControls.setLayout(new BoxLayout(panelControls, BoxLayout.X_AXIS));

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelControls.add(panel_1);

		progressBar = new JProgressBar();
		panel_1.add(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setString("80%");
		progressBar.setValue(80);

		lblTime = new JLabel("20 horas");
		lblTime.setPreferredSize(new Dimension(100, 14));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelControls.add(lblTime);

		tglbtnOn = new JToggleButton("Off");
		panelControls.add(tglbtnOn);
		panelControls.add(btnEdit);

		btnRemove = new JButton();
		btnRemove.addMouseListener(this);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(Color.LIGHT_GRAY);
		btnRemove.setContentAreaFilled(false);
		btnRemove.addActionListener(actionListener);
		btnRemove.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnRemove.setIcon(ConstantGUI.ICON_TRASH_GRAY_16);
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
		panelControls.add(btnRemove);
	}

	private void initProperties() {
		setOpaque(false);
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
		lblIndex.setText("" + index);
		setOpaque(index % 2 != 0);
		if (device != null) {
			lblName.setText(device.getName());
			lblTradeMark.setText(device.getTradeMark());
			lblModel.setText(device.getModel());
		}
	}

}