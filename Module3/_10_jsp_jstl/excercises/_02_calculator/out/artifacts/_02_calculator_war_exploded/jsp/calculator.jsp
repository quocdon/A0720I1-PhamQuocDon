<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 12/28/2020
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 style="margin-bottom: 30px">Simple Calculator</h1>
    <form action="calculator" method="post">
        <div class="form-group row">
            <label for="inputFirstOperand" class="col-sm-2 col-form-label">First Operand</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" id="inputFirstOperand"
                       name="firstOperand">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputOperator" class="col-sm-2 col-form-label">Operator</label>
            <div class="col-sm-4">
                <select class="form-control custom-select mr-sm-4" id="inputOperator" name="operator">
                    <option selected disabled>Choose...</option>
                    <option>Addition</option>
                    <option>Subtraction</option>
                    <option>Multiple</option>
                    <option>Division</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="inputSecondOperand" class="col-sm-2 col-form-label">Second Operand</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" id="inputSecondOperand"
                       name="secondOperand">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 col-form-label"></label>
            <div class="col-sm-4" style="text-align: left">
                <button class="btn btn-primary mb-2" type="submit">Calculate</button>
            </div>
        </div>
    </form>
    <c:if test="${error != null}">
        <h3 style="color: red">Error: ${error}</h3>
    </c:if>
    <c:if test="${secondOperand == 0 && operator == '/'}">
        <h3 style="color: red">Error: Divide by zero</h3>
    </c:if>
    <c:if test="${result != null && !(secondOperand == 0 && operator == '/')}">
        <h3 style="color:darkblue;">Result: ${firstOperand} ${operator} ${secondOperand} = ${result}</h3>
    </c:if>
</div>
</body>
</html>
