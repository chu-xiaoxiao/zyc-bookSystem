package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Publish;
import com.zyc.service.PublishService;
import com.zyc.service.PublishServiceImplelemt;
import com.zyc.util.MyExcepton;

public class PublishControllerImplement implements PublishControlller{
	PublishService publishService = new PublishServiceImplelemt();
	@Override
	public void addPublish(Publish publish) throws SQLException {
			publishService.addPublish(publish);
	}

	@Override
	public void modifyPublish(Publish publish) throws SQLException, MyExcepton {
		publishService.modifyPublis(publish);
	}

	@Override
	public void deletePublish(Integer publishId) throws SQLException {
		publishService.deletePublis(publishId);
	}

	@Override
	public List<Publish> findPublish(Publish publish) throws SQLException, MyExcepton {
		List<Publish> lists = publishService.findPublis(publish);
		return lists;
	}

	@Override
	public Publish findByPublishId(Integer publishid) throws SQLException, MyExcepton {
		return publishService.findBypublisId(publishid);
	}	
}
