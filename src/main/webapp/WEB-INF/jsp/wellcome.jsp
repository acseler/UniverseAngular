<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Wellcome to Create Your Universe</title>
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
        <h1 class="h1 text-center">Wellcome to Create your Universe</h1>

        <div class="col-md-offset-4 col-md-4">
            <c:if test="${not empty errorLogining}">
                <div id="errorLogining" class="col-md-12">
                    <div class="alert alert-warning text-center margin-bottom-0">
                            ${errorLogining}
                    </div>
                </div>
            </c:if>
            <form role="form" id="logForm" method="post" action="home">
                <div class="form-group">
                    <div class="col-md-12">
                        <input type="text" class="form-control margin-10" id="login" name="auLogin"
                               placeholder="Enter your login"/>
                        <input type="password" id="password" name="auPassword" class="form-control margin-10"
                               placeholder="Enter your password"/>
                        <button type="submit" class="btn btn-primary col-md-12 margin-10">Sign in</button>
                        <div class="btn btn-default col-md-12 margin-10" id="regButton">
                            Registration
                        </div>
                    </div>
                </div>
            </form>
            <form role="form" id="regForm" method="post" enctype="multipart/form-data">
                <div class="col-md-12">
                    <div id="enteringLogin">
                        <div>
                            <input type="text" class="form-control margin-10" id="regLogin" name="login"
                                   placeholder="Enter your login" required/>
                        </div>
                        <div>
                            <input type="password" class="form-control margin-10" id="regPassword" name="password"
                                   placeholder="Enter your password" required/>
                        </div>
                        <div>
                            <input type="password" class="form-control margin-10" id="regPasswordConfirm"
                                   name="regPasswordConfirm" placeholder="Confirm your password" required/>
                        </div>
                        <button type="button" class="col-md-12 btn btn-primary margin-10"
                                id="continueButtonFirstStep">
                            Continue
                        </button>
                    </div>
                    <div id="universeInfo">
                        <div>
                            <input type="text" class="form-control margin-10" id="universeName" name="universeName"
                                   placeholder="Universe name"/>
                        </div>
                        <div>
                            <textarea class="form-control margin-10" id="description" name="description"
                                      placeholder="Short description"></textarea>
                        </div>
                        <button type="button" class="col-md-12 btn btn-primary margin-10"
                                id="continueButtonSecondStep">Continue
                        </button>
                    </div>
                    <div id="enteringInfo">
                        <input type="text" class="form-control margin-10" id="firstName" name="firstName"
                               placeholder="First name" required/>
                        <input type="text" class="form-control margin-10" id="lastName" name="lastName"
                               placeholder="Last name" required/>
                        <label for="birthDayDay" class="control-label margin-10">Birthday</label>

                        <%--<div class="row">--%>
                            <%--<div class="col-md-4">--%>
                                <input type="text" class="form-control margin-10" id="birthDayDay" name="birthDayDay"
                                       placeholder="Day" pattern="0[1-9]|[12][0-9]|3[01]" required/>
                            <%--</div>--%>
                            <%--<div class="col-md-4">--%>
                                <input type="text" class="form-control margin-10" id="birthDayMounth" name="birthDayMounth"
                                       placeholder="Mounth" pattern="0[1-9]|1[012]" required/>
                            <%--</div>--%>
                            <%--<div class="col-md-4">--%>
                                <input type="text" class="form-control margin-10" id="birthDayYear" name="birthDayYear"
                                       placeholder="Year" pattern="(19|20)\d\d" required/>
                            <%--</div>--%>
                        <%--</div>--%>
                        <input type="text" class="form-control margin-10" id="eMail" name="eMail"
                               placeholder="E-mail" pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}^$|^.*@.*\..*$" required/>
                            <textarea class="form-control margin-10" id="hobbies" name="hobbies"
                                      placeholder="Hobbies" required></textarea>
                        <input type="text" class="form-control margin-10" id="profession" name="profession"
                               placeholder="Profession" required/>
                        <input type="file" class="form-control margin-10" id="avatar" name="avatar" required/>
                        <button type="button" class="col-md-12 btn btn-primary margin-10"
                                id="backButton">
                            Back
                        </button>
                        <button type="submit" class="col-md-12 btn btn-primary margin-10" id="registrationFinal">
                            Register
                        </button>
                    </div>
                    <div class="btn btn-default col-md-12 margin-10" id="signButton">
                        Sign in
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/pages/scripts/jquery-1.11.3.min.js"></script>
<script src="/pages/scripts/bootstrap.min.js"></script>
<script src="/pages/scripts/script.js"></script>
</body>
</html>