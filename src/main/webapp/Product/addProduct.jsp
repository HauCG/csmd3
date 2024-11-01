<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Add Product</h2>

    <c:if test="${not empty param.message}">
        <div class="alert alert-success">${param.message}</div>
    </c:if>


    <form action="${pageContext.request.contextPath}/products?action=create" method="post" class="w-50 mx-auto">
        <div class="form-group">
            <label for="name">Product Name:</label>
            <input type="text" class="form-control" name="nameProduct" id="name" placeholder="Enter product name" required>
        </div>
        <div class="form-group">
            <label for="brand">Brand Name:</label>
            <input type="text" class="form-control" name="brandProduct" id="brand" placeholder="Enter brand name">
        </div>
        <div class="form-group">
            <label for="price">Product Price:</label>
            <input type="number" step="0.01" class="form-control" name="priceProduct" id="price" placeholder="Enter price" required>
        </div>
        <div class="form-group">
            <label for="description">Product Description:</label>
            <input type="text" class="form-control" name="descriptionProduct" id="description" placeholder="Enter description">
        </div>
        <div class="form-group">
            <label for="quantity">Product Quantity:</label>
            <input type="number" class="form-control" name="quantityProduct" id="quantity" placeholder="Enter quantity" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Save</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
