/**
 * Handle home control dashboard
 */

'use strict';

var HOME_HANDLER = (function($) {

  var module;
  /**
   * Function handle light in the room
   * @method handleLight
   */
  function handleLightAndCurtain(id, lightStatus, curtainStatus) {
    var updateurl ="/v1/rooms/"+id
    $.ajax({
        url: updateurl,
        type: 'PUT',
        contentType: "application/json",
        data:   "{\"light\" : "+lightStatus+",\"curtain\" : "+curtainStatus+"}",
      })
      .done(function(data) {
         $.event.trigger({
           type:    "HouseLightAndCurtainEvent",
           message: "Light and Curtain Event occured",
           roomid:    id,
           opacity : data.opacity
         });
       })
      .fail(function( jqXHR, textStatus, errorThrown ) {
       //TODO
    });
  }


  /**
   * Function handle temperature in the room
   * @method handleCurtain
   */
  function handleTemperature(id , temp) {
    var updateurl ="/v1/rooms/"+id
      $.ajax({
          url: updateurl,
          type: 'PUT',
          contentType: "application/json",
          data:   "{\"temperature\" : "+temp+"}",
        })
        .done(function(data) {
           $.event.trigger({
                   type:    "TempChangeEvent",
                   message: "Temp ChangeEvent occured",
                   roomid:    id,
                   color : data.color
                 });
        })
        .fail(function( jqXHR, textStatus, errorThrown ) {
         //TODO
      });
  }
    Handlebars.registerHelper("checkedIf", function (condition) {
        return (condition) ? "checked" : "";
    });
  return {
    handleLightAndCurtain: handleLightAndCurtain,
    handleTemperature: handleTemperature
  };

}(jQuery));
