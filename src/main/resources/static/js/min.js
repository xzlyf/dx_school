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
            } else {
                alert("上传失败\n错误码：" + data.code)
            }
        },
        error: function (data) {
            console.log(data)
            alert("上传失败\n错误码：" + data.code)
        }

    });

}

function getAllData(id) {
    $.ajax({
        type: "GET",
        url: "/data/find",
        contentType: 'application/json;charset=utf-8', //设置请求头信息
        data: "devId=" + id,
        dataType: "json",
        success: function (res) {
            var code = res.code;
            var state = res.status;
            if (code == 1) {
                showTable(res.data)
            }
        },
        error: function (res) {
            console.log(res)
            alert("上传失败\n错误码：" + res.code)
        }
    });
}

function showTable(json) {
    var data = json2array(json)
    console.log(data)

    var table = "<table border='1' cellspacing='0'>";//这个字符串第一位为# 颜色的格式
    for (var i = 0; i < data.length; i++) {
        table += "<tr>";
        for (var key in data[i]) {
            table = table + "<td>" + data[i][key] + "</td>";
        }
        table += "</tr>";
    }
    table += "</table>";

    $("span").append(table)
    // var bodys = document.getElementsByTagName('body')[0];
    // bodys.innerHTML = table;

}


function json2array(data) {
    var len = eval(data).length;
    var arr = [];
    for (var i = 0; i < len; i++) {
        arr[i] = []; //js中二维数组必须进行重复的声明，否则会undefind
        arr[i]['age'] = data[i].age;
        arr[i]['duty'] = data[i].duty;
        arr[i]['idcard'] = data[i].idcard;
        arr[i]['name'] = data[i].name;
        arr[i]['phone'] = data[i].phone;
        arr[i]['remark'] = data[i].remark;
        arr[i]['sex'] = data[i].sex;
        arr[i]['will'] = data[i].will;
    }
    return arr;
}
