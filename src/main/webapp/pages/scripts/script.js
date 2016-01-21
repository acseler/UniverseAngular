$(document).ready(function () {
    $("#regForm").hide();
    $("#enteringInfo").hide();
    $("#universeInfo").hide();
    //Register button handler
    $("#regButton").click(function () {
        $("#logForm").slideUp();
        $("#regForm").fadeIn();
        //$("#errorLogining").hide();
    });
    //Sign in button handler
    $("#signButton").click(function () {
        $("#logForm").slideDown();
        $("#regForm").fadeOut();
        $("#enteringLogin").slideDown();
        $("#enteringInfo").fadeOut();
        $("#universeInfo").fadeOut();
        $("#regLogin").val('');
        $("#regPassword").val('');
        $("#regPasswordConfirm").val('');
    });
    //Continie first step button handler
    $("#continueButtonFirstStep").click(function () {
        if (isEmpty($("#regLogin").val())) {
            $("#regLogin").parent().addClass("has-error");
        } else if (isEmpty($("#regPassword").val())) {
            $("#regLogin").parent().removeClass("has-error");
            $("#regPassword").parent().addClass("has-error");
        } else if (isEmpty($("#regPasswordConfirm").val())) {
            $("#regLogin").parent().removeClass("has-error");
            $("#regPassword").parent().removeClass("has-error");
            $("#regPasswordConfirm").parent().addClass("has-error");
        } else {
            if ($("#regPassword").val() == $("#regPasswordConfirm").val()) {
                $.post("/checkLogin/" + $("#regLogin").val() + ".json", function (data) {
                    if (data == "true") {
                        $("#enteringLogin").slideUp();
                        $("#universeInfo").fadeIn();
                    } else {
                        alert("Login " + $("#regLogin").val() + " is already exists.");
                    }
                });

            } else {
                alert("Incorrect password");
            }
        }
    });
    //Continie second step button handler
    $("#continueButtonSecondStep").click(function () {
        if (isEmpty($("#universeName").val())) {
            $("#universeName").parent().addClass("has-error");
        } else if (isEmpty($("#description").val())) {
            $("#universeName").parent().removeClass("has-error");
            $("#description").parent().addClass("has-error");
        } else {
            $("#description").parent().removeClass("has-error");
            $("#universeInfo").slideUp();
            $("#enteringInfo").fadeIn();
        }
    });

    //Back button handler
    $("#backButton").click(function () {
        $("#universeInfo").slideDown();
        $("#enteringInfo").fadeOut();
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









