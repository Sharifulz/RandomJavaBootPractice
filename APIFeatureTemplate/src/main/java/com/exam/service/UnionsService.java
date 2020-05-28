package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exam.dao.IUnionsDao;
import com.exam.model.GisUnionModel;

@Service
public class UnionsService implements IUnionsService{

	@Autowired
	IUnionsDao unionDao;
	
	@Override
	public Page<GisUnionModel> findAll(Pageable pageable) {
		return unionDao.findAll(pageable);
	}

}
