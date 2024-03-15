package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.TestController;
import dao.BoardDao;
import dao.MemberDao;
import service.GetMemberDelete;
import service.GetMemberList;
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
	public BoardDao BoardDao() {
		return new BoardDao();
	}
	
	@Bean
	public GetMemberNumService getMemberNumService() {
		return new GetMemberNumService();
	}
	@Bean
	public GetMemberList getMemberList() {
		return new GetMemberList();
	}
	@Bean
	public GetMemberDelete getMemberDelete() {
		return new GetMemberDelete();
	}
}
