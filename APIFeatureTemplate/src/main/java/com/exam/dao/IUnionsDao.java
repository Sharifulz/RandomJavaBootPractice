package com.exam.dao;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.GisUnionModel;

@Repository
public interface IUnionsDao extends JpaRepository<GisUnionModel, UUID>, PagingAndSortingRepository<GisUnionModel, UUID> {
	public Page<GisUnionModel> findAll(Pageable pageable);
}
