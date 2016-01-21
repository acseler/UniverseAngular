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
                </div>
                <div class="col-md-8">
                    <form action="/edit" method="post" role="form" id="editProfileForm" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="firstName" class="control-label">First name</label>
                            <input type="text" id="firstName" name="firstName" class="form-control" value="${account.firstName}"/>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="control-label">Last name</label>
                            <input type="text" id="lastName" name="lastName" class="form-control" value="${account.lastName}"/>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <label for="birthdayDay" class="control-label col-md-4">Birthday</label>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <input type="text" id="birthDayDay" name="birthDayDay"
                                           class="form-control" placeholder="Day"
                                           pattern="0[1-9]|[12][0-9]|3[01]"
                                           value="<fmt:formatDate pattern='dd' value='${account.birthDay}' />"/>
                                </div>
                                <div class="col-md-4"><input type="text" id="birthDayMounth" name="birthDayMounth"
                                                             class="form-control col-md-4" placeholder="Mounth"
                                                             pattern="0[1-9]|1[012]"
                                                             value="<fmt:formatDate pattern='MM' value='${account.birthDay}' />"/>
                                </div>
                                <div class="col-md-4"><input type="text" id="birthDayYear" name="birthDayYear"
                                                             class="form-control col-md-4"
                                                             placeholder="Year" pattern="(19|20)\d\d"
                                                             value="<fmt:formatDate pattern='yyyy' value='${account.birthDay}' />"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="control-label margin-10">E-mail</label>
                            <input type="text" id="eMail" name="eMail" class="form-control"
                                   pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}^$|^.*@.*\..*$" value="${account.eMail}"/>
                        </div>
                        <div class="form-group">
                            <label for="profession" class="control-label">Profession</label>
                            <input type="text" id="profession" name="profession" class="form-control"
                                    value="${account.profession}"/>
                        </div>
                        <div class="form-group">
                            <label for="hobbies" class="control-label">Hobbies</label>
                            <input type="text" id="hobbies" name="hobbies" class="form-control"
                                   value="${account.hobbies}"/>
                        </div>
                        <div class="form-group">
                            <label for="avatar" class="control-label">Avatar</label>
                            <input type="file" id="avatar" name="avatar" class="form-control"/>
                        </div>
                        <button type="submit" class="col-md-offset-2 col-md-8 btn btn-primary margin-10">Save
                        </button>
                    </form>
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

