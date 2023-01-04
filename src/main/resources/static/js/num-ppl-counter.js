$(function() {

    let numberOfPeopleDiv = document.getElementById("numberOfPeople");

    let numberOfPeople = Number(numberOfPeopleDiv.innerText);
    console.log(numberOfPeople);


//event listener for increase button attempt

    // $(document).ready(function () {
        // Event listener to increment when .increasePeople button is clicked
        $(".incPplButton").on('click', function (e) {
            numberOfPeople++;
            numberOfPeopleDiv.innerText = numberOfPeople;
        });
        $(".decPplButton").on('click', function (e) {
            if (numberOfPeople <=1){
                alert("You must have at least one person in your party");
                return;
            }
            numberOfPeople--;
            numberOfPeopleDiv.innerText = numberOfPeople;
        });


});