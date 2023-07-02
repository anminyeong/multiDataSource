package com.hwc.isl.loader.dbif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwc.isl.loader.dbif.entity.UserInfo;

@Repository
public class UserInfoRepository {

	@PersistenceContext(unitName = "remoteEntityManagerFactory")
	private EntityManager remoteEntityManager;
	
	public List<UserInfo> findUserInfo(){
		Query query = remoteEntityManager.createNamedQuery("findUserInfo");
		
		String sql = query.unwrap(org.hibernate.query.Query.class).getQueryString();
		System.out.println(sql);
		
		return query.getResultList(); 
	}
	
}
