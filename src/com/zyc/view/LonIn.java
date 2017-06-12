package com.zyc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Scrollbar;

import javax.swing.SwingConstants;

import com.zyc.controlller.CustomerController;
import com.zyc.controlller.CustomerControllerImplement;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;
import com.zyc.util.Save;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class LonIn {

	private JFrame frame;
	private JPasswordField userPassowrd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LonIn window = new LonIn();
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
	public LonIn() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void initialize() throws FileNotFoundException, IOException {
		frame = new JFrame();
		frame.setTitle("用户登录");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(108, 43, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密  码");
		lblNewLabel_1.setBounds(108, 101, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JComboBox<String> userName = new JComboBox<String>();
		userName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userPassowrd.setText((String) new Save().readPassword(userName.getSelectedItem().toString()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		Set<Object> users = null;
		try {
			users = new Save().readUsername();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		userPassowrd = new JPasswordField();
		userPassowrd.setBounds(172, 98, 139, 21);
		frame.getContentPane().add(userPassowrd);
		String user[] = users.toArray(new String[users.size()]);
		userName.setModel(new DefaultComboBoxModel<String>(user));
		int flag = 0;
		if (userName.getSelectedItem() == null) {
			userName.setSelectedItem("");
			flag = 1;
		}
		String username = null;
		if (flag != 1) {
			username = userName.getSelectedItem().toString();
			userPassowrd.setText((String) new Save().readPassword(username));
		}
		JCheckBox saveUserName = new JCheckBox("保存用户名");
		saveUserName.setBounds(92, 214, 103, 23);
		frame.getContentPane().add(saveUserName);

		JCheckBox savePassword = new JCheckBox("保存密码");
		savePassword.setBounds(234, 214, 103, 23);
		frame.getContentPane().add(savePassword);

		userName.setEditable(true);
		userName.setBounds(172, 40, 139, 21);
		frame.getContentPane().add(userName);
		JButton btnNewButton = new JButton("登陆");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer(userName.getSelectedItem().toString(),
						new String(userPassowrd.getPassword()));
				System.out.println(customer);
				CustomerController controller = new CustomerControllerImplement();
				try {
					customer = controller.logIn(customer);
					new CenterView(customer).show();
					frame.dispose();
					if (saveUserName.isSelected() && savePassword.isSelected()) {
						new Save().saveUsername(customer);
					}
					if (saveUserName.isSelected() && !savePassword.isSelected()) {
						new Save().saveUsernameNoPassword(customer);
					}
				} catch (SQLException | MyExcepton e1) {
					Error error = new Error("用户名或密码错误");
					error.show();
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(92, 169, 93, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Register().show();
			}
		});
		btnNewButton_1.setBounds(244, 169, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
