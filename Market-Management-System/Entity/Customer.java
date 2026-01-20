package Entity;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Customer 
{
	private String customerName;
	private String phoneNumber;
	private String products;
	private int totalAmount;
	
	private File file;
	private FileWriter fwriter;
	
	private String path = System.getProperty("user.dir");

	private String db = "C:\\User\\High Tech\\Downloads\\Market-Management-System\\Data\\userdata.txt";



	public Customer() {
		this.customerName = "";
		this.phoneNumber = "";
		this.products = "";
		this.totalAmount = 0;
	}
	
	public Customer(String customerName, String phoneNumber, String products, int totalAmount) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.products = products;
		this.totalAmount = totalAmount;
	}
	
	public void insertInfo() {
		try {
			file = new File(db);
			System.out.println("Saving to: " + file.getAbsolutePath());
			
			if (!file.exists()) {
				file.getParentFile().mkdirs(); 
				file.createNewFile(); 
				System.out.println("Created new file");
			}
			
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm a, dd/MM/yyyy");
			String timeAndDate = myDateObj.format(myFormatObj);
			
			fwriter = new FileWriter(file, true);
			fwriter.write("\n\n");
			fwriter.write("Date and Time: " + timeAndDate + "\n");
			fwriter.write("Customer Name: " + customerName + "\n");
			fwriter.write("Phone Number: " + phoneNumber + "\n");
			fwriter.write("Products:\n" + products);
			fwriter.write("Total Amount: " + totalAmount + " BDT\n");
			fwriter.write("\n\n");
			fwriter.flush();
			fwriter.close();
			System.out.println("Data saved successfully");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		}
	}
}