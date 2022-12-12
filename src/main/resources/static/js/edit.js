$(document).ready(function(){
    // Event listener to redirect when .editButton clicked
    $(".editButton").on('click', function(e){
        window.location.replace(`/trips/${$(this).attr("data-id")}/edit`);
    });
});