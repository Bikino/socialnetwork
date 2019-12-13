$(document).ready(function () {

    $("#post-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        post_ajax_submit();

    });

});

function post_ajax_submit() {

    var post = {}
    post["post_text"] = $("#post_text").val();

    $("#btn-post").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/post/save",
        data: JSON.stringify(post),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-post").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}