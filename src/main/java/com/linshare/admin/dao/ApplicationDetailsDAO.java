package com.linshare.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.linshare.admin.dto.ApplicationDetailsDTO;
import com.linshare.admin.services.MyBatisUtil;

public class ApplicationDetailsDAO {
	SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

	public List<ApplicationDetailsDTO> getApplicationsListByUserId(List<Integer> ids) {
		List<ApplicationDetailsDTO> list = session.selectList("Appliction.getByUserIds", ids);
		return list;
	}

	public void insertMappingTable(ApplicationDetailsDTO applicationDetailsDTO, SqlSession sqlSession) {
		sqlSession.insert("Appliction.insertIntoMapping", applicationDetailsDTO);
	}
}
