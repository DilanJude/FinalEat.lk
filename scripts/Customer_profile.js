function CreateProfile(){
    let userdata =
    {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        dob: document.getElementById("DOB").value,
        address: document.getElementById("address").value,
        number: document.getElementById("number").value,
        gender: document.getElementById("gender").value,
        healthy: document.getElementById("healthy").value
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8085/api/createprofile",
        headers:
        {
            "Content-Type" : "application/json"
        },
        data: JSON.stringify(userdata),
        success: function(response){
            alert("Your profile has been created")
        },
        error: function(error){
            console.log(error);
            alert("An error has occured while creating your profile")
        }
    })
}




function loadprofile(){
    let useremail = sessionStorage.getItem("currentuser");

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/getprofile/" + useremail,
        headers:
        {
            "Content-Type" : "application/json"
        },
        success:function(response){

            if(response.email == null){

                document.getElementById("name").innerHTML = "Please create your profile";

            }
            else{

                document.getElementById("name").innerHTML = response.name;
                document.getElementById("email").innerHTML = response.email;
                document.getElementById("address").innerHTML = response.address;
                document.getElementById("dob").innerHTML = response.dob;
                document.getElementById("gender").innerHTML = response.gender;
                document.getElementById("number").innerHTML = response.number;

                if(response.gender == "Male"){
                    document.getElementById("usertype").src = "../images/maleuser.png";
                }
                else{
                    document.getElementById("usertype").src = "../images/femaleuser.jpg";
                }
            }
        },
        error: function(error){
            console.log(error);
            alert("something went wrong when loading your profile")
        }

    })
}



var container = document.getElementById("form_wrapper");
var btn = document.getElementById("update");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function(){
    container.style.display = "block";
    document.getElementById("updatename").value = document.getElementById("name").innerHTML; 
    document.getElementById("updateaddress").value = document.getElementById("address").innerHTML; 
    document.getElementById("updateDOB").value = document.getElementById("dob").innerHTML; 
    document.getElementById("updatenumber").value = document.getElementById("number").innerHTML;
    document.getElementById("updategender").value = document.getElementById("gender").innerHTML; 
}

span.onclick = function(){
    container.style.display = "none";
}


function UpdateProfile(){
    let userdata =
    {
        name: document.getElementById("updatename").value,
        email: sessionStorage.getItem("currentuser"),
        dob: document.getElementById("updateDOB").value,
        address: document.getElementById("updateaddress").value,
        number: document.getElementById("updatenumber").value,
        gender: document.getElementById("updategender").value
    }

    $.ajax({
        type: "PUT",
        url: "http://localhost:8085/api/updateProfile",
        headers:
        {
            "Content-Type" : "application/json"
        },
        data: JSON.stringify(userdata),
        success: function(response){
            alert("Your profile has been successfully updated")
        },
        error: function(error){
            console.log(error);
            alert("An error has occured while updating your profile")
        }
    })
}

//Greeting for customer
function greeting(){
    let useremail = sessionStorage.getItem("currentuser");

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/getprofile/" + useremail,
        headers:
        {
            "Content-Type" : "application/json"
        },
        success:function(response){
            if(response.email == null){
                document.getElementById("UserName").innerHTML = "Customer";
            }
            else{
              document.getElementById("UserName").innerHTML = response.name;
            }
        },

        error:function(error){
            console.log(error);
            alert("something went when accessing your profile");
        }
    })
}

