<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="#">HOME</a>
          <!-- active 클래스 부여하면 활성화됨 -->
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">인기상품</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">신상품</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="notice.do">공지사항</a>
        </li>
       
        <c:if test="${empty id }">
        <li class="nav-item">
          <a class="nav-link" href="login.do">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="signup.do">회원가입</a>
        </li>
        </c:if>
       
        <c:if test="${not empty id }">
        <li class="nav-item">
          <a class="nav-link" href="logOut.do">로그아웃</a>
        </li>
        </c:if>
        
        <c:if test="${id.substring(0,5) == 'admin' }">
        <li class="nav-item">
          <a class="nav-link" href="adminMain.do">관리자</a>
        </li>
        </c:if>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>