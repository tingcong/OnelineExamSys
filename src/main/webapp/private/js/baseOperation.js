/*保存表单*/
function excuteOperation(opt) {
    if (opt == undefined || opt == null || opt == '') {
        return;
    }
    if (opt['url'] == undefined || opt['url'] == null || opt['url'] == '') {
        return;
    }
    if (opt['data'] == undefined || opt['data'] == null) {
        opt['data'] = {};
    }
    $.ajax({
        url: opt['url'],
        data: opt['data'],
        type: "post",
        success: function (data) {
            opt['callBack'](data)
        }
    });
}
