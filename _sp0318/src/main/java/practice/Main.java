package practice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	private static Logger LOGGER 
				 	= LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
		= new AnnotationConfigApplicationContext
						(DbConfig.class, DbQueryConfig.class); //DbConfig(DB), DbQueryConfig(Bean객체 사용) 
		MemberDao dbQuery = ctx.getBean(MemberDao.class); //getBean 멤버다오
		int count = dbQuery.count(); //멤버다오 카운트 메서드 호출
		LOGGER.info("인원 {}명",count); //{}플레이스홀더로 값을 담는 역할을 수행한다.
		String name= dbQuery.memberName(2); //2번째열에 해당하는 멤버의 이름을 가져옴
		LOGGER.info("고객이름: {}", name);
		
//		Member dto = new Member("call","call@naver.com","콜"); //insert문
//		dbQuery.insert(dto); 
		Member update = new Member(3, "calll", "calll@naver.com", "게릿"); //업데이트문
		dbQuery.update(update); 
		dbQuery.delete(3);//삭제

		
		List<Member> list = dbQuery.selectAll();
		for(Member member: list) {
			LOGGER.info("{},{},{},{}",member.getMemberno(),member.getId(),member.getPw(),member.getName());
		}
		
	}

}
