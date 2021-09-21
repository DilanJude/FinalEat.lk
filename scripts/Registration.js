function register(){

    uPass= document.getElementById("password").value;
    ruPass= document.getElementById("repassword").value;


    if(uPass==ruPass){

    let userdata = 
    {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        type: document.getElementById("type").value
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8085/api/register",
        headers: 
        {
            "Content-Type" : "application/json"
        },
        data: JSON.stringify(userdata),
        success: function(response){
            alert("Suceessfully Registered")
        },
        error: function(error){
            console.log(error);
            alert("An error has occurred while registering")
        }
        
    })

    }
    else{
        alert("Passwords do not match")
    }




}