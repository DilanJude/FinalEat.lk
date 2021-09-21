var modal = document.getElementById("myModal");

var btn = document.getElementById("verify");

var span = document.getElementsByClassName("close")[0];


btn.onclick = function(){
    console.log("works");
    modal.style.display = "block";
    getUnverified();
}

span.onclick = function(){
    modal.style.display = "none";
}


window.onclick = function(event){
    if(event.target == modal){
        modal.style.display = "none";
    }
}

function getUnverified(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/get/unverified",
        success: function(restaurants){
            document.getElementById("Verify_List").innerHTML = "";

            for(restaurant of restaurants){
                let template = "<li>"+ restaurant.name +" <button onclick='verifyRestaurant(\""+ restaurant.name +"\")'>Verify</button></li>";
                document.getElementById("Verify_List").innerHTML += template;
            }
        },
        error: function(error){
            alert("An error occurred");
        }
    });
}

function verifyRestaurant(name){

    $.ajax({
        type: "PUT",
        url: "http://localhost:8085/api/verify/" + name,
        success: function(status){
            if(status == 1){
                alert("Profile Verified");
                window.location.reload();
            }
            else{
                alert("An error occurred");
            }
        },
        error: function(error){
            alert("An error occurred");
        }
    })
}



var modal2 = document.getElementById("MyModal2");
var customerbtn = document.getElementById("VeiwCustomers") ;
var span2 = document.getElementsByClassName("close2")[0];

customerbtn.onclick = function(){
    modal2.style.display = "block";
    VeiwCustomers();
}

span2.onclick = function(){
    modal2.style.display = "none";
}

window.onclick = function(event){
    if(event.target == modal2){
        modal2.style.display = "none";
    }
}


function VeiwCustomers(){

    document.getElementById("Customer_List").innerHTML = "";


    $.ajax({
        type : "GET",
        url : "http://localhost:8085/api/getAllCustomers",
        success: function(customers){

            for(customer of customers){
                let template = '<li>'+ customer.name +'</li>';
                document.getElementById("Customer_List").innerHTML += template;
            }
        },
        error: function(error){
            console.log(error);
            alert("failed to retrive Customer list")
        }
    })
}



var modal3 = document.getElementById("MyModal3");
var restaurantbtn = document.getElementById("ViewRestaurants");
var span3 = document.getElementsByClassName("close3")

restaurantbtn.onclick = function(){
    modal3.style.display = "block";
    ViewRestaurants();

}

span3.onclick = function(){
    modal3.style.display = "none";
}

window.onclick = function(event){
    if(event.target == modal3){
        modal3.style.display = "none";
    }
}

function ViewRestaurants(){

    document.getElementById("Restaurant_List").innerHTML = "";

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/getAll",
        success: function(restaurants){

            for(restaurant of restaurants){
                
                if(restaurant.verified == true){
                    console.log(restaurant)
                    let template = '<li><a href="restaurant.html?name='+ restaurant.name +'">'+ restaurant.name +'</a></li>';
                    document.getElementById("Restaurant_List").innerHTML += template;
                }
            }
        },
        error: function(error){
            console.log(error);
        }
    })
}
