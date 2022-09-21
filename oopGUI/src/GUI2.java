import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class GUI2 {
 
	private JFrame box;
	private JTextField inputField;
	JLabel lblNewLabel;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.box.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public GUI2() {
		initialize();
	}
 
	private void initialize() {
		box = new JFrame();
		box.setBounds(100, 100, 450, 300);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.getContentPane().setLayout(null);
 
		JButton btnNewButton = new JButton("ODD | EVEN | 0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(inputField.getText()) == 0) {
					lblNewLabel.setText("Point of reference");
				} else if (Integer.parseInt(inputField.getText()) % 2 == 0) {
					lblNewLabel.setText("The Number is EVEN");
				} else {
					lblNewLabel.setText("The Number is ODD");
				}
 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(146, 69, 133, 32);
		box.getContentPane().add(btnNewButton);
 
		lblNewLabel = new JLabel("Answer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(173, 132, 165, 27);
		box.getContentPane().add(lblNewLabel);
 
		inputField = new JTextField();
		inputField.setBounds(147, 29, 133, 30);
		box.getContentPane().add(inputField);
		inputField.setColumns(10);
	}
 
}