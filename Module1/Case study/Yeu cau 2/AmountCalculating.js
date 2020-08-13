let guestname
let guestid
let guestdob
let address
let guestclass;
let rentdays;
let services;
let roomtype;
let price;
let amount;
let discount;
let addDiscount;
let stayDiscount;
let classDiscount;
function inputguestinfo() {
    document.getElementById("showinformation").innerHTML = "<p CLASS=\"header\">THÔNG TIN ĐẶT PHÒNG <br>" +
        "        BOOKING INFORMATION" +
        "    </p><br><br><br><br><br><br>" +
        "<form action='guest.info.html' method=\"post\" id=\"guestinfo\">\n" +
        "        <table class=\"guest-table\">\n" +
        "            <tr>\n" +
        "                <td>\n" +
        "                    <label>Tên khách hàng/Guest name<label>\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <input class=\"inputstyle\" type=\"text\" id=\"guestname\">\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>\n" +
        "                    <label>Số CMND/ID number:</label>\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <input class=\"inputstyle\" type=\"text\" id=\"guestid\">\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>\n" +
        "                    <label>Ngày sinh/Date of birth</label>\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <input class=\"inputstyle\" type=\"date\" id=\"guestdob\">\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>\n" +
        "                    <label>Địa chỉ/Address:</label>\n" +
        "                </td>\n" +
        "                <td>\n" +
        "                    <select class=\"selectstyled\" id=\"address\">\n" +
        "                        <option>Đà Nẵng</option>\n" +
        "                        <option>Thừa Thiên Huế</option>\n" +
        "                        <option>Quảng Nam</option>\n" +
        "                        <option>Tỉnh khác</option>\n" +
        "                    </select>\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>Hạng khách hàng/Customer Class:</td>\n" +
        "                <td>\n" +
        "                    <select class=\"selectstyled\" id=\"guestclass\">\n" +
        "                        <option>Diamond</option>\n" +
        "                        <option>Platinum</option>\n" +
        "                        <option>Gold</option>\n" +
        "                        <option>Silver</option>\n" +
        "                        <option>Member</option>\n" +
        "                    </select>\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>Số ngày thuê/rentdays</td>\n" +
        "                <td>\n" +
        "                    <input class=\"inputstyle\" type=\"text\" id=\"rentdays\">\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>Loại dịch vụ/ Services</td>\n" +
        "                <td>\n" +
        "                    <select class=\"selectstyled\" id=\"services\">\n" +
        "                        <option>Villa</option>\n" +
        "                        <option>House</option>\n" +
        "                        <option>Room</option>\n" +
        "                    </select>\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td>Loại phòng/Room type</td>\n" +
        "                <td>\n" +
        "                    <select class=\"selectstyled\" id=\"roomtype\">\n" +
        "                        <option>VIP</option>\n" +
        "                        <option>Business</option>\n" +
        "                        <option>Normal</option>\n" +
        "                    </select>\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td></td>\n" +
        "                <td><br>\n" +
        "                    <input type=\"button\" class=\"buttonstyle\" value=\"Submit\" onclick=\"infosubmit()\" onmouseover=\"Smouseover()\" onmouseout=\"Smouseout()\" id=\"submitButton\">\n" +
        "                    &#160 &#160 &#160 &#160\n" +
        "                    <input type=\"reset\" class=\"buttonstyle\" value=\"Reset\" onmouseover=\"Rmouseover()\" onmouseout=\"Rmouseout()\" id=\"resetButton\">\n" +
        "                </td>\n" +
        "            </tr>\n" +
        "        </table>\n" +
        "    </form>";
}

function infosubmit() {
    /*Get data from input form*/
    guestname = document.forms["guestinfo"]["guestname"];
    guestid = document.forms["guestinfo"]["guestid"];
    guestdob = document.forms["guestinfo"]["guestdob"];
    address = document.forms["guestinfo"]["address"];
    guestclass = document.forms["guestinfo"]["guestclass"];
    rentdays = document.forms["guestinfo"]["rentdays"];
    services = document.forms["guestinfo"]["services"];
    roomtype = document.forms["guestinfo"]["roomtype"];
    alert("Thông tin đã được cập nhật");
}
function totalamount() {
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
    document.getElementById("showinformation").innerHTML = "<table class='confirmationTable'>" +
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
function editguestinfo() {
    document.getElementById("showinformation").innerHTML = "<p CLASS='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
                "BOOKING INFORMATION" +
            "</p><br><br><br><br><br><br>" +
        "<form action='guest.info.html' method='post' id='guestinfo'>" +
                "<table class='guest-table'>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Tên khách hàng/Guest name<label>" +
        "                </td>" +
        "                <td>" + "<input class='inputstyle' type='text' id='guestname' value='" + guestname.value +"'>" +
        "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>" +
    "                    <label>Số CMND/ID number:</label>" +
    "                </td>" +
    "                <td>" +
    "                    <input class='inputstyle' type='text' id='guestid' value='"+guestid.value+"'>" +
    "                </td>\n" +
    "            </tr>" +
    "            <tr>" +
    "                <td>" +
    "                    <label>Ngày sinh/Date of birth</label>\n" +
    "                </td>\n" +
    "                <td>" +
    "                    <input class=\"inputstyle\" type=\"date\" id='guestdob' value='" + guestdob.value +"'>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>" +
    "                    <label>Địa chỉ/Address:</label>" +
    "                </td>\n" +
    "                <td>\n" +
    "                    <select class='selectstyled' id='address'>" +
    "                        <option>Đà Nẵng</option>" +
    "                        <option>Thừa Thiên Huế</option>" +
    "                        <option>Quảng Nam</option>" +
    "                        <option>Tỉnh khác</option>" +
    "                    </select>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>Hạng khách hàng/Customer Class:</td>" +
    "                <td>" +
    "                    <select class='selectstyled' id='guestclass'>" +
    "                        <option>Diamond</option>" +
    "                        <option>Platinum</option>" +
    "                        <option>Gold</option>" +
    "                        <option>Silver</option>" +
    "                        <option>Member</option>" +
    "                    </select>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>Số ngày thuê/rentdays</td>" +
    "                <td>" +
    "                    <input class='inputstyle' type='text' id='rentdays' value='"+ rentdays.value +"'>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>Loại dịch vụ/ Services</td>" +
    "                <td>" +
    "                    <select class='selectstyled' id='services'>" +
    "                        <option>Villa</option>" +
    "                        <option>House</option>" +
    "                        <option>Room</option>" +
    "                    </select>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>Loại phòng/Room type</td>" +
    "                <td>" +
    "                    <select class='selectstyled' id='roomtype'>" +
    "                        <option>VIP</option>" +
    "                        <option>Business</option>" +
    "                        <option>Normal</option>" +
    "                    </select>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td></td>" +
    "                <td><br>" +
    "                    <input type='button' class='buttonstyle' value='Submit' onclick='infosubmit()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
    "                    &#160 &#160 &#160 &#160" +
    "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
    "                </td>" +
    "            </tr>" +
    "        </table>" +
    "    </form>";
    let temp1 = address.value;
    let mySelect1 = document.getElementById("address");
    for (let i, j = 0; i = mySelect1.options[j]; j++){
        if (i.value == temp1){
            mySelect1.selectedIndex = j;
            break;
        }
    }
    temp = guestclass.value;
    mySelect = document.getElementById("guestclass");
    for (let i, j = 0; i = mySelect.options[j]; j++){
        if (i.value == temp){
            mySelect.selectedIndex = j;
            break;
        }
    }
    temp = services.value;
    mySelect = document.getElementById("services");
    for (let i, j = 0; i = mySelect.options[j]; j++){
        if (i.value == temp){
            mySelect.selectedIndex = j;
            break;
        }
    }
    temp = roomtype.value;
    mySelect = document.getElementById("roomtype");
    for (let i, j = 0; i = mySelect.options[j]; j++){
        if (i.value == temp){
            mySelect.selectedIndex = j;
            break;
        }
    }
}

function showguestinfo() {
    document.getElementById("showinformation").innerHTML = "<table class='showInfoTable'>"+
        "<tr>"+
            "<th>Tên khách hàng </th>" +
            "<th>Số CMND</th>" +
            "<th>Ngày sinh</th>" +
            "<th>Địa chỉ</th>" +
            "<th>Hạng khách hàng</th>" +
        "</tr>" +
        "<tr>" +
            "<td>" + guestname.value + "</td>" +
            "<td>" + guestid.value + "</td>" +
            "<td>" + guestdob.value + "</td>" +
            "<td>" + address.value + "</td>" +
            "<td>" + guestclass.value + "</td>" +
        "</tr>"
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
function editdetail(field) {
    document.getElementById('name').innerHTML = "<form id=field> "
}