<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Puppy Adoption App</title>
</head>
<body style="background-color: darkgoldenrod">

<style>
    body{
        margin: 0;
        padding: 0;
    }
</style>

<%
    int recordId = (int) request.getAttribute("recordId");
    String firstName = (String) request.getAttribute("firstName");
    String lastName = (String) request.getAttribute("lastName");
    String breed = (String) request.getAttribute("breed");
    String gender = (String) request.getAttribute("gender");
    String puppy_name = (String) request.getAttribute("puppy_name");


%>

<p>You've successfully update the adoption record. Here is what the new record looks like: </p><br/>
<p>Adoption Record Id <%=recordId%> : <%=firstName%> <%=lastName%> adopted a <%=gender%> <%=breed%> puppy named <%=puppy_name%>.</p>

</body>
</html>
