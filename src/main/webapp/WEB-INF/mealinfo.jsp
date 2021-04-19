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
    <h1>Information about meal: ${mealToShow.name}</h1>


    <h2>Here are all the ingredients for this meal:</h2>
    <ul>
        <c:forEach items='${ mealToShow.ingredients }' var='ing'>
            <li>${ing.name}</li>
        </c:forEach>

    </ul>

    <form action="/addIngredientTomeal" method="post">
        <input type="hidden" name="hiddenMealId" value = ${mealToShow.id}>
        <label for="">Select an Ingredient to add to this meal</label>
        <select name="selectedIng" id="">
            <c:forEach items='${ allIngs }' var='ing'>
            <option value="${ing.id}">${ing.name}</option>
            </c:forEach>
            
        </select>
        <input type="submit" value="Add To meal">
    </form>
</body>
</html>