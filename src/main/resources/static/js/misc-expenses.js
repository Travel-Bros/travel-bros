// $(function() {
//     let expenseCount = 0;
//     let expenseTitle = '';
//
//     $("#add-expense").on('click', function (e){
//         console.log("anything");
//         $("#misc-expense-container").append(
//
//            `
//                             <p>Expense: </p>
//                             <input id="expenseCount-title" class="expenseCount">
//
//                             <p>Cost: </p>
//                             <input id="expenseCount-${expenseCount}" class="expenseCount">
//                         `
//
//             // `<p>Expense: </p>`
//         );
//     });
//
// });

$(function() {
    let expenseCount = 0;
    let expenseTitle = '';

    $("#add-expense").on('click', function (e){
        console.log("anything");
        $("#misc-expense-container").append(
            `<p>Expense: </p>
             <input name="miscexp-title" id="expenseCount-title" class="expenseCount">
             <p>Cost: </p>
             <input name="miscexp-cost" id="expenseCount-cost" class="expenseCount">`
        );
    });
});