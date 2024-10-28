package com.rng.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Number Background Generator is self-explanatory.
 * Generates a user-input number with a random font,
 * random background color, and random foreground color.
 * 
 * @author Adnan Wazwaz
 * @version 1.1 2024-10-28 
 * @since 2023-03-12.
 *
 */
public class NumberBackgroundGenerator extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8774226260492129366L;
	private JPanel contentPane;
	private JLabel numberLabel;
	private JTextField numberField;
	private JButton generatorButton;
	private JButton negativeForegroundButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberBackgroundGenerator frame = new NumberBackgroundGenerator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumberBackgroundGenerator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		numberLabel = new JLabel("100");
		numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberLabel.setOpaque(true);
		numberLabel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		contentPane.add(numberLabel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		numberField = new JTextField();
		numberField.setHorizontalAlignment(SwingConstants.CENTER);
		numberField.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, null, null, Color.BLACK));
		panel.add(numberField);
		numberField.setColumns(10);
		
		generatorButton = new JButton("Generate");
		generatorButton.setToolTipText("Display the input number with a random font and random set of colors.");
		generatorButton.setBackground(Color.GREEN);
		generatorButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, null, null, Color.BLACK));
		panel.add(generatorButton);
		
		negativeForegroundButton = new JButton("New Foreground");
		negativeForegroundButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, null, null, Color.BLACK));
		negativeForegroundButton.setBackground(Color.CYAN);
		panel.add(negativeForegroundButton);
		generatorButton.addActionListener(this);
		negativeForegroundButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generatorButton) {
			try {
				int number = Integer.parseInt(numberField.getText());
				String formattedNumber = Utilities.numberForamt(number);
				numberLabel.setText(formattedNumber);
				numberLabel.setBackground(Utilities.randomColor());
				numberLabel.setForeground(Utilities.randomColor());
				numberLabel.setFont(new Font(Utilities.randomFontName(), numberLabel.getFont().getStyle(), numberLabel.getFont().getSize()));
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == negativeForegroundButton) {
			numberLabel.setForeground(Utilities.negative(numberLabel.getBackground()));
		}
	}
}
