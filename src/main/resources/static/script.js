let valid = true;   //Boolean used to tell whether the input in the form is valid
let films = []; //Local array containing the films

$(function (){ //Ready function that runs every time the page loads
    getFilms();
})
function getFilms(){
    $("#films").html(`<option disabled selected hidden>Velg film her</option>`); //Resets the drop-down in the form to only containing the placeholder
    $.post("/get-films", function (filmArray){
        films = filmArray; //Sets the local film array to the imported array from the server
        for (let film of filmArray){
            $("#films").append(`<option value="${film}">${film}</option>`); //Fills out the drop-down with the films
        }
    })
}
function fillOutArray(){
    $.post("/get-tickets", function (tickets){
        console.log(tickets);
        $("#ticketsTable").html(""); //Clears the table first
        for (let film of films){ //Loops through all the films
            $("#ticketsTable").append(`<tr><th>${film}</th></tr>`) //Adds the films as table headers
            for (let ticket of tickets){
                if (ticket.film === film){
                    $("#ticketsTable").append(ticketFormat(ticket)); //Loops through all the tickets to place each films' corresponding tickets underneath it
                }
            }
        }

    })
}
function ticketFormat(ticket){
    return `<tr><td>${ticket.firstName} ${ticket.lastName} has ${ticket.numberOfTickets} ${getTicketText(ticket.numberOfTickets)}</td></tr>`;
}
//Fixes singular/plural grammar in the form
function getTicketText(numberOfTickets){
    if (numberOfTickets===1){
        return " ticket";
    }
    else{
        return " tickets";
    }
}


//function that runs when the button for buying tickets is pressed
$("#buyTicket").click(function (){
    valid = true; //Valid is true by default

    let ticket = {
        film: inputValidation($("#films").val(),"films"),
        numberOfTickets: inputValidation($("#number").val(),"number"),
        firstName: inputValidation($("#firstname").val(),"name"),
        lastName: inputValidation($("#lastname").val(),"name"),
        tlf: inputValidation($("#tlf").val(),"tlf"),
        email: inputValidation($("#email").val(),"email")
    };

    if (valid){ //This section will only run if the input validation has passed
        $.post("/register-ticket",ticket); //Adds the ticket to the server
        fillOutArray();
        $("#deleteTickets").show(); //Shows the delete button as there are now tickets that can be deleted
    }
})

//Function that runs when the button for deleting all tickets is pressed
$("#deleteTickets").click(function (){
    const confirmDelete = confirm("Are you sure you want to delete all tickets?"); //Shows a confirm dialog where the user gets the opportunity to abort the deletion
    if (confirmDelete){
        $.post("/delete-tickets"); //Clears the arraylist on the server
        $("#ticketsTable").html("<tr>No tickets have been bought yet</tr>");
        $("#deleteTickets").hide(); //Hides the delete button again as it serves no purpose until a new ticket is bought
    }
})


//Input validation. If it passes all, nothing is changed. If fail an alert pops up with the reason and valid is set to false (second part of buyTicket function will not run as a result)

function inputValidation(input, type){
    if (input === undefined || input.trim()===""){
        alert("One of the fields were not given a value. Please check your input")
        valid = false;
    }
    else if (type === "tlf"){
        if (isNaN(parseInt(input)) || !isEightDigits(input)){
            alert("The phone number entered is not valid")
            valid = false;
        }
    }
    else if (type === "email"){
        let emailPattern = /^\S+@\S+\.\S+$/; //Regular expression for email-validation
        if (!emailPattern.test(input)){
            alert("The email you entered was not valid.")
            valid = false;
        }
    }
    return input;
}
function isEightDigits(input){
    return input.toString().length === 8;
}


