package com.ctrends.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ctrends.model.UsersModel;

public interface IUserDao extends JpaRepository<UsersModel, UUID>, PagingAndSortingRepository<UsersModel, UUID> {
	@Query("FROM UsersModel ")
	public List<UsersModel> getUsers();
	
	@Query("FROM UsersModel WHERE id=?1")
	public List<UsersModel> getUserById(UUID id);
	
	@Query("FROM UsersModel WHERE username=?1 ")
	public List<UsersModel> getUserByUsername(String username);
	
	@Query("FROM UsersModel WHERE email=?1 ")
	public List<UsersModel> getUserByEmail(String email);
	
	@Query("FROM UsersModel WHERE mobile=?1 ")
	public List<UsersModel> getUserByMobile(String mobile);
	
	@Query("FROM UsersModel WHERE countryCode || divCode || districtCode || subdistrictCode || unionCode=?1 ")
	public List<UsersModel> getUsersByUnionCode(String code);

	@Query("FROM UsersModel WHERE unionId=?1")
	public List<UsersModel> getUsersByUnionId(UUID id);

	@Query("FROM UsersModel WHERE countryCode || divCode || districtCode || subdistrictCode=?1 ")
	public List<UsersModel> getUsersBySubdistrictCode(String code);

	@Query("FROM UsersModel WHERE subdistrictId=?1")
	public List<UsersModel> getUsersBySubdistrictId(UUID id);

	@Query("FROM UsersModel WHERE countryCode || divCode || districtCode=?1 ")
	public List<UsersModel> getUsersByDistrictCode(String code);

	@Query("FROM UsersModel WHERE districtId=?1")
	public List<UsersModel> getUsersByDistrictId(UUID id);

	@Query("FROM UsersModel WHERE countryCode || divCode=?1 ")
	public List<UsersModel> getUsersByDivisionCode(String code);

	@Query("FROM UsersModel WHERE divId=?1")
	public List<UsersModel> getUsersByDivisionId(UUID id);
	
	@Query("FROM UsersModel WHERE "
			+ " LOWER(personName) LIKE %:searchText% OR " 
			+ " LOWER(mobile) LIKE %:searchText% OR " 
			+ " LOWER(username) LIKE %:searchText% OR " 
			+ " LOWER(email) LIKE %:searchText%" 
			+ " ORDER BY username, personName ")
	public List<UsersModel> getUserBySearchText(@Param("searchText") String searchText);
	
	Page<UsersModel> findAll(Pageable pageable);
	
}
