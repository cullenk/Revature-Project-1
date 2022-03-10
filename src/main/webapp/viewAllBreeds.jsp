<%@ page import="model.Breed" %>
<%@ page import="java.util.List" %>
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

  h1 {
      margin: 15px 0;
      color: white;
  }

  h2 {
      color: black;
      font-family: "Arial Rounded MT Bold";
      font-size: 28px;
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

  .breed-container {
      display: grid;
      grid-template-columns: auto auto auto;
      margin: 20px auto;
  }

  .breed-div {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      padding: 20px;
      margin: 15px;
      width: 300px;
      height: 400px;
      background-color: white;
      border-radius: 5px;
      box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  }

  .breed-image-div{
      height: 80%;
      width: 100%;
      background-position: center;
      background-size: cover;
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
    List<Breed> allBreedsList = (List<Breed>) request.getAttribute("allBreedsList");
%>


<div class="container">
    <h1>Here are all the breeds we currently have up for adoption:</h1>
    <div class="breed-container">
        <%
            for (Breed b : allBreedsList){
        %>
        <div class="breed-div">
            <div class="breed-image-div" style="background-image: url(<%=b.image_url%>)"></div>
            <h2 class="breed-name"><%=b.breed%></h2>
        </div>
        <% } %>
    </div>
    <a href="index.html" class="button">Return Home</a>
</div>


</body>
</html>
