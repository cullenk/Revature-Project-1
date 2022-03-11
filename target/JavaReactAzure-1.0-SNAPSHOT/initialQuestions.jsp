<%@ page import="model.Breed" import="org.apache.catalina.filters.ExpiresFilter.XPrintWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
        margin: 20px auto;
        max-width: 1200px;
    }
    h1 {
        text-align: center;
        color: white;
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
        background: white;
        border-radius: 5px;
        height: 300px;
        width: 400px;
        padding: 20px;
        margin: 15px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    }

    .breed-image-div{
        height: 80%;
        width: 100%;
        background-position: center;
        background-size: cover;
        border: 5px solid dodgerblue;
        transition: .5s ease;
    }

    .breed-image-div:hover {
        box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;
    }

    .label-div {
        font-size: 24px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 15px;
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

    input:hover {
        cursor: pointer;
    }

    label {
        margin-left: 10px;
        font-family: "Arial Rounded MT Bold";
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
                    <input type="radio" name="chosenBreed" value="<%=b.breed%>" required>
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
