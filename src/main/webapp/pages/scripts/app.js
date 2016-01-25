/**
 * Created by boduill on 21.01.16.
 */
var app = angular.module('CreateYourUniverse', []);

app.controller('registrationController', ['$http', '$scope', function ($http, $scope) {
    $scope.headerTemplate = {name: 'header', url: 'pages/header.html'};
    $scope.checkRegisterForm = function() {
        $http.get('http://localhost:8080/checkLogin/' + $("#regLogin").val()).success(function(data) {
            console.log(data);
            if(data == "true") {
                console.log("if " + data);
                $("#regLogin").parent().removeClass("has-error");
                $("#LoginWarning").fadeOut();
            } else {
                console.log("else " + data);
                $("#regLogin").parent().addClass("has-error");
                $("#LoginWarning").fadeIn();
            }
        });
        if ($("#regPassword").val() != $("#regPasswordConfirm").val()) {
            $("#regPassword").parent().addClass("has-error");
            $("#regPasswordConfirm").parent().addClass("has-error");
            $("#PasswordWarning").fadeIn();
        } else {
            $("#regPassword").parent().removeClass("has-error");
            $("#regPasswordConfirm").parent().removeClass("has-error");
            $("#PasswordWarning").fadeOut();
        }
    };

}]);



