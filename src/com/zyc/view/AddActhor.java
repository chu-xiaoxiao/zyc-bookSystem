package com.zyc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.zyc.controlller.ActhorController;
import com.zyc.controlller.ActhorControllerImplememt;
import com.zyc.controlller.CategoryControllerImplement;
import com.zyc.controlller.PublishControllerImplement;
import com.zyc.controlller.PublishControlller;
import com.zyc.entity.Acthor;
import com.zyc.entity.Category;
import com.zyc.entity.Customer;
import com.zyc.entity.Publish;
import com.zyc.util.MySession;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddActhor {

	private JFrame frame;
	private JTextField name;
	private JLabel lblZuozheXingbie;
	private JLabel publishName;
	private JTextField publishNameText;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField categoryName;
	private JButton btnNewButton_2;
	private JButton button;
	private Customer customer;
	public static void show(Customer customer){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddActhor window = new AddActhor(customer);
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
	public AddActhor(Customer customer) {
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
					AddActhor window = new AddActhor();
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
	public AddActhor() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加中心 "+this.customer.getCustomerGroy()+"="+this.customer.getCustomerName());
		frame.setBounds(100, 100, 501, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("作者姓名");
		lblNewLabel.setBounds(68, 33, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		name = new JTextField();
		name.setBounds(132, 30, 66, 21);
		frame.getContentPane().add(name);
		name.setColumns(10);

		lblZuozheXingbie = new JLabel("作者性别");
		lblZuozheXingbie.setBounds(68, 61, 54, 15);
		frame.getContentPane().add(lblZuozheXingbie);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setBounds(132, 58, 66, 21);
		frame.getContentPane().add(comboBox);
		JButton btnNewButton = new JButton("添加作者");
		int flag = 0;
		Acthor acthor = null;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActhorController acthorController = new ActhorControllerImplememt();
				System.out.println(name.getText());
				Acthor acthor = new Acthor(null,name.getText(),comboBox.getSelectedItem().equals("男")?(short)1:(short)2);
				try {
					acthorController.addActhor(acthor);
					MySession.add("acthor", acthor);
					System.out.println(MySession.get("acthor"));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(83, 105, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		publishName = new JLabel("出版社名称");
		publishName.setBounds(68, 175, 74, 15);
		frame.getContentPane().add(publishName);
		
		publishNameText = new JTextField();
		publishNameText.setBounds(152, 172, 159, 21);
		frame.getContentPane().add(publishNameText);
		publishNameText.setColumns(10);
		
		btnNewButton_1 = new JButton("添加出版社");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublishControlller publishControlller = new PublishControllerImplement();
				Publish publish = new Publish(null, publishNameText.getText());
				try {
					publishControlller.addPublish(publish);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(132, 216, 128, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("类别名称");
		lblNewLabel_1.setBounds(293, 46, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		categoryName = new JTextField();
		categoryName.setBounds(357, 43, 79, 21);
		frame.getContentPane().add(categoryName);
		categoryName.setColumns(10);
		
		btnNewButton_2 = new JButton("添加类别");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category category = new Category(null, categoryName.getText());
				try {
					new CategoryControllerImplement().addCategory(category);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(311, 105, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		button = new JButton("返回中心界面");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CenterView(customer).show();
			}
		});
		button.setBounds(322, 216, 128, 23);
		frame.getContentPane().add(button);
		
	}
}
