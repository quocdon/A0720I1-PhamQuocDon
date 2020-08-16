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
let messageAlert;
let arrGuestAccount = new Array();
let listOfGuest = new Array();
let index;

//----------- Show input form -------------------
function inputguestinfo(){
    document.getElementById("showinformation").innerHTML = "<p CLASS=\"header\">THÔNG TIN ĐẶT PHÒNG <br>" +
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
        "                    <input type='button' class='buttonstyle' value='Submit' onclick='submitbutton()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
        "                    &#160 &#160 &#160 &#160\n" +
        "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
        "                </td>" +
        "            </tr>" +
        "        </table>" +
        "    </form>";
}

//----------- Edit guest information-------------
function editguestinfo() {
    findguest();
    if (index === listOfGuest.length) {
        alert("Không tìm thấy tên khách hàng");
    } else {
        document.getElementById("showinformation").innerHTML = "<p CLASS='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
            "BOOKING INFORMATION" +
            "</p><br><br><br><br><br><br>" +
            "<form action='guest.info.html' method='post' id='guestinfo'>" +
            "<table class='guest-table'>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Tên khách hàng/Guest name<label>" +
            "                </td>" +
            "                <td>" + "<input class='inputstyle' type='text' id='guestname' value='" + listOfGuest[index][0] + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số CMND/ID number:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestid' value='" + listOfGuest[index][1] + "'>" +
            "                </td>\n" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Ngày sinh/Date of birth</label>\n" +
            "                </td>\n" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestdob' value='" + listOfGuest[index][2] + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Email</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestemail' + value='" + listOfGuest[index][3] + "'>" +
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
            "                <td>Số lượng khách/Number of Guest:</td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='numOfGuest' value='" + listOfGuest[index][6] + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>Số ngày thuê/rentdays</td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='rentdays' value='" + listOfGuest[index][7] + "'>" +
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
            "                    <input type='button' class='buttonstyle' value='Update' onclick='updatebutton()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
            "                    &#160 &#160 &#160 &#160" +
            "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
            "                </td>" +
            "            </tr>" +
            "        </table>" +
            "    </form>";
        let temp = listOfGuest[index][4];
        let mySelect = document.getElementById("address");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfGuest[index][5];
        mySelect = document.getElementById("guestclass");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfGuest[index][8];
        mySelect = document.getElementById("services");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfGuest[index][9];
        mySelect = document.getElementById("roomtype");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
    }
}

//----------- Delete guest account---------------
function deleteguestinfo() {
    findguest();
    if (index === listOfGuest.length){
        alert("Không tìm thấy tên khách hàng");
    } else {
        listOfGuest.splice(index,1);
        alert("Đã xóa khách hàng");
    }
    showguestinfo();
}

//----------- Show list of guest account---------
function showguestinfo() {
    let guestinfotable = "<table class='showInfoTable'>"+
        "<tr>"+
        "<th>STT </th>" +
        "<th>Tên khách hàng </th>" +
        "<th>Số CMND</th>" +
        "<th>Ngày sinh</th>" +
        "<th>Email</th>"+
        "<th>Địa chỉ</th>" +
        "<th>Hạng khách hàng</th>" +
        "<th>SL khách</th>" +
        "<th>Số ngày thuê</th>" +
        "<th>Loại dịch vụ</th>" +
        "<th>Loại phòng</th>" +
        "<th>Số tiền phải trả</th>" +
        "</tr>";
    listOfGuest.sort();
    for (let i = 0; i < listOfGuest.length; i++){
        guestinfotable += "<tr>" +
            "<td>"+ parseInt(i+1) +"</td>";
        for (let j = 0; j < listOfGuest[i].length; j++){
            guestinfotable = guestinfotable + "<td>" + listOfGuest[i][j] + "</td>"
        }
        guestinfotable += "</tr>";
    }
    guestinfotable += "</table>";
    document.getElementById("showinformation").innerHTML = guestinfotable;
}

//----------- Show booking confirmation ---------
function confirmation() {
    findguest();
    if (index === listOfGuest.length) {
        alert("Không tìm thấy tên khách hàng");
    } else {
        document.getElementById("showinformation").innerHTML = "<table class='confirmationTable'>" +
            "<tr>" +
            "<td colspan='2' class='confirmationHeader'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Tên khách hàng/ Guest name: </td>" +
            "<td>" + listOfGuest[index][0] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số CMND/ID Number: </td>" +
            "<td>" + listOfGuest[index][1] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Ngày sinh/ Date of birth: </td>" +
            "<td>" + listOfGuest[index][2] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Email: </td>" +
            "<td>" + listOfGuest[index][3] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Địa chỉ/ Address: </td>" +
            "<td>" + listOfGuest[index][4] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Hạng khách hàng/ Customer class: </td>" +
            "<td>" + listOfGuest[index][5] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số lượng khách/ Number of Guest: </td>" +
            "<td>" + listOfGuest[index][6] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số ngày thuê/ Rentdays: </td>" +
            "<td>" + listOfGuest[index][7] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Loại dịch vụ/ Services: </td>" +
            "<td>" + listOfGuest[index][8] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Loại phòng/ Room type: </td>" +
            "<td>" + listOfGuest[index][9] + "</td>" +
            "</tr>" +
            "<tr>" +
            "<tr>" +
            "<td>Thành tiền/ Total Amount: </td>" +
            "<td class='amountstyle''>" + listOfGuest[index][10] + "  USD</td>" +
            "</tr>" +
            "</table>"
    }
}

// --------- Submit button event ----------------
function submitbutton() {
    messageAlert = "";
    getinputdata();
    if (checkinfo()){
        totalamount();
        arrGuestAccount = [guestname.value, guestid.value, guestdob.value, guestemail.value, address.value, guestclass.value, numOfGuest.value, rentdays.value, services.value, roomtype.value, amount];
        listOfGuest.push(arrGuestAccount);
        alert("Thông tin được nhập thành công");
        document.getElementById("guestinfo").reset();
    } else {alert(messageAlert)}
}

//---------- Update button event ----------------
function updatebutton() {
    messageAlert = "";
    getinputdata();
    if (checkinfo()){
        totalamount();
        arrGuestAccount = [guestname.value, guestid.value, guestdob.value, guestemail.value, address.value, guestclass.value, numOfGuest.value, rentdays.value, services.value, roomtype.value, amount];
        listOfGuest.splice(index,1);
        listOfGuest.push(arrGuestAccount);
        alert("Chỉnh sửa thành công");
    } else {alert(messageAlert)}
}

//----------- Get Data from input form ----------
function getinputdata() {
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
}

//----------- Check input information format -------------
function checkinfo(){
    let temp = "";
// Check guest name
    if (guestname.value ===""){
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
        messageAlert += "Số CMND: Chưa nhập thông tin \n"
    } else if (guestid.value.length !== 8 || isNaN(guestid.value) || !Number.isInteger(parseFloat(guestid.value)) || parseFloat(guestid.value) < 0){
        messageAlert += "Số CMND: Phải là dãy số có 8 chữ số \n";
    }
// Check DoB format
    let checkdob = false;
    if (guestdob.value === ""){
        messageAlert += "Ngày sinh: Chưa nhập thông tin \n";
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
            messageAlert += "Ngày sinh: Phải đúng định dạng DD/MM/YYYY và năm sinh lớn hơn 1900 \n "
        }
    }
// Check email format
    let filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (guestemail.value ===""){
        messageAlert += "Email: Chưa nhập thông tin \n"
    } else if (!filter.test(guestemail.value)){
        messageAlert += "Email: Phải đúng định dạng abc@def.xyz \n";
    }


// Check Number Of Guest
    if (numOfGuest.value === ""){
        messageAlert += "Số lượng khách: Chưa nhập thông tin\n"
    } else if (isNaN(numOfGuest.value) || !Number.isInteger(parseFloat(numOfGuest.value)) || parseFloat(numOfGuest.value) < 0){
        messageAlert += "Số lượng khách: Phải là số nguyên dương \n"
    }
// Check rentdays
    if (rentdays.value === ""){
        messageAlert += "Số ngày thuê: Chưa nhập thông tin\n"
    } else if (isNaN(rentdays.value) || !Number.isInteger(parseFloat(rentdays.value)) || parseFloat(rentdays.value) < 0){
        messageAlert += "Số ngày thuê: Phải là số nguyên dương \n"
    }
    if (messageAlert !== ""){
        return false
    } else return true;
}

// --------- Calculate booking amount -----------
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
        case "Room": {
            price = 100;
            break;
        }
    }
    /* Discount by address*/
    switch (address.value) {
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
        default: {
            addDiscount = 0
        }
            ;
    }
    /*Discount by number of day staying*/
    if (parseInt(rentdays.value) >= 7) {
        stayDiscount = 30;
    } else {
        if (parseInt(rentdays.value) >= 5) {
            stayDiscount = 20;
        } else {
            if (parseInt(rentdays.value) >= 2) {
                stayDiscount = 10;
            } else stayDiscount = 0;
        }

    }
    /*Discount by Customer class */
    switch (guestclass.value) {
        case "Diamond": {
            classDiscount = 15;
            break;
        }
        case "Platinum": {
            classDiscount = 10;
            break;
        }

        case "Gold": {
            classDiscount = 5;
            break;
        }
        case "Silver": {
            classDiscount = 2;
            break;
        }
        case "Member": {
            classDiscount = 0;
            break;
        }

    }
    discount = addDiscount + stayDiscount + classDiscount;
    amount = price * parseInt(rentdays.value) - discount;
}

//--------- Find guest frorm Guest Account array ----------
function findguest() {
    let Guest = prompt("Nhập tên khách hàng");
    index = 0;
    if (listOfGuest.length > 0){
        while (listOfGuest[index][0] !== Guest && listOfGuest !== "") {
            index++;
            if (index === listOfGuest.length) {
                break;
            }
        }
    }
}

//----------- Mouse event for Button --------------
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
