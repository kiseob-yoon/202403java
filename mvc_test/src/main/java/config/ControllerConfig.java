package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.TestController;
import dao.MemberDao;
import service.GetMemberNumService;




@Configuration
public class ControllerConfig {
	
	@Bean
	public TestController testController() {
		return new TestController();
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public GetMemberNumService getMemberNumService() {
		return new GetMemberNumService();
	}
	
}
