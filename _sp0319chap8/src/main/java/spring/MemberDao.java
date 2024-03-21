package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL =?", 
				new RowMapper<Member>() { //제네릭의 클래스타입으로 override하여 메서드생성
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("EMAIL"), 
						rs.getString("PASSWORD"), 
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}

		}, email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Member selectByEmail2(String email) {
		Member results = jdbcTemplate.queryForObject( // queryForObject은 null체크를 못함 따라서 반드시 값이 나오는 것만 사용해야함
				"select * from MEMBER where EMAIL =?", 
				new RowMapper<Member>() { //제네릭의 클래스타입으로 override하여 메서드생성
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("EMAIL"), 
						rs.getString("PASSWORD"), 
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}

		}, email);
		return results;
	}
	
	public Member selectByEmail3(String email) {
		Member results = jdbcTemplate.queryForObject( // queryForObject은 null체크를 못함 따라서 반드시 값이 나오는 것만 사용해야함
				"select * from MEMBER where EMAIL =?", 
				(rs, rowNum)->{
				Member member = new Member(
						rs.getString("EMAIL"), 
						rs.getString("PASSWORD"), 
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}, email);
		return results;
	}
	

	public void insert(Member member) {
		jdbcTemplate.update("insert into member(email,password,name,regdate) values(?,?,?,now())",
				member.getEmail(),member.getPassword(),member.getName());
		
	}
	public void insert2(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement
						("insert into member(email,password,name,regdate)" + "values(?,?,?,now())",
								new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());						
				return pstmt;
			}
		},keyHolder);
		Number keyvalue = keyHolder.getKey();
		member.setId(keyvalue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update("update member set name=?,password=? where email=?",
				member.getName(),member.getPassword(),member.getEmail());
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query( // queryForObject은 null체크를 못함 따라서 반드시 값이 나오는 것만 사용해야함
				"select * from MEMBER", 
				(rs, rowNum)->{
				Member member = new Member(
						rs.getString("EMAIL"), 
						rs.getString("PASSWORD"), 
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			});
		return results;
	}
	public int count() {
		return jdbcTemplate.queryForObject(
				"select count(*) from member", Integer.class);
		
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from member where id=?",id);
	}

}
