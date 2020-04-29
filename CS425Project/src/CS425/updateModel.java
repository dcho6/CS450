package CS425;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class updateModel extends JFrame
{
	private JPanel contentPane;
	private JTextField model_number;
	private JTextField sale_price;
	private JTextField manufacturer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateModel frame = new updateModel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public updateModel()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text2 = new JLabel("Model Number:");
		text2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		text2.setHorizontalAlignment(SwingConstants.RIGHT);
		text2.setBounds(10, 10, 166, 54);
		contentPane.add(text2);
		
		model_number = new JTextField();
		model_number.setBounds(186, 10, 315, 54);
		contentPane.add(model_number);
		model_number.setColumns(10);
		
		JLabel text1 = new JLabel("Sale Price:");
		text1.setHorizontalAlignment(SwingConstants.RIGHT);
		text1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		text1.setBounds(20, 74, 156, 54);
		contentPane.add(text1); 
		
		sale_price = new JTextField();
		sale_price.setBounds(186, 74, 315, 54);
		contentPane.add(sale_price);
		sale_price.setColumns(10);
		
		JLabel lblmanufacturer = new JLabel("Manufacturer:");
		lblmanufacturer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmanufacturer.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblmanufacturer.setBounds(20, 138, 156, 54);
		contentPane.add(lblmanufacturer);
		
		manufacturer = new JTextField();
		manufacturer.setBounds(186, 138, 315, 54);
		contentPane.add(manufacturer);
		manufacturer.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection connect = null;
				
				connect = functions.connect();
			
				String query = "UPDATE Model "
						+ "SET sale_price = ?, "
						+ "manufacturer = ? "
						+ "WHERE model_number = ?";/*will be using the text field to fill in the values of ?*/
			
				PreparedStatement myStmt = connect.prepareStatement(query);/*This is the line we are going to use if the user is actually an employee that is registered in the database*/
				
				myStmt.setLong(1, Integer.parseInt(sale_price.getText()));/*getting value enetered for employeeID*/
				
				myStmt.setString(2, manufacturer.getText());/*getting value enetered for privilege*/
			
				myStmt.setLong(3, Integer.parseInt(model_number.getText()));/*getting the entered value for ssn*/
				
				myStmt.executeUpdate();
				
				myStmt.close();} catch(Exception e1){
					

					JOptionPane.showMessageDialog(null, "Please Make sure you enter the correct value in each field");
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(156, 216, 250, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNotice = new JLabel("Warning: Model Number must already exist");
		lblNotice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotice.setBounds(10, 270, 450, 45);
		contentPane.add(lblNotice);
		
	}

}
