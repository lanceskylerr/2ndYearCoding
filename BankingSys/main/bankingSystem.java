import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bankingSystem {

	private JFrame frmHighLandsBanking;
	private JTextField txtname;
	private JTextField txtaddress;
	private JTextField txtcontactnum;
	private JTextField txtcardno;
	private JTextField txtcardval;
	private JTextField txtcardtype;
	private JTextField txtcardlim;
	private JTextField srchtxtField;
	private JTextField txtissuername;
	private JTextField txtid;
	
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection con;
	private JLabel lblJdbc;
	int condition;
	String query;
	String connection = "jdbc:mysql://localhost:3306/bankingdtbs";
	String username = "root";
	String password = "";
	private JTextField txtbday;
	private JTextField txtsex;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnAllRecords;
	private JButton btnReload;
	private JButton btnNextLast;
	private JButton btnNext;
	private JButton btnBack;
	private JButton btnBackLast;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankingSystem window = new bankingSystem();
					window.frmHighLandsBanking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// ---------------------------------CREATES THE APPLICATION-------------------------------------------
	public bankingSystem() {

		initialize();
		sql();
	}

// ------------------------------------------METHODS--------------------------------------------------
	void data2(String ID) {
		try {
			con = DriverManager.getConnection(connection, username, password);
			query = "SELECT * FROM tblStudents";

			pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(ID)) {
					getData();
					break;
				}
				getData();
			}

			lblJdbc.setText("Connection Successfull!");
			lblJdbc.setForeground(Color.GREEN);

		} catch (Exception e) {
			lblJdbc.setText("Connection Failed! Please Try Again. ");
			lblJdbc.setForeground(Color.RED);
			System.out.println(e.toString());
		}
	}

	void getData() {

		try {
			txtid.setText(rs.getString(1));
			txtname.setText(rs.getString(2));
			txtbday.setText(rs.getString(3));
			txtsex.setText(rs.getString(4));
			txtaddress.setText(rs.getString(5));
			txtcontactnum.setText(rs.getString(6));

			txtcardno.setText(rs.getString(7));
			txtcardval.setText(rs.getString(8));
			txtcardtype.setText(rs.getString(9));
			txtcardlim.setText(rs.getString(10));
			txtissuername.setText(rs.getString(11));
		} catch (Exception e) {

		}

	}

	void BackLast() {

		btnDelete.setEnabled(true);
		btnBackLast.setEnabled(false);

		btnNextLast.setEnabled(true);
		btnNext.setEnabled(true);
		try {
			rs.first();
			getData();
			btnNext.setEnabled(true);
			btnBack.setEnabled(false);

			JOptionPane.showMessageDialog(null, "This is the First Account!", "Notice",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e1) {
			System.out.println(e1.toString());
		}
	}

	void Back() {
		btnNextLast.setEnabled(true);
		btnNext.setEnabled(true);
		try {
			if (rs.previous()) {

				getData();

			} else {
				rs.first();
				btnBackLast.setEnabled(false);
				btnBack.setEnabled(false);
				JOptionPane.showMessageDialog(null, "First Account Reached!", "Notice",
						JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (Exception e1) {
			System.out.println(e1.toString());
		}
	}

	void Next() {
		btnBackLast.setEnabled(true);
		btnBack.setEnabled(true);
		try {
			if (rs.next()) {

				getData();

			} else {
				rs.last();
				btnNextLast.setEnabled(false);
				btnNext.setEnabled(false);

				JOptionPane.showMessageDialog(null, "Last Account Reached!", "Notice", JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e1) {
			System.out.println(e1.toString());
		}
	}

	void NextLast() {
		btnBackLast.setEnabled(true);
		btnBack.setEnabled(true);
		try {

			rs.last();
			getData();

			btnNextLast.setEnabled(false);
			btnNext.setEnabled(false);

			JOptionPane.showMessageDialog(null, "This is the last Account!", "Notice", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e1) {
			System.out.println(e1.toString());
		}

	}

	void allRecords() {
		// Calling another application window
		Thread x = new Thread() {
			public void run() {
				// the name of the application window to be called
				records.main(new String[] {});
			}
		};
		// Calling the application window
		x.start();
		try {
			x.join();
		} catch (InterruptedException e1) {
			// Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void add() {
		txtid.setEnabled(false);

		txtname.requestFocusInWindow();
		txtname.setEnabled(true);
		txtbday.setEnabled(true);
		txtsex.setEnabled(true);
		txtaddress.setEnabled(true);
		txtcontactnum.setEnabled(true);

		txtcardno.setEnabled(true);
		txtcardval.setEnabled(true);
		txtcardtype.setEnabled(true);
		txtcardlim.setEnabled(true);
		txtissuername.setEnabled(true);

		txtname.setText(null);
		txtbday.setText(null);
		txtsex.setText(null);
		txtaddress.setText(null);
		txtcontactnum.setText(null);

		txtcardno.setText(null);
		txtcardval.setText(null);
		txtcardtype.setText(null);
		txtcardlim.setText(null);
		txtissuername.setText(null);

		btnAdd.setEnabled(false);
		btnEdit.setEnabled(false);
		btnSave.setEnabled(true);
		btnDelete.setEnabled(false);
		btnCancel.setEnabled(true);

		btnNext.setEnabled(false);
		btnNextLast.setEnabled(false);
		btnBack.setEnabled(false);
		btnBackLast.setEnabled(false);
		btnSearch.setEnabled(true);
		btnReload.setEnabled(true);
		btnAllRecords.setEnabled(true);
	}

	void edit() {
		txtFields(true);

		btnCancel.setEnabled(true);
		btnSave.setEnabled(true);
		btnDelete.setEnabled(false);
		btnAdd.setEnabled(false);
		btnAllRecords.setEnabled(true);
		btnNext.setEnabled(false);
		btnNextLast.setEnabled(false);
		btnBack.setEnabled(false);
		btnBackLast.setEnabled(false);
	}

	void save() {
		btnAdd.setEnabled(true);
		btnCancel.setEnabled(false);
		btnBackLast.setEnabled(true);
		btnBack.setEnabled(true);
		btnNext.setEnabled(true);
		btnNextLast.setEnabled(true);
		btnEdit.setEnabled(true);
		btnAllRecords.setEnabled(true);

		txtid.setEnabled(false);
		txtname.requestFocusInWindow();
		txtname.setEnabled(false);
		txtbday.setEnabled(false);
		txtsex.setEnabled(false);
		txtaddress.setEnabled(false);
		txtcontactnum.setEnabled(false);

		txtcardno.setEnabled(false);
		txtcardval.setEnabled(false);
		txtcardtype.setEnabled(false);
		txtcardlim.setEnabled(false);
		txtissuername.setEnabled(false);

		String Cardnum = txtcardno.getText();
		String CardValidity = txtcardval.getText();
		String CardType = txtcardtype.getText();
		String CardLimit = txtcardlim.getText();
		String IssuersName = txtissuername.getText();

		String Name = txtname.getText();
		String Birthday = txtbday.getText();
		String Sex = txtsex.getText();
		String Address = txtaddress.getText();
		String Contactnum = txtcontactnum.getText();

		try {
			con = DriverManager.getConnection(connection, username, password);
			query = "INSERT INTO info(Name, Birthday, Sex, Address, Contactnum, "
					+ "Cardnum, CardValidity, CardType, CardLimit, IssuersName) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pst = con.prepareStatement(query);
			pst.setString(1, Name);
			pst.setString(2, Birthday);
			pst.setString(3, Sex);
			pst.setString(4, Address);
			pst.setString(5, Contactnum);
			pst.setString(6, Cardnum);
			pst.setString(7, CardValidity);
			pst.setString(8, CardType);
			pst.setString(9, CardLimit);
			pst.setString(10, IssuersName);

			pst.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Banking Information added Successfully!", "-",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Failed!");
		}
		{

		}
	}

	void saveEdit() {
		btnAdd.setEnabled(true);
		btnCancel.setEnabled(false);
		btnBackLast.setEnabled(true);
		btnBack.setEnabled(true);
		btnNext.setEnabled(true);
		btnNextLast.setEnabled(true);
		btnEdit.setEnabled(true);
		btnAllRecords.setEnabled(true);
		btnDelete.setEnabled(true);
		
		txtid.setEnabled(false);
		txtname.requestFocusInWindow();
		txtname.setEnabled(false);
		txtbday.setEnabled(false);
		txtsex.setEnabled(false);
		txtaddress.setEnabled(false);
		txtcontactnum.setEnabled(false);

		txtcardno.setEnabled(false);
		txtcardval.setEnabled(false);
		txtcardtype.setEnabled(false);
		txtcardlim.setEnabled(false);
		txtissuername.setEnabled(false);

		String Cardnum = txtcardno.getText();
		String CardValidity = txtcardval.getText();
		String CardType = txtcardtype.getText();
		String CardLimit = txtcardlim.getText();
		String IssuersName = txtissuername.getText();

		String Name = txtname.getText();
		String Birthday = txtbday.getText();
		String Sex = txtsex.getText();
		String Address = txtaddress.getText();
		String Contactnum = txtcontactnum.getText();
		String IDnum = txtid.getText();

		try {
			con = DriverManager.getConnection(connection, username, password);
			query = "UPDATE info SET Name=?, Birthday=?, Sex=?, Address=?, Contactnum=?,Cardnum=?, CardValidity=?, CardType=?, CardLimit=?, IssuersName=? WHERE IDnum= ?";

			pst = con.prepareStatement(query);
			pst.setString(1, Name);
			pst.setString(2, Birthday);
			pst.setString(3, Sex);
			pst.setString(4, Address);
			pst.setString(5, Contactnum);
			pst.setString(6, Cardnum);
			pst.setString(7, CardValidity);
			pst.setString(8, CardType);
			pst.setString(9, CardLimit);
			pst.setString(10, IssuersName);
			pst.setString(11, IDnum);

			pst.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Banking Information edited Successfully!", "Add Customer",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Failed!");
		}
		{

		}
	}

	void delete() {

		try {

			con = DriverManager.getConnection(connection, username, password);
			query = "Delete FROM info WHERE IDnum = ?";

			pst = con.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(txtid.getText()));
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Record Deleted!");

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Deletion Failed!");
		}
		sql();
	}

	void cancel() {

		txtname.setEnabled(false);
		txtbday.setEnabled(false);
		txtsex.setEnabled(false);
		txtaddress.setEnabled(false);
		txtcontactnum.setEnabled(false);

		txtcardno.setEnabled(false);
		txtcardval.setEnabled(false);
		txtcardtype.setEnabled(false);
		txtcardlim.setEnabled(false);
		txtissuername.setEnabled(false);

		btnAdd.setEnabled(true);
		btnEdit.setEnabled(true);
		btnSave.setEnabled(false);
		btnDelete.setEnabled(true);
		btnCancel.setEnabled(false);
		btnReload.setEnabled(true);
		btnAllRecords.setEnabled(true);
		btnNext.setEnabled(true);
		btnNextLast.setEnabled(true);
		btnBack.setEnabled(false);
		btnBackLast.setEnabled(false);
		btnSearch.setEnabled(true);

		JOptionPane.showMessageDialog(null, "Cancelled", "Add Customer", JOptionPane.INFORMATION_MESSAGE);
		sql();
	}

	void reload() {
		btnDelete.setEnabled(true);
		btnBackLast.setEnabled(false);
		btnBack.setEnabled(false);
		btnNextLast.setEnabled(true);
		btnNext.setEnabled(true);
		try {
			con = DriverManager.getConnection(connection, username, password);
			query = "SELECT * FROM info";

			pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();

			if (rs.next()) {
				txtid.setText(rs.getString(1));
				txtname.setText(rs.getString(2));
				txtbday.setText(rs.getString(3));
				txtsex.setText(rs.getString(4));
				txtaddress.setText(rs.getString(5));
				txtcontactnum.setText(rs.getString(6));
				txtcardno.setText(rs.getString(7));
				txtcardval.setText(rs.getString(8));
				txtcardtype.setText(rs.getString(9));
				txtcardlim.setText(rs.getString(10));
				txtissuername.setText(rs.getString(11));
			}
			lblJdbc.setText("JDBC Connection established successfully!");
			lblJdbc.setForeground(Color.BLUE);
			txtFields(false);
			btnAdd.setEnabled(false);

		} catch (Exception e) {
			lblJdbc.setText("JDBC Connection failed!");
			lblJdbc.setForeground(Color.RED);
			System.out.println(e.toString());
		}
	}

	void searchMain() {
		try {
			pst = con.prepareStatement("SELECT * FROM info WHERE UPPER(Name) LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			if (srchtxtField.getText().matches("[0-9]+")) {
				pst = con.prepareStatement("SELECT * FROM info WHERE IDnum  = ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				pst.setInt(1, Integer.parseInt(srchtxtField.getText()));

			} else {
				pst = con.prepareStatement("SELECT * FROM info WHERE UPPER(Name) LIKE ?",
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, srchtxtField.getText().toUpperCase());
			}

			rs = pst.executeQuery();

			if (rs.first()) {
				getData();

			} else {
				JOptionPane.showMessageDialog(null, "No record Found");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		srchtxtField.setText("");
	}

	void txtFields(boolean x) {
		txtname.setEnabled(x);
		txtbday.setEnabled(x);
		txtsex.setEnabled(x);
		txtaddress.setEnabled(x);
		txtcontactnum.setEnabled(x);

		txtcardno.setEnabled(x);
		txtcardval.setEnabled(x);
		txtcardtype.setEnabled(x);
		txtcardlim.setEnabled(x);
		txtissuername.setEnabled(x);

	}

	void buttons(boolean x) {
		btnAdd.setEnabled(x);
		btnEdit.setEnabled(x);
		btnSave.setEnabled(x);
		btnDelete.setEnabled(x);
		btnCancel.setEnabled(x);
		btnNext.setEnabled(x);
		btnNextLast.setEnabled(x);
		btnBack.setEnabled(x);
		btnBackLast.setEnabled(x);
		btnSearch.setEnabled(x);
		btnReload.setEnabled(x);
		btnAllRecords.setEnabled(x);
	}

// -----------------------------------------XAMPP CONNECTION-------------------------------------------
	public void sql() {
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(true);
		btnSave.setEnabled(false);
		btnDelete.setEnabled(true);
		btnCancel.setEnabled(false);
		btnReload.setEnabled(true);
		btnAllRecords.setEnabled(true);
		btnNext.setEnabled(true);
		btnNextLast.setEnabled(true);
		btnBack.setEnabled(false);
		btnBackLast.setEnabled(false);
		btnSearch.setEnabled(true);

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdtbs", username, password);
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = st.executeQuery("SELECT * FROM info");

			if (rs.next()) {
				getData();
			}

			lblJdbc.setText("JDBC connection is established successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// --------------------------------------INITIALIZATION OF THE SYSTEM---------------------------------
	private void initialize() {

		frmHighLandsBanking = new JFrame();
		frmHighLandsBanking.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHighLandsBanking.setTitle("High Lands Banking System");
		frmHighLandsBanking.setBounds(100, 100, 913, 526);
		frmHighLandsBanking.setLocationRelativeTo(null);
		frmHighLandsBanking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHighLandsBanking.getContentPane().setLayout(null);

// -------------------------------------------PERSONAL INFO-------------------------------------------

		JLabel personalInfo = new JLabel("PERSONAL INFORMATION");
		personalInfo.setBounds(0, -2, 905, 54);
		personalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		personalInfo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		frmHighLandsBanking.getContentPane().add(personalInfo);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(0, 64, 77, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblNewLabel);

		txtname = new JTextField();
		txtname.setEnabled(false);
		txtname.setBounds(76, 62, 285, 31);
		txtname.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtname);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(371, 103, 87, 31);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblAddress);

		txtaddress = new JTextField();
		txtaddress.setEnabled(false);
		txtaddress.setBounds(458, 103, 387, 34);
		txtaddress.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtaddress);

		JSeparator middleLine = new JSeparator();
		middleLine.setBounds(0, 215, 915, 7);
		middleLine.setForeground(Color.BLACK);
		middleLine.setBackground(Color.BLACK);
		frmHighLandsBanking.getContentPane().add(middleLine);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(0, 103, 101, 31);
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblBirthday);

		txtbday = new JTextField();
		txtbday.setEnabled(false);
		txtbday.setColumns(10);
		txtbday.setBounds(96, 104, 240, 31);
		frmHighLandsBanking.getContentPane().add(txtbday);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(0, 148, 101, 31);
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblSex);

		txtsex = new JTextField();
		txtsex.setEnabled(false);
		txtsex.setColumns(10);
		txtsex.setBounds(76, 148, 94, 31);
		frmHighLandsBanking.getContentPane().add(txtsex);

		JLabel lblContactNo = new JLabel("Contact no#");
		lblContactNo.setBounds(336, 149, 122, 29);
		lblContactNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblContactNo);

		txtcontactnum = new JTextField();
		txtcontactnum.setEnabled(false);
		txtcontactnum.setBounds(458, 148, 240, 31);
		txtcontactnum.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtcontactnum);

// ------------------------------------------------CARD INFO----------------------------------------------

		JLabel cardInfo = new JLabel("CARD INFORMATION");
		cardInfo.setBounds(0, 215, 905, 54);
		cardInfo.setHorizontalAlignment(SwingConstants.CENTER);
		cardInfo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		frmHighLandsBanking.getContentPane().add(cardInfo);

		JLabel lblCardNo = new JLabel("Card no#");
		lblCardNo.setBounds(0, 260, 101, 29);
		lblCardNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblCardNo);

		txtcardno = new JTextField();
		txtcardno.setEnabled(false);
		txtcardno.setBounds(100, 260, 285, 31);
		txtcardno.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtcardno);

		JLabel lblCardValidity = new JLabel("Card Validity");
		lblCardValidity.setBounds(0, 299, 122, 29);
		lblCardValidity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardValidity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblCardValidity);

		txtcardval = new JTextField();
		txtcardval.setEnabled(false);
		txtcardval.setBounds(120, 299, 148, 31);
		txtcardval.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtcardval);

		JLabel lblCardType = new JLabel("Card Type");
		lblCardType.setBounds(0, 340, 122, 29);
		lblCardType.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardType.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblCardType);

		txtcardtype = new JTextField();
		txtcardtype.setEnabled(false);
		txtcardtype.setBounds(120, 340, 148, 31);
		txtcardtype.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtcardtype);

		JLabel lblCardLimit = new JLabel("Card Limit");
		lblCardLimit.setBounds(398, 260, 122, 29);
		lblCardLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardLimit.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		frmHighLandsBanking.getContentPane().add(lblCardLimit);

		txtcardlim = new JTextField();
		txtcardlim.setEnabled(false);
		txtcardlim.setBounds(518, 260, 285, 31);
		txtcardlim.setColumns(10);
		frmHighLandsBanking.getContentPane().add(txtcardlim);

		JLabel lblIssuer = new JLabel("Issuer's Name");
		lblIssuer.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssuer.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		lblIssuer.setBounds(398, 310, 122, 29);
		frmHighLandsBanking.getContentPane().add(lblIssuer);

		txtissuername = new JTextField();
		txtissuername.setEnabled(false);
		txtissuername.setColumns(10);
		txtissuername.setBounds(518, 310, 285, 31);
		frmHighLandsBanking.getContentPane().add(txtissuername);

		JLabel lblIdNo = new JLabel("ID no.");
		lblIdNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		lblIdNo.setBounds(371, 64, 87, 29);
		frmHighLandsBanking.getContentPane().add(lblIdNo);

		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setColumns(10);
		txtid.setBounds(458, 64, 44, 31);
		frmHighLandsBanking.getContentPane().add(txtid);

		srchtxtField = new JTextField();
		srchtxtField.setColumns(10);
		srchtxtField.setBounds(86, 416, 193, 20);
		frmHighLandsBanking.getContentPane().add(srchtxtField);

// -------------------------------BUTTONS-------------------------------------------------------------

		JSeparator bottomLine = new JSeparator();
		bottomLine.setBounds(0, 398, 915, 7);
		bottomLine.setForeground(Color.BLACK);
		bottomLine.setBackground(Color.BLACK);
		frmHighLandsBanking.getContentPane().add(bottomLine);

		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Next();
			}
		});
		btnNext.setBackground(SystemColor.activeCaption);
		btnNext.setForeground(Color.BLACK);
		btnNext.setBounds(654, 416, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnNext);

		btnNextLast = new JButton(">>");
		btnNextLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextLast();
			}
		});
		btnNextLast.setForeground(Color.BLACK);
		btnNextLast.setBackground(SystemColor.activeCaption);
		btnNextLast.setBounds(753, 416, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnNextLast);

		btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(555, 416, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnBack);

		btnBackLast = new JButton("<<");
		btnBackLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackLast();
			}
		});
		btnBackLast.setForeground(Color.BLACK);
		btnBackLast.setBackground(SystemColor.activeCaption);
		btnBackLast.setBounds(462, 416, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnBackLast);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
				condition = 1;
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.setBounds(402, 450, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnAdd);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setBackground(SystemColor.activeCaption);
		btnEdit.setBounds(501, 450, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnEdit);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if(btnEdit.isEnabled()) {
					saveEdit();
					
				}else {
					save();
				}
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(SystemColor.activeCaption);
		btnSave.setBounds(600, 450, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.setBounds(699, 450, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(SystemColor.activeCaption);
		btnCancel.setBounds(798, 450, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnCancel);

		btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
				btnAdd.setEnabled(true);
			}
		});
		btnReload.setForeground(Color.BLACK);
		btnReload.setBackground(SystemColor.activeCaption);
		btnReload.setBounds(289, 416, 89, 23);
		frmHighLandsBanking.getContentPane().add(btnReload);

		btnAllRecords = new JButton("All Records");
		btnAllRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allRecords();
			}
		});
		btnAllRecords.setForeground(Color.BLACK);
		btnAllRecords.setBackground(SystemColor.activeCaption);
		btnAllRecords.setBounds(289, 450, 103, 23);
		frmHighLandsBanking.getContentPane().add(btnAllRecords);

		lblJdbc = new JLabel("");
		lblJdbc.setForeground(Color.BLUE);
		lblJdbc.setHorizontalAlignment(SwingConstants.LEFT);
		lblJdbc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		lblJdbc.setBounds(0, 453, 293, 20);
		frmHighLandsBanking.getContentPane().add(lblJdbc);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMain();
			}
		});
		btnSearch.setBounds(0, 415, 77, 23);
		frmHighLandsBanking.getContentPane().add(btnSearch);

	}
}
