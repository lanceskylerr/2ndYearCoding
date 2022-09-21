import java.awt.EventQueue;

import javax.swing.JFrame;
import java.time.Year;
import java.util.Scanner;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BIRTHDATE {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BIRTHDATE box = new BIRTHDATE();
					box.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BIRTHDATE() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(100, 100, 559, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel inputYr = new JLabel("Enter Your Birth Year");
		inputYr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputYr.setBounds(36, 34, 195, 34);
		frame.getContentPane().add(inputYr);

		textField = new JTextField();
		textField.setBounds(225, 38, 149, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 180, 548, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(21, 213, 548, 34);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int birthYear = Integer.parseInt(textField.getText());
				
				int age = Year.now().getValue() - birthYear;
				
				
				lblNewLabel_1.setText("The Current Year is 2022, " + " you were born on the year " + birthYear);
				lblNewLabel_1_1.setText("You are approximately " + String.valueOf(age) + " years old this year.");
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(146, 105, 109, 34);
		frame.getContentPane().add(btnSubmit);
		
	}
}
