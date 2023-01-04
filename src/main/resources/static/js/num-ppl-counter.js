

let numberOfPeopleDiv = document.getElementById("numberOfPeople");

let numberOfPeople = Number(numberOfPeopleDiv.innerText);
console.log(numberOfPeople);



//event listener for increase button attempt

// $(document).ready(function(){
//     // Event listener to increment when .increasePeople button is clicked
//     $(".incPplButton").on('click', function(e){
//             numberOfPeople ++;
//             numberOfPeopleDiv.innerText = numberOfPeople;
//         // window.location.replace(`/trips/${$(this).attr("data-id")}/delete`);
//     });
// });


function decreasePeople(){
    if (numberOfPeople <= 1){
        alert("You can't go below 1");
        return
    }
    numberOfPeople --;
    numberOfPeopleDiv.innerText = numberOfPeople;
}

function increasePeople() {
    numberOfPeople ++;
    numberOfPeopleDiv.innerText = numberOfPeople;
}
