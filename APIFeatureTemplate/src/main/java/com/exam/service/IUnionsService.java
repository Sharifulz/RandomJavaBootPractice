package com.exam.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exam.model.GisUnionModel;

public interface IUnionsService{
	public Page<GisUnionModel> findAll(Pageable pageable);
}
