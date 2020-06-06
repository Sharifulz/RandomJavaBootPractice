package com.ctrends.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ctrends.model.ApiKeyEndpointsModel;

@Repository
public interface IApiKeyDao extends JpaRepository<ApiKeyEndpointsModel, UUID> {
	
	@Query("FROM ApiKeyEndpointsModel where appCode='KYC' AND apiKey=:apiKey AND endpoint=:endpoint ")
	public List<ApiKeyEndpointsModel> getByApiKey(@Param("apiKey") String apiKey, @Param("endpoint") String endpoint);
	
}
