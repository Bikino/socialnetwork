$(document).ready(function(){
    $.ajax({
            url: "http://localhost:8080/post/getall",
            type: "GET",
            dataType: 'json',

            success: function (data) {
                var post = '';
                $
                    .each(
                        data,
                        function (i, item) {
                            post += '<div class="post-date hidden-xs hidden-sm">'
                                + '<h5>Sarah</h5> <p class="text-grey">10/22/2016</p> </div>'

                                + '<img src="images/post-images/13.jpg" alt="post-image" class="img-responsive post-image" />'
                                + '<div class="post-container">'
                                + '<img src="images/users/user-1.jpg" alt="user" class="profile-photo-md pull-left" />'
                                + '<div class="post-detail">'
                                + '<div class="user-info">'
                                + '<h5><a href="timeline.html" class="profile-link">Sarah Cruiz</a> <span class="following">following</span></h5>'
                                + '<p class="text-muted">Yesterday</p>'
                                + '</div>'
                                + '<div class="reaction">'
                                + '<a class="btn text-green"><i class="icon ion-thumbsup"></i> 49</a>'
                                + '<a class="btn text-red"><i class="fa fa-thumbs-down"></i> 0</a>'
                                + '</div>'
                                + '<div class="line-divider"></div>'
                                + '<div class="post-text">'
                                + '<p class="post-text"> '+item.postText +' <i class="em em-anguished"></i> <i class="em em-anguished"></i> <i class="em em-anguished"></i></p>'
                                + '</div>'
                                + '<div class="line-divider"></div>'
                                + '<div class="post-comment">'
                                + '<img src="images/users/user-11.jpg" alt="" class="profile-photo-sm" />'
                                + '<p><a href="timeline.html" class="profile-link">Diana </a><i class="em em-laughing"></i> Bite Hano?Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>'
                                + '</div>'
                                + '<div class="post-comment">'
                                + '<img src="images/users/user-4.jpg" alt="" class="profile-photo-sm" />'
                                + '<p><a href="timeline.html" class="profile-link">John</a> Bite na hano? Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>'
                                + '</div>'
                                + '<div class="post-comment">'
                                + '<img src="images/users/user-1.jpg" alt="" class="profile-photo-sm" />'
                                + '<input type="text" class="form-control" placeholder="Post a comment">'
                                + '</div>'
                                + '</div>'
                                + '</div>'
                        });
                $(".post-content").html(post);
            },
            error: function () {
                console.log(data);
            }
        });


})