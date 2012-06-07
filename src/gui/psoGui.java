package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import libs.Input;
import libs.Range;
import libs.Result;
import libs.functions.Ackley;
import libs.functions.Function;
import methods.evolution.EvInput;
import methods.evolution.GenericEvolution;

@SuppressWarnings("serial")
public class psoGui extends JPanel{

	
	public JPanel panel_pso;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Create the panel.
	 */
	public psoGui() {
		setLayout(null);
		
		panel_pso = new JPanel();
		panel_pso.setBorder(new TitledBorder(null, "PSO", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
		panel_pso.setBounds(12, 12, 673, 216);
		add(panel_pso);
		panel_pso.setLayout(null);
		
		JLabel lblTest = new JLabel("PSO parameters");
		lblTest.setBounds(33, 27, 133, 15);
		panel_pso.add(lblTest);
		
		JLabel lblC = new JLabel("c1");
		lblC.setBounds(33, 63, 37, 15);
		panel_pso.add(lblC);
		
		JLabel lblC_1 = new JLabel("c2");
		lblC_1.setBounds(33, 90, 37, 15);
		panel_pso.add(lblC_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 61, 50, 19);
		panel_pso.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 88, 50, 19);
		panel_pso.add(textField_1);
		
		JLabel lblConstrictionCoefficient = new JLabel("Constriction Coefficient");
		lblConstrictionCoefficient.setBounds(33, 131, 183, 15);
		panel_pso.add(lblConstrictionCoefficient);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(234, 129, 50, 19);
		panel_pso.add(textField_2);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Function f = new Ackley(20, 0.2, (2*Math.PI), 0);
				double min[] = {-30, -30};
				double max[] = {30, 30};
				
//				Range range = new Range(min, max);
//				Result res;
//				
//				Input in = new EvInput(f, range, mainGui.get_Calc(), mainGui.get_Acc(), sel, rc, m, popsize);
//				res = DIfferecinalEvolution.run(in);
//				String output = "PSO result = " + res.getValue() + " at " + res.getRes() + " after " + res.getSteps() +"\n";
//				mainGui.textArea.append(output);
			}
		});
		button.setBounds(559, 167, 89, 25);
		panel_pso.add(button);

	}
}
