package com.zyc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.zyc.controlller.CustomerController;
import com.zyc.controlller.CustomerControllerImplement;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Register {

	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	private JTextField passwordAgain;
	private JLabel newlabl;
	private Customer customer;
	private JTextField guanLiYuan;
	
	
	/**
	 * @param customer
	 */
	public Register(Customer customer) {
		super();
		this.customer = customer;
		initialize();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void show(){
		Customer customer = this.customer;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register(customer);
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("用户注册");
		frame.setBounds(100, 100, 447, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(73, 35, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		userName = new JTextField();
		userName.setBounds(162, 32, 148, 21);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		JLabel label = new JLabel("密码");
		label.setBounds(73, 77, 54, 15);
		frame.getContentPane().add(label);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(162, 74, 148, 21);
		frame.getContentPane().add(password);
		
		JLabel label_1 = new JLabel("重复密码");
		label_1.setBounds(73, 118, 54, 15);
		frame.getContentPane().add(label_1);
		
		passwordAgain = new JTextField();
		passwordAgain.setColumns(10);
		passwordAgain.setBounds(162, 115, 148, 21);
		frame.getContentPane().add(passwordAgain);
		
		newlabl = new JLabel("用户类别");
		newlabl.setBounds(73, 164, 54, 15);
		frame.getContentPane().add(newlabl);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>( new String[]{"用户","管理员"}));
		comboBox.setBounds(162, 161, 80, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!password.getText().equals(passwordAgain.getText())){
						throw new MyExcepton("两次输入的密码不相符");
					}
					Customer temp = new Customer(userName.getText().toString(),password.getText().toString(),comboBox.getSelectedItem().toString());
					new CustomerControllerImplement().addCustomer(temp);
					customer = new CustomerControllerImplement().logIn(temp);
					frame.dispose();
					new CenterView(customer).show();
				} catch (SQLException e1) {
					new Error("该用户名已被注册").show();
					e1.printStackTrace();
				} catch (MyExcepton e1) {
					new Error("两次输入的密码不相符").show();
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(144, 207, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
