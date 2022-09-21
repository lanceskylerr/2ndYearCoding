import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
 
public class GUI1 {
 
	private JFrame box;
	private JTextField num1;
	private JTextField num2;
 
	private JLabel lblNewLabel;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 window = new GUI1();
					window.box.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public GUI1() {
		initialize();
	}
 
	private void initialize() {
		box = new JFrame();
		box.setBounds(100, 100, 450, 300);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.getContentPane().setLayout(null);
 
		num1 = new JTextField();
		num1.setBounds(65, 97, 115, 29);
		box.getContentPane().add(num1);
		num1.setColumns(10);
 
		num2 = new JTextField();
		num2.setBounds(217, 97, 115, 29);
		box.getContentPane().add(num2);
		num2.setColumns(10);
 
		JButton btnNewButton = new JButton("Find the Highest Num");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(num1.getText()) > Integer.parseInt(num2.getText())) {
					lblNewLabel.setText("Highest Number is " + num1.getText());
				} else if (Integer.parseInt(num2.getText()) > Integer.parseInt(num1.getText())) {
					lblNewLabel.setText("Highest Number is " + num2.getText());
				} else {
					lblNewLabel.setText("Both Number is Equal");
				}
 
			}
		});
		btnNewButton.setBounds(125, 151, 159, 37);
		box.getContentPane().add(btnNewButton);
 
		lblNewLabel = new JLabel("Answer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(125, 198, 249, 37);
		box.getContentPane().add(lblNewLabel);
 
	}
}