package com.hwc.isl.reposit.dbif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwc.isl.reposit.dbif.entity.TbServerInfo;
import com.hwc.isl.reposit.dbif.repository.TbServerInfoRepository;

/**
 * @FileName : TbServerInfoService.java
 * @Project : InterSysLinkMain
 * @Date : 2023. 6. 15.
 * @author : anmin
 * 
 * @version : 1.0
 * @program info :
 */
@Service
public class TbServerInfoService {

	@Autowired
	private TbServerInfoRepository tbServerInfoRepository;

	/**
	 * SERVER 정보 조회
	 * 
	 * @return
	 */
	public List<TbServerInfo> findAll() {
		return this.tbServerInfoRepository.findAll();
	}

}
