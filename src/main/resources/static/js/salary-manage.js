$(function () {



    //------- 修改 job 信息 -----------
    // modal 带入信息并展示
    $(".btnEdit").click(
        function () {
            var id = $(this).parent().data("id");
            $("#edit_id").val(id);
            $("#edit_name").val($("#name_" + id).text());
            $("#edit_salary").val($("#salary_" + id).text());
            $("#updateModal").modal("show");
        });
    // 提交修改
    $("#submitUpdate").click(
        function () {
            // $('#updateForm').submit();
            $.ajax({
                url: "/salary-manage/update",
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