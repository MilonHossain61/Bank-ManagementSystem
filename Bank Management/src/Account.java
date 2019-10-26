import java.io.*;

import javax.swing.JOptionPane;

public class Account {

	private String name;
	private String username;
	private double acbalance;
	private String password;
	
	File datastore = new File("C:\\Users\\Milon Hossain\\Documents\\Bank Management\\src\\ClientData.txt");
	
	public Account(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
		acbalance = 0.0;
		
		try (FileWriter myF = new FileWriter(datastore, true);
			BufferedWriter bw = new BufferedWriter(myF);
			PrintWriter fileinput = new PrintWriter(myF);)
		{
			fileinput.println(name);
			fileinput.println(username);
			fileinput.println(password);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deposit(double amt)
    {
		
			acbalance = acbalance + amt;
   	 		JOptionPane.showMessageDialog(null,"Amount Deposited");
		
    }
	
    public void withdraw(double amt) throws Exception 
    {
   	 if(acbalance >= amt)
	{
	    acbalance = acbalance - amt;
	    JOptionPane.showMessageDialog(null,"Amount Withdrawn");
	}
	else
	{
	    throw new Exception("Could not Withdraw: Insufficent Amount.");
	}
    }
	
	public double getBalance(){
		return acbalance;
	}
	
}
