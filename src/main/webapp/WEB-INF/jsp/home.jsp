<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
    <link rel="stylesheet" href="/pages/css/bootstrap.min.css">
    <link rel="stylesheet" href="/pages/css/style.css"/>
    <meta name="viewport" content="width=device-width,
									initial-scale=1.0,
									maximum-scale=1.0,
									user-scalable=no">
</head>

<body>

<div class="container">
<jsp:include page="patterns/header.jsp"/>
    <div class="row">
        <jsp:include page="patterns/navigation.jsp"/>
        <div class="col-lg-8 col-md-8 margin-10">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <img src="${account.base64}" alt="Avatar" class="img-responsive img-rounded"/>
                    <a href="/edit"><button type="button" class="col-md-12 btn btn-default margin-10">Edit profile</button></a>
                </div>
                <div class="col-md-8">
                    <h3 class="h3">${account.firstName} ${account.lastName}</h3>
                </div>
                <div class="col-md-8">
                    <p>Birthday : <fmt:formatDate type="date" value="${account.birthDay}"/></p>
                    <p>E-mail : ${account.eMail}</p>
                    <p>Hobbies : ${account.hobbies}</p>
                    <p>Profession : ${account.profession}</p>
                    <p>Universe name : ${account.universe.unverseName}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/pages/scripts/jquery-1.11.3.min.js"></script>
<script src="/pages/scripts/bootstrap.min.js"></script>
<script src="/pages/scripts/script.js"></script>
</body>
</html>
