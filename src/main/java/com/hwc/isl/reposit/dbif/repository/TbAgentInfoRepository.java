package com.hwc.isl.reposit.dbif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hwc.isl.reposit.dbif.entity.TbAgentInfo;

public interface TbAgentInfoRepository extends JpaRepository<TbAgentInfo, Long> {

	// 모든 SERVER, AGENT 정보 조회
	@Query("SELECT a, s FROM TbAgentInfo a INNER JOIN a.tbServerInfo s")
	List<Object[]> getAgentWithServer();

}
