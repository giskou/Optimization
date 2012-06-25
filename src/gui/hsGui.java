package gui;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class hsGui extends JPanel {


	public JPanel panel_hs;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public hsGui() {
		setLayout(null);
		panel_hs = new JPanel();
		panel_hs.setBorder(new TitledBorder(null, "Harmony Search", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
		panel_hs.setBounds(12, 12, 673, 216);
		add(panel_hs);
		panel_hs.setLayout(null);
		
		JLabel lblPopulationSize = new JLabel("Population Size");
		lblPopulationSize.setBounds(12, 38, 124, 15);
		panel_hs.add(lblPopulationSize);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 36, 50, 19);
		panel_hs.add(textField);
		
		JLabel lblHmcr = new JLabel("HMCR");
		lblHmcr.setBounds(12, 78, 70, 15);
		panel_hs.add(lblHmcr);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 76, 50, 19);
		textField_1.setToolTipText("0.9");
		panel_hs.add(textField_1);
		
		JLabel lblPar = new JLabel("PAR");
		lblPar.setBounds(12, 117, 70, 15);
		panel_hs.add(lblPar);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 115, 50, 19);
		textField_2.setToolTipText("0.7");
		panel_hs.add(textField_2);
		
		JLabel lblMuttationFactor = new JLabel("Muttation factor");
		lblMuttationFactor.setBounds(12, 156, 124, 15);
		panel_hs.add(lblMuttationFactor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 154, 50, 19);
		textField_3.setToolTipText("1");
		panel_hs.add(textField_3);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(558, 168, 89, 25);
		panel_hs.add(button);
	}
}
