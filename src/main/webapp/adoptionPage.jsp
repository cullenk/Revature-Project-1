<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<style>
    body {
        font-family: Arial;
        line-height: 1.4;
        background-image: linear-gradient(to bottom right, dodgerblue, darkblue);
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: white;
        padding: 50px;
        border-radius: 5px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin: 50px auto;
        max-width: 1200px;
    }
    .image-div {
        width: 60%;
        height: 350px;
        background-position: center;
        background-size: cover;
        border: 5px solid dodgerblue;
        box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;

    }

    h1 {
        text-align: center;
        max-width: 600px;
    }

    .button {
        padding: 10px 20px;
        opacity: 80%;
        font-size: 16px;
        background-image: linear-gradient(to bottom right, dodgerblue, darkblue);
        color: white;
        cursor: pointer;
        border-radius: 5px;
        transition: .5s ease;
        max-width: 220px;
        margin: 20px 0;
        outline: none;
        border: 1px solid dodgerblue;
    }

    .button:hover {
        opacity: 100%;
    }
</style>

<%
    String firstName = (String) request.getSession().getAttribute("firstName");
    String gender = (String) request.getAttribute("gender");
    String name = (String) request.getAttribute("name");
    String chosenBreed = (String) request.getSession().getAttribute("chosenBreed");
    String imageUrl = (String) request.getSession().getAttribute("imageUrl");
%>
<div class="container">
    <div class="image-div" style="background-image: url(<%=imageUrl%>)"></div>
    <h1>Congratulations <%=firstName%>! You're taking home a <%=gender%> <%=chosenBreed%> puppy named <span style="color:dodgerblue"><%=name%></span>. Take good care of it!</h1>
    <h2>I'll go ahead and add this to our adoption records as well.</h2>
    <a href="index.html" class="button">Return Home</a>
</div>

</body>
</html>
