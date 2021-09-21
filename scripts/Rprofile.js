var btn = document.getElementById("feedback"); 

btn.onclick = function(){
    if (sessionStorage.getItem("currentuser") == null){
        alert("You have to be logged in to submit feedback");
    }
    else{
    Restaurant_name = document.getElementById("name").innerHTML;
    sessionStorage.setItem("Rname", Restaurant_name);
    window.location.href = "Feedback.html";
    }
}

function submitfeedback(){
    let userdata = 
    {
        restaurantName : sessionStorage.getItem("Rname"),
        customerName : document.getElementById("customerName").value,
        rating : document.getElementById("rating").value,
        comment : document.getElementById("comment").value

    }

    $.ajax({
        type : "POST",
        url : "http://localhost:8085/api/submitFeedback",
        headers:
        {
            "Content-Type" : "application/json"
        },
        data : JSON.stringify(userdata),
        success : function(response){
            alert("Thank you for your Feedback !")
        },
        error : function(error){
            console.log(error);
            alert("An error has occured when trying to submit your feedback")
        }
    })
}



var btn2 = document.getElementById("viewComments");

btn2.onclick = function(){
    window.location.href = "Comments.html?restaurant="+ document.getElementById("name").innerHTML;
}


var btn3 = document.getElementById("menu");

btn3.onclick = function(){
    window.location.href = "Menu_Page.html?restaurant="+document.getElementById("name").innerHTML;
}