package com.zyc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyc.dao.PublishDao;
import com.zyc.dao.PublishDaoImplement;
import com.zyc.entity.Publish;
import com.zyc.util.DButil;
import com.zyc.util.MyExcepton;


public class PublishServiceImplelemt implements PublishService {
	PublishDao publishDao = new PublishDaoImplement(DButil.getConnect());
	@Override
	public void addPublish(Publish publish) throws SQLException {
		publishDao.addPublish(publish);
		publishDao.closeConnect();
	}

	@Override
	public List<Publish>findPublis(Publish publish) throws SQLException, MyExcepton {
		List<Publish> publishs =publishDao.findPublish(publish);
		if(publishs==null||publishs.isEmpty()){
			throw new MyExcepton("未找到相关出版社信息");
		}
		
		publishDao.closeConnect();
		return publishs;
	}

	@Override
	public void deletePublis(Integer publishid) throws SQLException {
		publishDao.deletePublis(publishid);
		publishDao.closeConnect();
	}

	@Override
	public void modifyPublis(Publish publish) throws SQLException, MyExcepton {
		Publish temp = publishDao.findByPublishid(publish.getPublishId());
		if(temp==null){
			throw new MyExcepton("未找到相关出版社资料");
		}
		temp.setPublishName(publish.getPublishName());
		publishDao.modifyPublish(temp);
		publishDao.closeConnect();
	}

	@Override
	public Publish findBypublisId(Integer publishid) throws SQLException, MyExcepton {
		Publish temp =	publishDao.findByPublishid(publishid);
		if(temp==null){
			throw new MyExcepton("未找到相关出版社资料");
		}
		publishDao.closeConnect();
		return temp;
	}
}
