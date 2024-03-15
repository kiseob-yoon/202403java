package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.MemberDao;

@Service
public class GetMemberDelete {
	@Autowired
	private BoardDao boardDao;
	
	public int delete(int num) {
		return boardDao.delete(num);
	}
	
}
