import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Machprob6 {

	private JFrame frame;
	private JTextField textField;
	private JComboBox<String> comboBox;

	DefaultListModel jlistmodel = new DefaultListModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Machprob6 box = new Machprob6();
					box.frame.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}

	public Machprob6() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(210, 281, 175, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlistmodel.addElement(comboBox.getSelectedItem());
				textField.setText(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setBounds(32, 54, 198, 31);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Bird");
		comboBox.addItem("Cat");
		comboBox.addItem("Dog");
		comboBox.addItem("Rabbit");
		comboBox.addItem("Pig");

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(476, 46, 198, 179);
		frame.getContentPane().add(lblNewLabel);

		JList LIST = new JList(jlistmodel);
		LIST.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (LIST.getSelectedValue().toString() == "Bird") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Cat.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				} else if (LIST.getSelectedValue().toString() == "Cat") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Cat.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				} else if (LIST.getSelectedValue().toString() == "Dog") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Dog.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				} else if (LIST.getSelectedValue().toString() == "Rabbit") {
					lblNewLabel.setIcon(new ImageIcon(new ImageIcon("src/Rabbit.png").getImage().getScaledInstance(170,
							120, Image.SCALE_DEFAULT)));
				} else if (LIST.getSelectedValue().toString() == "Pig") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Pig.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				}
			}
		});
		LIST.setBounds(253, 54, 147, 130);
		frame.getContentPane().add(LIST);

	}
}
