<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-bordered">
    <h1>List Product</h1>
    <tr>
        <th>Id Product</th>
        <th>Name Product</th>
        <th>Brand Product</th>
        <th>Price Product</th>
        <th>Description Product</th>
        <th>Quantity Product</th>
        <th>Status Product</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${product}" var="p">
        <tr>
            <td>${p.idProduct}</td>
            <td>${p.nameProduct}</td>
            <td>${p.brandProduct}</td>
            <td>${p.priceProduct}</td>
            <td>${p.descriptionProduct}</td>
            <td>${p.quantityProduct}</td>
            <td>${p.statusProduct}</td>
            <td>
                <a class="btn btn-info" href="/products?action=view&idProduct=${p.idProduct}">View</a>|
                <a class="btn btn-danger" href="/products?action=delete&idProduct=${p.idProduct}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-info float-right" href="/products?action=create">Add new product</a>
</body>
</html>
