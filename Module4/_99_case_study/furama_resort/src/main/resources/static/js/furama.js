$(document).ready(function () {
    $("#btnModalService").click(function () {
        $.ajax({
            type: "GET",
            url: "/service/serviceModal",
            dataType: "HTML",
            success: function (data) {
                $(".modal-body").html(data);
                $("#modelId").modal('show');
            }
        })
    })

})