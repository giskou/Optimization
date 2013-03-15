package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class mainGui {

	private JFrame frmEvolutionaryAlgorithms;
	private JPanel contentPane;
	private JPanel panel;
	public static JTextArea textArea;
	private static JTextField acc;
	private static JTextField calc;
	private JScrollPane scrollPane;
	private JLabel lblOutput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGui window = new mainGui();
					window.frmEvolutionaryAlgorithms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		frmEvolutionaryAlgorithms = new JFrame();
		frmEvolutionaryAlgorithms.setResizable(false);
		frmEvolutionaryAlgorithms.setTitle("Evolutionary Algorithms");
		frmEvolutionaryAlgorithms.setBounds(100, 100, 755, 819);
		frmEvolutionaryAlgorithms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] meth = {"Evolutionnary Algorithm", "PSO", "Differential Evolution", "Harmony Search", "ACO Min Max"};
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmEvolutionaryAlgorithms.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(29, 83, 662, 16);
		contentPane.add(separator_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 609, 662, 160);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);

		
		lblOutput = new JLabel("Output");
		lblOutput.setBounds(29, 582, 70, 15);
		contentPane.add(lblOutput);
		
		
		JLabel lblSelectMethod = new JLabel("Select Method");
		lblSelectMethod.setBounds(28, 0, 184, 16);
		contentPane.add(lblSelectMethod);
		
		JComboBox methods = new JComboBox();
		
		methods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox methods = (JComboBox)e.getSource();
				String selection = (String)methods.getSelectedItem();
				System.out.println(selection);
				if(selection.compareTo("Evolutionnary Algorithm") == 0){
					if (panel != null) contentPane.remove(panel);
					panel = new eaGui();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
					lblOutput.setBounds(29, 582, 70, 15);
					scrollPane.setBounds(29, 609, 662, 160);
					frmEvolutionaryAlgorithms.setBounds(100, 100, 752, 819);
				}
				else if(selection.compareTo("PSO") == 0){
					contentPane.remove(panel);
					panel = new psoGui();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
					lblOutput.setBounds(29, 330, 70, 15);
					scrollPane.setBounds(29, 350, 662, 160);
					frmEvolutionaryAlgorithms.setBounds(100, 100, 755, 560);
				}
				else if(selection.compareTo("Differential Evolution") == 0){
					contentPane.remove(panel);
					panel = new deGui();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
					lblOutput.setBounds(29, 330, 70, 15);
					scrollPane.setBounds(29, 350, 662, 160);
					frmEvolutionaryAlgorithms.setBounds(100, 100, 755, 560);
					
				}
				else if(selection.compareTo("Harmony Search") == 0){
					contentPane.remove(panel);
					panel = new hsGui();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
					lblOutput.setBounds(29, 330, 70, 15);
					scrollPane.setBounds(29, 350, 662, 160);
					frmEvolutionaryAlgorithms.setBounds(100, 100, 755, 560);
				}
				else if(selection.compareTo("ACO Min Max") == 0){
					contentPane.remove(panel);
					panel = new ACOgui();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
					lblOutput.setBounds(29, 330, 70, 15);
					scrollPane.setBounds(29, 350, 662, 160);
					frmEvolutionaryAlgorithms.setBounds(100, 100, 755, 560);
				}
			}
		});
		methods.setBounds(29, 28, 183, 24);
		for(int i = 0; i < meth.length; i++){
			methods.addItem(meth[i]);
		}
		contentPane.add(methods);
		
		JLabel lblAccuarcy = new JLabel("Accuarcy");
		lblAccuarcy.setBounds(251, 33, 70, 15);
		contentPane.add(lblAccuarcy);
		
		acc = new JTextField();
		acc.setColumns(10);
		acc.setBounds(353, 31, 50, 19);
		contentPane.add(acc);
		
		JLabel lblCalculations = new JLabel("Calculations");
		lblCalculations.setBounds(455, 33, 105, 15);
		contentPane.add(lblCalculations);
		
		calc = new JTextField();
		calc.setColumns(10);
		calc.setBounds(578, 31, 107, 19);
		contentPane.add(calc);
	}
	public static double get_Acc(){
		double accuracy = Double.valueOf(acc.getText());
		System.out.println(accuracy);
		return accuracy;
	}
	
	public static double get_Calc(){
		double calcs = Double.valueOf(calc.getText());
		System.out.println(calcs);
		return calcs;
	}
}
