import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class records {

	private JFrame frame;
	private JTextField txtSearch;
	private JTable rcrdTbl;
	private JScrollPane scrollPane;
	ResultSet rs;
	Statement st;
	Connection con;
	PreparedStatement pst;
	ResultSetMetaData rmd;
	String query;
	String connection = "jdbc:mysql://localhost:3306/bankingdtbs";
	String username = "root";
	String password = "";
	private JButton btnSearch;

	String column[] = { "ID", "NAME", "BIRTHDAY", "SEX", "ADDRESS", "CONTACT NO.", "CARD NO.", "VALIDITY", "TYPE",
			"LIMIT", "ISSUER NAME" };
	DefaultTableModel model;

//----------------------------------------------- METHODS -----------------------------------------------------------
	void loadData() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdtbs", "root", "");
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * FROM info");

			while (rs.next()) {
				String[] info = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11),

				};
				model.addRow(info);

			}

			rcrdTbl.setModel(model);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void search() {
		try {
			pst = con.prepareStatement("SELECT * FROM info WHERE UPPER(Name) LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			if (txtSearch.getText().matches("[0-9]+")) {
				pst = con.prepareStatement("SELECT * FROM info WHERE IDnum  = ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				pst.setInt(1, Integer.parseInt(txtSearch.getText()));

			} else {
				pst = con.prepareStatement("SELECT * FROM info WHERE UPPER(Name) LIKE ?",
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, txtSearch.getText().toUpperCase());
			}

			rs = pst.executeQuery();

			if (rs.first()) {
				rs.beforeFirst();
				DefaultTableModel dtm = (DefaultTableModel) rcrdTbl.getModel();
				dtm.setRowCount(0);
				while (rs.next()) {
					String Idnum = rs.getString(1);
					String Name = rs.getString(2);
					String Birthday = rs.getString(3);
					String Sex = rs.getString(4);
					String Address = rs.getString(5);
					String ContactNum = rs.getString(6);
					String CardNum = rs.getString(7);
					String CardVal = rs.getString(8);
					String CardType = rs.getString(9);
					String CardLim = rs.getString(10);
					String IssuersName = rs.getString(11);

					dtm.addRow(new Object[] { Idnum, Name, Birthday, Sex, Address, ContactNum, CardNum, CardVal,
							CardType, CardLim, IssuersName });
				}
			} else {
				JOptionPane.showMessageDialog(null, "No record Found");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		txtSearch.setText("");
	}

	void reload() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdtbs", "root", "");
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * FROM info");

			DefaultTableModel dtm = (DefaultTableModel) rcrdTbl.getModel();
			dtm.setRowCount(0);
			while (rs.next()) {
				String Idnum = rs.getString(1);
				String Name = rs.getString(2);
				String Birthday = rs.getString(3);
				String Sex = rs.getString(4);
				String Address = rs.getString(5);
				String ContactNum = rs.getString(6);
				String CardNum = rs.getString(7);
				String CardVal = rs.getString(8);
				String CardType = rs.getString(9);
				String CardLim = rs.getString(10);
				String IssuersName = rs.getString(11);

				dtm.addRow(new Object[] { Idnum, Name, Birthday, Sex, Address, ContactNum, CardNum, CardVal, CardType,
						CardLim, IssuersName });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// -------------------------------------------- MAIN METHOD --------------------------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					records window = new records();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
// -------------------------------------------------- INITIALIZATION OF THE WINDOW ---------------------------------

	public records() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1026, 542);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtSearch = new JTextField();
		txtSearch.setBounds(119, 40, 135, 20);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		rcrdTbl = new JTable();
		scrollPane = new JScrollPane(rcrdTbl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 71, 990, 421);
		frame.getContentPane().add(scrollPane);
		model = new DefaultTableModel(column, 0);

		JButton btnReload = new JButton("RELOAD");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setBounds(264, 39, 89, 23);
		frame.getContentPane().add(btnReload);

		btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(20, 38, 89, 23);
		frame.getContentPane().add(btnSearch);

		loadData();

	}
}
