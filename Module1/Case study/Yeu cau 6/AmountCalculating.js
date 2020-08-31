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
                if (rentdays.value >= 2) {
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
let listOfGuest = new Array();
let index;
let info = new Customer();
//------------- Load main menu -------------------
function mainMenu() {
    document.getElementById("showinformation").innerHTML="";
    document.getElementById("mainMenu").innerHTML = "<ul>"+
        "<li><p onclick='inputguestinfo()'>Add new guest account</p></li>"+
        "<li><p onclick='editguestinfo()'>Edit Guest account</p></li>"+
        "<li><p onclick='deleteguestinfo()'>Delete guest account</p></li>"+
        "<li><p onclick='showguestinfo()'>Display list of guest account</p></li>"+
        "<li><p onclick='mainMenu()'>Exit</p></li>"+
        "</ul>"
}

//----------- Show input form -------------------
function inputguestinfo(){
    document.getElementById("showinformation").innerHTML = "<p class='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
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
            "                    <input type='button' class='buttonstyle' value='Update' onclick='updatebutton()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
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
function deleteguestinfo() {
    let guest = prompt("Nhập tên khách hàng");
    index = findguest(guest);
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
        "<th>Số tiền phải trả</th>" +
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
            "<td class='detail' onclick='confirmation(" + i + ")'>Chi tiết</td></tr>";
    }
    guestinfotable += "</table>";
    document.getElementById("showinformation").innerHTML = guestinfotable;
}

//----------- Show booking confirmation ---------
function confirmation(index) {
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
            "<td class='amountstyle''>" + listOfGuest[index].getAmount() + "  USD</td>" +
            "</tr>" +
            "</table>"

}

// --------- Submit button event ----------------
function submitbutton() {
    messageAlert = "";
    getinputdata();
    if (checkinfo()){
        let temp = new Customer(guestname.value, guestid.value, guestdob.value, guestemail.value, address.value, guestclass.value, numOfGuest.value, rentdays.value, services.value, roomtype.value);
        listOfGuest.push(temp);
        alert("Thông tin được nhập thành công");
        document.getElementById("guestinfo").reset();
        mainMenu();
    } else {alert(messageAlert)}
}

//---------- Update button event ----------------
function updatebutton() {
    messageAlert = "";
    getinputdata();
    if (checkinfo()){
        let temp = new Customer(guestname.value, guestid.value, guestdob.value, guestemail.value, address.value, guestclass.value, numOfGuest.value, rentdays.value, services.value, roomtype.value)
        listOfGuest.splice(index,1);
        listOfGuest.push(temp);
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
    let regexID = /^[\d]{8,8}$/;
    if (guestid.value === ""){
        messageAlert += "Số CMND: Chưa nhập thông tin \n"
    } else if (!regexID.test(guestid.value)){
        messageAlert += "Số CMND: Phải là dãy số có 8 chữ số \n";
    }
// Check DoB format
    let checkdob = false;
    let regexDob = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
    if (guestdob.value === ""){
        messageAlert += "Ngày sinh: Chưa nhập thông tin \n";
    } else if (!regexDob.test(guestdob.value)){
            messageAlert += "Ngày sinh: Phải đúng định dạng DD/MM/YYYY \n "
    }

// Check email format
    let regexEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (guestemail.value ===""){
        messageAlert += "Email: Chưa nhập thông tin \n"
    } else if (!regexEmail.test(guestemail.value)){
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
    if (rentdays.value === ""){
        messageAlert += "Số ngày thuê: Chưa nhập thông tin\n"
    } else if (!regexNumber.test(rentdays.value)){
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

