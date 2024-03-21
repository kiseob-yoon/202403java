package practice;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbQueryConfig { // Spring 프레임워크에서 데이터베이스 쿼리에 대한 빈(Bean)을 생성하기 위한 설정 클래스
	
	@Autowired
	private DataSource dataSource;
	
	@Bean //MemberDao 클래스의 객체를 생성하면서 생성자에 데이터베이스 연결을 주입합니다. 이를 통해 MemberDao 객체는 데이터베이스에 접근하여 쿼리를 수행할 수 있다
	public MemberDao memberDao() {
		return new MemberDao(dataSource);
	}
	
}
