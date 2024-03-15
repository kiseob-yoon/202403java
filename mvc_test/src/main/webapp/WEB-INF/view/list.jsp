<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<style>
td .custom-link {
	text-decoration: none; /* 링크 밑줄 제거 */
	color: inherit; /* 부모 요소에서 상속된 색상 사용 */
}

td a {
	text-decoration: none; /* 링크 밑줄 제거 */
	color: inherit;
} /* 부모 요소에서 상속된 색상 사용 */
</style>
	<h1 class="visually-hidden">Headers examples</h1>

	<div class="container">
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="move"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<svg xmlns="http://www.w3.org/2000/svg" width="40" height="32"
					fill="currentColor" class="bi bi-film" viewBox="0 0 16 16"
					style="margin: 10px;">
  		<path
						d="M0 1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1zm4 0v6h8V1zm8 8H4v6h8zM1 1v2h2V1zm2 3H1v2h2zM1 7v2h2V7zm2 3H1v2h2zm-2 3v2h2v-2zM15 1h-2v2h2zm-2 3v2h2V4zm2 3h-2v2h2zm-2 3v2h2v-2zm2 3h-2v2h2z" />
		</svg> <span class="fs-4">MOVIE BOARD</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item"><a href="move"
					class="nav-link active" aria-current="page">Home</a></li>
				<li class="nav-item"><a href="sessionLogout.jsp"
					class="nav-link">Logout</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Pricing</a></li>
				<li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
				<li class="nav-item"><a href="#" class="nav-link">About</a></li>
			</ul>
		</header>
	</div>
	</div>
	<div class="container d-flex flex-wrap justify-content-center">
		<form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto flex-row"
			role="search" method="post" action="select.jsp">
			<div class="d-flex align-items-center">
				<input type="search" name="na" class="form-control"
					placeholder="이름을 검색하세요" aria-label="Search" style="margin: 10px">
				<input type="submit" value="검색"
					class="btn btn-light text-dark me-2 d-inline-block"></input>
			</div>
		</form>
	</div>
	<div class="container" style="padding-top: 50px;">
	<table class="table table-striped table-hover"
		style="text-align: center;">
		<tr>
			<th class="num">번호</th>
			<th class="title">제목</th>
			<th class="writer">작성자</th>
			<th class="regtime">작성일시</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.getNum()}</td>
				<td>
				<a href="view?num=${item.getNum()}">
    			${item.getTitle()}
				</a>
				</td>
				<td>${item.getWriter()}</td>
				<td>${item.getRegtime()}</td>
				<td>${item.getHits()}</td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="button" value="글쓰기" class="btn btn-primary"
		onclick="window.location.href='write'">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>