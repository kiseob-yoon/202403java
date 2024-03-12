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
	<input id="todoInput" type="text" placeholder="할 일을 넣으세요">
	<button id="addButton">Add</button>
	<ul id="todoList">

	</ul>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
        $(function(){
          $.ajax({
        	 url: 'GetTodos',
        	 method: 'Get',
        	 success: function(data){
        		 console.log(data);
        	 }
          });
        });
    </script>

</body>
</html>