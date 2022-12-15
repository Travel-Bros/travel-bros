var x2js = new X2JS();
var xmlText = "<MyRoot><test>Success</test><test2><item>val1</item><item>val2</item></test2></MyRoot>";
var jsonObj = x2js.xml_str2json( xmlText );
console.log(jsonObj)


// new XMLSerializer()

let data1 = "1";
async function car() {
    parser = new DOMParser();
    let res = await fetch("https://www.fueleconomy.gov/ws/rest/ympg/shared/vehicles?make=Honda&model=Fit").then(res => res.text());
    let data = await parser.parseFromString(res, "text/xml");
    return data;
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


let fetchCarId = async () => {

    let listOfCars = [];
    let xmlDocument = await car();
    let stringXml = new XMLSerializer().serializeToString(xmlDocument);
    let xmltrim = stringXml.replace('<?xml version="1.0" encoding="UTF-8" standalone="yes"?>','');
    let jsonObject = x2js.xml_str2json(xmltrim);
    console.log(jsonObject);
    listOfCars = jsonObject.vehicles.vehicle;

    let UserSelection = listOfCars.filter((car)=>{
         return car.year === "2020";
        })
    console.log(UserSelection)

}

fetchCarId();
// getQuote((error, quote) => {
//     if (error) {
//         console.error(error);
//     } else {
//         console.log(quote);
//     }
// });