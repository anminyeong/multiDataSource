package com.hwc.isl.reposit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hwc.isl.common.consts.AppConsts;
import com.hwc.isl.loader.dbif.entity.UserInfo;
import com.hwc.isl.loader.dbif.repository.UserInfoRepository;
import com.hwc.isl.reposit.dbif.service.TbAgentInfoService;
import com.hwc.isl.reposit.dbif.service.TbServerInfoService;


@Component("repositInitializer")
public class RepositInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger("messageStationLogger");

//	@Autowired
//	private MainStarter mainStarter; // MessageStation starter

	@Autowired
	private TbServerInfoService tbServerInfoService;

	@Autowired
	private TbAgentInfoService tbAgentInfoService;

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	public void init() {

		// (내부 DB) 모든 SERVER,AGENT 정보 조회
		final List<Object[]> agentsWithServers = this.tbAgentInfoService.getAgentWithServer();
		System.out.println("agentsWithServers.size() : " + agentsWithServers.size());

		// (ORACLE) AGENT 정보 LOAD
		List<UserInfo> userInfoList = userInfoRepository.findUserInfo();
		
		for(UserInfo userInfo : userInfoList)
		{
			System.out.println("agentsWithServers.size() : " + userInfo.toString());	
		}

		// 연결정보 LOAD
		// 모니터링 TAG LOAD

		// EES 연결 설정 LOAD
		// EES 메시지 HEADER 설정 LOAD
		// EES 환경 설정 LOAD
		// EES TAG 정보 LOAD
		// EES TAG ACTION 전송
		// EES 실시간 값 전송

		try {
			// MessageManager Start
			//this.mainStarter.bootstrap();

			// 1. CMClient instance 생성
			//final CMClient client = CMClient.createInstance(AppConsts.SYSTEM_ID);

			// 2. Listener 등록과 connection 연결
//			client.addListener("GROUP1", new MessageStationListener()).connect("localhost", 30001);
//
//			RepositInitializer.LOGGER.info("client.isConnected() = {}", client.isConnected());
//
//			// 연결 될 때 까지 기다림
//			while (!client.isConnected()) {
//				Thread.sleep(3000);
//				RepositInitializer.LOGGER.info("client.isConnected() = {}", client.isConnected());
//			}

			// 3. 연결상태 확인
			//if (client.isConnected()) {
				// 1. CMClient instance로 MSMessageOperator Instance 생성
				//final MSMessageOperator messageOperator = MSMessageOperator.createInstance(client);

				//MSResponse<List<DriverInfo>> rResponse = null;
				//MSResponse<List<DriverInfo>> cudResponse = null;

//				rResponse = messageOperator.readDriverInfo();
//
//				RepositInitializer.LOGGER.info("readDriverInfo : {}", rResponse.toString());
//
//				// driver => agent
//				final DriverInfo driverInfo = DriverInfo.builder().driverId("AGT101").driverTypCd("MBT")
//						.driverLocate("L").build();
//
//				// 데이터 전송
//				cudResponse = messageOperator.createDriverInfo(driverInfo);
//
//				RepositInitializer.LOGGER.info("readDriverInfo : {}", cudResponse.toString());
			//}

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
