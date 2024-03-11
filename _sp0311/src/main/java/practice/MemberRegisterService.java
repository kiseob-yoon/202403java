package practice;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	@Autowired //MemberDao 데이터 타입의 Bean 객체를 찾아서 해당 필드에 주입
	private MemberDao memberDao;
	
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public void regist() {
		memberDao.process();
		System.out.println("regist()");
	}
}
