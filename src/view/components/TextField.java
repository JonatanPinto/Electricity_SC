package view.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextField extends JTextField implements FocusListener, KeyListener {

	private static final long serialVersionUID = -8726994665089880215L;
	private String placeholder;
	private Color foreground = Color.BLACK;
	private boolean written;
	private boolean decimalMode;
	private boolean numberMode;

	public TextField() {
		initProperties();
	}

	@Override
	public String getText() {
		return written || hasFocus() ? super.getText() : "";
	}

	private void initProperties() {
		addKeyListener(this);
		addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		selectAll();
		if (!written) {
			super.setText("");
			super.setForeground(foreground);
		}
	}

	@Override
	public void setForeground(Color fg) {
		foreground = fg;
		super.setForeground(fg);
	}

	public void setDecimalMode(boolean condition) {
		this.decimalMode = condition;
		if (condition) {
			this.numberMode = false;
		}
	}

	public void setNumberMode(boolean condition) {
		this.numberMode = condition;
		if (condition) {
			this.decimalMode = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		written = (super.getText().length() > 0);
		if (!written) {
			super.setText(placeholder);
			super.setForeground(Color.GRAY);
		}
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
		if (!written && !hasFocus()) {
			super.setText(placeholder);
			setForeground(Color.GRAY);
		}
	}

	public boolean isWritten() {
		return written;
	}

	@Override
	public void setText(String t) {
		super.setText(t);
		written = true;
	}

	public void setWritten(boolean written) {
		this.written = written;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		String keyChar = "" + e.getKeyChar();
		if (keyChar.equals(".") && decimalMode) {
			if (super.getText().contains(".")) {
				e.consume();
			}
		} else if (decimalMode || numberMode) {
			String nums = "0123456789";
			if (!nums.contains(keyChar)) {
				e.consume();
			}
		}
	}

}