
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: darkkhaki">

<style>
  body{
    margin: 0;
    padding: 0;
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
    padding: 20px 40px;
    border-radius: 5px;
    border: 1px solid rgba(0, 0, 0, 0.19);
    background: white;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  h1 {
    color: green;
    margin: 0px;
  }
  h2 {
    margin-bottom: 0px;
  }
h3 {
  margin-bottom: 0px;
}

.name-input-div {
  display: flex;
  flex-direction: column;
  margin: 10px 0;
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
</style>

<%String chosenBreed = (String) request.getSession().getAttribute("chosenBreed");%>

<div class="container">
  <div class="breed-header-div">
    <h2>You've chosen a:</h2><br/>
    <h1><%=chosenBreed%></h1>
  </div>

  <form action="adoptionPage" method="post">
    <h3>Would you like your puppy to be male or female?</h3><br/>
    <input type="radio" name="gender" value="male">
    <label for="male">Male</label><br/>
    <input type="radio" name="gender" value="female">
    <label for="female">Female</label><br/>
    <div class="name-input-div">
      <p>What would you like to name your puppy?</p>
      <input type="text" name="name"><br>
    </div>
    <input class="button" type="submit" value="Next">

  </form>
</div>

</body>
</html>
