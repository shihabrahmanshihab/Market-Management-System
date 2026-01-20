package Frame;
import Entity.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener
{
	private Font f1, f2;
	private Color c1, c2;
	private JPanel panel;
	private JLabel label1, label2, label3, label4;
	private JTextField tf1, tf2;
	private JButton bt1, bt2, bt3;
	private JTextArea ta2;

	private String[] products = {"Biscuit", "Cake", "Chocolate", "Nuts", "Chips", "Drinks"};
	private int[] prices = {50, 150, 80, 200, 40, 60};
	private JCheckBox[] productCheckboxes;
	private JTextField[] quantityFields;
		
	public Frame()
	{
		super("Market Management System");
		super.setBounds(400, 100, 900, 750);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		c2 = new Color(240, 248, 255); 
		panel.setBackground(c2);
		
		f1 = new Font("Cambria", Font.BOLD, 30);
		f2 = new Font("Cambria", Font.BOLD, 18);
		c1 = new Color(25, 25, 112); 
		
		label1 = new JLabel("Welcome to the Market !!!");
		label1.setBounds(200, 10, 500, 40);
		label1.setFont(f1);
		label1.setForeground(c1);
		label1.setOpaque(true);
		label1.setBackground(new Color(255, 223, 186)); 
		label1.setBorder(BorderFactory.createLineBorder(new Color(255, 140, 0), 2)); 
		panel.add(label1);
		
		label2 = new JLabel("Customer Name:");
		label2.setBounds(20, 70, 180, 30);
		label2.setFont(f2);
		label2.setForeground(new Color(47, 79, 79)); 
		panel.add(label2);
		
		tf1 = new JTextField();
		tf1.setBounds(200, 70, 200, 30);
		tf1.setFont(f2);
		tf1.setBackground(Color.WHITE);
		tf1.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); 
		panel.add(tf1);
		
		label3 = new JLabel("Phone Number:");
		label3.setBounds(20, 110, 180, 30);
		label3.setFont(f2);
		label3.setForeground(new Color(47, 79, 79)); 
		panel.add(label3);
		
		tf2 = new JTextField();
		tf2.setBounds(200, 110, 200, 30);
		tf2.setFont(f2);
		tf2.setBackground(Color.WHITE);
		tf2.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); 
		panel.add(tf2);
		
		label4 = new JLabel("Select Products:");
		label4.setBounds(20, 160, 180, 30);
		label4.setFont(f2);
		label4.setForeground(new Color(47, 79, 79));
		panel.add(label4);
		
		// Create checkboxes and quantity fields for each product
		productCheckboxes = new JCheckBox[products.length];
		quantityFields = new JTextField[products.length];
		
		int yPos = 200;
		for(int i = 0; i < products.length; i++) {
			// Product name label with price
			JLabel productLabel = new JLabel(products[i] + " (" + prices[i] + " BDT)");
			productLabel.setBounds(20, yPos, 150, 25);
			productLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
			panel.add(productLabel);
			
			// Checkbox
			productCheckboxes[i] = new JCheckBox();
			productCheckboxes[i].setBounds(180, yPos, 25, 25);
			panel.add(productCheckboxes[i]);
			
			// Quantity label
			JLabel qtyLabel = new JLabel("Qty:");
			qtyLabel.setBounds(210, yPos, 40, 25);
			qtyLabel.setFont(new Font("Cambria", Font.PLAIN, 12));
			panel.add(qtyLabel);
			
			// Quantity text field
			quantityFields[i] = new JTextField("0");
			quantityFields[i].setBounds(250, yPos, 60, 25);
			quantityFields[i].setFont(new Font("Cambria", Font.PLAIN, 14));
			quantityFields[i].setBackground(Color.WHITE);
			quantityFields[i].setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 1));
			panel.add(quantityFields[i]);
			
			yPos += 35;
		}
		
		JLabel historyLabel = new JLabel("Purchase History:");
		historyLabel.setBounds(20, 425, 200, 30);
		historyLabel.setFont(f2);
		historyLabel.setForeground(new Color(47, 79, 79)); 
		panel.add(historyLabel);
		
		ta2 = new JTextArea();
		ta2.setFont(new Font("Cambria", Font.PLAIN, 14));
		ta2.setEditable(false);
		ta2.setBackground(new Color(255, 255, 240)); 
		ta2.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); 
		JScrollPane scrollPane = new JScrollPane(ta2);
		scrollPane.setBounds(20, 460, 800, 150);
		panel.add(scrollPane);
		
		bt1 = new JButton("Submit Order");
		bt1.setBounds(350, 630, 180, 35);
		bt1.setFont(f2);
		bt1.setBackground(new Color(34, 139, 34)); 
		bt1.setForeground(Color.WHITE);
		bt1.setFocusPainted(false);
		bt1.setBorder(BorderFactory.createRaisedBevelBorder());
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2 = new JButton("Clear");
		bt2.setBounds(550, 630, 130, 35);
		bt2.setFont(f2);
		bt2.setBackground(new Color(255, 165, 0)); 
		bt2.setForeground(Color.WHITE);
		bt2.setFocusPainted(false);
		bt2.setBorder(BorderFactory.createRaisedBevelBorder());
		bt2.addActionListener(this);
		panel.add(bt2);
		
		bt3 = new JButton("Exit");
		bt3.setBounds(700, 630, 130, 35);
		bt3.setFont(f2);
		bt3.setBackground(new Color(220, 20, 60)); 
		bt3.setForeground(Color.WHITE);
		bt3.setFocusPainted(false);
		bt3.setBorder(BorderFactory.createRaisedBevelBorder());
		bt3.addActionListener(this);
		panel.add(bt3);
		
		super.add(panel);
		loadPurchaseHistory();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == bt3) {
			System.exit(0);
		}
		else if(ae.getSource() == bt2) {
			clearForm();
		}
		else if(ae.getSource() == bt1) {
			submitOrder();
		}
	}
	
	private void submitOrder() {
		String customerName = tf1.getText().trim();
		String phoneNumber = tf2.getText().trim();
		
		if(customerName.isEmpty() || phoneNumber.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter customer name and phone number!");
			return;
		}
		
		StringBuilder products = new StringBuilder();
		int grandTotal = 0;
		boolean hasProducts = false;
		
		for(int i = 0; i < productCheckboxes.length; i++) {
			if(productCheckboxes[i].isSelected()) {
				try {
					int quantity = Integer.parseInt(quantityFields[i].getText().trim());
					if(quantity > 0) {
						hasProducts = true;
						String productName = this.products[i];
						int price = this.prices[i];
						int total = price * quantity;
						
						products.append(productName)
								.append(" x").append(quantity)
								.append(" @ ").append(price)
								.append(" BDT = ").append(total)
								.append(" BDT\n");
						
						grandTotal += total;
					}
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(this, "Please enter valid quantity for " + this.products[i] + "!");
					return;
				}
			}
		}
		
		if(!hasProducts) {
			JOptionPane.showMessageDialog(this, "Please select at least one product!");
			return;
		}
		
		Customer customer = new Customer(customerName, phoneNumber, products.toString(), grandTotal);
		customer.insertInfo();
				
		clearForm();
		loadPurchaseHistory();
	}
	
	private void clearForm() {
		tf1.setText("");
		tf2.setText("");
		
		for(int i = 0; i < productCheckboxes.length; i++) {
			productCheckboxes[i].setSelected(false);
			quantityFields[i].setText("0");
		}
	}
	
	private void loadPurchaseHistory() {
		ta2.setText("");
		try {
			File file = new File("C:\\User\\High Tech\\Downloads\\Market-Management-System\\Data\\userdata.txt");
			System.out.println("Looking for file at: " + file.getAbsolutePath());
			
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					ta2.append(line + "\n");
				}
				br.close();
				System.out.println("Purchase history loaded successfully");
			} else {
				ta2.setText("No purchase history found yet.\nFile will be created when first order is placed.");
				System.out.println("File does not exist yet");
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error loading purchase history!");
		}
	}
}