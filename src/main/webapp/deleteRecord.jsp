<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Puppy Adoption App</title>
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
        padding: 50px;
        border-radius: 5px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin: 50px auto;
        max-width: 1200px;
    }
     h1 {
         color: white;
     }

    .id-div {
        background-color: dodgerblue;
        font-size: 20px;
        color: white;
        padding: 20px;
        margin: 25px auto;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 10px;
        width: 10px;
        border-radius: 50%;
        box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;
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
        margin: 20px auto;
        outline: none;
        border: 1px solid dodgerblue;
    }

    .button:hover {
        opacity: 100%;
    }
</style>

<%
  int recordId = (int) request.getAttribute("recordId");
%>
<div class="container">
    <h1>You've successfully deleted the adoption record with the id of:</h1>
    <div class="id-div"><%=recordId%></div>
    <a href="index.html" class="button">Return Home</a>
</div>


</body>
</html>
