import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class seatworkpt2 {
    private JFrame frmListBox;
    private JTextField txtfld;
    private JButton btnlisttolistone;
    private JButton btmlisttolistall;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    seatworkpt2 window = new seatworkpt2();
                    window.frmListBox.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public seatworkpt2() {
        initialize();
    }
    private void initialize() {
    	
        frmListBox = new JFrame();
        frmListBox.setTitle("List box");
        frmListBox.setBounds(100, 100, 525, 300);
        frmListBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmListBox.getContentPane().setLayout(null);
        txtfld = new JTextField();
        txtfld.setBounds(20, 31, 96, 19);
        frmListBox.getContentPane().add(txtfld);
        DefaultListModel < String > model1 = new DefaultListModel < > ();
        JList < String > list1 = new JList < > (model1);
        list1.setBounds(133, 33, 117, 155);
        frmListBox.getContentPane().add(list1);
        DefaultListModel < String > model2 = new DefaultListModel < > ();
        JList < String > list2 = new JList < > (model2);
        list2.setBounds(326, 33, 117, 155);
        frmListBox.getContentPane().add(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        JButton btnreturnall = new JButton("<<");
        btnreturnall.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (list2.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(btmlisttolistall, "Please Select all");
                } else {
                	DefaultListModel model2 = (DefaultListModel) list2.getModel();
                	for (Object sel : list2.getSelectedValues()) {
//	                	if (model2.indexOf(sel) == -1) {
		                	model1.addElement((String) sel);
		
		                	int index = list2.getSelectedIndex();
		                	model2.remove(index);
		                	
//	                	}
	                }
                }
        		
        	}
        });
        btnreturnall.setBounds(260, 120, 56, 21);
        frmListBox.getContentPane().add(btnreturnall);
        btmlisttolistall = new JButton(">>");
        btmlisttolistall.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  if (list1.getSelectedIndex() == -1) {
                      JOptionPane.showMessageDialog(btmlisttolistall, "Please Select all");
                  } else {
                      DefaultListModel model2 = (DefaultListModel) list2.getModel();
                      for (Object sel: list1.getSelectedValues()) {
                          if (model2.indexOf(sel) == -1) {
                              model2.addElement(sel);
                              model1.removeAllElements();
                          }
                      }
                  }
        	}
        });
        btmlisttolistall.setBounds(260, 78, 56, 21);
        frmListBox.getContentPane().add(btmlisttolistall);
        JButton btnclear1 = new JButton("Clear");
        btnclear1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model1.removeAllElements();
            }
        });
        btnclear1.setBounds(197, 198, 69, 21);
        frmListBox.getContentPane().add(btnclear1);
        JButton btmtexttolist = new JButton(">");
        btmtexttolist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model1.addElement(txtfld.getText());
                txtfld.setText(null);
                txtfld.requestFocusInWindow();
            }
        });
        btmtexttolist.setBounds(59, 60, 56, 21);
        frmListBox.getContentPane().add(btmtexttolist);
        btnlisttolistone = new JButton(">");
        btnlisttolistone.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 if (list1.getSelectedIndex() == -1) {
                     JOptionPane.showMessageDialog(btnlisttolistone, "Please Select one");
                 } else {
                     model2.addElement(list1.getSelectedValue());
                     int index = list1.getSelectedIndex();
                     model1.remove(index);
                 }
        	}
        }); 
        btnlisttolistone.setBounds(260, 33, 56, 21);
        frmListBox.getContentPane().add(btnlisttolistone);
        JButton btnSelectAll1 = new JButton("Select all");
        btnSelectAll1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int begn = 0;
                int end = list1.getModel().getSize() - 1;
                if (end >= 0) {
                    list1.setSelectionInterval(begn, end);
                }
            }
        });
        btnSelectAll1.setBounds(96, 198, 96, 21);
        frmListBox.getContentPane().add(btnSelectAll1);
    }
}