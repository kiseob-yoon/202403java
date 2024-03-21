package main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import dbquery.DbQuery;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForDao {

	private static Logger LOGGER = LoggerFactory.getLogger(MainForDao.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);

		
		MemberDao dao = ctx.getBean(MemberDao.class);
		
		Member member = new Member("kk22@naver.com","1233","김",null);
		dao.insert2(member);
		LOGGER.info("---한 행이 입력되었습니다.");
		LOGGER.info("새로 입력된 회원 ID: {}",member.getId());
		
//		Member member3 = new Member("www@naver.com","5678","김진영",null);
//		dao.update(member3);
//		LOGGER.info("---한 행이 수정되었습니다.");
		
		
//		Member member = dao.selectByEmail3("madvirus@madvirus.net");
		List<Member> results = dao.selectAll();
		int count = dao.count();
		LOGGER.info("멤버 수: {}명",count);
		
//		dao.delete(3);
//		LOGGER.info("멤버 삭제");

		
//		LOGGER.info("{}",member);
//		LOGGER.info("아이디:{}, 이메일:{}, 패스워드:{}, 이름:{}, 등록일:{}",
//				                      member.getId(), 
//				                      member.getEmail(),
//				                      member.getPassword(),
//				                      member.getName(),
//				                      member.getRegisterDateTime());
		LOGGER.info("--테이블 내용--");
		for (Member member2 : results) {
			LOGGER.info(member2.toString());
		}

		



		ctx.close();

	}
}
