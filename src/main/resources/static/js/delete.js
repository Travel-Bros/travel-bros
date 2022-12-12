$(document).ready(function(){
    // Event listener to redirect when .deleteButton clicked
    $(".deleteButton").on('click', function(e){
        window.location.replace(`/trips/${$(this).attr("data-id")}/delete`);
    });
});