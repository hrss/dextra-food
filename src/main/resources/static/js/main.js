$.ajax({
    url: "http://localhost:8080/api/sandwich",
    data: "",
    success: function (result) {
        var $dropdown = $("#inlineFormCustomSelectPref");

        $.each(result, function () {
            $dropdown.append($("<option />").val(this.id).text(this.name));
        });
    },
    dataType: "json"
});


$.ajax({
    url: "http://localhost:8080/api/ingredient",
    data: "",
    success: function (result) {
        var $formDiv = $("#ingredients");

        $.each(result, function () {
            $formDiv.append(
                '  <label for="' + this.id + '">' + this.name + '</label>\n' +
                '  <input type="number" class="form-control" id="' + this.id + '">\n');
        });
    },
    dataType: "json"
});


function getPriceBySandwich(sandwichId) {
    var $price = $("#price");
    var $dropdown = $("#inlineFormCustomSelectPref");
    var data = {};
    data.id = $dropdown.val();

    $.ajax({
        url: "http://localhost:8080/api/price/",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            $price.text("R$" + result);
        },
        dataType: "json"
    });

}

function getPriceByIngredients(sandwichId) {
    var $price = $("#price");
    var $dropdown = $("#inlineFormCustomSelectPref");
    var data = {};

    data.ingredients = {};

    var ingredientsInputs = $("#ingredients :input");

    ingredientsInputs.each(function(){
        var input = $(this); // This is the jquery object of the input, do what you will
        console.log(input)
        if (input.val() != "" && input.val() != undefined){
            data.ingredients[input.context.id] = input.val()
        }


    });

    $.ajax({
        url: "http://localhost:8080/api/price/",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            $price.text("R$" + result);
        },
        dataType: "json"
    });

}
