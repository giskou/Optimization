package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
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
import methods.evolution.mutation.Mutation;
import methods.evolution.mutation.RealGaussian;
import methods.evolution.recombination.Discrete;
import methods.evolution.recombination.RealValued;
import methods.evolution.recombination.Recombination;
import methods.evolution.selection.LinearRanking;
import methods.evolution.selection.LinearScaling;
import methods.evolution.selection.PowerScaling;
import methods.evolution.selection.RouletteWheel;
import methods.evolution.selection.Selection;
import methods.evolution.selection.Tournament;

@SuppressWarnings("serial")
public class eaGui extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	public JPanel panel;
	
	public String Selector;
	public String Recomb;
	public String Rsels;
	public String Mutations;
	public int popsize;
	public float presure;
	public float delta;
	public float delta_sel;
	public float pow;
	public float factor;
	public float prob;
	public float mut;
	public int ts;
	public int hs;
	
	
	

	/**
	 * Create the frame.
	 */
	public eaGui() {
		setLayout(null);
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Evolutionary Algorithm", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("InternalFrame.activeTitleForeground")));
		panel.setBounds(12, 0, 670, 466);
		add(panel);
		panel.setLayout(null);

		JLabel lblSelectors = new JLabel("Selectors");
		lblSelectors.setBounds(30, 12, 70, 15);
		panel.add(lblSelectors);
		
		JRadioButton rdbtnLinearRanking = new JRadioButton("Linear Ranking");
		rdbtnLinearRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEnabled(true);
				textField_7.setEnabled(true);
				
				textField_5.setEnabled(false);
				textField_6.setEnabled(false);
				textField_4.setEnabled(false);
				textField_8.setEnabled(false);
				textField_11.setEnabled(false);
				
				Selector = "LinearRanking";
			}
		});
		rdbtnLinearRanking.setBounds(30, 39, 149, 23);
		panel.add(rdbtnLinearRanking);
		
		JRadioButton rdbtnLinearScaling = new JRadioButton("Linear Scaling");
		rdbtnLinearScaling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setEnabled(true);
				textField_8.setEnabled(true);
				textField_11.setEnabled(true);
				
				textField.setEnabled(false);
				textField_7.setEnabled(false);
				textField_5.setEnabled(false);
				textField_6.setEnabled(false);
				
				Selector = "LinearScaling";
			}
		});
		rdbtnLinearScaling.setBounds(30, 61, 149, 23);
		panel.add(rdbtnLinearScaling);
		
		JRadioButton rdbtnPowerScaling = new JRadioButton("Power Scaling");
		rdbtnPowerScaling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);
				
				textField.setEnabled(false);
				textField_7.setEnabled(false);
				textField_4.setEnabled(false);
				textField_8.setEnabled(false);
				textField_11.setEnabled(false);
				
				Selector = "PowerScaling";
			}
		});
		rdbtnPowerScaling.setBounds(30, 84, 149, 23);
		panel.add(rdbtnPowerScaling);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 215, 626, 15);
		panel.add(separator_1);
		
		JLabel lblRecombination = new JLabel("Recombination");
		lblRecombination.setBounds(30, 242, 149, 15);
		panel.add(lblRecombination);
		
		JRadioButton rdbtnDescreteRecombination = new JRadioButton("Descrete Recombination");
		rdbtnDescreteRecombination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_9.setEnabled(false);
				Recomb = "Discrete";
			}
		});
		rdbtnDescreteRecombination.setBounds(30, 269, 215, 23);
		panel.add(rdbtnDescreteRecombination);
		
		JRadioButton rdbtnRealvaluedRecombination = new JRadioButton("Real-Valued Recombination");
		rdbtnRealvaluedRecombination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_9.setEnabled(true);
				Recomb = "RealValued";
			}
		});
		rdbtnRealvaluedRecombination.setBounds(30, 294, 234, 23);
		panel.add(rdbtnRealvaluedRecombination);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(28, 345, 627, 15);
		panel.add(separator_2);
		
		JLabel lblMutation = new JLabel("Mutation");
		lblMutation.setBounds(30, 372, 89, 15);
		panel.add(lblMutation);
		
		JRadioButton rdbtnOneCoeficient = new JRadioButton("One coeficient");
		rdbtnOneCoeficient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEnabled(true);
				
				textField_1.setEnabled(false);
				textField_3.setEnabled(false);
				
				mut = 0;
			}
		});
		rdbtnOneCoeficient.setBounds(30, 399, 128, 23);
		panel.add(rdbtnOneCoeficient);
		
		JRadioButton rdbtnAllCoefficients = new JRadioButton("All Coefficients");
		rdbtnAllCoefficients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEnabled(true);
				textField_3.setEnabled(true);
				
				textField_2.setEnabled(false);
				
				
				mut = 1;
			}
		});
		rdbtnAllCoefficients.setBounds(30, 421, 128, 23);
		panel.add(rdbtnAllCoefficients);
		
		JLabel lblRandomSelectors = new JLabel("Random Selectors");
		lblRandomSelectors.setBounds(30, 119, 149, 15);
		panel.add(lblRandomSelectors);
		
		JRadioButton rdbtnRouletteWheel = new JRadioButton("Roulette Wheel");
		rdbtnRouletteWheel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rsels = "RouletteWheel";
				textField_10.setEnabled(false);
			}
		});
		rdbtnRouletteWheel.setBounds(30, 146, 149, 23);
		panel.add(rdbtnRouletteWheel);
		
		JRadioButton rdbtnTouranmentSelection = new JRadioButton("Touranment Selection");
		rdbtnTouranmentSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rsels = "Tournament";
				textField_10.setEnabled(true);
			}
		});
		rdbtnTouranmentSelection.setBounds(30, 166, 183, 23);
		panel.add(rdbtnTouranmentSelection);
		
		
		//Group the radio buttons.
		ButtonGroup selectors = new ButtonGroup();
		selectors.add(rdbtnLinearRanking);
		selectors.add(rdbtnLinearScaling);
		selectors.add(rdbtnPowerScaling);
		
		ButtonGroup Rselectors = new ButtonGroup();
		Rselectors.add(rdbtnRouletteWheel);
		Rselectors.add(rdbtnTouranmentSelection);
		
		ButtonGroup recomb = new ButtonGroup();
		recomb.add(rdbtnDescreteRecombination);
		recomb.add(rdbtnRealvaluedRecombination);

		ButtonGroup mutants = new ButtonGroup();
		mutants.add(rdbtnOneCoeficient);
		mutants.add(rdbtnAllCoefficients);
		
		JLabel lblPopulationSize = new JLabel("Population Size");
		lblPopulationSize.setBounds(191, 43, 122, 15);
		panel.add(lblPopulationSize);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(320, 41, 50, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPopability = new JLabel("Factor");
		lblPopability.setBounds(176, 425, 99, 15);
		panel.add(lblPopability);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(241, 423, 70, 19);
		textField_1.setToolTipText("convergence factor 0.9999");
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFactor = new JLabel("Factor");
		lblFactor.setBounds(176, 403, 70, 15);
		panel.add(lblFactor);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(241, 401, 70, 19);
		textField_2.setToolTipText("convergence factor 0.9999");
		panel.add(textField_2);
		
		JLabel lblPropability = new JLabel("Propability");
		lblPropability.setBounds(330, 425, 107, 15);
		panel.add(lblPropability);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(428, 423, 70, 19);
		panel.add(textField_3);
		
		JLabel label = new JLabel("Population Size");
		label.setBounds(191, 65, 122, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Population Size");
		label_1.setBounds(191, 88, 122, 15);
		panel.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(320, 63, 50, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(320, 86, 50, 19);
		panel.add(textField_5);
		
		JLabel lblPower = new JLabel("Power");
		lblPower.setBounds(382, 88, 70, 15);
		panel.add(lblPower);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(453, 86, 50, 19);
		textField_6.setToolTipText("negative number");
		panel.add(textField_6);
		
		JLabel lblPressure = new JLabel("Pressure");
		lblPressure.setBounds(382, 43, 70, 15);
		panel.add(lblPressure);
		
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(453, 41, 50, 19);
		textField_7.setToolTipText("belongs in [1,2]");
		panel.add(textField_7);
		
		JLabel lblUpdateParameter = new JLabel("delta");
		lblUpdateParameter.setBounds(382, 65, 56, 15);
		panel.add(lblUpdateParameter);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(453, 63, 50, 19);
		textField_8.setToolTipText("update parameter [0,1]");
		panel.add(textField_8);
		
		JLabel lblDelta = new JLabel("delta");
		lblDelta.setBounds(258, 298, 70, 15);
		panel.add(lblDelta);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(320, 296, 50, 19);
		textField_9.setToolTipText("0,25");
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(320, 168, 50, 19);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(572, 63, 50, 19);
		textField_11.setToolTipText("history size");
		panel.add(textField_11);
		
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Function f = new Ackley(20, 0.2, (2*Math.PI), 0);
				double min[] = {-30, -30};
				double max[] = {30, 30};
				
				Range range = new Range(min, max);

				Recombination rc = null;
				set_Selectors(Selector);
				set_Recomb(Recomb);
				set_mut(mut);
				
				Selection sel = null;
				Result res;
				if(Selector.compareTo("LinearRanking") == 0 && Rsels.compareTo("RouletteWheel") == 0){
					sel = new LinearRanking(new RouletteWheel(), presure);
					if(Recomb.compareTo("Discrete") == 0){
						rc = new Discrete();
					}
					else{
						rc = new RealValued(range, delta);
					}
				}
				else if(Selector.compareTo("LinearRanking") == 0 && Rsels.compareTo("Tournament") == 0){
					set_Ts();
					sel = new LinearRanking(new Tournament(ts), presure);
					if(Recomb.compareTo("Discrete") == 0){
						rc = new Discrete();
					}
					else{
						rc = new RealValued(range, delta);
					}
				}
				else if(Selector.compareTo("LinearScaling") == 0 && Rsels.compareTo("RouletteWheel") == 0){
					sel = new LinearScaling(new RouletteWheel(), hs, delta_sel);
					if(Recomb.compareTo("Discrete") == 0){
						rc = new Discrete();
					}
					else{
						rc = new RealValued(range, delta);
					}
				}
				else if(Selector.compareTo("LinearScaling") == 0 && Rsels.compareTo("Tournament") == 0){
					set_Ts();
					sel = new LinearScaling(new Tournament(ts), hs, delta_sel);
					if(Recomb.compareTo("Discrete") == 0){
						rc = new Discrete();
					}
					else{
						rc = new RealValued(range, delta);
					}
				}
				else if(Selector.compareTo("PowerScaling") == 0 && Rsels.compareTo("RouletteWheel") == 0){
					sel = new PowerScaling(new RouletteWheel(), pow);
					if(Recomb.compareTo("Discrete") == 0){
						rc = new Discrete();
					}
					else{
						rc = new RealValued(range, delta);
					}
				}
				else if(Selector.compareTo("PowerScaling") == 0 && Rsels.compareTo("Tournament") == 0){
					set_Ts();
					sel =  new PowerScaling(new Tournament(ts), pow);
					if(Recomb.compareTo("Discrete") == 0){
						rc = new Discrete();
					}
					else{
						rc = new RealValued(range, delta);
					}
				}
				Mutation m = new RealGaussian(range, prob, factor);
				Input in = new EvInput(f, range, mainGui.get_Calc(), mainGui.get_Acc(), sel, rc, m, popsize);
				res = GenericEvolution.run(in);
				String output = "EA result = " + res.getValue() + " at " + res.getRes() + " after " + res.getSteps() +"\n";
//				System.out.println(output);
				mainGui.textArea.append(output);
				System.out.println(res);
			}
		});
		btnStart.setBounds(556, 429, 89, 25);
		panel.add(btnStart);

		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(256, 170, 35, 15);
		panel.add(lblSize);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setBounds(515, 65, 70, 15);
		panel.add(lblHistory);
	}
	public void set_Selectors(String s){
		
		if(s.compareTo("LinearRanking") == 0){
			popsize = Integer.parseInt(textField.getText());
			presure = Float.valueOf(textField_7.getText());
		}
		else if(s.compareTo("LinearScaling") == 0){
			popsize = Integer.parseInt(textField_4.getText());
			delta_sel = Float.valueOf(textField_8.getText());
			hs =  Integer.parseInt(textField_11.getText());
		}
		else if(s.compareTo("PowerScaling") == 0){
			popsize = Integer.parseInt(textField_5.getText());
			pow = Float.valueOf(textField_6.getText());
		}
	}
	
	public void set_Recomb(String r){
		if(r.compareTo("RealValued") == 0){
			delta = Float.valueOf(textField_9.getText());
		}
	}
	
	public void set_mut(float m){
		if(m == 1){
			factor = Float.valueOf(textField_1.getText());
			prob = Float.valueOf(textField_3.getText());
		}
		else{
			factor = Float.valueOf(textField_2.getText());
		}
	}
	
	public void set_Ts(){
		ts = Integer.parseInt(textField_10.getText());
	}
}
