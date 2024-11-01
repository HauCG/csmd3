<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detail Product</title>
</head>
<body>
<h1>Detail Product</h1>

<div>
    <p>ID: ${p.idProduct}</p>
    <p>Name: ${p.nameProduct}</p>
    <p>Brand: ${p.brandProduct}</p>
    <p>Price: ${p.priceProduct}</p>
    <p>Description: ${p.descriptionProduct}</p>
    <p>Quantity: ${p.quantityProduct}</p>
    <p>Status: ${p.statusProduct}</p>
</div>
</body>
</html>
