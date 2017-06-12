package com.zyc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.zyc.entity.Acthor;
import com.zyc.entity.Customer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CenterView {

	private JFrame frame;
	private Customer customer;

	/**
	 * @param customer
	 */
	public CenterView(Customer customer) {
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
					CenterView window = new CenterView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void show() {
		Customer customer1 = this.customer;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CenterView window = new CenterView(customer1);
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
	public CenterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		JButton rentBook = new JButton("借书");
		rentBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowBook3(customer).show();
				frame.dispose();
			}
		});
		rentBook.setBounds(37, 38, 93, 23);
		frame.getContentPane().add(rentBook);
		if (customer.getCustomerGroy().equals("管理员")) {
			JButton btnNewButton = new JButton("管理书籍");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ShowBook(customer).show();
				}
			});
			btnNewButton.setBounds(199, 88, 93, 23);
			frame.getContentPane().add(btnNewButton);
		}
		frame.setTitle("书籍管理页面 " + this.customer.getCustomerGroy() + ":" + this.customer.getCustomerName());
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton_2 = new JButton("修改密码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyCustomerPassword(customer).show();
			}
		});
		btnNewButton_2.setBounds(37, 88, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		if (customer.getCustomerGroy().equals("管理员")) {
			JButton btnNewButton_1 = new JButton("添加");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddActhor.show(customer);
				}
			});
			btnNewButton_1.setBounds(199, 38, 93, 23);
			frame.getContentPane().add(btnNewButton_1);
		}
	}
}
