function save() {
    var params = $("form").serializeArray();
    var j = {};
    for (var item in params) {
        j[params[item].name] = params[item].value;
    }
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/data/save',
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(j),
        success: function (data) {
            var code = data.code;
            var state = data.status;
            if (code == 1) {
                alert("上传成功")
                location.reload();
            }
        },
        error: function (data) {
            console.log(data)
            alert("上传失败\n错误码：" + data.code)
        }

    });

}

