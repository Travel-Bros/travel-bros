$(document).ready(function(){
    // Event listener to redirect to new page when .commentsButton clicked
    $("#registerButton").on('click', function(e){
        // window.location.replace(`/comments/${$(this).attr("data-id")}/create`);
        // alert("YOr");
        window.location.href = "/register";
    });
});

$(document).ready(function () {
    $("#signInButton").on('click', function (e){
        // alert("YwhAT?");
        window.location.href = "/login";
    });
});

$(document).ready(function () {
    $("#profileButton").on('click', function (e){
        window.location.replace(`/profile/${$(this).attr("data-id")}`);
        // alert("profile coming soon");
    });
});

$(document).ready(function () {
    $("#tripsButton").on('click', function (e){
        alert("trips coming soon!");
    });
});

$(document).ready(function () {
    $("#vehicleButton").on('click', function (e){
        alert("vehicles!");
    });
});

$(document).ready(function () {
    $("#settingsButton").on('click', function (e){
        alert("settings!");
    });
});

$(document).ready(function () {
    $("#logoutButton").on('click', function (e) {
        window.location.href = "/logout";
    })
})