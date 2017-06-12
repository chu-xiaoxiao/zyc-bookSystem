package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Acthor;
import com.zyc.service.ActhorService;
import com.zyc.service.ActhorServiceImplement;
import com.zyc.util.MyExcepton;
import com.zyc.util.MySession;

public class ActhorControllerImplememt implements ActhorController{
	@Override
	public void addActhor(Acthor acthor) throws SQLException {
		//接受前台数据
		ActhorService acthorService = new ActhorServiceImplement();
		acthorService.addActhor(acthor);
		System.out.println(MySession.get("acthor"));
	}

	@Override
	public void modifyActhor(Acthor acthor) throws SQLException, MyExcepton {
		ActhorService acthorService = new ActhorServiceImplement();
		acthorService.modifyActhor(acthor);
	}

	@Override
	public void deleteActhor(Integer acthorId) throws SQLException, MyExcepton {
		ActhorService acthorService = new ActhorServiceImplement();
		acthorService.deleteActhor(acthorId);
	}

	@Override
	public List<Acthor> findActhor(Acthor acthor) throws SQLException, MyExcepton {
		ActhorService acthorService = new ActhorServiceImplement();
		return acthorService.findActhor(acthor);
	}

	@Override
	public Acthor findByActhorId(Integer acthorid) throws SQLException, MyExcepton {
		ActhorService acthorService = new ActhorServiceImplement();
		return acthorService.findByActhorId(acthorid);
	}
}
