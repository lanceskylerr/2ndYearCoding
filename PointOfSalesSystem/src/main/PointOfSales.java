package main;

import java.awt.EventQueue;

public class PointOfSales {

	private JFrame frmJeyymsBasicPoint;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtBarangay;
	private JTextField txtTown;
	private JTextField txtProvince;
	private JTextField txtContact;
	private JTextField txtDateOfPurchase;
	private JTextField txtTotalPurchase;
	private JTextField txtSearch;
	private JTextField txtReceipt;

	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnDelete;
	private JButton btnViewRecords;
	private JButton btnReload;

	private JLabel lblDBStatus;
	private JTextArea txtRemarks;

	private String type = "";

	private final String connection = "jdbc:mysql://localhost:3306/posnijeyym";
	private final String username = "root";
	private final String password = "";

	private Connection conn;
	private PreparedStatement stmnt;
	private ResultSet rs;
	private String query;

	private void LoadCustomers() {

		setEnabledTextFields(false);
		setEnabledAddEditDelete(true);
		setEnabledSaveCancel(false);
		setEnabledFirstPrevious(false);
		setEnabledLastNext(true);

		try {
			conn = DriverManager.getConnection(connection, username, password);
			query = "SELECT * FROM tblCustomers";

			stmnt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmnt.executeQuery();

			if (rs.next()) {
				setInformation();
			}
			lblDBStatus.setText("JDBC Connection established successfully!");
			lblDBStatus.setForeground(Color.BLUE);

		} catch (Exception e) {
			lblDBStatus.setText("JDBC Connection failed!");
			lblDBStatus.setForeground(Color.RED);
			System.out.println(e.toString());
		}
	}

	private void getInformation(String id) {

		setEnabledTextFields(false);
		setEnabledAddEditDelete(true);
		setEnabledSaveCancel(false);
		setEnabledUpperButtons(true);

		try {
			conn = DriverManager.getConnection(connection, username, password);
			query = "SELECT * FROM tblCustomers";

			stmnt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(id)) {
					setInformation();
					break;
				}
			}

			lblDBStatus.setText("JDBC Connection established successfully!");
			lblDBStatus.setForeground(Color.BLUE);

		} catch (Exception e) {
			lblDBStatus.setText("JDBC Connection failed!");
			lblDBStatus.setForeground(Color.RED);
			System.out.println(e.toString());
		}
	}

	private void setInformation() {
		try {
			txtID.setText(rs.getString(1));
			txtName.setText(rs.getString(2));
			txtBarangay.setText(rs.getString(3));
			txtTown.setText(rs.getString(4));
			txtProvince.setText(rs.getString(5));
			txtContact.setText(rs.getString(6));
			txtReceipt.setText(rs.getString(7));
			txtDateOfPurchase.setText(rs.getString(8));
			txtTotalPurchase.setText(rs.getString(9));
			txtRemarks.setText(rs.getString(10));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void IncrementID() {
		try {
			conn = DriverManager.getConnection(connection, username, password);
			query = "SELECT * FROM tblCustomers";

			stmnt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmnt.executeQuery();

			rs.last();
			txtID.setText(String.valueOf((Integer.parseInt(rs.getString(1)) + 1)));

			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void SaveCustomer() {
		try {

			String name = txtName.getText();
			String barangay = txtBarangay.getText();
			String town = txtTown.getText();
			String province = txtProvince.getText();
			String contact = txtContact.getText();
			String receipt = txtReceipt.getText();
			String dateOfPurchase = txtDateOfPurchase.getText();
			String totalPurchase = txtTotalPurchase.getText();
			String remarks = txtRemarks.getText();

			conn = DriverManager.getConnection(connection, username, password);
			query = "INSERT INTO tblCustomers(name, barangay, town, province, contactNum, receiptID, dateOfPurchase, totalPurchase, remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			stmnt = conn.prepareStatement(query);
			stmnt.setString(1, name);
			stmnt.setString(2, barangay);
			stmnt.setString(3, town);
			stmnt.setString(4, province);
			stmnt.setString(5, contact);
			stmnt.setString(6, receipt);
			stmnt.setString(7, dateOfPurchase);
			stmnt.setString(8, totalPurchase);
			stmnt.setString(9, remarks);

			stmnt.execute();
			conn.close();
			JOptionPane.showMessageDialog(null, "Customer added successfully!", "Add Customer",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Customer not added! Connection Problem!", "Add Customer",
					JOptionPane.ERROR_MESSAGE);
			System.out.println(e.toString());
		}
		LoadCustomers();
	}

	private void DeleteCustomer(String id) {
		try {

			conn = DriverManager.getConnection(connection, username, password);
			query = "DELETE FROM tblCustomers WHERE id=?";

			stmnt = conn.prepareStatement(query);
			stmnt.setString(1, id);

			stmnt.executeUpdate();
			conn.close();
			JOptionPane.showMessageDialog(null, "Customer deleted successfully!", "Add Customer",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Customer not deleted! Connection Problem!", "Add Customer",
					JOptionPane.ERROR_MESSAGE);
			System.out.println(e.toString());
		}
		LoadCustomers();
	}

	private void SearchCustomers() {
		setEnabledFirstPrevious(false);
		setEnabledLastNext(true);

		String search = txtSearch.getText();

		try {
			conn = DriverManager.getConnection(connection, username, password);
			query = "SELECT * FROM tblCustomers WHERE name LIKE '%" + search + "%' OR id LIKE '%" + search + "%'";

			stmnt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmnt.executeQuery();

			if (rs.next()) {
				setInformation();
				if (rs.next() == false) {
					setEnabledLastNext(false);
				}
				rs.previous();
			}else {
				clearTextFields();
				txtID.setText("");
				setEnabledUpperButtons(false);
				
			}

			// System.out.println(x);

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void UpdateCustomer(String id) {
		try {
			String name = txtName.getText();
			String barangay = txtBarangay.getText();
			String town = txtTown.getText();
			String province = txtProvince.getText();
			String contact = txtContact.getText();
			String receipt = txtReceipt.getText();
			String dateOfPurchase = txtDateOfPurchase.getText();
			String totalPurchase = txtTotalPurchase.getText();
			String remarks = txtRemarks.getText();

			conn = DriverManager.getConnection(connection, username, password);
			query = "UPDATE tblCustomers SET name=?, barangay=?, town=?, province=?, contactNum=?, receiptID=?, dateOfPurchase=?, totalPurchase=?, remarks=? WHERE id=?";

			stmnt = conn.prepareStatement(query);
			stmnt.setString(1, name);
			stmnt.setString(2, barangay);
			stmnt.setString(3, town);
			stmnt.setString(4, province);
			stmnt.setString(5, contact);
			stmnt.setString(6, receipt);
			stmnt.setString(7, dateOfPurchase);
			stmnt.setString(8, totalPurchase);
			stmnt.setString(9, remarks);
			stmnt.setString(10, id);

			stmnt.executeUpdate();
			conn.close();
			JOptionPane.showMessageDialog(null, "Customer updated successfully!", "Add Customer",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Customer not updated! Connection Problem!", "Add Customer",
					JOptionPane.ERROR_MESSAGE);
			System.out.println(e.toString());
		}

		getInformation(id);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointOfSales window = new PointOfSales();
					window.frmJeyymsBasicPoint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PointOfSales() {
		initialize();
		LoadCustomers();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJeyymsBasicPoint = new JFrame();
		frmJeyymsBasicPoint.setTitle("Jeyym's Basic Point of Sales System");
		frmJeyymsBasicPoint.setBounds(100, 100, 477, 684);
		frmJeyymsBasicPoint.setLocationRelativeTo(null);
		frmJeyymsBasicPoint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJeyymsBasicPoint.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 67, 100, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblNewLabel);

		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCustomerName.setBounds(12, 92, 106, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblCustomerName);

		JLabel lblCustomerAddress = new JLabel("Customer Address");
		lblCustomerAddress.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCustomerAddress.setBounds(12, 133, 149, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblCustomerAddress);

		JLabel lblBarangay = new JLabel("Barangay");
		lblBarangay.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBarangay.setBounds(12, 160, 70, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblBarangay);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setFont(new Font("Arial", Font.PLAIN, 14));
		txtID.setBounds(128, 67, 142, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(128, 92, 320, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtName);

		txtBarangay = new JTextField();
		txtBarangay.setEnabled(false);
		txtBarangay.setFont(new Font("Arial", Font.PLAIN, 14));
		txtBarangay.setColumns(10);
		txtBarangay.setBounds(82, 160, 142, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtBarangay);

		txtTown = new JTextField();
		txtTown.setEnabled(false);
		txtTown.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTown.setColumns(10);
		txtTown.setBounds(304, 160, 142, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtTown);

		JLabel lblTowncity = new JLabel("Town/City");
		lblTowncity.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTowncity.setBounds(234, 160, 70, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblTowncity);

		txtProvince = new JTextField();
		txtProvince.setEnabled(false);
		txtProvince.setFont(new Font("Arial", Font.PLAIN, 14));
		txtProvince.setColumns(10);
		txtProvince.setBounds(82, 188, 142, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtProvince);

		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Arial", Font.PLAIN, 14));
		lblProvince.setBounds(12, 188, 70, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblProvince);

		JLabel lblCustomerInformation = new JLabel("Customer Information");
		lblCustomerInformation.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCustomerInformation.setBounds(12, 233, 149, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblCustomerInformation);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(-9, 123, 496, 2);
		frmJeyymsBasicPoint.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(-9, 219, 496, 2);
		frmJeyymsBasicPoint.getContentPane().add(separator_1);

		JLabel lblContact = new JLabel("Contact #");
		lblContact.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContact.setBounds(12, 257, 70, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblContact);

		txtContact = new JTextField();
		txtContact.setEnabled(false);
		txtContact.setFont(new Font("Arial", Font.PLAIN, 14));
		txtContact.setColumns(10);
		txtContact.setBounds(82, 257, 142, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtContact);

		JLabel lblReceipt = new JLabel("Receipt #");
		lblReceipt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblReceipt.setBounds(236, 257, 70, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblReceipt);

		txtReceipt = new JTextField();
		txtReceipt.setEnabled(false);
		txtReceipt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtReceipt.setColumns(10);
		txtReceipt.setBounds(306, 257, 142, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtReceipt);

		JLabel lblDateOfPurchase = new JLabel("Date of Purchase");
		lblDateOfPurchase.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDateOfPurchase.setBounds(12, 282, 128, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblDateOfPurchase);

		txtDateOfPurchase = new JTextField();
		txtDateOfPurchase.setEnabled(false);
		txtDateOfPurchase.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDateOfPurchase.setColumns(10);
		txtDateOfPurchase.setBounds(128, 282, 320, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtDateOfPurchase);

		JLabel lblTotalPurchase = new JLabel("Total Purchase");
		lblTotalPurchase.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotalPurchase.setBounds(12, 307, 128, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblTotalPurchase);

		txtTotalPurchase = new JTextField();
		txtTotalPurchase.setEnabled(false);
		txtTotalPurchase.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTotalPurchase.setColumns(10);
		txtTotalPurchase.setBounds(128, 307, 320, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtTotalPurchase);

		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRemarks.setBounds(12, 332, 128, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblRemarks);

		txtRemarks = new JTextArea();
		txtRemarks.setEnabled(false);
		txtRemarks.setLineWrap(true);
		txtRemarks.setBounds(12, 357, 436, 123);
		frmJeyymsBasicPoint.getContentPane().add(txtRemarks);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSearch.setBounds(204, 19, 78, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblSearch);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.DARK_GRAY);
		separator_2.setBounds(-23, 53, 496, 2);
		frmJeyymsBasicPoint.getContentPane().add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.DARK_GRAY);
		separator_2_1.setBounds(-23, 491, 496, 2);
		frmJeyymsBasicPoint.getContentPane().add(separator_2_1);

		btnFirst = new JButton("|<");
		btnFirst.setEnabled(false);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnabledLastNext(true);
				try {
					rs.first();
					setInformation();
					setEnabledFirstPrevious(false);
					JOptionPane.showMessageDialog(null, "First Customer Details reached!", "Customer Details",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					System.out.println(e1.toString());
				}
			}
		});
		btnFirst.setFont(new Font("Arial", Font.PLAIN, 14));
		btnFirst.setBounds(82, 504, 70, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnFirst);

		btnPrevious = new JButton("<");
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnabledLastNext(true);
				try {
					if (rs.previous()) {
						setInformation();

						if (rs.previous() == false) {
							rs.first();
							setEnabledFirstPrevious(false);
							JOptionPane.showMessageDialog(null, "First Customer Details reached!", "Customer Details",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							rs.next();
						}
					}
				} catch (Exception ex) {
					System.out.println(e.toString());
				}
			}
		});
		btnPrevious.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPrevious.setBounds(156, 504, 70, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnPrevious);

		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setEnabledFirstPrevious(true);
				try {
					if (rs.next()) {
						setInformation();

						if (rs.next() == false) {
							rs.last();
							setEnabledLastNext(false);
							JOptionPane.showMessageDialog(null, "Last Customer Details reached!", "Customer Details",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							rs.previous();
						}
					}
				} catch (Exception ex) {
					System.out.println(e.toString());
				}

			}
		});
		btnNext.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNext.setBounds(232, 504, 70, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setEnabledFirstPrevious(true);
				try {
					rs.last();
					setInformation();
					setEnabledLastNext(false);
					JOptionPane.showMessageDialog(null, "Last Customer Details reached!", "Customer Details",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					System.out.println(e1.toString());
				}
			}
		});
		btnLast.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLast.setBounds(312, 504, 70, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnLast);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				IncrementID();
				setEnabledTextFields(true);
				setEnabledAddEditDelete(false);
				setEnabledSaveCancel(true);
				clearTextFields();
				setEnabledUpperButtons(false);

				type = "add";

			}
		});
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAdd.setBounds(11, 538, 78, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnAdd);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setEnabledTextFields(true);
				setEnabledAddEditDelete(false);
				setEnabledSaveCancel(true);
				setEnabledUpperButtons(false);

				type = "edit";

			}
		});
		btnEdit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEdit.setBounds(100, 538, 78, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnEdit);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Add Functionalities
				if (type.equals("add")) {
					SaveCustomer();
				}
				// Edit/Update Functionalities
				else {
					UpdateCustomer(txtID.getText());
				}
				type = "";
			}
		});
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSave.setBounds(189, 538, 78, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnSave);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Add Functionalities
				if (type.equals("add")) {
					LoadCustomers();
				}
				// Edit/Update Functionalities
				else {
					getInformation(txtID.getText());
					try {
						if (rs.previous() == false) {
							setEnabledFirstPrevious(false);
							rs.next();
						} else if (rs.next()) {
							setEnabledLastNext(false);
						}

					} catch (Exception ex) {
						System.out.println(ex.toString());
					}
				}
				type = "";
			}
		});

		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancel.setBounds(278, 538, 78, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnCancel);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCustomer(txtID.getText());
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDelete.setBounds(367, 538, 78, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnDelete);

		btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadCustomers();
			}
		});
		btnReload.setFont(new Font("Arial", Font.PLAIN, 14));
		btnReload.setBounds(14, 569, 209, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnReload);

		btnViewRecords = new JButton("View All Records");
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomer(txtID.getText());
			}
		});
		btnViewRecords.setFont(new Font("Arial", Font.PLAIN, 14));
		btnViewRecords.setBounds(237, 570, 209, 23);
		frmJeyymsBasicPoint.getContentPane().add(btnViewRecords);

		lblDBStatus = new JLabel("JDBS Connection Status");
		lblDBStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDBStatus.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDBStatus.setBounds(140, 617, 309, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblDBStatus);

		JLabel lblJdbsConnectionStatus_1 = new JLabel("(c) Jeyym Santos");
		lblJdbsConnectionStatus_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblJdbsConnectionStatus_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblJdbsConnectionStatus_1.setBounds(12, 617, 118, 20);
		frmJeyymsBasicPoint.getContentPane().add(lblJdbsConnectionStatus_1);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SearchCustomers();
			}
		});
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(292, 19, 157, 20);
		frmJeyymsBasicPoint.getContentPane().add(txtSearch);
	}

	private void setEnabledTextFields(boolean status) {
		txtName.setEnabled(status);
		txtBarangay.setEnabled(status);
		txtTown.setEnabled(status);
		txtProvince.setEnabled(status);
		txtContact.setEnabled(status);
		txtReceipt.setEnabled(status);
		txtDateOfPurchase.setEnabled(status);
		txtTotalPurchase.setEnabled(status);
		txtRemarks.setEnabled(status);
	}

	private void clearTextFields() {
		txtName.setText("");
		txtBarangay.setText("");
		txtTown.setText("");
		txtProvince.setText("");
		txtContact.setText("");
		txtReceipt.setText("");
		txtDateOfPurchase.setText("");
		txtTotalPurchase.setText("");
		txtRemarks.setText("");
	}

	private void setEnabledSaveCancel(boolean status) {
		btnSave.setEnabled(status);
		btnCancel.setEnabled(status);
	}

	private void setEnabledAddEditDelete(boolean status) {
		btnAdd.setEnabled(status);
		btnEdit.setEnabled(status);
		btnDelete.setEnabled(status);
	}


	private void setEnabledFirstPrevious(boolean status) {
		btnFirst.setEnabled(status);
		btnPrevious.setEnabled(status);
	}

	private void setEnabledLastNext(boolean status) {
		btnLast.setEnabled(status);
		btnNext.setEnabled(status);
	}

	private void setEnabledUpperButtons(boolean status) {
		btnFirst.setEnabled(status);
		btnLast.setEnabled(status);
		btnNext.setEnabled(status);
		btnPrevious.setEnabled(status);
	}

}
