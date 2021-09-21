function loadMenu(){
    let restaurant = getRestaurant();

    if(restaurant == null){
        alert("Something went wrong");
        window.location.href = "restaurant.html";
    }
    else{
        $.ajax({
            type: "GET",
            url: "http://localhost:8085/api/food/get/" + restaurant,
            headers:
            {
                "Content-Type" : "application/json"
            },
            success: function(response){
                if (response == null){
                    alert(response.name+" Has not created a menu yet");
                    window.location.href = "Rprofile.html";
                }
                else{
                    console.log(response);

                    for(let i=0; i< response.length; i++){
                        let template = 
                        `<div class="testimonial-box">
            
                        <div class="box-top">
            
                    
                            <div class="profile">
                        
                                <div class="profile-img">
                                    <img id="image" src="images/`+response[i].imageURL+`">
                                </div>
                            </div>
                    
                                <div class="name-restaurant">
                                    <strong id="foodName">`+response[i].foodName+`</strong>
                                </div>
                        </div>
            
                        <div class="information">
                            <p class="heading">Price</p>
                            <p class="subheading" id="price">`+response[i].price+`</p>
            
                        </div>
                    </div>`

                    document.getElementById("menu").innerHTML += template;
                    }
                }

            },
            error: function(){
                alert("something went wrong when loading the menu")
            }
        })
    }
}

function getRestaurant(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    return urlParams.get("restaurant");
}
