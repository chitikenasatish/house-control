(function(window,$) {

$(document).on("HouseLightAndCurtainEvent", function (evt) {
        var element = document.getElementById('floor-plan').contentDocument.getElementById(evt.roomid);
        fillRoomColor(element);
        element.style.opacity = evt.opacity;
});
$(document).on("TempChangeEvent", function (evt) {
        var element = document.getElementById('floor-plan').contentDocument.getElementById(evt.roomid);
        //hsl(0, 100%, 97%)
        var lightness = 100-evt.color;
        element.style.fill = 'hsl(0, 100%, '+lightness+'%)';
});

  //Check if room color is transparent, turn color on before room action
  function fillRoomColor(element) {
    var bg = element.style.fill || '';
    if (bg === '' || bg === 'transparent') {
      element.style.fill = '#ffff32';
    }
  }



})(window,jQuery)