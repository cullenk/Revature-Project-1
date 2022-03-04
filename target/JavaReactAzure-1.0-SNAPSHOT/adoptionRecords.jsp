<%@ page import="model.AdoptionRecord" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<AdoptionRecord> adoptionRecordList = (List<AdoptionRecord>) request.getAttribute("adoptionRecordList");
%>

<div>
    <% for (AdoptionRecord ar : adoptionRecordList){ %>
    <p><%=ar.firstName%> <%=ar.lastName%>adopted a <%=ar.gender%> <%=ar.breed%> puppy named <%=ar.puppy_name%>.</p>
    <%}%>
</div>

</body>
</html>
