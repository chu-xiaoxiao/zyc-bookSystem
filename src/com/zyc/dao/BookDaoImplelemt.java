package com.zyc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyc.entity.Acthor;
import com.zyc.entity.Book;
import com.zyc.entity.Category;
import com.zyc.entity.Customer;
import com.zyc.entity.Publish;
import com.zyc.util.DButil;
import com.zyc.util.MyExcepton;


public class BookDaoImplelemt implements BookDao {
	private Connection connection;
	
	/**
	 * @param connection
	 */
	public BookDaoImplelemt(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 
	 */
	public BookDaoImplelemt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addBook(Book book) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "insert INTO book (bookid,bookname,acthor,categoryid,publishid,rentdate,returndate) values (seqbook.nextval,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,book.getBookName());
		preparedStatement.setInt(2, book.getActhor().getActhorId());
		preparedStatement.setInt(3, book.getBookCategory().getCategoryId());
		preparedStatement.setInt(4, book.getBookPress().getPublishId());
		preparedStatement.setDate(5, book.getRentdate());
		preparedStatement.setDate(6, book.getReturndate());
		int i =preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("图书信息插入成功");
			DButil.commit(connection);
		}else{
			System.out.println("图书信息插入失败");
			DButil.rooback(connection);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
		DButil.closeTranscation(connection);
	}

	@Override
	public void deleteBook(Integer bookis) throws SQLException {
		DButil.startTranscation(connection);
		String sql ="DELETE book WHERE bookid =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, bookis);
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("信息删除成功");
			DButil.commit(connection);
		}else{
			System.out.println("删除失败");
			DButil.rooback(connection);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
		DButil.closeTranscation(connection);
	}

	@Override
	public void modifyBook(Book book) throws SQLException {
		DButil.startTranscation(connection);
		StringBuilder sql = new StringBuilder("UPDATE book SET bookname =?,categoryid =?,publishid=?,acthor=? WHERE bookid =?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setString(1,book.getBookName());
		preparedStatement.setInt(2, book.getBookCategory().getCategoryId());
		preparedStatement.setInt(3, book.getBookPress().getPublishId());
		preparedStatement.setInt(4, book.getActhor().getActhorId());
		preparedStatement.setInt(5, book.getBookid());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("修改成功");
			DButil.commit(connection);
		}else{
			System.out.println("修改失败");
			DButil.rooback(connection);
		}
		DButil.closeTranscation(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public List<Book> findBook(Book book) throws SQLException {
		/*
		 * SELECT b.bookid,b.bookname,b.acthor,a.acthorname,a.acthorsex,b.rentdate,b.returndate,c.categoryid,c.categroyname,p.publishid,p.publishname FROM book b,categroy c,publish p,acthor a where b.acthor = a.acthorid AND b.categoryid = c.categoryid AND b.publishid = p.publishid 
		 */
		StringBuilder sql = new StringBuilder("SELECT b.bookid,b.bookname,b.acthor,a.acthorname,a.acthorsex,b.rentdate,b.returndate,c.categoryid,c.categroyname,p.publishid,p.publishname FROM book b,categroy c,publish p,acthor a where b.acthor = a.acthorid AND b.categoryid = c.categoryid AND b.publishid = p.publishid ");
		List<Book > books = new ArrayList<Book>();
		if(book.getBookid()!=null){
			sql.append(" AND bookid = "+book.getBookid()+" ");
		}
		if(book.getBookName()!=null){
			sql.append(" AND bookname = '"+book.getBookName()+"' ");
		}
		if(book.getBookCategory()!=null){
			sql.append(" AND c.categoryid = "+book.getBookCategory().getCategoryId()+" ");
		}
		if(book.getBookPress()!=null){
			sql.append("  AND p.publishid = "+book.getBookPress().getPublishId()+" ");
		}
		if(book.getActhor()!=null){
			sql.append("  AND a.acthorid = "+book.getActhor().getActhorId()+" ");
		}
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Category category = new Category(resultSet.getInt(8),resultSet.getString(9));
			Publish publish = new Publish(resultSet.getInt(10),resultSet.getString(11));
			Acthor acthor = new Acthor(resultSet.getInt(3),resultSet.getString(4),resultSet.getShort(5));
			Book temp = new Book(resultSet.getInt(1), resultSet.getString(2), acthor, category, publish, resultSet.getDate(6), resultSet.getDate(7));
			books.add(temp);
		}
		return books;
	}

	@Override
	public Book findBookById(Integer bookid) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT b.bookid,b.bookname,b.acthor,a.acthorname,a.acthorsex,b.rentdate,b.returndate,c.categoryid,c.categroyname,p.publishid,p.publishname FROM book b,categroy c,publish p,acthor a where b.acthor = a.acthorid AND b.categoryid = c.categoryid AND b.publishid = p.publishid AND bookid =?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, bookid);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			Category category = new Category(resultSet.getInt(8),resultSet.getString(9));
			Publish publish = new Publish(resultSet.getInt(10),resultSet.getString(11));
			Acthor acthor = new Acthor(resultSet.getInt(3),resultSet.getString(4),resultSet.getShort(5));
			Book temp = new Book(resultSet.getInt(1), resultSet.getString(2), acthor, category, publish, resultSet.getDate(6), resultSet.getDate(7));
			DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
			return temp;
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
		return null;
	}
	
	
	public void closeConnect(){
		DButil.closeConnection(connection);
	}

	@Override
	public List<Book> findBookPage(Book book, Integer page) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT b.bookid,b.bookname,b.acthor,a.acthorname,a.acthorsex,b.rentdate,b.returndate,c.categoryid,c.categroyname,p.publishid,p.publishname FROM book b,categroy c,publish p,acthor a where b.acthor = a.acthorid AND b.categoryid = c.categoryid AND b.publishid = p.publishid ");
		List<Book > books = new ArrayList<Book>();
		if(book.getBookName()!=null){
			sql.append(" AND bookname = '"+book.getBookName()+"' ");
		}
		if(book.getBookCategory()!=null){
			sql.append(" AND c.categoryid = "+book.getBookCategory().getCategoryId()+" ");
		}
		if(book.getBookPress()!=null){
			sql.append("  AND p.publishid = "+book.getBookPress().getPublishId()+" ");
		}
		if(book.getActhor()!=null){
			sql.append("  AND a.acthorid = "+book.getActhor().getActhorId()+" ");
		}
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Category category = new Category(resultSet.getInt(8),resultSet.getString(9));
			Publish publish = new Publish(resultSet.getInt(10),resultSet.getString(11));
			Acthor acthor = new Acthor(resultSet.getInt(3),resultSet.getString(4),resultSet.getShort(5));
			Book temp = new Book(resultSet.getInt(1), resultSet.getString(2), acthor, category, publish, resultSet.getDate(6), resultSet.getDate(7));
			books.add(temp);
		}
		return books;
	}

	@Override
	public void rentbook(Book book) throws SQLException, MyExcepton {
		String sql = "update book set book.rentdate = sysdate,book.returndate = add_months(sysdate,1) where book.bookid = ?";
		DButil.startTranscation(connection);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getBookid());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("借书成功");
			DButil.commit(connection);
			DButil.closeTranscation(connection);
		}else{
			throw new MyExcepton("借书失败");
		}
	}

	@Override
	public void writeRentBook(Customer customer,Book book) throws SQLException, MyExcepton {
		DButil.startTranscation(connection);
		String sql = "insert into rentbook(rentId,customerid,bookid) values(seqrentbook.nextval,?,?)";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setInt(1,customer.getCustomerId());
		preparedStatement.setInt(2, book.getBookid());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("借书记录插入成功");
			DButil.commit(connection);
			DButil.closeTranscation(connection);
		}else{
			System.out.println("借书记录插入失败");
			throw new MyExcepton("借书记录插入失败");
		}
	}

	@Override
	public void returnBook(Book book) throws SQLException, MyExcepton {
		String sql = "update book set book.returndate = null,book.rentdate = null where book.bookid = ?";
		DButil.startTranscation(connection);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getBookid());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("还书成功");
			DButil.commit(connection);
			DButil.closeTranscation(connection);
		}else{
			throw new MyExcepton("还书失败");
		}
	}

	@Override
	public void writeReturnBook(Customer customer,Book book,Integer rentid) throws SQLException, MyExcepton {
		DButil.startTranscation(connection);
		String sql = "insert into returnbook(returnId,customerid,bookid) values(?,?,?)";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setInt(1, rentid);
		preparedStatement.setInt(2,customer.getCustomerId());
		preparedStatement.setInt(3, book.getBookid());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("还书记录插入成功");
			DButil.commit(connection);
			DButil.closeTranscation(connection);
		}else{
			System.out.println("还书记录插入失败");
			throw new MyExcepton("还书记录插入失败");
		}
	}

	@Override
	public void deleteRentBook(Integer rentId) throws SQLException {
		DButil.startTranscation(connection);
		String sql ="DELETE rentBook WHERE rentid =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, rentId);
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("借书信息删除成功");
			DButil.commit(connection);
			DButil.closeTranscation(connection);
		}else{
			System.out.println("删除失败");
			DButil.rooback(connection);
		}
		DButil.closeTranscation(connection);
	}

	@Override
	public Object[][] findRentBook(Customer customer) throws SQLException {
		StringBuilder sql = new StringBuilder("select t.bookid,t.rentid,t.bookname,a1.acthorname,p1.publishname from book b1,acthor a1,publish p1,(select r.rentid,b.bookname,b.bookid,b.acthor,b.publishid ,c.customerid from rentbook r,customer c,book b where r.bookid=b.bookid and c.customerid=r.customerid and c.customerid = ?) t where t.acthor = a1.acthorid and t.publishid=p1.publishid and t.bookid = b1.bookid");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, customer.getCustomerId());
		ResultSet resultSet = preparedStatement.executeQuery();
		Object[][] objects = new Object[10][5];
		int i=0;
		while(resultSet.next()){
			/*Category category = new	Category(resultSet.getInt(8),resultSet.getString(9));
			Publish publish = new Publish(resultSet.getInt(10),resultSet.getString(11));
			Acthor acthor = new Acthor(resultSet.getInt(3),resultSet.getString(4),resultSet.getShort(5));
			Book temp = new Book(resultSet.getInt(1), resultSet.getString(2), acthor, category, publish, resultSet.getDate(6), resultSet.getDate(7));
			books.add(temp);*/
			objects[i][0]=resultSet.getInt(1);
			objects[i][1] = resultSet.getInt(2);
			objects[i][2] = resultSet.getString(3);
			objects[i][3] = resultSet.getString(4);
			objects[i][4] = resultSet.getString(5);
			i++;
		}
		return objects;
	}

	@Override
	public Object[][] findReturnBook(Customer customer) throws SQLException {
		StringBuilder sql = new StringBuilder("select t.bookid,t.returnid,t.bookname,a1.acthorname,p1.publishname  from book b1,acthor a1,publish p1,(select r.returnid,b.bookname,b.bookid,b.acthor,b.publishid ,c.customerid from returnbook r,customer c,book b where r.bookid=b.bookid and c.customerid=r.customerid and c.customerid = ?) t where t.acthor = a1.acthorid and t.publishid=p1.publishid and t.bookid = b1.bookid");
		List<Book > books = new ArrayList<Book>();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, customer.getCustomerId());
		ResultSet resultSet = preparedStatement.executeQuery();
		Object[][] objects = new Object[100][5];
		int i=0;
		while(resultSet.next()){
		/*	Category category = new Category(resultSet.getInt(8),resultSet.getString(9));
			Publish publish = new Publish(resultSet.getInt(10),resultSet.getString(11));
			Acthor acthor = new Acthor(resultSet.getInt(3),resultSet.getString(4),resultSet.getShort(5));
			Book temp = new Book(resultSet.getInt(1), resultSet.getString(2), acthor, category, publish, resultSet.getDate(6), resultSet.getDate(7));
			books.add(temp);*/
			objects [i][0]=resultSet.getInt(1);
			objects[i][1] = resultSet.getInt(2);
			objects[i][2] = resultSet.getString(3);
			objects[i][3] = resultSet.getString(4);
			objects[i][4] = resultSet.getString(5);
			i++;
		}
		return objects;
	}
}
