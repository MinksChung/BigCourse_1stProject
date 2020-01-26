package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextArea;

public class HintTextArea extends JTextArea{
	Font hintfont = new Font("굴림", Font.PLAIN, 15);
	public HintTextArea (final String hint) {
		setText(hint);
		setForeground(Color.GRAY);
		this.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint)) {
					setText("");
					setFont(hintfont);
				} else {
					setText(getText());
					setFont(hintfont);
				}
			}

		});

	}
}
