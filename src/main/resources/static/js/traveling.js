// const startInput = document.querySelector('#vehicle-make')
// const endInput = document.querySelector('#endLocation')

// const data = document.querySelector('div[data-gas-tank="description"]').content
// function getMetaContent(name){
//     return document.querySelector('#dataFromUser')[name].getAttribute("content");
// }

// const el2 = document.querySelector('[data-gas-tank]');
//
// console.log(el2.dataset.distance);

// const recalculateButton = document.querySelector(".recalculate-button");
//$(document).ready(function(){
//     // Event listener to redirect when .editButton clicked
//     $(".recalculate-button").on('click', function(e){
//         console.log("recalculate-button clicked!");
//         window.location.replace(`/trips/${$(this).attr("data-id")}/edit`);
//     });
// });
let x = document.getElementsByTagName(".currency-format");

function formatCurrency(className) {
    let elements = document.getElementsByClassName(className);
    for (let element of elements) {
        let number = parseFloat(element.textContent); // convert string to number
        let formatted_number = new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(number);
        element.textContent = formatted_number;
    }
}
