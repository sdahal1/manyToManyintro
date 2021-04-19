<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Hello Many to Many!</h1>
        <div class="col-8">
            <form:form action="/meals/create" method="post" modelAttribute = "meal">
                <div class="form-group">
                    <form:label path="name">Name</form:label>
                    <form:errors path="name"/>
                    <form:input type="text" path="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="num_calories">Number of Calories:</form:label>
                    <form:errors path="num_calories"/>
                    <form:input type="number" path="num_calories" class="form-control"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Add Meal" class= "btn btn-primary">
                </div>
            </form:form>

        </div>

        <table class="table table-striped">
            <thead>
              <tr>
                
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Calories</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items='${ allMeals }' var='m'>
              <tr>
                <td>${m.id}</td>
                <td><a href="/meals/${m.id}">${m.name}</a></td>
                <td>${m.num_calories}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>

    </div>

</body>
</html>