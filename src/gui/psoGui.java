package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class psoGui extends JPanel{

	
	public JPanel panel_pso;
	/**
	 * Create the panel.
	 */
	public psoGui() {
		setLayout(null);
		
		panel_pso = new JPanel();
		panel_pso.setBounds(12, 101, 695, 466);
		add(panel_pso);
		panel_pso.setLayout(null);
		
		JLabel lblTest = new JLabel("oi mpourdes tou pso mpainoyn edw");
		lblTest.setBounds(33, 27, 70, 15);
		panel_pso.add(lblTest);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(160, 160, 117, 25);
		panel_pso.add(btnNewButton);

	}

}
