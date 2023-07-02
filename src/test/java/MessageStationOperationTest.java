//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import com.hwc.isl.InterSysLinkMain;
//import com.hwc.isl.consts.AppConsts;
//import com.hwc.isl.dbif.oracle.repository.TnCmEqpRepository;
//import com.hwc.isl.msif.MessageStationListener;
//import com.hwc.messagestation.communicationmanager.communication.socket.client.CMClient;
//import com.hwc.messagestation.domains.entity.DriverInfo;
//import com.hwc.messagestation.domains.resp.MSResponse;
//import com.hwc.messagestation.msmessageapi.message.MSMessageOperator;
//
/////@ExtendWith(SpringExtension.class) //스프링 테스트의 확장 기능으로, 스프링 관련 애노테이션(@Autowired, @Transactional 등)을 테스트에서 사용할 수 있도록 지원
////@ContextConfiguration(classes = InterSysLinkMainStarter.class )
////@DataJpaTest //JPA 관련 구성 요소만 로드
////@EnableTransactionManagement
//
//@SpringBootTest
//@ContextConfiguration(classes = InterSysLinkMain.class)
//public class MessageStationOperationTest {
//
//	private final Logger LOGGER = LoggerFactory.getLogger("messageStationLogger");
//
//	// @Autowired
//	// private MainStarter mainStarter; // MessageStation starter
//
//	@Autowired
//	private TnCmEqpRepository tncmeqprepository;
//
////	@Autowired
////    private MainStarter mainStarter; // MessageStation starter
////
////	@Test
////	void messageStationInterfaceTest() {
////
////		try {
////			mainStarter.bootstrap();
////		}catch(Exception e)
////		{
////			e.printStackTrace();
////		}
////	}
//
//	@Test
//	public void OperateMessageStation() {
//		try {
//			// MessageManager Start
//			// mainStarter.bootstrap();
//
//			// 1. CMClient instance 생성
//			//final CMClient client = CMClient.createInstance(AppConsts.SYSTEM_ID);
//
//			// 2. Listener 등록과 connection 연결
//			client.addListener("GROUP1", new MessageStationListener()).connect("192.168.122.143", 30001);
//
//			this.LOGGER.info("client.isConnected() = {}", client.isConnected());
//
//			// 연결 될 때 까지 기다림
////			while (!client.isConnected()) {
////				Thread.sleep(3000);
////				this.LOGGER.info("client.isConnected() = {}", client.isConnected());
////			}
//
//			// 3. 연결상태 확인
//			//if (client.isConnected()) {
//				// 1. CMClient instance로 MSMessageOperator Instance 생성
////				final MSMessageOperator messageOperator = MSMessageOperator.createInstance(client);
////
////				MSResponse<List<DriverInfo>> rResponse = null;
////				MSResponse<List<DriverInfo>> cudResponse = null;
//
//				rResponse = messageOperator.readDriverInfo();
//
//				this.LOGGER.info("readDriverInfo : {}", rResponse.toString());
//
//				// driver => agent
//				final DriverInfo driverInfo = new DriverInfo();
//
//				// driverInfo.setDriverId("AGT101");
//				// driverInfo.setDriverNm(null);
//				// driverInfo.setDriverTypCd("MBT"); //MODBUS TCP
//				// driverInfo.setDriverLocate("L");
//				// driverInfo.setDriverPath(null);
//
//				// 데이터 전송
//				cudResponse = messageOperator.createDriverInfo(driverInfo);
//
//				this.LOGGER.info("readDriverInfo : {}", cudResponse.toString());
//			}
//
//		} catch (final Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
