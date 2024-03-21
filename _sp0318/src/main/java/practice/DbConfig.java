package practice;

import org.apache.tomcat.jdbc.pool.DataSource; //Apache Tomcat JDBC 풀에서 제공하는 DataSource 클래스를 가져옴
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //이 애노테이션은 클래스가 Spring의 설정 클래스임을 나타냄
public class DbConfig {
	@Bean(destroyMethod = "close") //이 애노테이션은 해당 메서드가 스프링 빈을 생성하는 메서드임을 나타냄, 
								  //destroyMethod 속성을 사용하여 스프링 컨테이너가 해당 빈을 소멸할 때 호출할 메서드를 지정	
	public DataSource dataSource() { //데이터베이스 연결 풀을 생성하는 메서드
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/project2?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("mysql");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}

}
