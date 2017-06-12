package com.zyc.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.zyc.controlller.ActhorControllerImplememt;
import com.zyc.controlller.BookControllerImplement;
import com.zyc.controlller.CategoryControllerImplement;
import com.zyc.controlller.PublishControllerImplement;
import com.zyc.entity.Acthor;
import com.zyc.entity.Book;
import com.zyc.entity.Category;
import com.zyc.entity.Customer;
import com.zyc.entity.Publish;
import com.zyc.util.MyExcepton;

import oracle.net.aso.p;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook {

	private JFrame frame;
	private JTextField bookName;
	private Customer customer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void show(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook(customer);
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
	public AddBook(Customer customer) {
		super();
		this.customer = customer;
		initialize();
	}
	/**
	 * Create the application.
	 */
	public AddBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加图书 "+customer.getCustomerGroy()+":"+customer.getCustomerName());
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("图书名称");
		lblNewLabel.setBounds(82, 23, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		bookName = new JTextField();
		bookName.setBounds(172, 20, 154, 21);
		frame.getContentPane().add(bookName);
		bookName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("图书类别");
		lblNewLabel_1.setBounds(82, 64, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<Category> comboBox = new JComboBox<Category>();
		comboBox.setBounds(172, 64, 154, 21);
		List<Category> categories = null;
		Category[] categories2 = null;
		try {
			categories = new CategoryControllerImplement().findCategory(new Category());
			categories2 = new Category[categories.size()];
			categories2 = categories.toArray(categories2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox.setModel(new DefaultComboBoxModel<Category>(categories2));
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("图书出版社");
		lblNewLabel_2.setBounds(82, 169, 67, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<Publish> comboBox_1 = new JComboBox<Publish>();
		comboBox_1.setBounds(172, 166, 154, 21);
		List<Publish> publishs = null;
		Publish[] publishs1 = null;
		try {
			publishs = new PublishControllerImplement().findPublish(new Publish());
			publishs1 = new Publish[publishs.size()];
			publishs1 = publishs.toArray(publishs1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			e.printStackTrace();
		}
		comboBox_1.setModel(new DefaultComboBoxModel<Publish>(publishs1));
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("图书作者");
		lblNewLabel_3.setBounds(82, 118, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		@SuppressWarnings("rawtypes")
		JComboBox<Acthor> comboBox_2 = new JComboBox<Acthor>();
		comboBox_2.setBounds(172, 115, 154, 21);
		List<Acthor> acthors = null;
		Acthor[] acthors2 = null;
		try {
			acthors = new ActhorControllerImplememt().findActhor(new Acthor());
			acthors2 = new Acthor[acthors.size()];
			acthors2 = acthors.toArray(acthors2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox_2.setModel(new DefaultComboBoxModel<Acthor>(acthors2));
		frame.getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("添加图书");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book(null,bookName.getText(),(Acthor)comboBox_2.getSelectedItem(),(Category)comboBox.getSelectedItem(),(Publish)comboBox_1.getSelectedItem(),null,null);
				try {
					new BookControllerImplement().addBook(book);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(146, 215, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回中心界面");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CenterView(customer).show();
			}
		});
		btnNewButton_1.setBounds(303, 215, 121, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
