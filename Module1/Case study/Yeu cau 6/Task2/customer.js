class Customer {
    constructor(name, id, dob, email, address, guestClass, numOfGuest, rentDays, services, roomType) {
        this.guestName = name;
        this.guestId = id;
        this.guestDob = dob;
        this.guestEmail = email;
        this.address = address;
        this.guestClass = guestClass;
        this.numOfGuest = parseInt(numOfGuest);
        this.rentDays = parseInt(rentDays);
        this.services = services;
        this.roomType = roomType;
    }
    getName(){
        return this.guestName;
    }
    getID(){
        return this.guestId;
    }
    getDob(){
        return this.guestDob;
    }
    getEmail(){
        return this.guestEmail;
    }
    getAddress(){
        return this.address;
    }
    getClass(){
        return this.guestClass;
    }
    getnumOfGuest(){
        return this.numOfGuest;
    }
    getRentDays(){
        return this.rentDays;
    }
    getServices(){
        return this.services;
    }
    getRoomType(){
        return this.roomType;
    }
    getAmount(){
        switch (this.services) {
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
        switch (this.address) {
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
        if (this.rentDays >= 7) {
            stayDiscount = 30;
        } else {
            if (this.rentDays >= 5) {
                stayDiscount = 20;
            } else {
                if (rentDays.value >= 2) {
                    stayDiscount = 10;
                } else stayDiscount = 0;
            }

        }
        /*Discount by Customer class */
        switch (this.guestClass) {
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
        return  (price * this.rentDays - discount);
    }
}
let guestName;
let guestId;
let guestDob;
let guestEmail;
let address;
let guestClass;
let numOfGuest;
let rentDays;
let services;
let roomType;
let price;
let amount;
let discount;
let addDiscount;
let stayDiscount;
let classDiscount;
let messageAlert;
let listOfGuest = new Array();
let index;
let info = new Customer();
//------------- Load main menu -------------------
function mainMenu() {
    document.getElementById("showinformation").innerHTML="";
    document.getElementById("mainMenu").innerHTML = "<ul>"+
        "<li><p class='headTitle'>CUSTOMER</p></li>"+
        "<li><p onclick='inputGuestInfo()'>Add new guest account</p></li>"+
        "<li><p onclick='editGuestInfo()'>Edit Guest account</p></li>"+
        "<li><p onclick='deleteGuestInfo()'>Delete guest account</p></li>"+
        "<li><p onclick='showGuestInfo()'>Display list of guest account</p></li>"+
        "<li><p class='headTitle'>EMPLOYEE</p></li>"+
        "<li><p onclick='inputStaffInfo()'>Add new employee</p></li>"+
        "<li><p onclick='editStaffinfo()'>Edit employee information</p></li>"+
        "<li><p onclick='deleteStaffInfo()'>Delete employee</p></li>"+
        "<li><p onclick='showStaffInfo()'>Display list of employee</p></li>"+
        "<li><p onclick='mainMenu()' class='headTitle'>Exit</p></li>"+
        "</ul>"
}

//----------- Show input form -------------------
function inputGuestInfo(){
    document.getElementById("showinformation").innerHTML = "<p class='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
        "        BOOKING INFORMATION" +
        "    </p><br><br><br>" +
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
        "                    <input type='button' class='buttonstyle' value='Submit' onclick='submitGuest()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
        "                    &#160 &#160 &#160 &#160\n" +
        "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
        "                </td>" +
        "            </tr>" +
        "        </table>" +
        "    </form>";
}

//----------- Edit guest information-------------
function editGuestInfo() {
    let guest = prompt("Nhập tên khách hàng");
    index = findguest(guest);
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
            "                <td>" + "<input class='inputstyle' type='text' id='guestname' value='" + listOfGuest[index].getName() + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số CMND/ID number:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestid' value='" + listOfGuest[index].getID() + "'>" +
            "                </td>\n" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Ngày sinh/Date of birth</label>\n" +
            "                </td>\n" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestdob' value='" + listOfGuest[index].getDob() + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Email</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestemail' + value='" + listOfGuest[index].getEmail() + "'>" +
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
            "                    <input class='inputstyle' type='text' id='numOfGuest' value='" + listOfGuest[index].getnumOfGuest() + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>Số ngày thuê/rentdays</td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='rentdays' value='" + listOfGuest[index].getRentDays() + "'>" +
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
            "                    <input type='button' class='buttonstyle' value='Update' onclick='updateGuest()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
            "                    &#160 &#160 &#160 &#160" +
            "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
            "                </td>" +
            "            </tr>" +
            "        </table>" +
            "    </form>";
        let temp = listOfGuest[index].getAddress();
        let mySelect = document.getElementById("address");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfGuest[index].getClass();
        mySelect = document.getElementById("guestclass");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfGuest[index].getServices();
        mySelect = document.getElementById("services");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfGuest[index].getRoomType();
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
function deleteGuestInfo() {
    let guest = prompt("Nhập tên khách hàng");
    index = findguest(guest);
    if (index === listOfGuest.length){
        alert("Không tìm thấy tên khách hàng");
    } else {
        if (confirm("Bạn có muốn xóa khách hàng " + listOfGuest[index].getName() + " không?")){
            listOfGuest.splice(index,1);
            alert("Đã xóa khách hàng");
        }
    }
    showGuestInfo();
}

//----------- Show list of guest account---------
function showGuestInfo() {
    listOfGuest.sort(function (a,b){
        if (a.getName().toLowerCase()< b.getName().toLowerCase()){return -1}
        if (a.getName().toLowerCase()> b.getName().toLowerCase()){return 1}
        return 0;
    });
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
        "<th>Xác nhận đặt phòng</th>" +
        "</tr>";
    for (let i = 0; i < listOfGuest.length; i++){
        guestinfotable += "<tr>" +
            "<td>"+ parseInt(i+1) +"</td>"+
            "<td>"+ listOfGuest[i].getName() +"</td>"+
            "<td>"+ listOfGuest[i].getID() +"</td>"+
            "<td>"+ listOfGuest[i].getDob() +"</td>"+
            "<td>"+ listOfGuest[i].getEmail() +"</td>"+
            "<td>"+ listOfGuest[i].getAddress() +"</td>"+
            "<td>"+ listOfGuest[i].getClass() +"</td>"+
            "<td>"+ listOfGuest[i].getnumOfGuest() +"</td>"+
            "<td>"+ listOfGuest[i].getRentDays() +"</td>"+
            "<td>"+ listOfGuest[i].getServices() +"</td>"+
            "<td>"+ listOfGuest[i].getRoomType() +"</td>"+
            "<td class='detail' onclick='bookingDetail(" + i + ")'>Chi tiết</td></tr>";
    }
    guestinfotable += "</table>";
    document.getElementById("showinformation").innerHTML = guestinfotable;
}

//----------- Show booking confirmation ---------
function bookingDetail(index) {
        document.getElementById("showinformation").innerHTML = "<table class='confirmationTable'>" +
            "<tr>" +
            "<td colspan='2' class='confirmationHeader'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Tên khách hàng/ Guest name: </td>" +
            "<td>" + listOfGuest[index].getName() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số CMND/ID Number: </td>" +
            "<td>" + listOfGuest[index].getID() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Ngày sinh/ Date of birth: </td>" +
            "<td>" + listOfGuest[index].getDob() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Email: </td>" +
            "<td>" + listOfGuest[index].getEmail() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Địa chỉ/ Address: </td>" +
            "<td>" + listOfGuest[index].getAddress() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Hạng khách hàng/ Customer class: </td>" +
            "<td>" + listOfGuest[index].getClass() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số lượng khách/ Number of Guest: </td>" +
            "<td>" + listOfGuest[index].getnumOfGuest() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số ngày thuê/ Rentdays: </td>" +
            "<td>" + listOfGuest[index].getRentDays() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Loại dịch vụ/ Services: </td>" +
            "<td>" + listOfGuest[index].getServices() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Loại phòng/ Room type: </td>" +
            "<td>" + listOfGuest[index].getRoomType() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<tr>" +
            "<td>Thành tiền/ Total Amount: </td>" +
            "<td class='amountstyle''>" + listOfGuest[index].getAmount() + " USD</td>" +
            "</tr>" +
            "</table>"

}

// --------- Submit button event ----------------
function submitGuest() {
    messageAlert = "";
    getGuestData();
    if (checkInfo()){
        let temp = new Customer(guestName.value, guestId.value, guestDob.value, guestEmail.value, address.value, guestClass.value, numOfGuest.value, rentDays.value, services.value, roomType.value);
        listOfGuest.push(temp);
        alert("Thông tin được nhập thành công");
        document.getElementById("guestinfo").reset();
        mainMenu();
    } else {alert(messageAlert)}
}

//---------- Update button event ----------------
function updateGuest() {
    messageAlert = "";
    getGuestData();
    if (checkInfo()){
        let temp = new Customer(guestName.value, guestId.value, guestDob.value, guestEmail.value, address.value, guestClass.value, numOfGuest.value, rentDays.value, services.value, roomType.value)
        listOfGuest.splice(index,1);
        listOfGuest.push(temp);
        alert("Chỉnh sửa thành công");
    } else {alert(messageAlert)}
}

//----------- Get Data from input form ----------
function getGuestData() {
    guestName = document.forms["guestinfo"]["guestname"];
    guestId = document.forms["guestinfo"]["guestid"];
    guestDob = document.forms["guestinfo"]["guestdob"];
    guestEmail = document.forms["guestinfo"]["guestemail"]
    address = document.forms["guestinfo"]["address"];
    guestClass = document.forms["guestinfo"]["guestclass"];
    numOfGuest = document.forms["guestinfo"]["numOfGuest"];
    rentDays = document.forms["guestinfo"]["rentdays"];
    services = document.forms["guestinfo"]["services"];
    roomType = document.forms["guestinfo"]["roomtype"];
}

//----------- Check input information format -------------
function checkInfo(){
    let temp = "";
// Check guest name
    if (guestname.value ===""){
        messageAlert += "Tên khách hàng: Chưa nhập thông tin \n";
    } else {
        for (let i = 0; i < guestname.value.length; i++) {
            if (guestName.value.charAt(i) === " " && guestName.value.charAt(i + 1) === " ") {
                continue;
            }
            temp += guestName.value.charAt(i);
        }
        guestName.value = temp;
    }
//Check guestID format
    let regexID = /^[\d]{8,8}$/;
    if (guestId.value === ""){
        messageAlert += "Số CMND: Chưa nhập thông tin \n"
    } else if (!regexID.test(guestId.value)){
        messageAlert += "Số CMND: Phải là dãy số có 8 chữ số \n";
    }
// Check DoB format
    let regexDob = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
    if (guestDob.value === ""){
        messageAlert += "Ngày sinh: Chưa nhập thông tin \n";
    } else if (!regexDob.test(guestDob.value)){
            messageAlert += "Ngày sinh: Phải đúng định dạng DD/MM/YYYY \n "
    }

// Check email format
    let regexEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (guestEmail.value ===""){
        messageAlert += "Email: Chưa nhập thông tin \n"
    } else if (!regexEmail.test(guestEmail.value)){
        messageAlert += "Email: Phải đúng định dạng abc@def.xyz \n";
    }


// Check Number Of Guest
    let regexNumber = /^[\d]+$/;
    if (numOfGuest.value === ""){
        messageAlert += "Số lượng khách: Chưa nhập thông tin\n"
    } else if (!regexNumber.test(numOfGuest.value)){
        messageAlert += "Số lượng khách: Phải là số nguyên dương \n"
    }
// Check rentdays
    if (rentDays.value === ""){
        messageAlert += "Số ngày thuê: Chưa nhập thông tin\n"
    } else if (!regexNumber.test(rentDays.value)){
        messageAlert += "Số ngày thuê: Phải là số nguyên dương \n"
    }
    if (messageAlert !== ""){
        return false
    } else return true;
}

//--------- Find guest frorm Guest Account array ----------
function findguest(guest) {
    let i = 0;
    if (listOfGuest.length > 0){
        while (listOfGuest[i].guestName !== guest) {
            i++;
            if (i === listOfGuest.length) {
                break;
            }
        }
    }
    return i;
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

