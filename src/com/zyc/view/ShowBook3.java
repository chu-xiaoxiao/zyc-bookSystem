package com.zyc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.zyc.controlller.ActhorControllerImplememt;
import com.zyc.controlller.BookController;
import com.zyc.controlller.BookControllerImplement;
import com.zyc.controlller.CategoryControllerImplement;
import com.zyc.controlller.PublishControllerImplement;
import com.zyc.entity.Acthor;
import com.zyc.entity.Book;
import com.zyc.entity.Category;
import com.zyc.entity.Customer;
import com.zyc.entity.Publish;
import com.zyc.util.MyExcepton;

public class ShowBook3 {
	private JTable table;
	private JTextField bookName;
	private JLabel bookId;
	private Customer customer;
	private JFrame frame;
	final static DefaultTableModel dataModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowBook3 window = new ShowBook3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void show(){
		Customer customer1 = this.customer;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowBook3 window = new ShowBook3(customer1);
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
	public ShowBook3(Customer customer) {
		super();
		this.customer = customer;
		initialize();
	}
	/**
	 * Create the application.
	 */
	public ShowBook3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("书籍管理页面 "+this.customer.getCustomerGroy()+":"+this.customer.getCustomerName());
		frame.setBounds(100, 100, 742, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final DefaultTableModel dtm = new DefaultTableModel();

		String[] columnName = { "图书编号", "图书名称", "图书类别", "图书作者", "图书出版社", "借阅状态" };
		List<Book> books = null;
		try {
			books = new BookControllerImplement().findBook(new Book());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			e.printStackTrace();
		}
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);

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
		// JTable table_1 = new JTable(addMod(books), columnName);

		// table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//final DefaultTableModel dataModel = new DefaultTableModel(books.size(), 6);
		JTable table_1 = new JTable(dataModel){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		dataModel.setDataVector(addMod(books), columnName);
		dataModel.fireTableDataChanged();

		JScrollPane scroll = new JScrollPane(table_1);
		panel_1.add(scroll);

		Panel panel = new Panel();
		panel_1.add(panel);

		JLabel lblNewLabel_1 = new JLabel("图书名称");

		bookName = new JTextField();
		bookName.setColumns(10);
		bookName.setEnabled(false);
		bookId = new JLabel("未选中");

		JLabel label_1 = new JLabel("图书类别");

		JLabel label_2 = new JLabel("图书作者");

		JLabel label_3 = new JLabel("出版社");

		JComboBox<Category> bookLeibie = new JComboBox<Category>();
		bookLeibie.setEnabled(false);
		bookLeibie.setModel(new DefaultComboBoxModel<Category>(categories2));
		bookLeibie.setLightWeightPopupEnabled(false);

		JComboBox<Acthor> bookActhor = new JComboBox<Acthor>();
		bookActhor.setEnabled(false);
		bookActhor.setModel(new DefaultComboBoxModel<Acthor>(acthors2));
		bookActhor.setLightWeightPopupEnabled(false);

		JComboBox<Object> bookPublish = new JComboBox<Object>();
		bookPublish.setEnabled(false);
		bookPublish.setModel(new DefaultComboBoxModel<Object>(publishs1));
		bookPublish.setLightWeightPopupEnabled(false);
		JLabel label_4 = new JLabel("图书编号");

		JLabel label = new JLabel("归还期限:");

		JLabel label_5 = new JLabel("借书日期:");
		
		JButton btnNewButton = new JButton("借书");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(table_1.getSelectedRow()==-1){
						new Error("请选择书").show();
						throw new MyExcepton("没有选中的书");
					}
					Book book = new BookControllerImplement().findByBookId((Integer) table_1.getValueAt(table_1.getSelectedRow(), 0));
					System.out.println(book);
					if(book.getRentdate()!=null){
						new Error("该书以借出").show();
						throw new MyExcepton("该书以借出");
					}
					new BookControllerImplement().rentBook(customer, book);
					upDate(dataModel);
					new Prompt("借阅"+book.getBookName()+"成功").show();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (MyExcepton e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("还书");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dataModel.getColumnCount()!=5){
						new Error("请去查看借书界面还书").show();;
						throw new MyExcepton("请去查看借书界面还书");
					}
					Book book = new BookControllerImplement().findByBookId((Integer) table_1.getValueAt(table_1.getSelectedRow(), 0));
					new BookControllerImplement().returnbook(customer, book, (Integer) table_1.getValueAt(table_1.getSelectedRow(), 1));
					upDate(dataModel);
					new Prompt("还"+book.getBookName()+"成功").show();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (MyExcepton e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("查看借书");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataModel.setDataVector(new BookControllerImplement().findRentBook(customer), new String[]{"书编号","借书编号","书名 ","作者名","出版社名"});
					dataModel.fireTableDataChanged();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("查看还书");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataModel.setDataVector(new BookControllerImplement().findReturnBook(customer), new String[]{"书编号","借书编号","书名 ","作者名","出版社名"});
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				dataModel.fireTableDataChanged();
			}
		});
		
		JButton btnNewButton_4 = new JButton("查询书");
		final Category[] categories3 = categories2;
		final Acthor[] acthors3 =acthors2;
		final Publish[] publishs2 = publishs1;
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindBooks findBooks =new FindBooks(categories3, acthors3, publishs2,3);
				findBooks.show();
			}
		});
		
		JLabel rentDate = new JLabel("New label");
		
		JLabel returnDate = new JLabel("New label");
		
		JButton btnNewButton_5 = new JButton("返回中心页面");
		btnNewButton_5.addActionListener(new ActionListener() {
			final Customer temp = customer;
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CenterView(temp).show();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookLeibie, 0, 152, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4)
							.addGap(18)
							.addComponent(bookId))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(bookPublish, 0, 150, Short.MAX_VALUE)
								.addComponent(bookActhor, 0, 150, Short.MAX_VALUE)
								.addComponent(rentDate, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
								.addComponent(returnDate, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(144))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton))
						.addComponent(btnNewButton_2)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_4)))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookId))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookLeibie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookActhor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookPublish, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(rentDate))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(returnDate))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Book book1 = new Book();
				book1.setBookid((Integer) table_1.getValueAt(table_1.getSelectedRow(), 0));
				bookId.setText(book1.getBookid().toString());
				try {
					book1 = new BookControllerImplement().findByBookId(book1.getBookid());
					bookName.setText(book1.getBookName());
					bookLeibie.setSelectedItem(book1.getBookCategory());
					bookPublish.setSelectedItem(book1.getBookPress());
					bookActhor.setSelectedItem(book1.getActhor());
					rentDate.setText(book1.getRentdate() == null ? "暂无借阅信息" : book1.getRentdate().toString());
					returnDate.setText(book1.getReturndate() == null ? "暂无借阅信息" : book1.getReturndate().toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (MyExcepton e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public static Object[][] addMod(List<Book> books) {
		Object[][] objects = new Object[books.size()][6];
		for (int i = 0; i < books.size(); i++) {
			for (int j = 0; j < 6; j++) {
				switch (j) {
				case 0:
					objects[i][j] = books.get(i).getBookid();
					break;
				case 1:
					objects[i][j] = books.get(i).getBookName();
					break;
				case 2:
					objects[i][j] = books.get(i).getBookCategory().getCategoryName();
					break;
				case 3:
					objects[i][j] = books.get(i).getActhor().getActhorName();
					break;
				case 4:
					objects[i][j] = books.get(i).getBookPress().getPublishName();
					break;
				case 5:
					objects[i][j] = books.get(i).getRentdate() == null ? "在库" : "借出";
				default:
					break;
				}
			}
		}
		return objects;
	}
	
	
	
	public static void upDate(DefaultTableModel defaultTableModel) throws SQLException, MyExcepton {
		String[] columnName = { "图书编号", "图书名称", "图书类别", "图书作者", "图书出版社", "借阅状态" };
		List<Book> books = new BookControllerImplement().findBook(new Book());
		defaultTableModel.setDataVector(addMod(books), columnName);
		defaultTableModel.fireTableDataChanged();
	}
	public static DefaultTableModel getDatamodel() {
		return dataModel;
	}
}
