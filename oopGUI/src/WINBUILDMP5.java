
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Button;

public class WINBUILDMP5 {

	private JFrame box;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WINBUILDMP5 field = new WINBUILDMP5();
					field.box.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}

	public WINBUILDMP5() {
		initialize();
	}

	private void initialize() {
		box = new JFrame();
		box.setForeground(Color.BLACK);
		box.getContentPane().setBackground(Color.GRAY);
		box.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		box.setBounds(100, 100, 809, 576);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.getContentPane().setLayout(null);

		JLabel lblSize = new JLabel("Sizes: ");
		lblSize.setForeground(Color.PINK);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSize.setBounds(24, 28, 51, 27);
		box.getContentPane().add(lblSize);

		JLabel lblToppings = new JLabel("Toppings: ");
		lblToppings.setForeground(Color.PINK);
		lblToppings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblToppings.setBounds(166, 28, 103, 27);
		box.getContentPane().add(lblToppings);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.PINK);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setBounds(570, 33, 37, 27);
		box.getContentPane().add(lblPrice);

		JLabel lblAddtop = new JLabel("Plus 25 for each topping");
		lblAddtop.setForeground(Color.WHITE);
		lblAddtop.setBackground(Color.WHITE);
		lblAddtop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddtop.setBounds(404, 302, 200, 27);
		box.getContentPane().add(lblAddtop);

		JRadioButton rdbtnSmall = new JRadioButton("Small");
		rdbtnSmall.setBackground(Color.DARK_GRAY);
		rdbtnSmall.setForeground(Color.WHITE);
		rdbtnSmall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnSmall.setBounds(34, 65, 75, 21);
		box.getContentPane().add(rdbtnSmall);

		JRadioButton rdbtnMed = new JRadioButton("Medium");
		rdbtnMed.setBackground(Color.DARK_GRAY);
		rdbtnMed.setForeground(Color.WHITE);
		rdbtnMed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMed.setBounds(34, 99, 103, 21);
		box.getContentPane().add(rdbtnMed);

		JRadioButton rdbtnLarge = new JRadioButton("Large");
		rdbtnLarge.setBackground(Color.DARK_GRAY);
		rdbtnLarge.setForeground(Color.WHITE);
		rdbtnLarge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnLarge.setBounds(34, 134, 103, 21);
		box.getContentPane().add(rdbtnLarge);

		JRadioButton rdbtnJumbo = new JRadioButton("Jumbo");
		rdbtnJumbo.setBackground(Color.DARK_GRAY);
		rdbtnJumbo.setForeground(Color.WHITE);
		rdbtnJumbo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnJumbo.setBounds(34, 168, 103, 21);
		box.getContentPane().add(rdbtnJumbo);

		rdbtnSmall.setActionCommand("Small");
		rdbtnMed.setActionCommand("Medium");
		rdbtnLarge.setActionCommand("Large");
		rdbtnJumbo.setActionCommand("Jumbo");
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnSmall);
		group2.add(rdbtnMed);
		group2.add(rdbtnLarge);
		group2.add(rdbtnJumbo);

		JCheckBox chbxMush = new JCheckBox("Mushroom");
		chbxMush.setBackground(Color.DARK_GRAY);
		chbxMush.setForeground(Color.WHITE);
		chbxMush.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxMush.setBounds(176, 168, 109, 21);
		box.getContentPane().add(chbxMush);

		JCheckBox chbxOnion = new JCheckBox("Onion");
		chbxOnion.setBackground(Color.DARK_GRAY);
		chbxOnion.setForeground(Color.WHITE);
		chbxOnion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxOnion.setBounds(176, 99, 75, 21);
		box.getContentPane().add(chbxOnion);

		JCheckBox chbxOlives = new JCheckBox("Olives");
		chbxOlives.setBackground(Color.DARK_GRAY);
		chbxOlives.setForeground(Color.WHITE);
		chbxOlives.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxOlives.setBounds(176, 65, 75, 21);
		box.getContentPane().add(chbxOlives);

		JCheckBox chbxSaus = new JCheckBox("Sausage");
		chbxSaus.setBackground(Color.DARK_GRAY);
		chbxSaus.setForeground(Color.WHITE);
		chbxSaus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxSaus.setBounds(176, 134, 96, 21);
		box.getContentPane().add(chbxSaus);

		JCheckBox chbxPproni = new JCheckBox("Pepperoni");
		chbxPproni.setBackground(Color.DARK_GRAY);
		chbxPproni.setForeground(Color.WHITE);
		chbxPproni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxPproni.setBounds(176, 201, 119, 21);
		box.getContentPane().add(chbxPproni);

		JCheckBox chbxCheese = new JCheckBox("More Cheese");
		chbxCheese.setBackground(Color.DARK_GRAY);
		chbxCheese.setForeground(Color.WHITE);
		chbxCheese.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxCheese.setBounds(176, 241, 127, 21);
		box.getContentPane().add(chbxCheese);

		JLabel priceSmall = new JLabel("\u25CF Small Pizza is 100");
		priceSmall.setForeground(Color.WHITE);
		priceSmall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceSmall.setBounds(489, 93, 183, 27);
		box.getContentPane().add(priceSmall);

		JLabel priceMed = new JLabel("\u25CF Medium Pizza is 200");
		priceMed.setForeground(Color.WHITE);
		priceMed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceMed.setBounds(489, 128, 200, 27);
		box.getContentPane().add(priceMed);

		JLabel priceLarge = new JLabel("\u25CF Large Pizza is 300");
		priceLarge.setForeground(Color.WHITE);
		priceLarge.setBackground(Color.WHITE);
		priceLarge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceLarge.setBounds(489, 165, 202, 27);
		box.getContentPane().add(priceLarge);

		JLabel priceJumbo = new JLabel("\u25CF Jumbo Pizza is 400");
		priceJumbo.setForeground(Color.WHITE);
		priceJumbo.setBackground(Color.WHITE);
		priceJumbo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceJumbo.setBounds(489, 198, 202, 27);
		box.getContentPane().add(priceJumbo);

		JButton btnOrder = new JButton("Order");
		btnOrder.setBackground(Color.DARK_GRAY);
		btnOrder.setForeground(Color.PINK);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int sizePrice = 0;
				String OrdrSize = "";

				if (group2.getSelection().getActionCommand().equals("Small")) {
					sizePrice = 100;
					OrdrSize = "Small Pizza for";
				} else if (group2.getSelection().getActionCommand().equals("Medium")) {
					sizePrice = 200;
					OrdrSize = "Medium Pizza for ";
				} else if (group2.getSelection().getActionCommand().equals("Large")) {
					sizePrice = 300;
					OrdrSize = "Large Pizza for";
				} else if (group2.getSelection().getActionCommand().equals("Jumbo")) {
					sizePrice = 400;
					OrdrSize = "Jumbo Pizza for";
				}

				int item1 = chbxMush.isSelected() ? 25 : 0;
				int item2 = chbxOnion.isSelected() ? 25 : 0;
				int item3 = chbxOlives.isSelected() ? 25 : 0;
				int item4 = chbxSaus.isSelected() ? 25 : 0;
				int item5 = chbxPproni.isSelected() ? 25 : 0;
				int item6 = chbxCheese.isSelected() ? 25 : 0;

				int toppingsTotal = item1 + item2 + item3 + item4 + item5 + item6;

				int totalAmount = toppingsTotal + sizePrice;

				String j = chbxMush.isSelected() ? "Mushrooms \n" : "";
				String k = chbxOnion.isSelected() ? "Onions \n" : "";
				String l = chbxOlives.isSelected() ? "Olives \n" : "";
				String m = chbxSaus.isSelected() ? "Sausage \n" : "";
				String n = chbxPproni.isSelected() ? "Pepperoni \n" : "";
				String o = chbxCheese.isSelected() ? "More Cheese \n" : "";

				JOptionPane.showMessageDialog(box, "" + "You ordered a " + OrdrSize + " : " + sizePrice + "\n"
						+ "With the following additional toppings: " + "\n" + j + k + l + m + n + o
						+ "Additional toppings: " + toppingsTotal + "\n" + "\n" + "Total Ammount is : " + totalAmount

				);

			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOrder.setBounds(668, 302, 96, 27);
		box.getContentPane().add(btnOrder);
		
		JList list = new JList();
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.DARK_GRAY);
		list.setBounds(394, 21, 375, 260);
		box.getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBackground(Color.DARK_GRAY);
		list_1.setForeground(Color.DARK_GRAY);
		list_1.setBounds(394, 292, 252, 48);
		box.getContentPane().add(list_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to Sky's Pizza Place! ");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 36));
		lblNewLabel.setBounds(10, 375, 568, 125);
		box.getContentPane().add(lblNewLabel);
	}
}

