package com.exam.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.model.UserAttachmentsModel;

public interface IUserAttachmentsDao extends JpaRepository<UserAttachmentsModel, UUID> {
	
	@Query("FROM UserAttachmentsModel WHERE username=:username AND LOWER(fileName)=LOWER(:fileName) ")
	public List<UserAttachmentsModel> getUserAttachmentListByUsernameAndFileName(@Param("username") String username,@Param("fileName") String fileName);
}
