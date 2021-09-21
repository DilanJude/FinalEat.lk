function createmenu(){
    useremail = sessionStorage.getItem("currentuser");

    let userdata = 
    {
        name : document.getElementById("name").value,
        email : useremail,
        item1 : document.getElementById("item1").value,
        item2 : document.getElementById("item2").value,
        item3 : document.getElementById("item3").value,
        item4 : document.getElementById("item4").value,
        item5 : document.getElementById("item5").value
    }


    $.ajax({
        type : "POST",
        url : "http://localhost:8085/api/createmenu",
        headers:
        {
            "Content-Type" : "application/json"
        },
        data : JSON.stringify(userdata),
        success : function(response){
            alert("Your menu has been created successfully")
        },
        error : function(error){
            console.log(error);
            alert("An error has occured while trying to create your menu")
        }

    })
}


