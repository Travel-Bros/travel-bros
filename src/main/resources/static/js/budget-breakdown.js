$(document).ready(function(){
    // Event listener to redirect when .editButton clicked
    $(".budgetBreakdown").on('click', function(e){
        console.log("budgetBreakdown clicked!");
        window.location.replace(`/trips/${$(this).attr("data-id")}/calculator`);
    });
});
// $(document).ready(function(){
//     // Event listener to redirect when .deleteButton clicked
//     $(".editVehicleButton").on('click', function(e){
//         console.log("editVehicleButton Clicked!");
//         window.location.replace(`/vehicles/${$(this).attr("data-id")}/edit`);
//     });
// });