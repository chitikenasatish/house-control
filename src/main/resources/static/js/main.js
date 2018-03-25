/**
 * Generate home control dashboard
 */

'use strict';

var HOME_CONTROL_DASHBOARD = (function($) {

  var module;

  //initial set up constant for type of home needed to be automated
  var LIGHT = 'light';
  var CURTAIN = 'curtain';
  var TEMPERATURE = 'temp';

  /**
   * Function calling to home control data on page load
   * @method init
   */
  function init() {
    $.get('/v1/rooms', function(data) {
      console.log(data);
      var arr = [];
      // Grab the template script
        var theTemplateScript = $("#room-template").html();
     // Compile the template
        var theTemplate = Handlebars.compile(theTemplateScript);
      for (var key in data.Rooms) {
        var obj = data.Rooms[key];
        var theCompiledHtml = theTemplate(obj);
        $('#control-room-panel').append(theCompiledHtml).append("<br/>");
        $.event.trigger({
               type:    "TempChangeEvent",
               message: "Initialize TempColor",
               roomid:    obj.id,
               color : obj.temperature
             });
  }

      $('input').on('change', handleOnChange);

    });
  }


  /**
   * Helper function to handle input onchange
   * @method handleOnChange
   */
  function handleOnChange(e) {
    var target = $(e.target);
    var type = target.data('type'); //type of home automation
    var id = $(e.target).parent().parent().attr('id'); //type id
    var lightprop = $(e.target).parent().children('[type=checkbox]')[0].checked;
    var curtainprop = $(e.target).parent().children('[type=checkbox]')[1].checked;
    if (type === LIGHT || type === CURTAIN) {
      HOME_HANDLER.handleLightAndCurtain(id ,lightprop,curtainprop);
    }else if(type= TEMPERATURE){
        var temp = $(e.target).parent().children('[type=range]').val();
        handleTemp(id, temp);
    }
  }

  /**
   * Helper function to handle temperature change
   * @method handleTemp
   */
  function handleTemp(id , temp) {
    HOME_HANDLER.handleTemperature(id, temp);
  }

  /**
   * Function being called on DOM ready
   * @method onReady
   */
  function onReady(themeModule) {
    module = themeModule || this;
    init();
  }
  /**
   * Return global function
   */
  return {
    onReady: onReady
  };

}(jQuery));

window.onload = function() {
  var obj = document.getElementById("floor-plan");
  obj.onload = HOME_CONTROL_DASHBOARD.onReady();
};
