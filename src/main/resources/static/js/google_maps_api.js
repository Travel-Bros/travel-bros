


///////////////////////////////////////////////
///  Getting the values from the input  //////
//////////////////////////////////////////////

function useState(defaultValue) {
    // 👆🏻We create a function useState with a default value
    let value = defaultValue;
    // 👆🏻We create a local variable value = defaultValue
    function getValue() {
        // 👆🏻We create a function getValue to get the value that return the value
        return value;
    }
    function setValue(newValue) {
        // 👆🏻We create a function to set the value with parameter newValue
        value = newValue; // 👈🏻 We change the value for newValue
        //   render(); // 👈🏻We run the render function on our app
    }
    return [getValue, setValue];
    // 👆🏻We return an array with the value and the function
}

///////////////////////////////////////////////
//////////// Set up for useState /////////////
/////////////////////////////////////////////

const [getvalue, setValue] =useState({
    startLocation: "",
    endLocation: "",
    tripDistance: 0,
    tripTime: "",
})

const locationsFromUser = getvalue()
console.log(locationsFromUser)

/////////////////////////////////////////////
///////////  Event handler for Form ////////
///////////////////////////////////////////


// document.addEventListener('DOMContentLoaded', function () {
//
//     const startInput = document.querySelector('#vehicle-make')
//     const endInput = document.querySelector('#endLocation')
//
//     startInput.addEventListener('keyup',function(e){
//         e.preventDefault
//         let startValue;
//         startValue = e.target.value;
//         locationsFromUser.startLocation = startValue;
//         setValue(locationsFromUser)
//         console.log(getvalue())
//     });
//
//     endInput.addEventListener('keyup',function(e){
//         e.preventDefault
//         let endValue;
//         endValue = endingLoc;
//         locationsFromUser.endLocation = endValue;
//         setValue(locationsFromUser)
//         console.log(getvalue())
//     });
// })

// const input = document.querySelector('input');
// function onChange(e){
//     e.prevnt.defaultValue
// const startInput = document.getElemnetById('startLocation')
// const endInput = document.getElemnetById('endLocation')



// }
// const startInput = document.getElementById('startLocation')
// startInput.addEventListener('onChange', updateForm);




// function updateForm(e){

//     function updateObject() {
//         return {
//             ...locationsFromUser,
//             [e.target.id]: e.target.value
//         }
//     }

//     setValue(updateObject)

//     console.log(getvalue())
// }



///////////////////////////////////////////////
// this is how we intialize our Google maps ///
///////////////////////////////////////////////

let map;

function initMap() {

    map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 39.056, lng:  -95.695 },
        zoom: 4,
    });

    function clearMap() {
        map.clear();
    }

    /////////////////////////////////////////////////////////
    ////////////////  Driving distance API /////////////////
    ///////////////////////////////////////////////////////


    const service = new google.maps.DistanceMatrixService();

    let routes = [];
    const directionsService = new google.maps.DirectionsService();
    const button = document.getElementById("planYourTrip");
    button.addEventListener("click", (e)=>{
        e.preventDefault

        clearMap();

        // object made for saving state
        let locationInfo = getvalue()
        console.log(locationInfo)
        service.getDistanceMatrix(
            {
                origins:[locationInfo.startLocation],

                destinations:[locationInfo.endLocation],
                // "100 Congress Ave., Austin, TX 78701"
                travelMode: "DRIVING",
            }, callback)

        function callback(response, status) {
            console.log(response)

            if (status == 'OK') {

                //////////////////// Setting the trip distance, and trip time  ///////////////////
                locationInfo.tripDistance = response.rows[0].elements[0].distance
                    .value;
                locationInfo.tripTime = response.rows[0].elements[0].duration
                    .text;

                ////////////////////  Setting javascript object  ///////////////////////
                setValue(locationInfo)
                console.log(getvalue())

                ////////////  Setting the value of the travel input and trip distance //////////
                console.log(locationInfo)
                let travelInput = document.querySelector('#totalDistance');
                travelInput.value = locationInfo.tripDistance;


                //////////////  Display the result on the page  /////////////////
                let miles = ((locationInfo.tripDistance/1000)/1.609)
                let milesRound = miles.toFixed(1)
                document.getElementById("yourTripDistance").innerHTML = `Your trip distance: ${milesRound} mi`;
                document.getElementById("yourTravelDistance").innerHTML = `Your trip will take: ${locationInfo.tripTime}`;

                // var origins = response.originAddresses;
                // var destinations = response.destinationAddresses;

                // for (var i = 0; i < origins.length; i++) {
                //     var results = response.rows[i].elements;
                //     for (var j = 0; j < results.length; j++) {
                //         var element = results[j];
                //         var distance = element.distance.text;
                //         var duration = element.duration.text;
                //         locationInfo.tripDistance = distance;
                //         locationInfo.tripTime = duration;
                //         setValue(locationInfo)
                //         var from = origins[i];
                //         var to = destinations[j];
                //      }
                //  }

            ///////////////////////////////////////////////////////////
            ////////////  Getting your array of places  ///////////////
            ///////////////////////////////////////////////////////////
            }
        }

        console.log(getvalue());
        let directionsService = new google.maps.DirectionsService();
        let directionsDisplay = new google.maps.DirectionsRenderer({
            map: map,
        });

        // get route
        directionsService.route({
            origin: locationInfo.startLocation,
            destination: locationInfo.endLocation,
            travelMode: google.maps.TravelMode.DRIVING
            // see more attributes at https://developers.google.com/maps/documentation/javascript/directions

        }, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);

                /////////////////////////////////////////////
                ///////////  Here is the distance //////////
                ///////////////////////////////////////////

                var routes = response.routes[0].legs[0].steps;
                console.log(routes);

                var previousStop = routes[0].start_location;
                console.log(previousStop);

                var range = 5000; // maximum range in meters

                for (var i = 1; i < routes.length; i++) {
                    var currentStop = routes[i].start_location;
                    var distance = google.maps.geometry.spherical.computeDistanceBetween(previousStop, currentStop);
                    if (distance <= range) {
                        console.log(currentStop);
                        console.log(distance);
                    }
                    previousStop = currentStop;
                }


            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });






    })

    ////////////////////////////////////////////////////////
    ///////////////  Auto complete  ////////////////////////
    ///////////////////////////////////////////////////////


    const center = { lat: 50.064192, lng: -130.605469 };
    const defaultBounds = {
        north: center.lat + 0.1,
        south: center.lat - 0.1,
        east: center.lng + 0.1,
        west: center.lng - 0.1,
    };

    const input = document.getElementById("startLocation");
    const options = {
        bounds: defaultBounds,
        componentRestrictions: { country: "us" },
        fields: ["address_components", "geometry", "icon", "name"],
        strictBounds: false,
        types: ["establishment"],
    };
    const autocomplete = new google.maps.places.Autocomplete(input, options);
    autocomplete.setFields(["place_id", "geometry", "name"]);
    autocomplete.setComponentRestrictions({
        country: ["us"],
    });


    /////////////////////////////////////////////////////////////////////////
    ////////////////////// Auto Complete for the start point ///////////////
    ///////////////////////////////////////////////////////////////////////
    google.maps.event.addListener(autocomplete, "place_changed", () => {

        //////////  How we get the place obbject from google /////////////
        const place = autocomplete.getPlace();

        ///////////  getting the array of address parts /////////////////
        let arrayPlace = [];
        arrayPlace = place.address_components
        let wholeAddress="";

        ////////////// Putting all the address component together //////////
        arrayPlace.forEach((info, index)=>{
            if(index < arrayPlace.length ){
                wholeAddress = wholeAddress + info.long_name + " ";
            } else{
                wholeAddress = wholeAddress + info
            }
        })

        // setting the useState object //
        locationsFromUser.startLocation = wholeAddress;
        setValue(locationsFromUser)
        console.log(getvalue())
    })



    /////////////////////////////////////////////////////////////////////////
    ////////////////////// Auto Complete for the end point /////////////////
    ///////////////////////////////////////////////////////////////////////


    const endInput = document.getElementById("endLocation");
    const autocomplete2 = new google.maps.places.Autocomplete(endInput, options);
    autocomplete2.setFields(["place_id", "geometry", "name"]);
    autocomplete2.setComponentRestrictions({
        country: ["us"],
    });

    google.maps.event.addListener(autocomplete2, "place_changed", () => {

        //////////  How we get the place obbject from google /////////////
        const place = autocomplete2.getPlace();

        ///////////  getting the array of address parts /////////////////
        let arrayPlace = [];
        arrayPlace = place.address_components
        let wholeAddress="";

        ////////////// Putting all the address component together //////////
        arrayPlace.forEach((info, index)=>{
            if(index < arrayPlace.length ){
                wholeAddress = wholeAddress + info.long_name + " ";
            } else{
                wholeAddress = wholeAddress + info
            }
        })

        // setting the useState object //
        locationsFromUser.endLocation = wholeAddress;
        setValue(locationsFromUser)
        console.log(getvalue())
    })


    ///////////////////////////////////////////////////
    //////////////  When the code loads  //////////////
    ///////////////////////////////////////////////////

    document.addEventListener('DOMContentLoaded', function () {

        const startInput = document.querySelector('#startLocation')
        const endInput = document.querySelector('#endLocation')

        startInput.addEventListener('keyup',function(e){
            e.preventDefault
            let startValue;
            startValue = e.target.value;
            locationsFromUser.startLocation = startValue;
            setValue(locationsFromUser)
            console.log(getvalue())
        });

        endInput.addEventListener('keyup',function(e){
            e.preventDefault
            let endValue;
            endValue = endingLoc;
            locationsFromUser.endLocation = endValue;
            setValue(locationsFromUser)
            console.log(getvalue())
        });

        window.addEventListener('load', function (e) {
            e.preventDefault()

            var startPlace = document.querySelector("#startingLocation").innerHTML;
            var endPlace = document.querySelector("#endingLocation").innerHTML;
            let locationInfo= {};

            function setStartLocation() {
                    let startValue;
                    startValue = startPlace;
                    locationsFromUser.startLocation = startValue;
                    setValue(locationsFromUser)

                    let endValue;
                    endValue = endPlace;
                    locationsFromUser.endLocation = endValue;
                    setValue(locationsFromUser)
                    console.log(getvalue())

                    locationInfo = getvalue()
                    console.log(locationsFromUser)
                }



            setStartLocation();
            // object made for saving state


            console.log(locationsFromUser)
            service.getDistanceMatrix(
                {
                    origins: [locationInfo.startLocation],

                    destinations: [locationInfo.endLocation],
                    // "100 Congress Ave., Austin, TX 78701"
                    travelMode: "DRIVING",
                }, callback)

            function callback(response, status) {
                console.log(response)

                if (status == 'OK') {

                    //////////////////// Setting the trip distance, and trip time  ///////////////////
                    locationInfo.tripDistance = response.rows[0].elements[0].distance
                        .value;
                    locationInfo.tripTime = response.rows[0].elements[0].duration
                        .text;

                    ////////////////////  Setting javascript object  ///////////////////////
                    setValue(locationInfo)
                    console.log(getvalue())

                    ////////////  Setting the value of the travel input and trip distance //////////
                    console.log(locationInfo)
                    let travelInput = document.querySelector('#totalDistance');
                    travelInput.value = locationInfo.tripDistance;


                    //////////////  Display the result on the page  /////////////////
                    let miles = ((locationInfo.tripDistance / 1000) / 1.609)
                    let milesRound = miles.toFixed(1)
                    document.getElementById("yourTripDistance").innerHTML = `Your trip distance: ${milesRound} mi`;
                    document.getElementById("yourTravelDistance").innerHTML = `Your trip will take: ${locationInfo.tripTime}`;

                    // var origins = response.originAddresses;
                    // var destinations = response.destinationAddresses;

                    // for (var i = 0; i < origins.length; i++) {
                    //     var results = response.rows[i].elements;
                    //     for (var j = 0; j < results.length; j++) {
                    //         var element = results[j];
                    //         var distance = element.distance.text;
                    //         var duration = element.duration.text;
                    //         locationInfo.tripDistance = distance;
                    //         locationInfo.tripTime = duration;
                    //         setValue(locationInfo)
                    //         var from = origins[i];
                    //         var to = destinations[j];
                    //      }
                    //  }

                    ///////////////////////////////////////////////////////////
                    ////////////  Getting your array of places  ///////////////
                    ///////////////////////////////////////////////////////////
                }
            }

            console.log(getvalue());
            let directionsService = new google.maps.DirectionsService();
            let directionsDisplay = new google.maps.DirectionsRenderer({
                map: map,
            });

            // get route
            directionsService.route({
                origin: locationInfo.startLocation,
                destination: locationInfo.endLocation,
                travelMode: google.maps.TravelMode.DRIVING
                // see more attributes at https://developers.google.com/maps/documentation/javascript/directions

            }, function (response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);

                    /////////////////////////////////////////////
                    ///////////  Here is the distance //////////
                    ///////////////////////////////////////////

                    var routes = response.routes[0].legs[0].steps;
                    console.log(routes);

                    var previousStop = routes[0].start_location;
                    console.log(previousStop);

                    var range = 5000; // maximum range in meters

                    for (var i = 1; i < routes.length; i++) {
                        var currentStop = routes[i].start_location;
                        var distance = google.maps.geometry.spherical.computeDistanceBetween(previousStop, currentStop);
                        if (distance <= range) {
                            console.log(currentStop);
                            console.log(distance);
                        }
                        previousStop = currentStop;
                    }


                } else {
                    window.alert('Directions request failed due to ' + status);
                }
            });

        });
    })

    /////////////////////////////////////////////////////////
    /////////////////// end o event Listiner ////////////////
    /////////////////////////////////////////////////////////

}

window.initMap = initMap;