package com.zyc.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zyc.controlller.BookControllerImplement;
import com.zyc.entity.Acthor;
import com.zyc.entity.Book;
import com.zyc.entity.Category;
import com.zyc.entity.Publish;
import com.zyc.util.MyExcepton;

import net.miginfocom.layout.AC;
import oracle.net.aso.f;
import oracle.security.o3logon.b;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FindBooks {

	private JFrame frame;
	private JTextField bookId;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private static Category[] categories;
	private static Acthor[] acthors;
	private static Publish[] publishs;
	private static Integer dingxiang;
	/**
	 * Launch the application.
	 */
	public FindBooks(Category[] categories,Acthor[] acthors,Publish[]  publishs,Integer dingxiang){
		FindBooks.categories = categories;
		FindBooks.acthors =acthors;
		FindBooks.publishs = publishs;
		FindBooks.dingxiang=dingxiang;
		initialize(categories, acthors, publishs,dingxiang);
	}
	
	public  void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindBooks window = new FindBooks(categories,acthors,publishs,dingxiang);
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
	public FindBooks(){
		initialize(this.categories, this.acthors, this.publishs,this.dingxiang);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Category[] categories,Acthor[] acthors,Publish[] publishs,int dingxiang) {
		frame = new JFrame();
		frame.setTitle("查询书");
		frame.setBounds(100, 100, 580, 166);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("图书编号");
		lblNewLabel.setBounds(10, 21, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		bookId = new JTextField();
		bookId.setBounds(67, 18, 66, 21);
		frame.getContentPane().add(bookId);
		bookId.setColumns(10);
		
		JLabel bookName = new JLabel("图书名称");
		bookName.setBounds(143, 21, 54, 15);
		frame.getContentPane().add(bookName);
		
		textField = new JTextField();
		textField.setBounds(207, 18, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel achotr = new JLabel("作者");
		achotr.setBounds(295, 21, 54, 15);
		frame.getContentPane().add(achotr);
		
		lblNewLabel_1 = new JLabel("类别");
		lblNewLabel_1.setBounds(10, 63, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		label = new JLabel("出版社");
		label.setBounds(179, 63, 54, 15);
		frame.getContentPane().add(label);
		
		JComboBox<Acthor> author = new JComboBox<Acthor>(acthors);
		author.setBounds(328, 18, 94, 21);
		frame.getContentPane().add(author);
		author.setSelectedItem(null);
		//new JScrollPane(author);
		
		JComboBox<Category> bookCategory = new JComboBox<Category>(categories);
		bookCategory.setBounds(44, 60, 105, 21);
		frame.getContentPane().add(bookCategory);
		bookCategory.setSelectedItem(null);
		//new JScrollPane(bookCategory);
			
		JComboBox<Publish> bookPress = new JComboBox<Publish>(publishs);
		bookPress.setBounds(223, 60, 114, 21);
		frame.getContentPane().add(bookPress);
		bookPress.setSelectedItem(null);
		//	new JScrollPane(bookPress);
		
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(328, 60, 150, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book(bookId.getText().equals("")?null:Integer.parseInt(bookId.getText().toString()),textField.getText().equals("")?null:textField.getText(),(Acthor)author.getSelectedItem(),(Category)bookCategory.getSelectedItem(),(Publish)bookPress.getSelectedItem(),null,null);
				frame.dispose();
				String[] columnName = { "图书编号", "图书名称", "图书类别", "图书作者", "图书出版社", "借阅状态" };
				try {
					if(dingxiang==1){
					ShowBook.getDatamodel().setDataVector(ShowBook.addMod(new BookControllerImplement().findBook(book)),columnName);
					ShowBook.upDate(new DefaultTableModel(ShowBook.addMod(new BookControllerImplement().findBook(book)),columnName));
					}
					if(dingxiang==3){
						ShowBook3.getDatamodel().setDataVector(ShowBook.addMod(new BookControllerImplement().findBook(book)),columnName);
						ShowBook3.upDate(new DefaultTableModel(ShowBook.addMod(new BookControllerImplement().findBook(book)),columnName));
					}
				} catch (SQLException | MyExcepton e1) {
					new Error("数据库中没有与条件相对应的书").show();
					e1.printStackTrace();
				}
				//new ShowBook(book).frame.setVisible(true);
			}
		});
	}
}
