function totalamount() {
    /*Get data from input form*/
    let guestname = document.forms["guestinfo"]["guestname"];
    let guestid = document.forms["guestinfo"]["guestid"];
    let guestdob = document.forms["guestinfo"]["guestdob"];
    let address = document.forms["guestinfo"]["address"];
    let guestclass = document.forms["guestinfo"]["guestclass"];
    let rentdays = document.forms["guestinfo"]["rentdays"];
    let services = document.forms["guestinfo"]["services"];
    let roomtype = document.forms["guestinfo"]["roomtype"];
    let price;
    let amount;
    let discount;
    let discountprice;
    let addDiscount;
    let stayDiscount;
    let classDiscount;
    /* Get price based on services*/
    switch (services.value) {
        case ("Villa"): {
            price = 500;
            break;
        }
        case "House": {
            price = 300;
            break;
        }
        case "Room":{
            price = 100;
            break;
        }
    }
    /* Discount by address*/
    switch (address.value){
        case "Đà Nẵng": {
            addDiscount = 20;
            break;
        }
        case  "Thừa Thiên Huế": {
            addDiscount = 10;
            break;
        }
        case "Quảng Nam": {
            addDiscount = 5;
            break;
        }
        default: {addDiscount = 0};
    }
    /*Discount by number of day staying*/
    if (parseInt(rentdays.value) >= 7) {
        stayDiscount = 30;
    }
    else {
        if (parseInt(rentdays.value) >= 5) {
            stayDiscount = 20;
        }
        else {
            if (parseInt(rentdays.value) >= 2) {
                stayDiscount = 10;
            }
            else stayDiscount = 0;
        }

    }
    /*Discount by Customer class */
    switch (guestclass.value) {
        case "Diamond": {
            classDiscount = 15;
            break;
        }
        case "Platinum":{
            classDiscount = 10;
            break;
        }

        case "Gold":{
            classDiscount = 5;
            break;
        }
        case "Silver":{
            classDiscount = 2;
            break;
        }
        case "Member":{
            classDiscount = 0;
            break;
        }

    }
    discount = addDiscount + stayDiscount + classDiscount;
    amount = price * parseInt(rentdays.value) - discount;

    /*Display booking confirmation with total amount to screen*/
    document.getElementById("ketqua").innerHTML = "<table class='confirmationTable'>" +
        "<tr>" +
            "<td colspan='2' class='confirmationHeader'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</td>"+
        "</tr>"+
        "<tr>" +
            "<td>Tên khách hàng/ Guest name: </td>"+
            "<td>" + guestname.value +"</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Số CMND/ID Number: </td>"+
            "<td>" + guestid.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Ngày sinh/ Date of birth: </td>"+
            "<td>" + guestdob.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Địa chỉ/ Address: </td>"+
            "<td>" + address.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Hạng khách hàng/ Customer class: </td>"+
            "<td>" + guestclass.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Số ngày thuê/ Rentdays: </td>"+
            "<td>" + rentdays.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Loại dịch vụ/ Services: </td>"+
            "<td>" + services.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Loại phòng/ Room type: </td>"+
            "<td>" + roomtype.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Đơn giá/ Price: </td>"+
            "<td>"+ price + " USD/Đêm" + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Giảm giá/ Discount: </td>"+
            "<td>"+ discount + " USD (Add: " + addDiscount + " - Rdd: " + stayDiscount + " - Cls: " + classDiscount + ")" + "</td>" +
        "</tr>"+
        "<tr>"+
            "<td>Thành tiền/ Total Amount: </td>"+
            "<td class='amountstyle''>" + amount + "  USD</td>"+
        "</tr>"+
        "</table>"
}
/* Making styles for Submit and Reset button */
function Smouseover() {
    document.getElementById("submitButton").style.color="white";
    document.getElementById("submitButton").style.background="#a0a0a0";
}
function Smouseout() {
    document.getElementById("submitButton").style.color="black";
    document.getElementById("submitButton").style.background="white"
}
function Rmouseover() {
    document.getElementById("resetButton").style.color="white";
    document.getElementById("resetButton").style.background="#a0a0a0";
}
function Rmouseout() {
    document.getElementById("resetButton").style.color="Black";
    document.getElementById("resetButton").style.background="white";
}