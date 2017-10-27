angular.module('app.controllers', []).controller('DomainobjectListController', function($scope, $state, popupService, $window, DomainObject) {
  $scope.domainobjects = DomainObject.query(); //fetch all domainobjects. Issues a GET to /api/vi/domainobjects

  $scope.deleteDomainObject = function(domainobject) { // Delete a DomainObject. Issues a DELETE to /api/v1/domainobjects/:id
    if (popupService.showPopup('Really delete this?')) {
    	domainobject.$delete(function() {
        $scope.domainobjects = DomainObject.query(); 
        $state.go('domainobjects');
      });
    }
  };
}).controller('DomainobjectViewController', function($scope, $stateParams, DomainObject) {
  $scope.domainobject = DomainObject.get({ id: $stateParams.id }); //Get a single domainobject.Issues a GET to /api/v1/domainobjects/:id
}).controller('DomainobjectCreateController', function($scope, $state, $stateParams, DomainObject) {
  $scope.domainobject = new DomainObject();  //create new domainobject instance. Properties will be set via ng-model on UI

  $scope.addDomainObject = function() { //create a new domainobject. Issues a POST to /api/v1/domainobjects
    $scope.domainobject.$save(function() {
      $state.go('domainobjects'); // on success go back to the list i.e. domainobjects state.
    });
  };
}).controller('DomainobjectEditController', function($scope, $state, $stateParams, DomainObject) {
  $scope.loadDomainObject = function() { //Issues a GET request to /api/v1/domainobjects/:id to get a domainobject to update
    $scope.domainobject = DomainObject.get({ id: $stateParams.id });
  };

  $scope.loadDomainObject(); // Load a domainobject which can be edited on UI
  
  $scope.updateDomainObject = function() { //Update the edited domainobject. Issues a PUT to /api/v1/domainobjects/:id
	    $scope.domainobject.$update(function() {
	      $state.go('domainobjects'); // on success go back to the list i.e. domainobjects state.
	    });
	  };

});
