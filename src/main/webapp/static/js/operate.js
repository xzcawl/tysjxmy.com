Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        //月份
        "d+": this.getDate(),
        //日
        "h+": this.getHours(),
        //小时
        "m+": this.getMinutes(),
        //分
        "s+": this.getSeconds(),
        //秒
        "q+": Math.floor((this.getMonth() + 3) / 3),
        //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}
/*$(function() {*/
var guestTable = {
    select: true,
    processing: true,
    serverSide: true,//服务器端进行分页处理的意思
    searchable: true,
    deferRender: true,
    autoWidth: false,

    lengthMenu: [[10, 20, 50], [10, 20, 50]],
    dom: '<"datatable-header"fl><"datatable-scroll"t><"datatable-footer"ip>',
    language: {
        emptyTable: "没有数据",
        info: "显示 _START_ 到 _END_ 共 _TOTAL_ 条记录",
        infoEmpty: "显示 0 到 0 共 0 条记录",
        search: '<span>查找:</span> _INPUT_',
        lengthMenu: '<span>每页展示:</span> _MENU_',
        infoFiltered: "-(_MAX_ 条记录中)",
        paginate: {
            'first': '第一页',
            'last': '最后一页',
            'next': '下一页',
            'previous': '上一页',
            'processing': "正在处理中。。。"

        },
        sZeroRecords: '没有匹配记录被发现'
    },
    ajax: {
        url: "/guestInformation/getAllAppList.do",
        type: "POST",
        async: false,
        dataSrc: function (result) {
            //console.log(result);
            return result.data;
        }
    },
    columns: [
        {"data": "tableNumber"},
        {"data": "guestName"},
        {"data": "guestPhone"},
        {"data": "remarks"},
        {"data": "preTableTime"},
        {"data": "operator"},
        {"data": "id"}
    ],
    columnDefs: [
        {
            /*"width": "2.1%",*/ orderable: false, targets: 0,
            render: function (data, type, row, meta) {
                return data;
            }
        },
        {
            /*"width": "3%",*/ orderable: false, targets: 1,
            render: function (data, type, row, meta) {
                return data;
            }
        },
        {
            /*"width": "4%",*/ orderable: false, targets: 2,
            render: function (data, type, row, meta) {
                return data;
            }
        },
        {
            /*"width": "4%",*/ orderable: false, targets: 3,
            render: function (data, type, row, meta) {
                return data;
            }
        },
        {
            /*"width": "4%",*/ orderable: false, targets: 4,
            render: function (data, type, row, meta) {
                return data;
            }
        },
        {
            /*"width": "3%",*/ orderable: false, targets: 5,
            render: function (data, type, row, meta) {
                // return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                return data;
            }
        },
        {
            "class": "text-center", orderable: false, targets: 6,
            render: function (data, type, row, meta) {
                return '<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#updateGuestInformation" onclick="edit_guestInformation(\'' + data + '\')">修改<i class="icon-pencil3 position-right"></i></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" onclick="firm(\'' + data + '\')">删除<i class="icon-database-remove position-right"></i></button>\n';
            }
        }
        /*{
            "class": "text-center", orderable: false, targets: 3,
            render: function (data, type, row, meta) {
                return '<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#showUserDetail" onclick="showUserDetail(' + data.id + ')">详情<i class="icon-newspaper2 position-right"></i></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#showLogDetail" data-whatever="' + data.ip + "," + data.appPort + "," + data.appDomain + '">日志<i class="icon-copy position-right"></i></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" onclick="deploy(' + data.appDomain + ')"><a class="bg-white" href="/deploy.do?appDomain=' + data.appDomain + '">部署<i class="icon-calendar5 position-right"></i></a></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" id="state_appinfo" onclick="get_appStatus(\'' + data.ip + '\',\'' + data.appDomain + '\')"><a id="get_appStatus' + data.appDomain + '"></a>状态<i class="icon-file-stats position-right"></i></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" id="restart_appinfo" onclick="restart_app(\'' + data.ip + '\',\'' + data.appDomain + '\')"><a id="restart_app' + data.appDomain + '"></a>重启<i class="icon-loop3 position-right"></i></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#update" onclick="editInfo(\'' + data.id + '\',\'' + 'queryDoIpList.do' + '\',\'' + 'queryGitUserList.do' + '\')">修改<i class="icon-pencil3 position-right"></i></button>\n' +
                    '<button type="button" class="btn btn-default btn-sm" onclick="delete_appInfo(\'' + data.ip + '\',\'' + data.appDomain + '\')"><a id="delete_appInfo' + data.appDomain + '"></a>删除<i class="icon-database-remove position-right"></i></button>\n';
            }
        }*/],
}

var table = $('#guestTable').DataTable(guestTable);

/*})*/

//保存guestInformation
function save_guestInformation() {
    var tableNumber = $("#tableNumber").val();
    var guestName = $("#guestName").val();
    var guestPhone = $("#guestPhone").val();
    var preTableTime = $("#preTableTime").val();
    var remarks = $("#remarks").val();

    var str1 = tableNumber.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
    var str2 = guestName.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
    var str3 = guestPhone.replace(/(^\s*)|(\s*$)/g, '');//去除空格;

    if (str1 == '' || str1 == undefined || str1 == null) {
        //return true;
        alert('桌号不能为空！')
    } else if (str2 == '' || str2 == undefined || str2 == null) {
        //return true;
        alert('客户姓名不能为空！')
    } else if (str3 == '' || str3 == undefined || str3 == null) {
        //return true;
        alert('客户电话不能为空！')
    } else {
        //alert($("#addUserName").val());
        var dataParam = {
            tableNumber: str1,
            guestName: str2,
            guestPhone: str3,
            preTableTime: preTableTime,
            remarks: remarks,
        };
        //alert(JSON.stringify(dataParam));
        $.ajax({
            type: "POST",
            url: "/guestInformation/saveGuestInformation.do",
            cache: false,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(dataParam),
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {
                //接收后台返回的结果
                //console.log(data);
                alert(data.message);
                if (data.message == "成功") {
                    location.reload();
                }
            }
        });
    }
}

function firm(id) {
    //利用对话框返回的值 （true 或者 false）
    if (confirm("确定删除吗？")) {
        //如果是true ，
        delete_guestInformation(id);
    } else {
        //否则说明下了
        //alert("你按了取消，那就是返回false");
    }
}

function delete_guestInformation(id) {
    var dataParam = {
        id: id,
    };
    //alert(JSON.stringify(dataParam));
    $.ajax({
        type: "POST",
        url: "/guestInformation/deleteGuestInformation.do",
        //data: jsonLabelList,
        cache: false,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(dataParam),
        beforeSend: function () {
            $('#' + id).html('<img src="/static/images/wait.gif" id="imgimg" class="small-head-img"style="width: 20px;height: 20px">');
        },
        complete: function () {
            $('#imgimg').remove()
        },
        error: function (request) {
            //$('#'+tras).remove()
            alert("Connection error");
        },
        success: function (data) {
            //$('#'+tras).remove()
            //接收后台返回的结果
            //console.log(data);
            alert(data.message);
            location.reload();
        }
    });
}

function edit_guestInformation(id) {
    $.ajax({
        type: "GET",
        url: "/guestInformation/queryIdGuestInformation/" + id + ".do",
        async: false,
        dataType: "json",
        contentType: "application/json",
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            $('#updateGuestInformation').on('show.bs.modal', function (event) {
                //var button = $(event.relatedTarget) // 触发事件的按钮
                //var recipient = button.data('whatever') // 解析出data-whatever内容
                var modal = $(this)
                //modal.find('.modal-title').text('Message To ')
                console.log(data)
                var guestInformation = data.value;
                modal.find(".modal-body input[name='tableNumber']").val(guestInformation.tableNumber);
                modal.find(".modal-body input[name='guestName']").val(guestInformation.guestName);
                modal.find(".modal-body input[name='guestPhone']").val(guestInformation.guestPhone);
                modal.find(".modal-body input[name='preTableTime']").val(guestInformation.preTableTime);
                modal.find(".modal-body select[name='remarks']").val(guestInformation.remarks);
                modal.find(".modal-header input[name='id']").val(guestInformation.id);
            })
            $("#updateGuestInformation").on("hide.bs.modal", function () {
                location.reload();
            })
        }
    })
}

function update_guestInformation() {
    var id = $("#idEdit").val();
    var tableNumber = $("#tableNumberEdit").val();
    var guestName = $("#guestNameEdit").val();
    var guestPhone = $("#guestPhoneEdit").val();
    var preTableTime = $("#preTableTimeEdit").val();
    var remarks = $("#remarksEdit").val();

    var str1 = tableNumber.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
    var str2 = guestName.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
    var str3 = guestPhone.replace(/(^\s*)|(\s*$)/g, '');//去除空格;

    if (str1 == '' || str1 == undefined || str1 == null) {
        //return true;
        alert('桌号不能为空！')
    } else if (str2 == '' || str2 == undefined || str2 == null) {
        //return true;
        alert('客户姓名不能为空！')
    } else if (str3 == '' || str3 == undefined || str3 == null) {
        //return true;
        alert('客户电话不能为空！')
    } else {
        var dataParam = {
            id: id,
            tableNumber: str1,
            guestName: str2,
            guestPhone: str3,
            preTableTime: preTableTime,
            remarks: remarks,
        };
        //alert(JSON.stringify(dataParam));
        $.ajax({
            type: "POST",
            url: "/guestInformation/updateGuestInformation.do",
            //data: jsonLabelList,
            cache: false,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(dataParam),
            beforeSend: function () {
                $('#' + id).html('<img src="/static/images/wait.gif" id="imgimg" class="small-head-img"style="width: 20px;height: 20px">');
            },
            complete: function () {
                $('#imgimg').remove()
            },
            error: function (request) {
                //$('#'+tras).remove()
                alert("Connection error");
            },
            success: function (data) {
                //$('#'+tras).remove()
                //接收后台返回的结果
                console.log(data);
                alert(data.message);
                //location.reload();
            }
        });
    }
}