let guestname
let guestid
let guestdob
let guestemail;
let address
let guestclass;
let numOfGuest
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
    document.getElementById("showinformation").innerHTML = "<p CLASS='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
        "        BOOKING INFORMATION" +
        "    </p><br><br><br><br><br><br>" +
        "<form action='guest.info.html' method='post' id='guestinfo'>" +
        "        <table class='guest-table'>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Tên khách hàng/Guest name<label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='guestname'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Số CMND/ID number:</label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='guestid'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Ngày sinh/Date of birth</label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='guestdob' placeholder='DD/MM/YYYY'>" +
        "                </td>" +
        "            </tr>" +
                    "<tr>" +
        "                <td>" +
        "                    <label>Email</label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='guestemail'>" +
        "                </td>" +
        "            </tr>"+
        "            <tr>" +
        "                <td>" +
        "                    <label>Địa chỉ/Address:</label>" +
        "                </td>" +
        "                <td>" +
        "                    <select class='selectstyled' id='address'>" +
        "                        <option>Đà Nẵng</option>" +
        "                        <option>Thừa Thiên Huế</option>" +
        "                        <option>Quảng Nam</option>" +
        "                        <option>Tỉnh khác</option>" +
        "                    </select>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>Hạng khách hàng/Customer Class:</td>\n" +
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
        "                <td>Số lượng khách/Number of Guest</td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='numOfGuest'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>Số ngày thuê/rentdays</td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='rentdays'>" +
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
        "                    &#160 &#160 &#160 &#160\n" +
        "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
        "                </td>" +
        "            </tr>" +
        "        </table>" +
        "    </form>";
}

function infosubmit() {
    /*Get data from input form*/
    guestname = document.forms["guestinfo"]["guestname"];
    guestid = document.forms["guestinfo"]["guestid"];
    guestdob = document.forms["guestinfo"]["guestdob"];
    guestemail = document.forms["guestinfo"]["guestemail"]
    address = document.forms["guestinfo"]["address"];
    guestclass = document.forms["guestinfo"]["guestclass"];
    numOfGuest = document.forms["guestinfo"]["numOfGuest"];
    rentdays = document.forms["guestinfo"]["rentdays"];
    services = document.forms["guestinfo"]["services"];
    roomtype = document.forms["guestinfo"]["roomtype"];
    let checkinfo = true;
    let messageAlert = "";
    let temp = "";
// Check guest name
    if (guestname.value ===""){
        checkinfo = false;
        messageAlert += "Tên khách hàng: Chưa nhập thông tin \n";
    } else {
        for (let i = 0; i < guestname.value.length; i++) {
            if (guestname.value.charAt(i) === " " && guestname.value.charAt(i + 1) === " ") {
                continue;
            }
            temp += guestname.value.charAt(i);
        }
        guestname.value = temp;
    }
//Check guestID format
    if (guestid.value === ""){
        checkinfo = false;
        messageAlert += "Số CMND: Chưa nhập thông tin \n"
    } else if (guestid.value.length !== 8 || !Number.isInteger(parseInt(guestid.value) || parseInt(guestid.value) < 0)){
        checkinfo = false;
        messageAlert += "Số CMND: Nhập sai định dạng XXXXXXXX \n"
    }
// Check DoB format
    let checkdob = false;
    if (guestdob.value === ""){
        checkinfo = false;
        messageAlert += "Ngày sinh: Chưa nhập thông tin \n"
    } else {
        if (guestdob.value.length === 10 && guestdob.value.charAt(2) ==="/" && guestdob.value.charAt(5) ==="/"){
            let date = guestdob.value.substr(0,2);
            let month =  guestdob.value.substr(3,2);
            let year = guestdob.value.substr(6,4);
            if (!isNaN(date) && !isNaN(month) && !isNaN(year)){
                date = parseFloat(date);
                month = parseFloat(month);
                year = parseFloat(year);
                if (Number.isInteger(date) && Number.isInteger(month) && Number.isInteger(year)){
                    if (date < 32 && month < 13 && year > 1900){
                        checkdob = true;
                    }
                }
            }
        }
        if (!checkdob){
            checkinfo = false;
            messageAlert += "Ngày sinh: Không đúng định dạng DD/MM/YYYY \n "
        }
    }
// Check email format
    let filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (guestemail.value ===""){
        checkinfo = false;
        messageAlert += "Email: Chưa nhập thông tin \n"
    } else if (!filter.test(guestemail.value)){
        checkinfo = false;
        messageAlert += "Email: Không đúng định dạng abc@def.xyz \n";
    }


// Check Number Of Guest
    if (numOfGuest.value === ""){
        checkinfo = false;
        messageAlert += "Số lượng khách: Chưa nhập thông tin\n"
    } else if (isNaN(numOfGuest.value) || !Number.isInteger(parseFloat(numOfGuest.value)) || parseFloat(numOfGuest.value) < 0){
        checkinfo = false;
        messageAlert += "Số lượng khách: Không đúng định dạng số nguyên dương \n"
    }
// Check rentdays
    if (rentdays.value === ""){
        checkinfo = false;
        messageAlert += "Số ngày thuê: Chưa nhập thông tin\n"
    } else if (isNaN(rentdays.value) || !Number.isInteger(parseFloat(rentdays.value)) || parseFloat(rentdays.value) < 0){
        checkinfo = false;
        messageAlert += "Số ngày thuê: Không đúng định dạng số nguyên dương \n"
    }
// Alert information submit status
    if (checkinfo){
        alert("Thông tin đã được cập nhật!")
    } else alert(messageAlert);


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
        "<td>Email: </td>"+
        "<td>" + guestemail.value + "</td>"+
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
        "<td>Số lượng khách/ Number of Guest: </td>"+
        "<td>" + numOfGuest.value + "</td>"+
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
    "                    <input class='inputstyle' type='text' id='guestdob' value='" + guestdob.value +"'>" +
    "                </td>" +
    "            </tr>" +
    "            <tr>" +
    "                <td>" +
    "                    <label>Email</label>" +
    "                </td>" +
    "                <td>" +
    "                    <input class='inputstyle' type='text' id='guestemail' + value='" + guestemail.value +"'>" +
    "                </td>" +
    "            </tr>"+
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
    "                <td>Số lượng khách/Number of Guest:</td>" +
    "                <td>" +
    "                    <input class='inputstyle' type='text' id='numOfGuest' value='"+ numOfGuest.value +"'>" +
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
            "<th>Email</th>"+
            "<th>Địa chỉ</th>" +
            "<th>Hạng khách hàng</th>" +
        "</tr>" +
        "<tr>" +
            "<td>" + guestname.value + "</td>" +
            "<td>" + guestid.value + "</td>" +
            "<td>" + guestdob.value + "</td>" +
            "<td>" + guestemail.value + "</td>" +
            "<td>" + address.value + "</td>" +
            "<td>" + guestclass.value + "</td>" +
            "<td>" + numOfGuest.value + "</td>" +
            "<td>" + rentdays.value + "</td>" +
            "<td>" + services.value + "</td>" +
            "<td>" + roomtype.value + "</td>" +
            "<td>" + amount + "</td>" +
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