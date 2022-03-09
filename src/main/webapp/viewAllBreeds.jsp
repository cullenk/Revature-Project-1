<%@ page import="model.Breed" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Puppy Adoption App</title>
</head>
<body style="background-color: mediumpurple">

<style>
  body{
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      margin: 0;
      padding: 0;
  }

  h1 {
      margin: 15px 0;
  }

  .breed-container {
      display: grid;
      grid-template-columns: auto auto auto;
      max-width: 80vw;
      margin: 20px auto;
  }

  .breed-div {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      padding: 20px;
      margin: 15px;
      width: 400px;
      height: 500px;
      background-color: darkcyan;
  }

  .breed-image-div{
      height: 80%;
      width: 100%;
      background-position: center;
      background-size: cover;
  }

</style>

<%
    List<Breed> allBreedsList = (List<Breed>) request.getAttribute("allBreedsList");
%>

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

</body>
</html>
