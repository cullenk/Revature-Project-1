<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body bgcolor="skyblue">

<%
            int t1 = Integer.parseInt(request.getParameter("t1"));
            int t2 = Integer.parseInt(request.getParameter("t2"));
            int result = t1+t2;
            out.println(t1+" + "+t2+" = "+ result);
%>
</body>
</html>