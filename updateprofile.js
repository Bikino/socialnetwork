$(document).ready(function(){

    $("#save_updates").click(function () {

       updateProfile();
       // alert("clicked")
    })


});

function updateProfile() {
    let path="http://localhost:8080/saveperson";
     let search={};
     search["firstName"]=$("#firstName").val();
     search["lastName"]=$("#lastName").val();
     search["email"]=$("#email").val();
     search["phoneNumber"]=$("#phoneNumber").val();
     search["address.street"]=$("#address.street").val();
     search["address.city"]=$("#address.city").val();
     search["address.state"]=$("#address.state").val();
     search["gender"]=$("#gender").val();
     search["bio"]=$("#bio").val();

    $.ajax({

        type:"POST",
        contentType:'application/json',
        url:path,
        data:JSON.stringify(search),
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