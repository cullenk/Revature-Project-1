
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: darkkhaki">

<style>
  body{
    margin: 0;
    padding: 0;
  }
</style>

<%String chosenBreed = (String) request.getAttribute("chosenBreed");%>
<h2>You've chosen a:</h2><br/>
<h1><%=chosenBreed%></h1>

<form action="adoptionPage" method="post">
  <h3>Would you like your puppy to be male or female?</h3><br/>
  <input type="radio" name="gender" value="male">
  <label for="male">Male</label><br/>
  <input type="radio" name="gender" value="female">
  <label for="female">Female</label><br/>
  What would you like to name your puppy? <input type="text" name="name"><br>
  <input type="submit" value="Next">
</form>
</body>
</html>
