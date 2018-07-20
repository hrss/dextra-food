$(document).ready(function () {
    $('#smartcart').smartCart();
});

var $ingDiv = $("#ingredientsDiv");
$ingDiv.hide();

$.ajax({
    url: "http://localhost:8080/api/sandwich",
    data: "",
    success: function (result) {
        var $dropdown = $("#inlineFormCustomSelectPref");
        $.each(result, function () {
            $dropdown.append($("<option />").val(this.id).text(this.name));
        });

        $dropdown.append($("<option />").val("").text("Personalizado"));
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
                '  <input onchange="getPriceByIngredients()"  type="number" class="form-control" id="' + this.id + '">\n');
        });
    },
    dataType: "json"
});


function getPriceBySandwich() {
    var $price = $("#price");
    var $dropdown = $("#inlineFormCustomSelectPref");
    var $pPrice = $("#pPrice");
    var data = {};
    data.id = $dropdown.val();

    $.ajax({
        url: "http://localhost:8080/api/price/",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            $price.text("R$ " + result.toFixed(2).replace('.', ','));
            $pPrice.val(result);
        },
        dataType: "json"
    });

}

function getPriceByIngredients(sandwichId) {
    var $price = $("#price");
    var $pPrice = $("#pPrice");
    var $dropdown = $("#inlineFormCustomSelectPref");
    var data = {};

    data.ingredients = {};

    var ingredientsInputs = $("#ingredients :input");

    ingredientsInputs.each(function () {
        var input = $(this); // This is the jquery object of the input, do what you will
        console.log(input)
        if (input.val() != "" && input.val() != undefined) {
            data.ingredients[input.context.id] = input.val()
        }


    });

    $.ajax({
        url: "http://localhost:8080/api/price/",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            $price.text("R$ " + result.toFixed(2).replace('.', ','));
            $pPrice.val(result);
        },
        dataType: "json"
    });

}

function doStuff() {
    var $dropdown = $("#inlineFormCustomSelectPref");
    var $ingDiv = $("#ingredientsDiv");
    var $price = $("#price");
    var $pName = $("#pName");
    var addButton = $("#add");

    $pName.val($("#inlineFormCustomSelectPref option:selected").text());

    addButton.prop("disabled", false);

    if ($dropdown.val() === "") {
        $ingDiv.show();
        $price.text("R$ 0,00");
        getPriceByIngredients();
    } else if ($dropdown.val() === "none") {
        addButton.prop("disabled", true);
    }else {
        $ingDiv.hide();
        getPriceBySandwich();
    }


}
