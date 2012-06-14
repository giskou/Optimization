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
import methods.swarm.Network;
import methods.swarm.PSO;
import methods.swarm.PSOInput;
import methods.swarm.RingLatice;

@SuppressWarnings("serial")
public class psoGui extends JPanel{

	
	public JPanel panel_pso;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
		lblC.setBounds(33, 104, 37, 15);
		panel_pso.add(lblC);
		
		JLabel lblC_1 = new JLabel("c2");
		lblC_1.setBounds(33, 131, 37, 15);
		panel_pso.add(lblC_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 102, 50, 19);
		textField.setToolTipText("2.05");
		panel_pso.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(69, 129, 50, 19);
		textField_1.setToolTipText("2.05");
		panel_pso.add(textField_1);
		
		JLabel lblConstrictionCoefficient = new JLabel("Constriction Coefficient");
		lblConstrictionCoefficient.setBounds(33, 158, 183, 15);
		panel_pso.add(lblConstrictionCoefficient);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(234, 154, 50, 19);
		textField_2.setToolTipText("0.729");
		panel_pso.add(textField_2);
		
		JLabel lblPopulationSize = new JLabel("Population Size");
		lblPopulationSize.setBounds(33, 67, 133, 15);
		panel_pso.add(lblPopulationSize);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 65, 50, 19);
		panel_pso.add(textField_3);
		
		JLabel lblNeigbourhoudSize = new JLabel("Neighbourhood Size");
		lblNeigbourhoudSize.setBounds(305, 67, 147, 15);
		panel_pso.add(lblNeigbourhoudSize);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("0.729");
		textField_4.setColumns(10);
		textField_4.setBounds(470, 65, 50, 19);
		panel_pso.add(textField_4);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Function f = new Ackley(20, 0.2, (2*Math.PI), 0);
				double min[] = {-30, -30};
				double max[] = {30, 30};
				
				Range range = new Range(min, max);
				Network net = new RingLatice(Integer.parseInt(textField_4.getText()));
				Input in = new PSOInput(f, range, mainGui.get_Calc(), mainGui.get_Acc(), Integer.parseInt(textField_3.getText()) , Float.valueOf(textField_2.getText()), Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()), net);
				Result res = PSO.run(in);
				String output = "PSO result = " + res.getValue() + " at " + res.getRes() + " after " + res.getSteps() +"\n";
				mainGui.textArea.append(output);
			}
		});
		button.setBounds(559, 167, 89, 25);
		panel_pso.add(button);
		

	}
}
