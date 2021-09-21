function loadComments(){

    // window.location.href = "comment.html?restaurant= "+ value;

    let restaurant = getRestaurant();

    if(restaurant == null){

        // error
    }

    else{
        document.getElementById("comments").innerHTML = "";
        $.ajax({
            type: "GET",
            url: "http://localhost:8085/api/comments/get/" + restaurant,
            headers:
            {
                "Content-Type" : "application/json"
            },
            success: function(feedback){
    
                console.log(feedback);
    
                for(let i = 0; i < feedback.length; i++){
    
                    let template =
                    `<div class="testimonial-box">
                        <div class="box-top">
    
                            <div class="profile">
                                <div class="profile-img">
                                    <img src="images/commentsIcon.png">
                                </div>
                            </div>
    
                            <div class="name-user">
                                <strong id="UserName">`+ feedback[i].customerName +`</strong>
                            </div>
    
                            <div class="reviews">
                                <strong id="rating">`+ feedback[i].rating +`/5</strong>
                            </div>
    
                        </div>
    
                        <div class="user-comment">
                            <p id="comments">`+ feedback[i].comment +`</p>
                        </div>
    
                    </div>`;
    
                    document.getElementById("comments").innerHTML += template;
                }
            },
            error: function(){
    
            }
        });
    }
}

function getRestaurant(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    return urlParams.get("restaurant");
}








let btn = document.getElementById("positive");
btn.onclick = veiwPositive;






function veiwPositive(){

    document.getElementById("comments").innerHTML = "";

    let restaurant = getRestaurant();

    if (restaurant == null){

    }
    else{
        $.ajax({
            type: "GET",
            url: "http://localhost:8085/api/comments/get/" + restaurant,
            headers:
            {
                "Content-Type" : "application/json"
            },
            success: function(feedback){
    
                console.log(feedback);
    
                for(let i = 0; i < feedback.length; i++){
    
                    if(feedback[i].rating < "3"){
                        
                    }
                    else{
                        let template =
                        `<div class="testimonial-box">
                            <div class="box-top">
        
                                <div class="profile">
                                    <div class="profile-img">
                                        <img src="images/commentsIcon.png">
                                    </div>
                                </div>
        
                                <div class="name-user">
                                    <strong id="UserName">`+ feedback[i].customerName +`</strong>
                                </div>
        
                                <div class="reviews">
                                    <strong id="rating">`+ feedback[i].rating +`/5</strong>
                                </div>
        
                            </div>
        
                            <div class="user-comment">
                                <p id="comments">`+ feedback[i].comment +`</p>
                            </div>
        
                        </div>`;
                    document.getElementById("comments").innerHTML += template;
                    }
                }
            },
            error: function(){
    
            }
        });
    }
}





let btn2 = document.getElementById("negative");
btn2.onclick = veiwNegative;


function veiwNegative(){

    document.getElementById("comments").innerHTML = "";

    let restaurant = getRestaurant();

    if (restaurant == null){

    }
    else{
        $.ajax({
            type: "GET",
            url: "http://localhost:8085/api/comments/get/" + restaurant,
            headers:
            {
                "Content-Type" : "application/json"
            },
            success: function(feedback){
    
                console.log(feedback);
    
                for(let i = 0; i < feedback.length; i++){
    
                    if(feedback[i].rating > "3"){
                        
                    }
                    else{
                        let template =
                        `<div class="testimonial-box">
                            <div class="box-top">
        
                                <div class="profile">
                                    <div class="profile-img">
                                        <img src="images/commentsIcon.png">
                                    </div>
                                </div>
        
                                <div class="name-user">
                                    <strong id="UserName">`+ feedback[i].customerName +`</strong>
                                </div>
        
                                <div class="reviews">
                                    <strong id="rating">`+ feedback[i].rating +`/5</strong>
                                </div>
        
                            </div>
        
                            <div class="user-comment">
                                <p id="comments">`+ feedback[i].comment +`</p>
                            </div>
        
                        </div>`;
                    document.getElementById("comments").innerHTML += template;
                    }
                }
            },
            error: function(){
    
            }
        });
    }
}


let btn3 = document.getElementById("reset");
btn3.onclick = loadComments;