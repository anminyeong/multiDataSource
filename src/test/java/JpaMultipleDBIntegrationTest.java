import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.hwc.isl.InterSysLinkMain;
import com.hwc.isl.loader.dbif.entity.TnCmEqp;
import com.hwc.isl.loader.dbif.repository.AgentInfoRepository;
import com.hwc.isl.reposit.dbif.entity.TbServerInfo;
import com.hwc.isl.reposit.dbif.repository.TbServerInfoRepository;

//import com.hwc.messagestation.main.init.MainStarter;

///@ExtendWith(SpringExtension.class) //스프링 테스트의 확장 기능으로, 스프링 관련 애노테이션(@Autowired, @Transactional 등)을 테스트에서 사용할 수 있도록 지원
//@ContextConfiguration(classes = InterSysLinkMainStarter.class )
//@DataJpaTest //JPA 관련 구성 요소만 로드
//@EnableTransactionManagement

@SpringBootTest
@ContextConfiguration(classes = InterSysLinkMain.class)
public class JpaMultipleDBIntegrationTest {

	@Autowired
	private AgentInfoRepository tnCmEqpRepository;

	@Autowired
	private TbServerInfoRepository tbServerInfoRepository;

//	@Autowired
//    private MainStarter mainStarter; // MessageStation starter
//
//	@Test
//	void messageStationInterfaceTest() {
//
//		try {
//			mainStarter.bootstrap();
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}

	public void OracleSelectEqpRepository() {
		try {
			System.out.println("selectEqpRepository() call...");
			final List<TnCmEqp> tnCmEqpList = this.tnCmEqpRepository.findAll();
			System.out.println("selectEqpSize : " + tnCmEqpList.size());

			Assertions.assertThat(this.tnCmEqpRepository.findAll()).isEmpty();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void H2selectTbServerInfo() {
		try {
			System.out.println("selectEqpRepository() call...");
			final List<TbServerInfo> tbServerInfos = this.tbServerInfoRepository.findAll();
			System.out.println("selectEqpSize : " + tbServerInfos.size());

			Assertions.assertThat(this.tbServerInfoRepository.findAll()).isEmpty();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
