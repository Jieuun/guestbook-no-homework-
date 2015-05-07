package com.sds.icto.guestbook.test;

import java.sql.*;
import java.util.List;
import com.sds.icto.guestbook.dao.GuestBookDao;
import com.sds.icto.guestbook.vo.GuestBookVo;

public class TestGuestBookDao {
	public static void main(String[] args) {

		try {

			// Add 테스트
			testAdd();
			testFetchList();

		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public static void testAdd() throws ClassNotFoundException, SQLException {
		GuestBookVo vo = new GuestBookVo();
		vo.setName("lee");
		vo.setPassword("1234");
		vo.setMessage("hello");

		GuestBookDao dao = new GuestBookDao();
		dao.add(vo);
	}
	
	public static void testFetchList() throws Exception {

		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.fetchlist();
		for (GuestBookVo vo : list) {
			System.out.print(vo.getNo() + " , ");
			System.out.print(vo.getName() + " : ");
			System.out.print(vo.getMessage() + " : ");
			System.out.print(vo.getDate() + " : ");
			System.out.println("\n");
		}

	}
	
	

}
