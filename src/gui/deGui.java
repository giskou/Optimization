package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import libs.Input;
import libs.Range;
import libs.Result;
import libs.functions.Ackley;
import libs.functions.Function;
import methods.evolution.differential.DEInput;
import methods.evolution.differential.DERecombination;
import methods.evolution.differential.DifferentialEvolution;
import methods.evolution.differential.mutation.Best1Bin;
import methods.evolution.differential.mutation.Best2Bin;
import methods.evolution.differential.mutation.DEMutation;
import methods.evolution.differential.mutation.Rand1Bin;
import methods.evolution.differential.mutation.Rand2Bin;
import methods.evolution.differential.mutation.Rand2BinStar;

@SuppressWarnings("serial")
public class deGui extends JPanel {

	public JPanel panel_de;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	public int V;
	private JTextField textField_2;
	/**
	 * Create the panel.
	 */
	public deGui() {
		
		setLayout(null);
		panel_de = new JPanel();
		panel_de.setBorder(new TitledBorder(null, "Differential Evolution", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
		panel_de.setBounds(12, 12, 673, 216);
		add(panel_de);
		panel_de.setLayout(null);
		
		JLabel lblF = new JLabel("F");
		lblF.setBounds(12, 115, 30, 15);
		panel_de.add(lblF);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(49, 113, 50, 19);
		panel_de.add(textField);
		
		JLabel lblCr = new JLabel("CR");
		lblCr.setBounds(12, 142, 30, 15);
		panel_de.add(lblCr);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 138, 50, 19);
		panel_de.add(textField_1);
		
		JRadioButton rdbtnBestbin = new JRadioButton("Best/1/bin");
		rdbtnBestbin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V = 1;
			}
		});
		rdbtnBestbin.setBounds(8, 73, 103, 23);
		panel_de.add(rdbtnBestbin);
		
		JRadioButton rdbtnRandbin = new JRadioButton("Rand/1/bin");
		rdbtnRandbin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V = 2;
			}
		});
		rdbtnRandbin.setBounds(115, 73, 103, 23);
		panel_de.add(rdbtnRandbin);
		
		JRadioButton rdbtnRandStarbin = new JRadioButton("Rand Star/2/bin");
		rdbtnRandStarbin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V = 3;
			}
		});
		rdbtnRandStarbin.setBounds(222, 73, 144, 23);
		panel_de.add(rdbtnRandStarbin);
		
		JRadioButton rdbtnBestbin_1 = new JRadioButton("Best/2/bin");
		rdbtnBestbin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V = 4;
			}
		});
		rdbtnBestbin_1.setBounds(370, 73, 103, 23);
		panel_de.add(rdbtnBestbin_1);
		
		JRadioButton rdbtnRandbin_1 = new JRadioButton("Rand/2/bin");
		rdbtnRandbin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V = 5;
			}
		});
		rdbtnRandbin_1.setBounds(482, 73, 103, 23);
		panel_de.add(rdbtnRandbin_1);
		
		//Group the radio buttons.
		ButtonGroup selectors = new ButtonGroup();
		selectors.add(rdbtnBestbin);
		selectors.add(rdbtnRandbin);
		selectors.add(rdbtnRandStarbin);
		selectors.add(rdbtnBestbin_1);
		selectors.add(rdbtnRandbin_1);
		
		button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Function f = new Ackley(20, 0.2, (2*Math.PI), 0);
				double min[] = {-30, -30};
				double max[] = {30, 30};
				Range range = new Range(min, max);
				DEMutation m = null;
				
				switch(V){
					case 1:	m = new Best1Bin(Float.valueOf(textField.getText()));
						break;
					case 2:	m = new Rand1Bin(Float.valueOf(textField.getText()));
						break;
					case 3:	m = new Rand2BinStar(Float.valueOf(textField.getText()));
						break;
					case 4:	m = new Best2Bin(Float.valueOf(textField.getText()));
						break;
					case 5:	m = new Rand2Bin(Float.valueOf(textField.getText()));
						break;
					default: System.out.println("What a Terrible Failure");
				}
				DERecombination r = new DERecombination(Float.valueOf(textField_1.getText()));
				Input in = new DEInput(f, range, mainGui.get_Calc(), mainGui.get_Acc(), Integer.parseInt(textField_2.getText()), m, r);
				Result res = DifferentialEvolution.run(in);
				String output = "DE result = " + res.getValue() + " at " + res.getRes() + " after " + res.getSteps() +"\n";
				mainGui.textArea.append(output);
			}
		});
		button.setBounds(572, 168, 89, 25);
		panel_de.add(button);
		
		JLabel lblPopulationSize = new JLabel("Population Size");
		lblPopulationSize.setBounds(12, 39, 126, 15);
		panel_de.add(lblPopulationSize);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 37, 50, 19);
		panel_de.add(textField_2);
	}
}
