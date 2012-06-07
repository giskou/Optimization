package gui;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class deGui extends JPanel {

	public JPanel panel_de;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	/**
	 * Create the panel.
	 */
	public deGui() {
		
		setLayout(null);
		panel_de = new JPanel();
		panel_de.setBorder(new TitledBorder(null, "Differencial Evolution", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
		panel_de.setBounds(12, 12, 673, 216);
		add(panel_de);
		panel_de.setLayout(null);
		
		JLabel lblF = new JLabel("F");
		lblF.setBounds(12, 41, 30, 15);
		panel_de.add(lblF);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(49, 39, 50, 19);
		panel_de.add(textField);
		
		JLabel lblCr = new JLabel("CR");
		lblCr.setBounds(12, 68, 30, 15);
		panel_de.add(lblCr);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 68, 50, 19);
		panel_de.add(textField_1);
		
		button = new JButton("Start");
		button.setBounds(551, 112, 89, 25);
		panel_de.add(button);
	}
}
