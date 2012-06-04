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

public class mainGui {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel;
	public static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGui window = new mainGui();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 752, 819);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] meth = {"Evolutionnary Algorithm", "PSO", "DE"};
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(29, 83, 695, 6);
		contentPane.add(separator_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 609, 662, 160);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);

		
		JLabel lblOutput = new JLabel("Output");
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
					panel = new window();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
					
				}
				else if(selection.compareTo("PSO") == 0){
					contentPane.remove(panel);
					panel = new psoGui();
					panel.setBounds(12, 101, 695, 466);
					contentPane.add(panel);
					panel.repaint();
					panel.setLayout(null);
				}
				else if(selection.compareTo("DE") == 0){
				}
			}
		});
		methods.setBounds(29, 28, 183, 24);
		for(int i = 0; i < meth.length; i++){
			methods.addItem(meth[i]);
		}
		contentPane.add(methods);
	}
}
