import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class seatwork2 {
	private JFrame frmComboboxWithPicture;
	private JTextField txtfld;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seatwork2 window = new seatwork2();
					window.frmComboboxWithPicture.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public seatwork2() {
		initialize();
	}

	private void initialize() {
		frmComboboxWithPicture = new JFrame();
		frmComboboxWithPicture.setTitle("ComboBox with Picture");
		frmComboboxWithPicture.setBounds(100, 100, 450, 300);
		frmComboboxWithPicture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComboboxWithPicture.getContentPane().setLayout(null);
		txtfld = new JTextField();
		txtfld.setBounds(186, 35, 96, 19);
		frmComboboxWithPicture.getContentPane().add(txtfld);
		txtfld.setColumns(10);
		JTextArea txtarea = new JTextArea();
		txtarea.setBounds(292, 32, 104, 112);
		frmComboboxWithPicture.getContentPane().add(txtarea);
		txtarea.setLineWrap(true);
		JLabel picture = new JLabel();
		picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
		picture.setHorizontalAlignment(JLabel.CENTER);
		picture.setBounds(77, 64, 205, 134);
		frmComboboxWithPicture.getContentPane().add(picture);
		String[] petStrings = { "Select one", "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		JComboBox cbPets = new JComboBox(petStrings);
		cbPets.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				txtfld.setText((String) cbPets.getSelectedItem());
				txtarea.setText((String) cbPets.getSelectedItem());
				if (cbPets.getSelectedItem() == "Pig") {
					picture.setIcon(new ImageIcon(new ImageIcon("src/Pigitt.png").getImage().getScaledInstance(170, 120,
							Image.SCALE_DEFAULT)));
				} else if (cbPets.getSelectedItem() == "Dog") {
					picture.setIcon(new ImageIcon(new ImageIcon("Img/Dogitat.png").getImage().getScaledInstance(170,
							120, Image.SCALE_DEFAULT)));
				} else if (cbPets.getSelectedItem() == "Cat") {
					picture.setIcon(new ImageIcon(new ImageIcon("Img/Catitat.png").getImage().getScaledInstance(170,
							120, Image.SCALE_DEFAULT)));
				} else if (cbPets.getSelectedItem() == "Rabbit") {
					picture.setIcon(new ImageIcon(new ImageIcon("Img/Rabbitat.png").getImage().getScaledInstance(170,
							120, Image.SCALE_DEFAULT)));
				} else if (cbPets.getSelectedItem() == "Bird") {
					picture.setIcon(new ImageIcon(new ImageIcon("Img/Birditat.png").getImage().getScaledInstance(170,
							120, Image.SCALE_DEFAULT)));

				} else {
					picture.setIcon(new ImageIcon(""));
				}
			}
		});
		cbPets.setBounds(67, 34, 86, 21);
		frmComboboxWithPicture.getContentPane().add(cbPets);
	}
}