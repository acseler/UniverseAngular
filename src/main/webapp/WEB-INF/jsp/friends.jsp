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
            <div class="row border-of-entity">
                <div class="h4 text-center">You have ${friendList.size()} friends</div>
            </div>

            <c:forEach items="${friendList}" var="friend">
                <div class="row">
                    <div class="border-of-entity col-md-12">
                        <div class=" col-md-3 padding-0">
                            <img src="${friend.base64}" alt="" width="128" height="128"
                                 class="img-responsive img-rounded left"/>
                        </div>
                        <div class="col-md-5">
                            <h3 class="text-left margin-0">${friend.firstName} ${friend.lastName}</h3>

                            <div class="h5"> ${friend.profession}</div>
                            <div class="h5"> ${friend.hobbies}</div>
                            <div class="h5"><fmt:formatDate value="${friend.birthDay}" type="Date"/></div>
                        </div>
                        <div class="col-md-4">
                            <button type="button" class="col-md-12 btn btn-primary" data-toggle="modal"
                                    data-target="#SendMessageDialog"
                                    onclick=setModalFields(${friend.json})>
                                Send message
                            </button>
                            <button type="button" class="col-md-12 btn btn-default margin-10" data-toggle="modal"
                                    data-target="#DeleteFriendDialog"
                                    onclick="setDeleteFriendId(${account.id} ,${friend.id})">
                                Delete from friends
                            </button>
                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>
    <!-- Modal send message -->
    <div class="modal fade" id="SendMessageDialog" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Send message</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">
                            <label for="messageTo">Send to : </label>

                            <div class="h4" id="messageTo"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label for="message" class="control-label">Message</label>
                            <textarea class="form-control" id="message"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <input type="button" id="send" class="form-control btn btn-primary" value="Send"/>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- Modal delete friend-->
    <div class="modal fade" id="DeleteFriendDialog" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><span class="text-center">Are you sure?</span></h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-offset-2 col-md-8">
                            <div class="row">
                                <button type="button" class="col-md-5 btn btn-primary" id="DeleteFriendButton">Delete</button>
                                <div class="col-md-2"></div>
                                <button type="button" class="col-md-5 btn btn-default" id="cancelDeleteFriend">Cancel</button>
                            </div>

                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="/pages/scripts/jquery-1.11.3.min.js"></script>
<script src="/pages/scripts/bootstrap.min.js"></script>
<script src="/pages/scripts/friends.js"></script>
</body>
</html>
