package view.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ButtonOpaquer extends JButton implements MouseListener {

	private static final long serialVersionUID = -1112138293577375761L;

	public ButtonOpaquer() {
		initProperties();
	}

	private void initProperties() {
		setFocusPainted(false);
		addMouseListener(this);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setContentAreaFilled(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setContentAreaFilled(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}