package com.sds.icto.guestbook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.guestbook.vo.GuestBookVo;

public class GuestBookDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2 디비 콘 생성
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dburl, "webdb", "webdb");

		return conn;

	}

	public void add(GuestBookVo vo) throws ClassNotFoundException, SQLException {

		// connection 생성
		Connection conn = getConnection();

		// statement sql 준비
		String sql = "insert into GUESTBOOK"
				+ " values(GUESTBOOK_SEQ.nextval, ? , ? , ? , sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 바인딩
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getMessage());

		// query 설정
		pstmt.executeUpdate();

		// 자원정리
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	public List<GuestBookVo> fetchlist() throws ClassNotFoundException,
			SQLException {

		List<GuestBookVo> list = new ArrayList<GuestBookVo>();

		// connection 생성
		Connection conn = getConnection();

		// statement sql 준비
		Statement stmt = conn.createStatement();
		String sql = "select * from guestbook";
		ResultSet rs = stmt.executeQuery(sql);

		// 결과처리
		while (rs.next()) {
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String password = rs.getString(3);
			String message = rs.getString(4);
			String date = rs.getString(5);

			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setDate(date);

			list.add(vo);

		}

		// 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}

		return list;

	}

	public void delete(GuestBookVo vo) throws ClassNotFoundException, SQLException {
		
		// connection 생성
			Connection conn = getConnection();
			
			
			String sql = "delete from guestbook where no = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1,vo.getNo());
			pstmt.setString(2, vo.getPassword());
					
			pstmt.executeUpdate();
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			
			

	}

}
