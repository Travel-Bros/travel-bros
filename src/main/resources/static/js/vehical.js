

var x2js = new X2JS();
// var xmlText = "<MyRoot><test>Success</test><test2><item>val1</item><item>val2</item></test2></MyRoot>";
// var jsonObj = x2js.xml_str2json( xmlText );
// console.log(jsonObj)


// const useState = new useStateForProject;
// const [getvalue, setValue] = useState.useState1(true);
//
// setValue(false)
// console.log(getvalue())\


// let data1 = "1";
// async function car(car) {
//     let parser = new DOMParser();
//     let res = await fetch("https://www.fueleconomy.gov/ws/rest/ympg/shared/vehicles?make=Honda&model=Fitindex.shtml").then(res => res.text());
//     let data = await parser.parseFromString(res, "text/xml");
//     console.log(data)
//     return data;
// }


// let fetchCarId = async (cars) => {
//
//
//
//     let listOfCars = [];
//     let xmlDocument = await car(cars);
//     console.log(xmlDocument)
//     let stringXml = new XMLSerializer().serializeToString(xmlDocument);
//     let xmltrim = stringXml.replace('<?xml version="1.0" encoding="UTF-8" standalone="yes"?>','');
//     let jsonObject = x2js.xml_str2json(xmltrim);
//     console.log(jsonObject);
//     listOfCars = jsonObject.vehicles.vehicle;
//
//     let UserSelection = listOfCars.filter((car)=>{
//          return car.year === cars.year;
//         })
//     console.log(UserSelection)
//
// }

/////////////////////////////////////////////////
////////////

let data1 = "1";
async function car(car) {
    let res = await fetch(`https://datasource.kapsarc.org/api/records/1.0/search/?dataset=us-vehicle-fuel-economy-data-1984-2017&q=${car.model}&facet=fueltype1&facet=highway08&facet=vclass`).then(res => res);
    let data = await res.json()
    console.log(data)
    return data;
}


let fetchCarId = async (cars) => {
    let listOfCars = [];
    let carObj = await car(cars);
    listOfCars = carObj.records;
    console.log(listOfCars);
    let UserSelection = listOfCars.filter( car =>{
         return car.fields.year === cars.year;
        })
    return  UserSelection;
    // console.log(UserSelection)

}



//      fetch(https://www.fueleconomy.gov/ws/rest/vehicle/menu/options?year=2012&make=Honda&model=Fit)
//         .then(response => response.text())
//         .then(xmlString => parser.parseFromString(xmlString, "text/xml"))
//         .then(data =>  console.log( new XMLSerializer().serializeToString(data))
//
//         );
// }
//
//  data1 = car();
// console.log(data1)








// fetchCarId();
// getQuote((error, quote) => {
//     if (error) {
//         console.error(error);
//     } else {
//         console.log(quote);
//     }
// });



document.addEventListener('DOMContentLoaded', async function () {

    /////////////////////////////////////////
    ////////////////  New Car  /////////////
    ///////////////////////////////////////

    let userVehicle = {
        make: "",
        model:"",
        mpg: "",
        tanksize: "",
        year: "",
    }

    //////////////////////////////////////////
    ////////////////  Selectors  ////////////
    ////////////////////////////////////////

    const vehicleMake = document.querySelector('#vehicle-make')
    const vehicleModel = document.querySelector('#vehicle-model')
    const vehicleMpg = document.querySelector('#vehicle-mpg')
    const vehicleTanksize = document.querySelector('#vehicle-tank-size')
    const vehicleYear = document.querySelector('#vehicle-year')
    const vehicleBtn = document.querySelector('#get-vehical')




    //////////////////////////////////////////
    ////////////////  Listeners  ////////////
    ////////////////////////////////////////

    ///////////////  vehicleMake ////////////////
    vehicleMake.addEventListener('keyup',async function(e){
        e.preventDefault
        let makeValue;
        makeValue = e.target.value;
        userVehicle.make = makeValue;
        console.log(userVehicle)
    });


    ///////////////  vehicleMake ////////////////
    vehicleModel.addEventListener('keyup',async function(e){
        e.preventDefault
        let carValue;
       carValue = e.target.value;
        userVehicle.model = carValue;
        console.log(userVehicle)
    });


    ///////////////  vehicleYear ////////////////
    vehicleYear.addEventListener('keyup', async function(e){
        e.preventDefault
        let carValue;
        carValue = e.target.value;
        userVehicle.year = carValue;
        console.log(userVehicle)
    });


    vehicleBtn.addEventListener('click',async function(e){
        e.preventDefault

        let carArray = [];
        carArray = await fetchCarId(userVehicle);

        if (carArray.length > 1) {
            let mpg = "";
            for(let i = 0; i < carArray.length; i++){

            }
        }


    });





    // endInput.addEventListener('keyup',function(e){
    //     e.preventDefault
    //     let endValue;
    //     endValue = e.target.value;
    //     locationsFromUser.endLocation = endValue;
    //     setValue(locationsFromUser)
    //     console.log(getvalue())
    // });
})