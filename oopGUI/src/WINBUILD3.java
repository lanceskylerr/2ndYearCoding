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

public class WINBUILD3 {

	private JFrame frame;
	private JTextField textField;
	private JComboBox<String> comboBox;

	DefaultListModel jlistmodel = new DefaultListModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WINBUILD3 box = new WINBUILD3();
					box.frame.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}

	public WINBUILD3() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(253, 212, 147, 31);
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

		JLabel lblNewLabel = new JLabel("Animal Pic");
		lblNewLabel.setBounds(478, 45, 198, 179);
		frame.getContentPane().add(lblNewLabel);

		JList list = new JList(jlistmodel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				textField.setText(list.getSelectedValue().toString());
				if (list.getSelectedValue().toString() == "Bird") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Cat.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				} else if (list.getSelectedValue().toString() == "Cat") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Cat.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				} else if (list.getSelectedValue().toString() == "Dog") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Dog.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				} else if (list.getSelectedValue().toString() == "Rabbit") {
					lblNewLabel.setIcon(new ImageIcon(new ImageIcon("src/Rabbit.png").getImage().getScaledInstance(170,
							120, Image.SCALE_DEFAULT)));
				} else if (list.getSelectedValue().toString() == "Pig") {
					lblNewLabel.setIcon(new ImageIcon(
							new ImageIcon("src/Pig.png").getImage().getScaledInstance(170, 120, Image.SCALE_DEFAULT)));
				}
			}
		});
		list.setBounds(253, 54, 147, 130);
		frame.getContentPane().add(list);

	}
}
