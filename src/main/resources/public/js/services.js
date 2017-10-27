angular.module('app.services', []).factory('DomainObject', function($resource) {
  return $resource('/api/v1/domainobjects/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
