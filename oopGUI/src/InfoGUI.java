import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoGUI {

	private JFrame frame;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField middleInitial;
	private JTextField age;
	private JTextField username;
	private JTextField email;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoGUI box = new InfoGUI();
					box.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InfoGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 769, 833);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 213, 43);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 45, 213, 43);
		frame.getContentPane().add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 75, 213, 43);
		frame.getContentPane().add(lblFirstName);

		JLabel MidI = new JLabel("Middle Initial");
		MidI.setHorizontalAlignment(SwingConstants.CENTER);
		MidI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MidI.setBounds(10, 112, 213, 43);
		frame.getContentPane().add(MidI);

		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(10, 141, 213, 43);
		frame.getContentPane().add(lblAge);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(10, 176, 213, 43);
		frame.getContentPane().add(lblGender);

		JLabel lblAddress = new JLabel("Address 1");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(10, 212, 213, 43);
		frame.getContentPane().add(lblAddress);

		JLabel lblTown = new JLabel("Town");
		lblTown.setHorizontalAlignment(SwingConstants.CENTER);
		lblTown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTown.setBounds(10, 243, 213, 43);
		frame.getContentPane().add(lblTown);

		JLabel lblHobbies = new JLabel("Status");
		lblHobbies.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobbies.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHobbies.setBounds(10, 276, 213, 43);
		frame.getContentPane().add(lblHobbies);

		JLabel persInfo = new JLabel("Personal Information");
		persInfo.setHorizontalAlignment(SwingConstants.LEFT);
		persInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		persInfo.setBounds(37, 371, 213, 43);
		frame.getContentPane().add(persInfo);

		JLabel user = new JLabel("Username");
		user.setHorizontalAlignment(SwingConstants.LEFT);
		user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		user.setBounds(37, 416, 213, 43);
		frame.getContentPane().add(user);

		JLabel pass = new JLabel("Password");
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pass.setBounds(37, 453, 213, 43);
		frame.getContentPane().add(pass);

		JLabel EmailAdd = new JLabel("Email");
		EmailAdd.setHorizontalAlignment(SwingConstants.LEFT);
		EmailAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		EmailAdd.setBounds(37, 492, 213, 43);
		frame.getContentPane().add(EmailAdd);

		JLabel other = new JLabel("Others");
		other.setHorizontalAlignment(SwingConstants.LEFT);
		other.setFont(new Font("Tahoma", Font.PLAIN, 16));
		other.setBounds(37, 545, 72, 43);
		frame.getContentPane().add(other);

		JLabel passInfo = new JLabel("Password");
		passInfo.setHorizontalAlignment(SwingConstants.LEFT);
		passInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passInfo.setBounds(37, 788, 213, 43);
		frame.getContentPane().add(passInfo);

		JLabel college = new JLabel("College");
		college.setHorizontalAlignment(SwingConstants.LEFT);
		college.setFont(new Font("Tahoma", Font.PLAIN, 16));
		college.setBounds(37, 580, 95, 43);
		frame.getContentPane().add(college);

		JLabel campusOpt = new JLabel("Campus");
		campusOpt.setHorizontalAlignment(SwingConstants.LEFT);
		campusOpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campusOpt.setBounds(20, 664, 88, 43);
		frame.getContentPane().add(campusOpt);

		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastName.setColumns(10);
		lastName.setBounds(233, 51, 173, 29);
		frame.getContentPane().add(lastName);

		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstName.setColumns(10);
		firstName.setBounds(233, 81, 173, 29);
		frame.getContentPane().add(firstName);

		middleInitial = new JTextField();
		middleInitial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		middleInitial.setColumns(10);
		middleInitial.setBounds(233, 118, 173, 29);
		frame.getContentPane().add(middleInitial);

		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 18));
		age.setColumns(10);
		age.setBounds(233, 147, 173, 29);
		frame.getContentPane().add(age);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMale.setBounds(229, 181, 95, 30);
		frame.getContentPane().add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemale.setBounds(326, 181, 95, 30);
		frame.getContentPane().add(rdbtnFemale);

		rdbtnFemale.setActionCommand("Female");
		rdbtnMale.setActionCommand("Male");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtnMale);
		group1.add(rdbtnFemale);

		JTextArea address1 = new JTextArea();
		address1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		address1.setBounds(233, 218, 435, 29);
		frame.getContentPane().add(address1);

		JComboBox cmbBoxTown = new JComboBox();
		cmbBoxTown.addItem("Baliuag");
		cmbBoxTown.addItem("Pulilan");
		cmbBoxTown.addItem("Plaridel");
		cmbBoxTown.addItem("Bustos");
		cmbBoxTown.addItem("San Rafael");
		cmbBoxTown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbBoxTown.setBounds(233, 249, 173, 28);
		frame.getContentPane().add(cmbBoxTown);

		JRadioButton rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnSingle.setBounds(229, 283, 95, 30);
		frame.getContentPane().add(rdbtnSingle);

		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMarried.setBounds(326, 283, 95, 30);
		frame.getContentPane().add(rdbtnMarried);

		rdbtnSingle.setActionCommand("Single");
		rdbtnMarried.setActionCommand("Married");
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnSingle);
		group2.add(rdbtnMarried);

		JLabel lblHobbies_1 = new JLabel("Hobbies");
		lblHobbies_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobbies_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHobbies_1.setBounds(10, 308, 213, 43);
		frame.getContentPane().add(lblHobbies_1);

		JCheckBox chckbxSinging = new JCheckBox("Singing");
		chckbxSinging.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxSinging.setBounds(233, 330, 111, 21);
		frame.getContentPane().add(chckbxSinging);

		JCheckBox chckbxCycling = new JCheckBox("Cycling");
		chckbxCycling.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCycling.setBounds(326, 329, 111, 21);
		frame.getContentPane().add(chckbxCycling);

		JCheckBox chckbxDancing = new JCheckBox("Dancing");
		chckbxDancing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxDancing.setBounds(444, 329, 111, 21);
		frame.getContentPane().add(chckbxDancing);

		JCheckBox chckbxSwimming = new JCheckBox("Swimming");
		chckbxSwimming.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxSwimming.setBounds(568, 329, 111, 21);
		frame.getContentPane().add(chckbxSwimming);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setColumns(10);
		username.setBounds(146, 425, 173, 29);
		frame.getContentPane().add(username);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(146, 506, 173, 29);
		frame.getContentPane().add(email);

		String[] colleges = new String[5];
		String[] campus = new String[5];

		colleges[0] = "CCIT";
		colleges[1] = "CET";
		colleges[2] = "CAB";
		colleges[3] = "CAS";
		colleges[4] = "SHS";

		campus[0] = "NUB";
		campus[1] = "NUL";
		campus[2] = "NU Manila";
		campus[3] = "NUD";
		campus[4] = "NUF";

		JList list1 = new JList(colleges);
		list1.setBounds(135, 579, 151, 92);
		frame.getContentPane().add(list1);

		JList list2 = new JList(campus);
		list2.setBounds(135, 680, 151, 98);
		frame.getContentPane().add(list2);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String First = firstName.getText();
				String Last = lastName.getText();
				String MidIn = middleInitial.getText();
				String Age = age.getText();
				String Address = address1.getText();
				String Town = String.valueOf(cmbBoxTown.getSelectedItem());
				String gender = group1.getSelection().getActionCommand();
				String status = group2.getSelection().getActionCommand();

				String hb1 = chckbxSinging.isSelected() ? "Singing" : "";
				String hb2 = chckbxCycling.isSelected() ? "Cycling" : "";
				String hb3 = chckbxDancing.isSelected() ? "Dancing" : "";
				String hb4 = chckbxSwimming.isSelected() ? "Swimming" : "";
				String hobbies = hb1 + " " + hb2 + " " + hb3 + " " + hb4;

				String uname = username.getText();
				String pass = new String(passwordField.getPassword());
				String em = email.getText();

				String col = list1.getSelectedValue().toString();
				String camp = list2.getSelectedValue().toString();
				;

				JOptionPane.showMessageDialog(frame,
						"" + "Personal Information \n" + "Name: " + Last + " " + First + ", " + MidIn + "\n" + "Age: "
								+ Age + "\n" + "Gender: " + gender + "\n" + "Address: " + Address + " " + Town + "\n"
								+ "Status: " + status + "\n" + "Hobbies include " + hobbies + "\n" + "\n"
								+ "Login Information \n" + "Username: " + uname + "\n" + "Password: " + pass + "\n"
								+ "Email Address: " + em + "\n" + "\n" + "Other Information \n" + "College is " + col
								+ "\n" + "Campus is " + camp + "\n"

				);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(381, 669, 111, 30);
		frame.getContentPane().add(btnSubmit);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(146, 467, 162, 29);
		frame.getContentPane().add(passwordField);

	}
}
