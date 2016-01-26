/**
 * Created by boduill on 21.01.16.
 */
var app = angular.module('CreateYourUniverse', []);

app.controller('registrationController', ['$http', '$scope', '$q', function ($http, $scope, $q) {
    $scope.headerTemplate = {name: 'header', url: 'pages/header.html'};
    $scope.checkRegisterForm = function () {
        $("#regForm").submit(function (e) {
            e.preventDefault();
            var login = false;
            var password = false;
            var form = this;
            $http.get('/checkLogin/' + $("#regLogin").val()).success(function (data) {
                console.log("Response data " + data);
                if (data == "true") {
                    $("#regLogin").parent().removeClass("has-error");
                    $("#LoginWarning").fadeOut();
                    login = true;
                } else {
                    $("#regLogin").parent().addClass("has-error");
                    $("#LoginWarning").fadeIn();
                    login = true;
                }
                if ($("#regPassword").val() != $("#regPasswordConfirm").val()) {
                    $("#regPassword").parent().addClass("has-error");
                    $("#regPasswordConfirm").parent().addClass("has-error");
                    $("#PasswordWarning").fadeIn();
                    password = false;
                } else {
                    $("#regPassword").parent().removeClass("has-error");
                    $("#regPasswordConfirm").parent().removeClass("has-error");
                    $("#PasswordWarning").fadeOut();
                    password = true;
                }
                console.log("Login " + login);
                console.log("Password " + password);
                if (login && password) {
                    form.submit();
                }
            });


        });
    };




}]);



