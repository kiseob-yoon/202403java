<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Todo List</h1>
	<input id="todoInput" type="text" placeholder="할 일을 넣으세요" />
	<button id="addButton">Add</button>
	<ul id="todoList">
		<!-- 할 일 목록이 여기에 추가됩니다. -->
	</ul>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$(function() {
			$.ajax({//a.jax(비동기 방식)발동
				url : 'GetTodos', //url을 Get방식으로 'GetTodos'로 요청
				method : 'GET', 
				success : function(data) { //요청 성공 시 함수에 데이터값 가져옴
					addItem(data); //addItem 함수를 호출하며 data값을 함수 선언부에 넘겨줌
				}
			});
		});

		function addItem(data) { //addItem함수를 정의함
			const list = $('#todoList'); //id값 todoList를 찾아 list변수에 대입

			const item = $('<li></li>').text(data); //item 변수에 받은 데이터값을 담은 li태그를 대입
			const removeButton = $('<button></button>').text('Remove'); //removeButton변수에 버튼을 생성하고 텍스트 값으로 'Remove'를 부여함
			removeButton.click(function() { //삭제 버튼을 클릭하면 
				$.ajax({ //ajax(비동기 방식)발동
					url : 'RemoveTodo', // 서버에서 할 일을 삭제하는 엔드포인트 url을 POST방식으로 'RemoveTodo'로 요청
					method : 'POST',
					data : { //삭제할 데이터를 전송
						text : data
					},
					success : function() { //서블릿에서 데이터를 제대로 받고 성공 시 밑에 구문 실행 즉, 삭제가 됨
						item.remove();
					}
				});
			});

			item.append(removeButton); //삭제 버튼을 폼에 띄움

			list.append(item); //list(ul)에 li태그 삽입하여 폼에 띄움
		}
	</script>
</body>
</html>


