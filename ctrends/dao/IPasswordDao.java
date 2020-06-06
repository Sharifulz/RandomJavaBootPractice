package com.ctrends.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ctrends.model.PasswordModel;

@Transactional
public interface IPasswordDao extends JpaRepository<PasswordModel, UUID> {

	@Query("FROM PasswordModel WHERE username=:username")
	List<PasswordModel> getPasswordByUsername(@Param("username") String username);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE PasswordModel SET prevPwd4=prevPwd3, prevPwd3=prevPwd2, prevPwd2=prevPwd1, prevPwd1=pwd, pwd=:pwd WHERE username=:username")
	int updatePassword(@Param("pwd") String pwd, @Param("username") String username);
	
	/*
		update password set prev_pwd4=prev_pwd3, prev_pwd3=prev_pwd2, prev_pwd2=prev_pwd1, prev_pwd1=pwd, pwd='pwdnew2222'
		where username='CTS200001'
	*/
}
