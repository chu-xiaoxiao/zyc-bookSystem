package com.zyc.test;


import java.sql.SQLException;

import org.junit.Test;

import com.zyc.controlller.ActhorControllerImplememt;
import com.zyc.controlller.ActhorController;
import com.zyc.entity.Acthor;
import com.zyc.util.MyExcepton;


public class TestActhor {
	private ActhorController acthorController = new ActhorControllerImplememt();
	@Test
	public void add(){
		try {
			acthorController.addActhor(new Acthor(null,"作者",(short)3 ));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void find(){
		try {
			System.out.println(acthorController.findActhor(new Acthor(null,"修改后",null)));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void delete(){
		try {
			acthorController.deleteActhor(2);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void up(){
		try {
			acthorController.modifyActhor(new Acthor(3,"修改后",(short)2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
