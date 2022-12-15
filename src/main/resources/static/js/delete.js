$(document).ready(function(){
    // Event listener to redirect when .deleteButton clicked
    $(".deleteButton").on('click', function(e){
        window.location.replace(`/trips/${$(this).attr("data-id")}/delete`);
    });
});
$(document).ready(function(){
    // Event listener to redirect when .deleteButton clicked
    $(".deleteVehicleButton").on('click', function(e){
        window.location.replace(`/vehicles/${$(this).attr("data-id")}/delete`);
    });
});