package com.zyc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.zyc.controlller.CustomerControllerImplement;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModifyCustomerPassword {

	private JFrame frame;
	private JTextField password;
	private JTextField passwordAgain;
	private Customer customer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyCustomerPassword window = new ModifyCustomerPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * @param customer
	 */
	public ModifyCustomerPassword(Customer customer) {
		super();
		this.customer = customer;
		initialize();
	}
	public void show(){
		Customer temp = this.customer;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyCustomerPassword window = new ModifyCustomerPassword(temp);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public ModifyCustomerPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("密码修改 " + this.customer.getCustomerGroy() + ":" + this.customer.getCustomerName());
		frame.setBounds(100, 100, 419, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新密码");
		lblNewLabel.setBounds(120, 23, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		password = new JTextField();
		password.setBounds(184, 20, 117, 21);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("再次输入");
		lblNewLabel_1.setBounds(120, 75, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordAgain = new JTextField();
		passwordAgain.setBounds(184, 72, 117, 21);
		frame.getContentPane().add(passwordAgain);
		passwordAgain.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password.getText().equals(passwordAgain.getText())){
					customer.setCustomerPassword(password.getText().toString());
					System.out.println(customer);
					try {
						new CustomerControllerImplement().modifyCustomer(customer);
					} catch (SQLException e1) {
						new Error("密码修改失败").show();
						e1.printStackTrace();
					} catch (MyExcepton e1) {
						new Error("密码修改失败").show();
						e1.printStackTrace();
					}
					new Prompt("密码修改成功").show();
					frame.dispose();
				}else{
					new Error("两次输入密码不一致").show();
				}
			}
		});
		btnNewButton.setBounds(143, 122, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
