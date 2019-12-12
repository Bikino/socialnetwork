$(document).ready(function(){

        $("#btn-post").click(function () {

            post_ajax_submit();
            // alert("clicked")
        })


    });

function post_ajax_submit() {
    let path="http://localhost:8080/post/save";
    let post={}
    post["postText"]=$("#postText").val();
    $.ajax({
        type:"POST",
        contentType:'application/json',
        url:path,
        data:JSON.stringify(post),
        dataType:'json',
        cache: false,
        timeout: 600000,
        success:function (data) {
            // alert("I am there");
            let json = "<div> <strong>"+data.firstName+" "+data.lastName+" Saved successfully</strong>" + "</div>";
            $('#feedback').html(json);
            //alert("Saved");
        },
        error:function (e) {

            let json = "<div> <strong>Oops! </strong>" +
                "Something has gone wrong : " +e.responseText+"</div>";
            $('#feedback').html(json);


        }

    });


}