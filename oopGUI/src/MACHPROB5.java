
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

public class MACHPROB5 {

	private JFrame box;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MACHPROB5 field = new MACHPROB5();
					field.box.setVisible(true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
	}

	public MACHPROB5() {
		initialize();
	}

	private void initialize() {
		box = new JFrame();
		box.setBounds(100, 100, 699, 520);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.getContentPane().setLayout(null);

		JLabel lblSize = new JLabel("Size: ");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSize.setBounds(24, 28, 77, 27);
		box.getContentPane().add(lblSize);

		JLabel lblToppings = new JLabel("Toppings: ");
		lblToppings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblToppings.setBounds(24, 76, 103, 27);
		box.getContentPane().add(lblToppings);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setBounds(24, 156, 77, 27);
		box.getContentPane().add(lblPrice);

		JLabel lblAddtop = new JLabel("Plus 25 for each topping");
		lblAddtop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddtop.setBounds(14, 357, 308, 27);
		box.getContentPane().add(lblAddtop);

		JRadioButton rdbtnSmall = new JRadioButton("Small");
		rdbtnSmall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnSmall.setBounds(89, 31, 103, 21);
		box.getContentPane().add(rdbtnSmall);

		JRadioButton rdbtnMed = new JRadioButton("Medium");
		rdbtnMed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMed.setBounds(170, 31, 103, 21);
		box.getContentPane().add(rdbtnMed);

		JRadioButton rdbtnLarge = new JRadioButton("Large");
		rdbtnLarge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnLarge.setBounds(271, 31, 103, 21);
		box.getContentPane().add(rdbtnLarge);

		JRadioButton rdbtnJumbo = new JRadioButton("Jumbo");
		rdbtnJumbo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnJumbo.setBounds(369, 31, 103, 21);
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
		chbxMush.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxMush.setBounds(133, 76, 109, 21);
		box.getContentPane().add(chbxMush);

		JCheckBox chbxOnion = new JCheckBox("Onion");
		chbxOnion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxOnion.setBounds(249, 76, 89, 21);
		box.getContentPane().add(chbxOnion);

		JCheckBox chbxOlives = new JCheckBox("Olives");
		chbxOlives.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxOlives.setBounds(342, 76, 89, 21);
		box.getContentPane().add(chbxOlives);

		JCheckBox chbxSaus = new JCheckBox("Sausage");
		chbxSaus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxSaus.setBounds(444, 76, 119, 21);
		box.getContentPane().add(chbxSaus);

		JCheckBox chbxPproni = new JCheckBox("Pepperoni");
		chbxPproni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxPproni.setBounds(560, 79, 119, 21);
		box.getContentPane().add(chbxPproni);

		JCheckBox chbxCheese = new JCheckBox("More Cheese");
		chbxCheese.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chbxCheese.setBounds(133, 116, 168, 21);
		box.getContentPane().add(chbxCheese);

		JLabel priceSmall = new JLabel("\u25CF Small Pizza is 100");
		priceSmall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceSmall.setBounds(24, 193, 183, 27);
		box.getContentPane().add(priceSmall);

		JLabel priceMed = new JLabel("\u25CF Medium Pizza is 200");
		priceMed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceMed.setBounds(24, 230, 200, 27);
		box.getContentPane().add(priceMed);

		JLabel priceLarge = new JLabel("\u25CF Large Pizza is 300");
		priceLarge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceLarge.setBounds(24, 267, 202, 27);
		box.getContentPane().add(priceLarge);

		JLabel priceJumbo = new JLabel("\u25CF Jumbo Pizza is 400");
		priceJumbo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceJumbo.setBounds(24, 304, 202, 27);
		box.getContentPane().add(priceJumbo);

		JButton btnOrder = new JButton("Order");
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
		btnOrder.setBounds(348, 396, 96, 27);
		box.getContentPane().add(btnOrder);
	}
}
