$(document).ready(function(){
    // Event listener to redirect when .editButton clicked
    $(".editButton").on('click', function(e){
        console.log("editButton clicked!");
        window.location.replace(`/trips/${$(this).attr("data-id")}/edit`);
    });
});
$(document).ready(function(){
    // Event listener to redirect when .deleteButton clicked
    $(".editVehicleButton").on('click', function(e){
        console.log("editVehicleButton Clicked!");
        window.location.replace(`/vehicles/${$(this).attr("data-id")}/edit`);
    });
});