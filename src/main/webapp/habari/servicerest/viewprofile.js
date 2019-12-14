$(document).ready(function () {

    $("#view_data").click(function () {

        alert("hello");
        //viewprofiles();
        viewprofileOnePerson();
    });

    $("#save_updates").click(function () {
        alert(" update clicked")
        updateProfile();

    })

})

function viewprofiles() {
    var count = 0;
    var id=10;
    $
        .ajax({
            url : "http://localhost:8080/person/onePerson/"+id,
            type : "GET",
            dataType : 'json',

            success : function(data) {
                var profile = '';
                $
                    .each(
                        data,
                        function(i, item) {
                            // profile += '<div class="col-md-4 col-sm-6"> <div class="template-thumb"><a class="viewm" target="_blank" data-toggle="modal" data-target="#imageVideomodal"><div class="img-wrapper"><img src="'
                            //     + 'data:image/png;base64,'
                            //     + item.content
                            //     + '" alt="" class="img-responsive" /><input class="postcommentid" type="hidden" value="'+ item.id +'"></div></a><div class="page-link"><a href="index.html" target="_blank"> </a></div></div></div>';
                            // count++;

                            profile+='<p>'+item.firstName+'</p>'

                        });
                $("#profile").html(profile);
                //$("#postcount").html(count + " posts ");
            },
            error : function() {
                console.log("not found");
            }
        });
}

function viewprofileOnePerson() {
    var count = 0;
    var id=15;
    $
        .ajax({
            url : "http://localhost:8080/person/onePerson/"+id,
            type : "GET",
            dataType : 'json',

            success : function(data) {
                var profile = '<p>'+data.firstName+'</p>';

                $("#firstName").val(data.firstName);
                $("#lastName").val(data.lastName);
                $("#gender").val(data.gender);
                $("#email").val(data.email);
                $("#phoneNumber").val(data.phoneNumber);
                $("#addressState").val(data.addressState);
                $("#addressCity").val(data.addressCity);
                $("#bio").val(data.bio);

                $("#profile").html(profile);
                //$("#postcount").html(count + " posts ");
                $('#p_image2').attr('src', 'data:image/png;base64,'+data.profilePath);
                alert(data.profilePath);

            },
            error : function() {
                console.log("not found");
            }
        });
}



function updateProfile() {
    var id=15;
   // let path="http://localhost:8080/person/updateperson"+id;
    let search={}
    search["id"]=$("#id").val();
    search["firstName"]=$("#firstName").val();
    search["lastName"]=$("#lastName").val();
    search["email"]=$("#email").val();
    search["phoneNumber"]=$("#phoneNumber").val();
    search["addressState"]=$("#addressState").val();
    search["addressCity"]=$("#addressCity").val();
    search["gender"]=$("#gender").val();
    search["bio"]=$("#bio").val();

    $.ajax({

        type:"PUT",
        contentType:'application/json',
        url : "http://localhost:8080/person/updateperson/"+id,
        data:JSON.stringify(search),
        dataType:'json',
        cache: false,
        timeout: 600000,
        success:function (data) {

            let json = "<div> <strong>"+data.firstName+" "+data.lastName+" your data updated successfully</strong>" + "</div>";
            $('#feedback').html(json);


        },
        error:function (e) {

            let json = "<div> <strong>Oops! </strong>" +
                "Something has gone wrong : " +e.responseText+"</div>";
            $('#feedback').html(json);


        }

    });


}
