$(function() {
    let expenseCount = 0;
    let expenseTitle = '';

    $("#add-expense").on('click', function (e){
        console.log("anything");
        $("#misc-expense-container").append(

        //    `
            //                 <p>Expense: </p>
            //                 <input id="expenseCount-title" th:field="${createTrip.tripBudget.}" class="expenseCount">
            //
            //                 <p>Cost: </p>
            //                 <input id="expenseCount-${expenseCount}" th:field="${createTrip.tripBudget.miscExpenses}" class="expenseCount">
            //             `

            `<p>Expense: </p>`
        );
    });

});