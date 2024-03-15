package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dto.Board;

@Service
public class GetMemberList {
	
	@Autowired
	private BoardDao boardDao;
	
	public ArrayList<Board> selectList() {
		return boardDao.selectList();
	}

}
