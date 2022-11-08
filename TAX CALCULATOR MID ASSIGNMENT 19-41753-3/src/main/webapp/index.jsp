
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
Welcome to TAX CALCULATOR

<form action="calculator" method="post">
    <input type="text" name="username" placeholder="Please write your name"> <br> <br>
    <input type="text" SALARY="bsal"placeholder="SALARY" ><br> <br>
    <input type="text" ALLOWANCE="allo" placeholder="ALLOWANCE"> <br> <br>
    <input type="text" TAX="tax"placeholder="TAX" > <br> <br>
    <input type="text" RENT="rent"placeholder="RENT" > <br> <br>
    <input type="text" SHOPPING="nsal"placeholder="SHOPPING" > <br> <br>
    <input type="text" TOTAL="nsal"placeholder="TOTAL" > <br> <br>
    <input type="submit">

    <br><br>

    <body>
    <h1>Citizen! ${paramValues.bsal}</h1>
    <h1>Citizen! ${paramValues.allo}</h1>
    <h1>Citizen! ${paramValues.nsal}</h1>
    <h1>Citizen! ${paramValues.tax}</h1>
    </body>
</form>
</body>
</html>
