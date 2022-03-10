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

    .container {
        margin: 20px auto;
        max-width: 1200px;
    }
    h1 {
        text-align: center;
    }
    form {
        display: flex;
        width: 100%;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }


    .all-breeds-div {
        display: grid;
        grid-template-columns: auto auto;
    }

    .breed-option-div {
        background: bisque;
        height: 300px;
        width: 400px;
        padding: 20px;
        margin: 15px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .breed-image-div{
        height: 80%;
        width: 100%;
        background-position: center;
        background-size: cover;
    }

    .label-div {
        font-size: 24px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 15px;
    }
    .button {
        padding: 20px 40px;
        font-size: 20px;
        outline: none;
        background: darkslategrey;
        color: white;
        cursor: pointer;
        border-radius: 5px;
    }

    .button:hover {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
    label {
        margin-left: 10px;
    }
</style>

<%
    String firstName = (String) request.getSession().getAttribute("firstName");
    String lastName = (String) request.getSession().getAttribute("lastName");
    List<Breed> breedList = (List<Breed>) request.getAttribute("returnedBreeds");
%>

<div class="container">
    <h1>Hi <%=firstName + " " + lastName%>, here are some breeds that will suit you best. Please select whichever one you would like!</h1>
    <form action="nameAndGender" method="post">
        <div class="all-breeds-div">
            <%
            for (Breed b : breedList){
             %>
            <div class="breed-option-div">
                <div class="breed-image-div" style="background-image: url(<%=b.image_url%>)"></div>
                <div class="label-div">
                    <input type="radio" name="chosenBreed" value="<%=b.breed%>">
                    <label for="<%=b.breed%>"><%=b.breed%></label><br/>
                </div>
            </div>
            <%}%>
        </div>

        <input class="button" type="submit" value="Next">
    </form>
</div>

</body>
</html>
