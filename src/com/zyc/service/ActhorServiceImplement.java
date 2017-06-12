package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.dao.ActhorDao;
import com.zyc.dao.ActhorDaoImplement;
import com.zyc.entity.Acthor;
import com.zyc.entity.Category;
import com.zyc.util.DButil;
import com.zyc.util.MyExcepton;

public class ActhorServiceImplement implements ActhorService{
	ActhorDao acthorDao = new ActhorDaoImplement(DButil.getConnect());
	@Override
	public void addActhor(Acthor acthor) throws SQLException {
		acthorDao.addCategroy(acthor);
		acthorDao.closeConnect();
	}

	@Override
	public List<Acthor> findActhor(Acthor acthor) throws SQLException, MyExcepton {
		List<Acthor> lists = acthorDao.findCategory(acthor);
		if(lists==null||lists.isEmpty()){
			throw new MyExcepton("未找到作者");
		}
		acthorDao.closeConnect();
		return lists;
	}

	@Override
	public void deleteActhor(Integer acthorid) throws SQLException, MyExcepton {
		Acthor acthor = acthorDao.findCategoryById(acthorid);
		acthorDao.deleteCategroy(acthor.getActhorId());
		acthorDao.closeConnect();
	}

	@Override
	public void modifyActhor(Acthor acthor) throws SQLException, MyExcepton {
		if(acthorDao.findCategoryById(acthor.getActhorId())==null){
			throw new MyExcepton("未找到要修改的条目");
		}
		
		acthorDao.modifyCategory(acthor);
		acthorDao.closeConnect();
	}

	@Override
	public Acthor findByActhorId(Integer acthorId) throws SQLException, MyExcepton {
		Acthor acthor = acthorDao.findCategoryById(acthorId);
		if(acthor==null){
			throw new MyExcepton("未找到此作者");
		}
		return acthor;
	}

}
