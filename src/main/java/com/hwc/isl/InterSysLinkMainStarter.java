package com.hwc.isl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hwc.isl.common.utils.LogMsgUtil;
import com.hwc.isl.reposit.RepositInitializer;

@Component
public class InterSysLinkMainStarter implements ApplicationListener<ApplicationStartedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger("messageStationLogger");

	@Autowired
	private RepositInitializer repositInitializer;

	@Override
	public void onApplicationEvent(final ApplicationStartedEvent event) {
		InterSysLinkMainStarter.LOGGER.info("");
		InterSysLinkMainStarter.LOGGER.info(LogMsgUtil
				.infoFormat("========================= InterSysLink Initializer Start ========================="));
		InterSysLinkMainStarter.LOGGER.info("");

		/** 1. 라이선스 체크 */

		/** 2. 이중화 연결 */

		/** 3. 저장소 모듈 초기화 */
		this.repositInitializer.init();

	}

}
