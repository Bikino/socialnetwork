$(document).ready(function(){



    $("#save_person").click(function () {
        createAccount();

    })


});

function createAccount() {
    let path="http://localhost:8080/person/saveperson";
     let search={}
     search["firstName"]=$("#firstName").val();
     search["lastName"]=$("#lastName").val();
     search["email"]=$("#email").val();
     search["phoneNumber"]=$("#phoneNumber").val();
     search["addressState"]=$("#addressState").val();
     search["addressCity"]=$("#addressCity").val();
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

            let json = "<div> <strong>"+data.firstName+" "+data.lastName+" Saved successfully</strong>" + "</div>";
            $('#feedback').html(json);

        },
        error:function (e) {

         let json = "<div> <strong>Oops! </strong>" +
                "Something has gone wrong : " +e.responseText+"</div>";
            $('#feedback').html(json);


        }

    });


}





function getProfile() {


    $.ajax({

        type:"GET",
        url:"localhost:8080/person/all",
        dataType:'json',
        success:function (data) {
            alert("test ");

            // var print='';
            // $.each(data, function (i, item) {
            //
            //
            //     print+=''
            //     +'<p>'+item.firstName+'</p>'
            //     });
            // $("#myForm").html(print);



        //     // alert("I am there");
        //     // let json = "<div> <strong>"+data.firstName+" "+data.gender+" data retreived </strong>" + "</div>";
        //     // $('#feedback').html(json);
        //     // //alert("Saved");
        //
        //
        //     let myform=''
        //
        // myform+=''
        //     +'<form class="contact-form">'
        //         +'<div class="form-group">'
        //         +'<i class="ion-images"></i>'
        //        +'<input id="picture" name="picture" class="form-control" placeholder="upload picture">'
        //        +' <button class="btn-primary">Upload picture</button>'
        //     +'</div>'
        //     +'<div class="form-group">'
        //         +'<i class="icon ion-person"></i>'
        //         +'<input id="firstName" type="text" class="form-control" value="'+data.firstName+'">'
        //     +'</div>'
        //   //  +'<div class="form-group">'
        //   //      +'<i class="icon ion-person"></i>'
        //   //       +'<input id="lastName" type="text" class="form-control" placeholder="last name" >'
        //   //     +'  </div>'
        //   //       +'<div class="form-group">'
        //   //      +' <select id="gender" class="form-control">'
        //   //      +' <option>choose gender</option>'
        //   // +'  <option value="male">Male</option>'
        //   //      +' <option value="female">Female</option>'
        //   //       +'</select>'
        //   //      +' </div>'
        //         // <div class="form-group">
        //         // <i class="icon ion-email"></i>
        //         // <input id="email" type="text" class="form-control" placeholder="email" >
        //         // </div>
        //         // <div class="form-group">
        //         // <i class="icon ion-android-call"></i>
        //         // <input id="phoneNumber" type="text"  class="form-control" placeholder="phone number">
        //         // </div>
        //         // <div class="form-group">
        //         // <input id="addressState" type="text"  class="form-control" placeholder="State">
        //         // </div>
        //         // <div class="form-group">
        //         // <input id="addressCity" type="text"  class="form-control" placeholder="City">
        //         // </div>
        //         // <div class="form-group">
        //         // <textarea id="bio" class="form-control" placeholder="Short Bio" rows="4"></textarea>
        //         // </div>
        //
        //
        //        +' </form>';
        //         // <button class="btn-primary" id="save_updates">Update Profile</button>
        //         // <div id="feedback"></div>
        //         //
        //         // <button class="btn-primary" id="view_data">Update Profile</button>
        //
        //     $('#myForm').html(myform);


        },
        error:function (e) {

            let json = "<div> <strong>Oops! </strong>" +
                " can't display data : " +e.responseText+"</div>";
            $('#feedback').html(json);



        }

    });

}