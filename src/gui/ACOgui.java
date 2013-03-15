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
import libs.functions.Function;
import libs.functions.MagicSquare;
import methods.swarm.aco.ACOMMInput;
import methods.swarm.aco.ACOMinMax;

public class ACOgui extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6042688235222908270L;
	public JPanel panel_aco;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	public ACOgui() {
		setLayout(null);
		panel_aco = new JPanel();
		panel_aco.setBorder(new TitledBorder(null, "ACO Min Max", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
		panel_aco.setBounds(12, 12, 673, 216);
		add(panel_aco);
		panel_aco.setLayout(null);
		
		JLabel lblPopulationSize = new JLabel("Population Size");
		lblPopulationSize.setBounds(12, 32, 106, 15);
		panel_aco.add(lblPopulationSize);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 30, 50, 19);
		panel_aco.add(textField);
		
		JLabel lblProbability = new JLabel("Pheromone");
		lblProbability.setBounds(12, 59, 95, 15);
		panel_aco.add(lblProbability);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 57, 50, 19);
		panel_aco.add(textField_1);
		
		JLabel lblDt = new JLabel("dt");
		lblDt.setBounds(12, 86, 61, 15);
		panel_aco.add(lblDt);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 84, 50, 19);
		panel_aco.add(textField_2);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(12, 113, 61, 15);
		panel_aco.add(lblA);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(136, 111, 50, 19);
		panel_aco.add(textField_3);
		
		JLabel lblB = new JLabel("b");
		lblB.setBounds(222, 113, 61, 15);
		panel_aco.add(lblB);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(306, 111, 50, 19);
		panel_aco.add(textField_4);
		
		JLabel lblTmin = new JLabel("tMin");
		lblTmin.setBounds(12, 140, 61, 15);
		panel_aco.add(lblTmin);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(136, 138, 50, 19);
		panel_aco.add(textField_5);
		
		JLabel lblTmax = new JLabel("tMax");
		lblTmax.setBounds(222, 140, 61, 15);
		panel_aco.add(lblTmax);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(306, 138, 50, 19);
		panel_aco.add(textField_6);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Function f = new MagicSquare();
				double[] domain = {9,8,3,4,5,2,7,6,1};
				Range range = new Range(domain, new double[1]);
				
				Input in = new ACOMMInput(f, range, Math.pow(10, 5), 0, Integer.valueOf(textField.getText()), Float.valueOf(textField_1.getText()), Float.valueOf(textField_2.getText()), Float.valueOf(textField_3.getText()), Float.valueOf(textField_4.getText()), Float.valueOf(textField_5.getText()), Float.valueOf(textField_6.getText()), true);
				
					Result res = ACOMinMax.run(in);
					String output = "ACO result = " + res.getValue() + " at " + res.getRes() + " after " + res.getSteps() +"\n";
					mainGui.textArea.append(output);
			}
		});
		button.setBounds(547, 164, 89, 25);
		panel_aco.add(button);
	}
}
