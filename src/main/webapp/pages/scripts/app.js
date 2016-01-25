/**
 * Created by boduill on 21.01.16.
 */
var app = angular.module('CreateYourUniverse', []);

app.controller('registrationController', ['$scope', function ($scope) {
    $scope.headerTemplate = {name: 'header', url: 'pages/header.html'};
}]);

