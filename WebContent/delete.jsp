<%@page import="com.sds.icto.guestbook.dao.GuestBookDao"%>
<%@page import="com.sds.icto.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

Long no = Long.parseLong(request.getParameter("no"));
String password = request.getParameter("password");

GuestBookVo vo = new GuestBookVo();
vo.setNo(no);
vo.setPassword(password);


GuestBookDao dao = new GuestBookDao();
dao.delete(vo);


response.sendRedirect("/GuestBook");

%>