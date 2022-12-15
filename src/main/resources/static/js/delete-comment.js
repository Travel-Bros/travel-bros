$(document).ready(function(){
    // Event listener to redirect when .deleteButton clicked
    $(".deleteCommentButton").on('click', function(e){
        window.location.replace(`/comments/${$(this).attr("data-id")}/delete`);
    });
});