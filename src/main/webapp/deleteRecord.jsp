<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Puppy Adoption App</title>
</head>
<body style="background-color: green">

<style>
    body{
        margin: 0;
        padding: 0;
    }
</style>

<%
  int recordId = (int) request.getAttribute("recordId");
%>

<p>You've successfully deleted the adoption record with the id of <%=recordId%>.</p>

</body>
</html>
