<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: darksalmon">

<style>
    body{
        margin: 0;
        padding: 0;
    }
</style>

<%
    String firstName = (String) request.getAttribute("firstName");
    String gender = (String) request.getAttribute("gender");
    String name = (String) request.getAttribute("name");
    String chosenBreed = (String) request.getSession().getAttribute("chosenBreed");

%>

<h1>Congratulations, <%=firstName%>! You're taking home a <%=gender%> <%=chosenBreed%> puppy named <%=name%>. Take good care of it!</h1><br/>
<h2>I'll go ahead and add this to our adoption records as well.</h2>
</body>
</html>
