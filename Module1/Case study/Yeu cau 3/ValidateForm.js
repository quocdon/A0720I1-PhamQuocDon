function validateForm() {
    let guestname = document.forms["guestinfo"]["guestname"];
    let guestid = document.forms["guestinfo"]["guestid"];
    let guestdob = document.forms["guestinfo"]["guestdob"];
    let guestemail = document.forms["guestinfo"]["guestemail"];
    let address = document.forms["guestinfo"]["address"];
    let guestclass = document.forms["guestinfo"]["guestclass"];
    let rentdays = document.forms["guestinfo"]["rentdays"];
    let services = document.forms["guestinfo"]["services"];
    let roomtype = document.forms["guestinfo"]["roomtype"];
    /*Tên không được để trống*/
    if (guestname.value = ""){
        alert("Please input guest name")
        return false;
    }
    if (guestid.value=""){
        alert("Please input Guest ID");
        return false;
    }
    else {
        if (isNaN(guestid.value) || guestid.value.length <> 9){
            alert("The guest ID is incorrect");
            return false;
        }

    }
    let aCircleIndex = guestemail.value.indexOf("@");
    let dotIndex = guestemail.value.lastIndexOf(".");
    if (guestemail.value = ""){
        alert("Please input guest email!");
        return false;
    }
    else {
        if ((aCircleIndex < 1) || (dotIndex < aCircleIndex +2) || (dotIndex + 2 > guestemail.value.length)){
            alert("The email is incorrect");
            return false;
        }
    }
}