package com.hwc.isl.reposit.dbif.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hwc.isl.reposit.dbif.repository.TbAgentInfoRepository;

/**
 * @FileName : TbAgentInfoService.java
 * @Project : InterSysLinkMain
 * @Date : 2023. 6. 15.
 * @author : anmin
 * 
 * @version : 1.0
 * @program info :
 */
@Service
public class TbAgentInfoService {

	private final TbAgentInfoRepository tbAgentInfoRepository;

	public TbAgentInfoService(final TbAgentInfoRepository tbAgentInfoRepository) {
		this.tbAgentInfoRepository = tbAgentInfoRepository;
	}

	public List<Object[]> getAgentWithServer() {
		return this.tbAgentInfoRepository.getAgentWithServer();
	}

}
