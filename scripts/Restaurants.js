var modal = document.getElementById("myModal");

var btn = document.getElementById("btn");

var span = document.getElementsByClassName("close")[0];

btn.onclick = function(){
    modal.style.display = "block";
}

span.onclick = function(){
    modal.style.display = "none";
}

window.onclick = function(event){
    if(event.target == modal){
        modal.style.display = "none";
    }
}




function search(){
    var input, filter, ul, li, a, i, txtvalue

    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    ul = document.getElementById("R_List");
    li = document.getElementsByTagName("li");


    for(i=0; i<li.length; i++){
        a = li[i].getElementsByTagName("a")[0];
        txtvalue = a.textContent || a.innerText;

        if (txtvalue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}




var modal1 = document.getElementById("myModal1");

function openmodal(){
    modal1.display.style = "block";
}

function getRestaurants(){

    document.getElementById("R_List").innerHTML = "";

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/getAll",
        success: function(restaurants){

            for(restaurant of restaurants){
                
                if(restaurant.verified == true){
                    console.log(restaurant)
                    let template = '<li><a href="restaurant.html?name='+ restaurant.name +'">'+ restaurant.name +'</a></li>';
                    document.getElementById("R_List").innerHTML += template;
                }
            }
        },
        error: function(error){
            console.log(error);
        }
    })
}

document.getElementById("btn").addEventListener("click", function(){
    getRestaurants();
})




function preference(){
    let useremail = sessionStorage.getItem("currentuser");

    $.ajax({
        type : "GET",
        url : "http://localhost:8085/api/getprofile/" + useremail,
        headers:
        {
            "Content-Type" : "application/json"
        },
        success:function(response){
            if(response.healthy == "No"){
                 let profile = document.getElementsByClassName("testimonial-box-health");
                 for( let i=0; i < profile.length; i++){
                     profile[i].style.display = "none";
                 }
            }
            else{

            }
        },
        error: function(error){
            console.log(error);
        }
    })
}