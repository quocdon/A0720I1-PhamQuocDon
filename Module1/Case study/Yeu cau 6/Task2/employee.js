class Employee {
    constructor(name, id, dob, tel, email, address, literacy, department) {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.literacy = literacy;
        this.department = department;
    }
    getName(){
        return this.name;
    }
    getId(){
        return this.id;
    }
    getDob(){
        return this.dob;
    }
    getTel(){
        return this.tel;
    }
    getEmail(){
        return this.email;
    }
    getAddress(){
        return this.address;
    }
    getLiteracy(){
        return this.literacy;
    }
    getDepartment(){
        return this.department;
    }
    getSalary(){
        switch (this.department) {
            case "Manager":{
                return 500;
                break
            }
            case "Sales": {
                return 300;
                break
            }
            case "Marketing":{
                return 200;
                break
            }

        }
    }
}
let staffName;
let staffId;
let staffDob;
let staffTel;
let staffEmail;
let staffAddress;
let literacy;
let department;
let listOfStaff = new Array()

//----------- Show input form -------------------
function inputStaffInfo(){
    document.getElementById("showinformation").innerHTML = "<p class='header'>THÔNG TIN NHÂN VIÊN <br></p><br><br><br><br><br><br>" +
        "<form action='guest.info.html' method='post' id='staffinfo'>" +
        "        <table class='guest-table'>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Tên nhân viên: <label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='staffname'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Số CMND:</label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='staffid'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Ngày sinh: </label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='staffdob' placeholder='DD/MM/YYYY'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>" +
        "                    <label>Số điện thoại: </label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='stafftel'>" +
        "                </td>" +
        "            </tr>"+
                    "<tr>" +
        "                <td>" +
        "                    <label>Email: </label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='staffemail'>" +
        "                </td>" +
        "            </tr>"+
        "            <tr>" +
        "                <td>" +
        "                    <label>Địa chỉ:</label>" +
        "                </td>" +
        "                <td>" +
        "                    <input class='inputstyle' type='text' id='staffaddress'>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td>Trình độ học vấn:</td>" +
        "                <td>" +
        "                    <select class='selectstyled' id='literacy'>" +
        "                        <option>Trung cấp</option>" +
        "                        <option>Cao đẳng</option>" +
        "                        <option>Đại học</option>" +
        "                        <option>Sau đại học</option>" +
        "                    </select>" +
        "                </td>" +
        "            </tr>" +
        "            </tr>" +
        "              <tr>" +
        "                <td>Bộ phận</td>" +
        "                <td>" +
        "                    <select class='selectstyled' id='department'>" +
        "                        <option>Manager</option>" +
        "                        <option>Sales</option>" +
        "                        <option>Marketing</option>" +
        "                    </select>" +
        "                </td>" +
        "            </tr>" +
        "            <tr>" +
        "                <td></td>" +
        "                <td><br>" +
        "                    <input type='button' class='buttonstyle' value='Submit' onclick='submitStaff()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
        "                    &#160 &#160 &#160 &#160\n" +
        "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
        "                </td>" +
        "            </tr>" +
        "        </table>" +
        "    </form>";
}

//----------- Edit guest information-------------
function editStaffinfo() {
    let staff = prompt("Nhập tên nhân viên");
    index = findStaff(staff);
    if (index === listOfStaff.length) {
        alert("Không tìm thấy tên nhân viên");
    } else {
        document.getElementById("showinformation").innerHTML = "<p CLASS='header'>THÔNG TIN NHÂN VIÊN <br>" +
            "STAFF INFORMATION" +
            "</p><br><br><br><br><br><br>" +
            "<form action='staff.info.html' method='post' id='staffinfo'>" +
            "<table class='guest-table'>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Tên nhân viên: <label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='staffname' value ='"+ listOfStaff[index].getName() +"'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số CMND:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='staffid' value = '" + listOfStaff[index].getId() + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Ngày sinh: </label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='staffdob' placeholder='DD/MM/YYYY' value='" + listOfStaff[index].getDob() + "'>" +
            "                </td>" +
            "            </tr>" +
            "<tr>" +
            "                <td>" +
            "                    <label>Số điện thoại: </label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='stafftel' value='" + listOfStaff[index].getTel() + "'>" +
            "                </td>" +
            "            </tr>"+
            "<tr>" +
            "                <td>" +
            "                    <label>Email: </label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='staffemail' value='" + listOfStaff[index].getEmail() + "'>" +
            "                </td>" +
            "            </tr>"+
            "            <tr>" +
            "                <td>" +
            "                    <label>Địa chỉ:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='staffaddress' value='" + listOfStaff[index].getAddress() + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>Trình độ học vấn:</td>" +
            "                <td>" +
            "                    <select class='selectstyled' id='literacy'>" +
            "                        <option>Trung cấp</option>" +
            "                        <option>Cao đẳng</option>" +
            "                        <option>Đại học</option>" +
            "                        <option>Sau đại học</option>" +
            "                    </select>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>Bộ phận</td>" +
            "                <td>" +
            "                    <select class='selectstyled' id='department'>" +
            "                        <option>Manager</option>" +
            "                        <option>Sales</option>" +
            "                        <option>Marketing</option>" +
            "                    </select>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td></td>" +
            "                <td><br>" +
            "                    <input type='button' class='buttonstyle' value='Submit' onclick='updateStaff()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
            "                    &#160 &#160 &#160 &#160\n" +
            "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
            "                </td>" +
            "            </tr>" +
            "        </table>" +
            "    </form>";
        let temp = listOfStaff[index].getLiteracy();
        let mySelect = document.getElementById("literacy");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = listOfStaff[index].getDepartment();
        mySelect = document.getElementById("department");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
    }
}

//----------- Delete guest account---------------
function deleteStaffInfo() {
    let staff = prompt("Nhập tên nhân viên");
    index = findStaff(staff);
    if (index === listOfStaff.length){
        alert("Không tìm thấy tên nhân viên");
    } else {
        if (confirm("Bạn có muốn xóa nhân viên " + listOfStaff[index].getName() + " không?")){
            listOfStaff.splice(index,1);
            alert("Đã xóa nhân viên");
        }
    }
    showStaffInfo();
}

//----------- Show list of guest account---------
function showStaffInfo() {
    listOfStaff.sort(function (a,b){
        if (a.getName().toLowerCase()< b.getName().toLowerCase()){return -1}
        if (a.getName().toLowerCase()> b.getName().toLowerCase()){return 1}
        return 0;
    });
    let staffInfoTable = "<table class='showInfoTable'>"+
        "<tr>"+
        "<th>STT </th>" +
        "<th>Tên khách hàng </th>" +
        "<th>Số CMND</th>" +
        "<th>Ngày sinh</th>" +
        "<th>Điện thoại</th>"+
        "<th>Email</th>"+
        "<th>Địa chỉ</th>" +
        "<th>Trình độ học vấn</th>" +
        "<th>Bộ phận</th>" +
        "<th>Lương</th>" +
        "</tr>";
    for (let i = 0; i < listOfStaff.length; i++){
        staffInfoTable += "<tr>" +
            "<td>"+ parseInt(i+1) +"</td>"+
            "<td>"+ listOfStaff[i].getName() +"</td>"+
            "<td>"+ listOfStaff[i].getId() +"</td>"+
            "<td>"+ listOfStaff[i].getDob() +"</td>"+
            "<td>"+ listOfStaff[i].getTel() +"</td>"+
            "<td>"+ listOfStaff[i].getEmail() +"</td>"+
            "<td>"+ listOfStaff[i].getAddress() +"</td>"+
            "<td>"+ listOfStaff[i].getLiteracy() +"</td>"+
            "<td>"+ listOfStaff[i].getDepartment() +"</td>"+
            "<td class='detail' onclick='staffDetail(" + i + ")'>Chi tiết</td></tr>";
    }
    staffInfoTable += "</table>";
    document.getElementById("showinformation").innerHTML = staffInfoTable;
}

//----------- Show booking confirmation ---------
function staffDetail(index) {
        document.getElementById("showinformation").innerHTML = "<table class='confirmationTable'>" +
            "<tr>" +
            "<td colspan='2' class='confirmationHeader'>THÔNG TIN NHÂN VIÊN</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Tên khách hàng: </td>" +
            "<td>" + listOfStaff[index].getName() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số CMND: </td>" +
            "<td>" + listOfStaff[index].getId() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Ngày sinh: </td>" +
            "<td>" + listOfStaff[index].getDob() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số điện thoại: </td>" +
            "<td>" + listOfStaff[index].getTel() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Email: </td>" +
            "<td>" + listOfStaff[index].getEmail() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Địa chỉ: </td>" +
            "<td>" + listOfStaff[index].getAddress() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Trình độ học vấn: </td>" +
            "<td>" + listOfStaff[index].getLiteracy() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Bộ phận: </td>" +
            "<td>" + listOfStaff[index].getDepartment() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Lương: </td>" +
            "<td class='amountstyle'>" + listOfStaff[index].getSalary() + "USD</td>" +
            "</tr>" +
            "</table>"

}

// --------- Submit button event ----------------
function submitStaff() {
    messageAlert = "";
    getStaffData();
    if (checkStaffInfo()){
        let temp = new Employee(staffName.value, staffId.value, staffDob.value, staffTel.value, staffEmail.value, staffAddress.value, literacy.value, department.value);
        listOfStaff.push(temp);
        alert("Thông tin được nhập thành công");
        document.getElementById("staffinfo").reset();
        mainMenu();
    } else {alert(messageAlert)}
}

//---------- Update button event ----------------
function updateStaff() {
    messageAlert = "";
    getStaffData();
    if (checkStaffInfo()){
        let temp = new Employee(staffName.value, staffId.value, staffDob.value, staffTel.value, staffEmail.value, staffAddress.value, literacy.value, department.value);
        listOfStaff.splice(index,1);
        listOfStaff.push(temp);
        alert("Chỉnh sửa thành công");
    } else {alert(messageAlert)}
}

//----------- Get Data from input form ----------
function getStaffData() {
    staffName = document.forms["staffinfo"]["staffname"];
    staffId = document.forms["staffinfo"]["staffid"];
    staffDob = document.forms["staffinfo"]["staffdob"];
    staffTel = document.forms["staffinfo"]["stafftel"];
    staffEmail = document.forms["staffinfo"]["staffemail"];
    staffAddress = document.forms["staffinfo"]["staffaddress"];
    literacy = document.forms["staffinfo"]["literacy"];
    department = document.forms["staffinfo"]["department"];
}

//----------- Check input information format -------------
function checkStaffInfo(){
    let temp = "";
// Check staff name
    if (staffName.value ===""){
        messageAlert += "Tên nhân viên: Chưa nhập thông tin \n";
    } else {
        for (let i = 0; i < staffName.value.length; i++) {
            if (staffName.value.charAt(i) === " " && staffName.value.charAt(i + 1) === " ") {
                continue;
            }
            temp += staffName.value.charAt(i);
        }
        staffName.value = temp;
    }
//Check staffID format
    let regexID = /^[\d]{8,8}$/;
    if (staffId.value === ""){
        messageAlert += "Số CMND: Chưa nhập thông tin \n"
    } else if (!regexID.test(staffId.value)){
        messageAlert += "Số CMND: Phải là dãy số có 8 chữ số \n";
    }
// Check DoB format
    let checkdob = false;
    let regexDob = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
    if (staffDob.value === ""){
        messageAlert += "Ngày sinh: Chưa nhập thông tin \n";
    } else if (!regexDob.test(staffDob.value)){
            messageAlert += "Ngày sinh: Phải đúng định dạng DD/MM/YYYY \n "
    }
//Check telephone format
    let regexTel = /^[\d]{10,10}$/;
    if (staffId.value === ""){
        messageAlert += "Số điện thoại: Chưa nhập thông tin \n"
    } else if (!regexTel.test(staffTel.value)){
        messageAlert += "Số điện thoại: Phải là dãy số có 10 chữ số \n";
    }
// Check email format
    let regexEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (staffEmail.value ===""){
        messageAlert += "Email: Chưa nhập thông tin \n"
    } else if (!regexEmail.test(staffEmail.value)){
        messageAlert += "Email: Phải đúng định dạng abc@def.xyz \n";
    }
// Check address
    if (staffAddress.value ===""){
        messageAlert += "Địa chỉ: Chưa nhập thông tin \n";
    }

    if (messageAlert !== ""){
        return false
    } else return true;
}

//--------- Find guest frorm Guest Account array ----------
function findStaff(staff) {
    let i = 0;
    if (listOfStaff.length > 0){
        while (listOfStaff[i].getName() !== staff) {
            i++;
            if (i === listOfStaff.length) {
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

