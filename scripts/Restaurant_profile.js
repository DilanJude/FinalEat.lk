function CreateProfile(){
    let userdata = 
    {
        name : document.getElementById("name").value,
        email : document.getElementById("email").value,
        address : document.getElementById("address").value,
        description : document.getElementById("description").value,
        cuisine : document.getElementById("cuisine").value,
        type : document.getElementById("type").value,
        number : document.getElementById("contactno").value,
        website : document.getElementById("website").value

    }



    $.ajax({
        type : "POST",
        url : "http://localhost:8085/api/createRprofile",
        headers:
        {
            "Content-Type" : "application/json"
        },
        data : JSON.stringify(userdata),
        success : function(response){
            alert("Your profile has been created")
        },
        error : function(error){
            console.log(error);
            alert("An error has occured while creating your profile")
        }
    })
}



//Loading profile from restaurant home

function loadprofile(){
    let useremail = sessionStorage.getItem("currentuser");

    $.ajax({
        type : "GET",
        url : "http://localhost:8085/api/getRprofile/" + useremail,
        headers : 
        {
            "Content-Type" : "application/json"
        },
        success:function(response){


            if(useremail != null){
                document.getElementById("name").innerHTML = response.name;
                document.getElementById("description").innerHTML = response.description;
                document.getElementById("type").innerHTML = response.type;
                document.getElementById("address").innerHTML = response.address;
                document.getElementById("number").innerHTML = response.number;
                document.getElementById("cuisine").innerHTML = response.cuisine;
                document.getElementById("website").href = response.website;

            }
            
            else{
                document.getElementById("name").innerHTML = "Please create your profile";
            }



        },
        error: function(error){
            console.log(error);
            alert("something went wrong when loading your profile");
        }



    });
}




//loading menu from restaurant profile
function loadRMenu(){
    let useremail = sessionStorage.getItem("currentuser");


    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/getRmenu/" + useremail,
        headers:
        {
            "Content-Type" : "application/json"
        },
        success:function(response){
    
            document.getElementById("item1").innerHTML = response.item1;
            document.getElementById("item2").innerHTML = response.item2;
            document.getElementById("item3").innerHTML = response.item3;
            document.getElementById("item4").innerHTML = response.item4;
            document.getElementById("item5").innerHTML = response.item5;
            

        },
        error:function(error){
            console.log(error);
            alert("something went wrong when loading your menu")
        }
    })
}





//gettinf profile from seach/sort results
function getProfile(){         

    let restaurant = new URL(document.location).searchParams.get("name");

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/get/" + restaurant,
        success: function(data){

            document.getElementById("name").innerText = data.name;
            document.getElementById("description").innerText = data.description;
            document.getElementById("type").innerText = data.type;
            document.getElementById("address").innerText = data.address;
            document.getElementById("number").innerText = data.number;
            document.getElementById("cuisine").innerText = data.cuisine;
            document.getElementById("website").href =  data.website;

        },
        error: function(error){
            console.log(error);
            alert("something went wrong when loading your profie")
        }
    })
}

//getting menu from search / sort results
function getMenu(){
    let restaurant = new URL(document.location).searchParams.get("name");

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/getCmenu/" + restaurant,
        success: function(data){

            console.log(data);

            document.getElementById("item1").innerHTML = data.item1;
            document.getElementById("item2").innerHTML = data.item2;
            document.getElementById("item3").innerHTML = data.item3;
            document.getElementById("item4").innerHTML = data.item4;
            document.getElementById("item5").innerHTML = data.item5;
        },
        error: function(error){
            console.log(error);
            alert("something went wrong while loading your menu")
        }
    })
}





function UpdateProfileLoad(){
    let useremail = sessionStorage.getItem("currentuser");

    $.ajax({
        type : "GET",
        url : "http://localhost:8085/api/getRprofile/" + useremail,
        headers : 
        {
            "Content-Type" : "application/json"
        },
        success:function(response){


            if(useremail != null){
                document.getElementById("name").value = response.name;
                document.getElementById("description").value = response.description;
                document.getElementById("type").value = response.type;
                document.getElementById("address").value = response.address;
                document.getElementById("contactno").value = response.number;
                document.getElementById("cuisine").value = response.cuisine;
                document.getElementById("website").value= response.website;


            }
            
            else{
                document.getElementById("name").innerHTML = "Please create your profile";
            }



        },
        error: function(error){
            console.log(error);
            alert("something went wrong when loading your profile");
        }



    });
}






var container = document.getElementById("form_wrapper");
var btn = document.getElementById("update");
var span = document.getElementsByClassName("close")[0];


btn.onclick = function(){
    container.style.display = "block";
    UpdateProfileLoad();
}

span.onclick = function(){
    container.style.display = "none";
}


function UpdateRestaurantProfile(){
    let userdata = 
    {
        name: document.getElementById("name").value,
        email : sessionStorage.getItem("currentuser"),
        address : document.getElementById("address").value,
        description : document.getElementById("description").value,
        cuisine : document.getElementById("cuisine").value,
        type : document.getElementById("type").value,
        number : document.getElementById("contactno").value,
        website : document.getElementById("website").value
    }

    $.ajax({
        type : "PUT",
        url : "http://localhost:8085/api/updateRestaurantProfile",
        headers:
        {
            "Content-Type" : "application/json"
        },
        data: JSON.stringify(userdata),
        success: function(response){
            alert("Your profile has been successfully updated")
        },
        error: function(error){
            console.log(error)
            alert("An error has occured while updating your profile")
        }
    })
}



//Function for the greeting of user

function greeting(){
    let useremail = sessionStorage.getItem("currentuser");

    $.ajax({
        type : "GET",
        url : "http://localhost:8085/api/getRprofile/" + useremail,
        headers : 
        {
            "Content-Type" : "application/json"
        },
        success:function(response){
            if(response.email == null){
                document.getElementById("UserName").innerHTML = "Restaurant";
            }
            else{
            document.getElementById("UserName").innerHTML = response.name;

            sessionStorage.setItem("currentRestaurant", response.name)
            }
        },
        error:function(error){
            console.log(error);
            alert("something went wrong when accessing your profile")
        }
    })
}


//Function for veiwing comments on profile 
var btn3 = document.getElementById("viewComments");


btn3.onclick = function(){
    window.location.href = "Comments.html?restaurant="+ sessionStorage.getItem("currentRestaurant");
}



let menubtn = document.getElementById("menu");
menubtn.onclick = function(){
    window.location.href = "Menu_Page.html?restaurant="+ sessionStorage.getItem("currentRestaurant");
}

