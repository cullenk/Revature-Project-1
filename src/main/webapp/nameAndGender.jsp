
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
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 20px auto;
    max-width: 1200px;
  }

  .breed-header-div {
    padding: 20px 40px 40px;
    border-radius: 5px;
    border: 1px solid rgba(0, 0, 0, 0.19);
    background: white;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .image-div {
    width: 100%;
    min-width: 450px;
    height: 350px;
    background-position: center;
    background-size: cover;
    border: 5px solid dodgerblue;
    box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;
  }

  h1 {
    color: dodgerblue;
    font-family: "Arial Rounded MT Bold";
    font-size: 42px;
    margin: 20px 0;
  }
  h2 {
    margin-bottom: 0px;
  }
h3 {
  margin-bottom: 0px;
  color: white;
}

form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
}

label {
  color: white;
}

input:hover {
  cursor: pointer;
}

.input {
  margin-top: 15px;
}

.name-input-div {
  display: flex;
  flex-direction: column;
  margin: 10px 0;
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
  String chosenBreed = (String) request.getSession().getAttribute("chosenBreed");
  String imageUrl = (String) request.getSession().getAttribute("imageUrl");

%>

<div class="container">
  <div class="breed-header-div">
    <h2>Your Choice:</h2>
    <h1><%=chosenBreed%></h1>
    <div class="image-div" style="background-image: url(<%=imageUrl%>)"></div>
  </div>

  <form action="adoptionPage" method="post">
    <h3>Would you like your puppy to be male or female?</h3>
    <div>
      <input type="radio" name="gender" value="male" required>
      <label>Male</label>
    </div>
    <div>
      <input type="radio" name="gender" value="female" required>
      <label>Female</label>
    </div>
    <div class="name-input-div">
      <label>What would you like to name your puppy?</label>
      <input class="input" type="text" name="name" required>
    </div>
    <input class="button" type="submit" value="Next">

  </form>
</div>

</body>
</html>
