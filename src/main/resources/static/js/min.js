function save() {
    var params = $("form").serializeArray();
    var j = {};
    for (var item in params) {
        j[params[item].name] = params[item].value;
    }
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/data/saveV2',
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(j),
        success: function (data) {
            var code = data.code;
            var state = data.status;

        },
        error: function (data) {
            console.log(data)
        }

    });

}

