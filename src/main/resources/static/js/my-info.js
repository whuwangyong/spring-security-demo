$(function () {



    //------- 修改 job 信息 -----------
    // modal 带入信息并展示
    $(".btnEdit").click(
        function () {
            $("#edit_id").val($(this).parent().data("id"));
            $("#edit_name").val($(this).parent().data("name"));
            $("#edit_gender").val($(this).parent().data("gender"));
            $("#edit_phone").val($(this).parent().data("phone"));
            $("#updateModal").modal("show");
        });
    // 提交修改
    $("#submitUpdate").click(
        function () {
            // $('#updateForm').submit();
            $.ajax({
                url: "/my-info/update",
                type: "POST",
                dataType: "JSON", // 服务器返回的数据类型
                data: $('#updateForm').serialize(),
                success: function (ret) {
                    if (ret.valid) {
                        // alert("update success!");
                        location.reload();
                    } else {
                        alert(ret.msg);
                    }
                }
            });
        });
    //------- 修改 job 信息 -----------
});