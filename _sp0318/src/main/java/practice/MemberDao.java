package practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int count() { //jdbcTemplate.queryForObject() 메서드는 하나의 값을 반환하는데, 이 값이 null일 수도 있습니다. 따라서 이 메서드는 결과가 없을 때 null을 반환할 수 있음
		Integer count = jdbcTemplate //기본 데이터 타입은 null을 허용하지 않기 때문에 Wrapper클래스인 Integer로 null값을 포함한 모든 값을 처리할 수 있게 됨                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
				.queryForObject("select count(*) from member", Integer.class); //int형 메서드는 Integer형 사용
		return count;
	}
	
	public String memberName(int memberno) { //멤버 이름 
		return jdbcTemplate.
				queryForObject("select name from member where memberno = ?",
						 String.class,memberno); //String형 메서드는 String형으로 사용
	}
	public void insert(Member member) { //멤버 객체 매개변수로 받음
		jdbcTemplate.update("insert into member(id,pw,name)values(?,?,?)" , //insert 쿼리문
				member.getId(), member.getPw(), member.getName()); //getter메서드 호출해서 값 가지고 오고 삽입
	}
	
	public void update(Member member) { //insert랑 같은 로직 쿼리문만 다름
		jdbcTemplate.update("update member set pw =? ,name =? where memberno = ?",
				member.getPw(), member.getName(), member.getMemberno());
	}
	public void delete(int memberno) { //delete문
		jdbcTemplate.update("delete from member where memberno = ?",
				memberno);
	}
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate
				.query("select * from member",
						new RowMapper<Member>() {

							@Override
							public Member mapRow(ResultSet rs, int rowNum) throws SQLException {//  ResultSet이 특정 쿼리에 대한 결과를 처리할 때 행의 번호를 나타냄
								Member dto = new Member(
										rs.getInt("memberno"),
										rs.getString("id"),
										rs.getString("PW"),
										rs.getString("name")
										);
								return dto;
							}
					
				});
		return results;
	}
	
	public List<Member> selectAll2(){
		List<Member> results = jdbcTemplate
				.query("select * from member", //jdbcTemplate.query() 메서드의 두 번째 매개변수로 RowMapper 인터페이스를 구현한 코드 블록을 전달
											   //jdbcTemplate.query() 메서드는 결과를 처리하기 위해 전달된 RowMapper의 mapRow() 메서드를 내부적으로 호출
						(rs, rowNum)->{ //람다식에서는 컴파일러가 자동으로 타입을 추론할 수 있기 때문에 (rs, rowNum)과 같이 매개변수의 타입을 생략할 수 있음
							Member dto = new Member(
									rs.getInt("memberno"),
									rs.getString("id"),
									rs.getString("PW"),
									rs.getString("name")
									);
							return dto;
						});
		return results;
	}
}
