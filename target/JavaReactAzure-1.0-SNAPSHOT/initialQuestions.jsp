<%@ page import="model.Breed" import="org.apache.catalina.filters.ExpiresFilter.XPrintWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>JSP Page</title>
</head>
<body style="background-color: aqua">

<style>
    body{
        margin: 0;
        padding: 0;
    }
</style>

<%
    String firstName = (String) request.getAttribute("firstName");
    String lastName = (String) request.getAttribute("lastName");
    List<Breed> breedList = (List<Breed>) request.getAttribute("returnedBreeds");
%>
<h1>Hi <%=firstName + " " + lastName%>, here are some breeds that will suit you best. Please select whichever one you would like!</h1>

<form action="nameAndGender" method="post">
    <%
        for (Breed b : breedList){
    %>
    <input type="radio" name="chosenBreed" value="<%=b.breed%>">
    <label for="<%=b.breed%>"><%=b.breed%></label><br/>
    <%}%>
    <input type="submit" value="Next">
</form>

</body>
</html>
