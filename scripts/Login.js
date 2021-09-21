function login(){
    let userdata = 
    {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8085/api/login",
        headers:
        {
            "Content-type" : "application/json"
        },
        data: JSON.stringify(userdata),
        success: function(response){

            emailval = document.getElementById("email").value;
            sessionStorage.setItem("currentuser", emailval);


            if (response== 1){
                window.location.href = "Customer_home.html"
            }
            else if(response == 2){
                window.location.href = "Restaurant_home.html"
            }
            else if (response == 3){
                window.location.href = "Admin_home.html"
            }
            else { 
                alert("Invalid User credentials")
            }
        },
        error: function(error){
            console.log(error);
            alert("An error has occured while trying to login")
        }
        

    })
}