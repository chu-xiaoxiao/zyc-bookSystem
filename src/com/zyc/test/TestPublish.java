package com.zyc.test;


import java.sql.SQLException;

import org.junit.Test;

import com.zyc.controlller.PublishControllerImplement;
import com.zyc.controlller.PublishControlller;
import com.zyc.entity.Publish;
import com.zyc.util.MyExcepton;

public class TestPublish {
	private PublishControlller publishControlller = new PublishControllerImplement() ;
	@Test
	public void testAdd(){
		Publish publish  = new Publish();
		publish.setPublishName("jdbc1");
		try {
			publishControlller.addPublish(publish);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDelete(){
		try {
			publishControlller.deletePublish(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testModify(){
		Publish publish = new Publish(4,"修改之后temp");
		try {
			publishControlller.modifyPublish(publish);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFind(){
		Publish publish = new Publish();
		try {
			System.out.println(publishControlller.findPublish(publish));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testFindId(){
		try {
			System.out.println(publishControlller.findByPublishId(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
