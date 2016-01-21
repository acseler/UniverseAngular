/**
 * Created by bod on 13.01.2016.
 */


var account;
var accId;
var friendId;
var setModalFields = function (accountJson) {
    setAccount(accountJson);
    $("#messageTo").text(account.firstName + " " + account.lastName);
};

function setAccount(accountJson) {
    console.log("Account JSON " + accountJson);
    account = accountJson;
};

function setDeleteFriendId(accId, friendId) {
    this.accId = accId;
    this.friendId = friendId;
    console.log(this.accId);
    console.log(this.friendId);
};

$(document).ready(function () {
    $("#send").click(function () {
        if (isEmpty($("#message").val())) {
            $("#message").parent().addClass("has-error");
        } else {
            $("#message").parent().removeClass("has-error");
            $.ajax({
                method: "POST",
                url: "/message/" + account.id,
                data: {message: $("#message").val()}
            });
            $('#SendMessageDialog').modal('hide');
            $('body').removeClass('modal-open');
            $('.modal-backdrop').remove();
            $("#messageTo").text("");
            $("#message").val("");
        }

    });

    $("#DeleteFriendButton").click(function () {
        $.ajax({
            method: "POST",
            url: "/friends/" + accId + "/" + friendId
        });
        $('#DeleteFriendDialog').modal('hide');
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
        location.reload();
    });

    $("#cancelDeleteFriend").click(function () {
        $('#DeleteFriendDialog').modal('hide');
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
    });

    var isEmpty = function (value) {
        if (!value) {
            return true;
        } else if (!value.trim()) {
            return true;
        } else {
            return false;
        }
    };
});
