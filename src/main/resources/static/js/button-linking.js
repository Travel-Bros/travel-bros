// THIS LINKS TO REGISTER //
$(document).ready(function(){
    // Event listener to redirect to new page when .commentsButton clicked
    $("#registerButton").on('click', function(e){
        // window.location.replace(`/comments/${$(this).attr("data-id")}/create`);
        // alert("YOr");
        window.location.href = "/register";
    });
});

// THIS LINKS TO LOGIN //
$(document).ready(function () {
    $("#signInButton").on('click', function (e){
        // alert("YwhAT?");
        window.location.href = "/login";
    });
});

// THIS LINKS TO PROFILE //
$(document).ready(function () {
    $("#profileButton").on('click', function (e){
        window.location.replace(`/profile`);
        // alert("profile coming soon");
    });
});
// THIS LINKS TO HOME //
$(document).ready(function () {
    $("#homeButton").on('click', function (e){
        window.location.replace(`/dashboard`);
        // alert("profile coming soon");
    });
});
// THIS LINKS TO TRIPS //
$(document).ready(function () {
    $("#tripsButton").on('click', function (e){
        // alert("trips coming soon!");
        window.location.href = "/trips/create";
    });
});
// THIS LINKS TRIPS/CREATE BUTTON //
$(document).ready(function () {
    $(".addTripButton").on('click', function (e) {
        window.location.href = "/trips/create";
    })
});
// THIS LINKS TO VEHICLES //
$(document).ready(function () {
    $("#vehicleButton").on('click', function (e){
        window.location.href = "/vehicles";
    });
});

// THIS LINKS ADD VEHICLE BUTTON TO CREATE VEHICLE FORM
$(document).ready(function () {
    $(".add-new-vehicle").on('click', function (e) {
        window.location.replace("/vehicles/create");
    });
});

    // This makes the cancel input take you back to dashboard
    $(document).ready(function () {
        $("#cancel-vehicle").on('click', function (e) {
            window.location.replace("/dashboard");
        });
    });

// // THIS LINKS TO SETTINGS //
// $(document).ready(function () {
//     $("#settingsButton").on('click', function (e){
//         window.location.href = "/settings";
//     });
// });
// THIS LINKS TO LOGOUT //
$(document).ready(function () {
    $("#logoutButton").on('click', function (e) {
        window.location.href = "/logout";
    });
});

$(document).ready(function () {
    $(".addTripButton").on('click', function (e) {
        window.location.href = "/trips/create";
    });
});

// $(document).ready(function () {
//     $("#submit-to-calculator-btn").on('click', function (e) {
//         window.location.href = "/budget/calculator";
//     });
// });


