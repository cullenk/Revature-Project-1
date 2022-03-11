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
        background: white;
        padding: 50px;
        border-radius: 5px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: flex-start;
        margin: 50px auto;
        max-width: 1200px;
    }

    .id-div {
        background-color: dodgerblue;
        font-size: 20px;
        color: white;
        padding: 20px;
        margin-right: 10px;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 10px;
        width: 10px;
        border-radius: 50%;
        box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;
    }

    .record-div {
        display: flex;
        align-items: center;
    }

    .details-text {
        font-size: 24px;
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
    String firstName = (String) request.getAttribute("firstName");
    String lastName = (String) request.getAttribute("lastName");
    String breed = (String) request.getAttribute("breed");
    String gender = (String) request.getAttribute("gender");
    String puppy_name = (String) request.getAttribute("puppy_name");
%>

<div class="container">
    <p>You've successfully updated the adoption record. Here is what the new record looks like: </p>
    <div class="record-div">
        <div class="id-div">
            <p>#<%=recordId%></p>
        </div>
        <div class="details-div">
            <p class="details-text"><%=firstName%> <%=lastName%> adopted a <%=gender%> <%=breed%> puppy named <%=puppy_name%>.</p>
        </div>
    </div>
    <a href="index.html" class="button">Return Home</a>
</div>

</body>
</html>
