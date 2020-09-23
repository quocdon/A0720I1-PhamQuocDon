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

    getName() {
        return this.guestName;
    }

    getID() {
        return this.guestId;
    }

    getDob() {
        return this.guestDob;
    }

    getEmail() {
        return this.guestEmail;
    }

    getAddress() {
        return this.address;
    }

    getClass() {
        return this.guestClass;
    }

    getnumOfGuest() {
        return this.numOfGuest;
    }

    getRentDays() {
        return this.rentDays;
    }

    getServices() {
        return this.services;
    }

    getRoomType() {
        return this.roomType;
    }

    getAmount() {
        let price;
        let addDiscount;
        let stayDiscount;
        let classDiscount;
        let discount;
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
        }
        /*Discount by number of day staying*/
        if (this.rentDays >= 7) {
            stayDiscount = 30;
        } else {
            if (this.rentDays >= 5) {
                stayDiscount = 20;
            } else {
                if (this.rentDays >= 2) {
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
        return (price * this.rentDays - discount);
    }

    setName(name) {
        this.guestName = name
    }
}

class CustomerProgram {
    constructor(guestList) {
        this.guestList = guestList
    }
    //Using pattern attribute to check input element value before submission
    inputGuestInfo() {
        let inputTable = "<p class='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
            "        BOOKING INFORMATION" +
            "    </p><br><br><br>" +
            "<form action='guest.info.html' method='post' id='guestInfo'>" +
            "        <table class='guest-table'>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Tên khách hàng/Guest name<label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestName' required title='Không để trống'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số CMND/ID number:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestId' pattern='^[0-9]{8}' title='CMND gồm 8 chữ số' required>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Ngày sinh/Date of birth</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestDob' placeholder='DD/MM/YYYY' required pattern='^(?=\\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\\d|0?[1-9]))([-.\\/])(?:1[012]|0?[1-9])\\1(?:1[6-9]|[2-9]\\d)?\\d\\d(?:(?=\x20\\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\\d){0,2}(\x20[AP]M))|([01]\\d|2[0-3])(:[0-5]\\d){1,2})?$' title='Định dạng DD/MM/YYYY'>" +
            "                </td>" +
            "            </tr>" +
            "<tr>" +
            "                <td>" +
            "                    <label>Email</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestEmail' placeholder='example@abc.xyz' required pattern='^[_a-z0-9]+(\\.[_a-z0-9]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$' title='Định dạng abc@def.xyz'>" +
            "                </td>" +
            "            </tr>" +
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
            "                    <select class='selectstyled' id='guestClass'>" +
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
            "                    <input class='inputstyle' type='text' id='numOfGuest' required pattern='^[\\d]+$' title='Nhập số nguyên dương'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>Số ngày thuê/rentdays</td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='rentDays' required pattern='^[\\d]+$' title='Nhập số nguyên dương'>" +
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
            "                    <select class='selectstyled' id='roomType'>" +
            "                        <option>VIP</option>" +
            "                        <option>Business</option>" +
            "                        <option>Normal</option>" +
            "                    </select>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td></td>" +
            "                <td><br>" +
            "                    <input type='button' class='buttonstyle' value='Submit' onclick='submitInfo()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
            "                    &#160 &#160 &#160 &#160\n" +
            "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
            "                </td>" +
            "            </tr>" +
            "        </table>" +
            "    </form>";
        document.getElementById("showInformation").innerHTML = inputTable;
    }

    getGuestData() {
        let guestName = document.forms["guestInfo"]["guestName"];
        let guestId = document.forms["guestInfo"]["guestId"];
        let guestDob = document.forms["guestInfo"]["guestDob"];
        let guestEmail = document.forms["guestInfo"]["guestEmail"]
        let address = document.forms["guestInfo"]["address"];
        let guestClass = document.forms["guestInfo"]["guestClass"];
        let numOfGuest = document.forms["guestInfo"]["numOfGuest"];
        let rentDays = document.forms["guestInfo"]["rentDays"];
        let services = document.forms["guestInfo"]["services"];
        let roomType = document.forms["guestInfo"]["roomType"];
        let guestData = new Customer(guestName.value, guestId.value, guestDob.value, guestEmail.value, address.value, guestClass.value, numOfGuest.value, rentDays.value, services.value, roomType.value);
        return guestData;
    }

    checkInfo(guest) {
        let temp = "";
    // Check guest name
        if (guest.getName() === "") {
            return false;
        } else {
            for (let i = 0; i < guest.getName().length; i++) {
                if (guest.getName().charAt(i) === " " && guest.getName().charAt(i + 1) === " ") {
                    continue;
                }
                temp += guest.getName().charAt(i);
            }
            guest.setName(temp);
        }
    //Check guestID format
        let regexID = /^[\d]{8,8}$/;
        if (!regexID.test(guest.getID())) {
            return false
        }
    // Check DoB format
        let regexDob = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
        if (!regexDob.test(guest.getDob())) {
            return false
        }
    // Check email format
        let regexEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!regexEmail.test(guest.getEmail())) {
            return false
        }
    // Check Number Of Guest
        let regexNumber = /^[\d]+$/;
        if (!regexNumber.test(guest.getnumOfGuest())) {
            return false
        }
    // Check rentdays
        if (!regexNumber.test(guest.getRentDays())) {
            return false
        }
        return true
    }

    submitGuest() {
        let guest = this.getGuestData();
        if (this.checkInfo(guest)) {
            this.guestList.push(guest);
            alert("Thông tin được nhập thành công");
            document.getElementById("guestInfo").reset();
        }
    }

    edit(index) {
        let guest = new Customer();
        guest = this.guestList[index];
        let editTable = "<p CLASS='header'>THÔNG TIN ĐẶT PHÒNG <br>" +
            "BOOKING INFORMATION" +
            "</p><br><br><br><br><br><br>" +
            "<form action='guest.info.html' method='post' id='guestInfo'>" +
            "<table class='guest-table'>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Tên khách hàng/Guest name<label>" +
            "                </td>" +
            "                <td>" + "<input class='inputstyle' type='text' id='guestName' value='" + guest.getName() + "'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số CMND/ID number:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestId' value='" + guest.getID() + "' pattern='^[0-9]{8}' title='CMND gồm 8 chữ số' required>" +
            "                </td>\n" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Ngày sinh/Date of birth</label>\n" +
            "                </td>\n" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestDob' value='" + guest.getDob() + "' required pattern='^(?=\\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\\d|0?[1-9]))([-.\\/])(?:1[012]|0?[1-9])\\1(?:1[6-9]|[2-9]\\d)?\\d\\d(?:(?=\x20\\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\\d){0,2}(\x20[AP]M))|([01]\\d|2[0-3])(:[0-5]\\d){1,2})?$' title='Định dạng DD/MM/YYYY'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Email</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='guestEmail' + value='" + guest.getEmail() + "' required pattern='^[_a-z0-9]+(\\.[_a-z0-9]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$' title='Định dạng abc@def.xyz'>" +
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
            "                    <select class='selectstyled' id='guestClass'>" +
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
            "                    <input class='inputstyle' type='text' id='numOfGuest' value='" + this.guestList[index].getnumOfGuest() + "' required pattern='^[\\d]+$' title='Nhập số nguyên dương'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>Số ngày thuê/rentdays</td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='rentDays' value='" + this.guestList[index].getRentDays() + "' required pattern='^[\\d]+$' title='Nhập số nguyên dương'>" +
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
            "                    <select class='selectstyled' id='roomType'>" +
            "                        <option>VIP</option>" +
            "                        <option>Business</option>" +
            "                        <option>Normal</option>" +
            "                    </select>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td></td>" +
            "                <td><br>" +
            "                    <input type='button' class='buttonstyle' value='Update' onclick='updateInfo(" + index + ")' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
            "                    &#160 &#160 &#160 &#160" +
            "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
            "                </td>" +
            "            </tr>" +
            "        </table>" +
            "    </form>";
        document.getElementById("showInformation").innerHTML = editTable;
        let temp = guest.getAddress();
        let mySelect = document.getElementById("address");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = guest.getClass();
        mySelect = document.getElementById("guestClass");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = guest.getServices();
        mySelect = document.getElementById("services");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }
        temp = guest.getRoomType();
        mySelect = document.getElementById("roomType");
        for (let i, j = 0; i = mySelect.options[j]; j++) {
            if (i.value === temp) {
                mySelect.selectedIndex = j;
                break;
            }
        }


    }

    update(index) {
        let guest = this.getGuestData();
        if (this.checkInfo(guest)) {
            this.guestList.splice(index, 1);
            this.guestList.push(guest);
            alert("chỉnh sửa thành công");
        }
    }

    delete(index) {
        if (confirm("Bạn có muốn xóa khách hàng " + this.guestList[index].getName() + " không?")) {
            this.guestList.splice(index, 1);
            alert("Đã xóa khách hàng");
        }
        let guestName = document.getElementById("searchName");
        if (guestName === null) {
            this.showGuestInfo()
        } else {
            this.searchGuestInfo()
        }
    }

    sort() {
        this.guestList.sort(function (a, b) {
            if (a.getName().toLowerCase() < b.getName().toLowerCase()) {
                return -1
            }
            if (a.getName().toLowerCase() > b.getName().toLowerCase()) {
                return 1
            }
            return 0;
        });
    }

    showGuestInfo() {
        this.sort();
        let guestInfoTable = "<table class='showInfoTable'>" +
            "<tr>" +
            "<th>STT </th>" +
            "<th>Tên khách hàng </th>" +
            "<th>Số CMND</th>" +
            "<th>Ngày sinh</th>" +
            "<th>Email</th>" +
            "<th>Địa chỉ</th>" +
            "<th>Hạng khách hàng</th>" +
            "<th>Xác nhận đặt phòng</th>" +
            "<th>Chỉnh sửa</th>" +
            "<th>Xóa</th>" +
            "</tr>"
        for (let i = 0; i < this.guestList.length; i++) {
            guestInfoTable += "<tr>" +
                "<td>" + (i + 1) + "</td>" +
                "<td>" + this.guestList[i].getName() + "</td>" +
                "<td>" + this.guestList[i].getID() + "</td>" +
                "<td>" + this.guestList[i].getDob() + "</td>" +
                "<td>" + this.guestList[i].getEmail() + "</td>" +
                "<td>" + this.guestList[i].getAddress() + "</td>" +
                "<td>" + this.guestList[i].getClass() + "</td>" +
                "<td class='detail' onclick='bookingDetail(" + i + ")'>Chi tiết</td>" +
                "<td class='detail' onclick='guestEdit(" + i + ")'>Sửa</td>" +
                "<td class='detail' onclick='guestDelete(" + i + ")'>Xóa</td></tr>";
        }
        guestInfoTable += "</table>";
        document.getElementById("showInformation").innerHTML = guestInfoTable;
    }

    detail(index) {
        let detail = "<table class='confirmationTable'>" +
            "<tr>" +
            "<td colspan='2' class='confirmationHeader'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Tên khách hàng/ Guest name: </td>" +
            "<td>" + this.guestList[index].getName() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số CMND/ID Number: </td>" +
            "<td>" + this.guestList[index].getID() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Ngày sinh/ Date of birth: </td>" +
            "<td>" + this.guestList[index].getDob() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Email: </td>" +
            "<td>" + this.guestList[index].getEmail() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Địa chỉ/ Address: </td>" +
            "<td>" + this.guestList[index].getAddress() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Hạng khách hàng/ Customer class: </td>" +
            "<td>" + this.guestList[index].getClass() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số lượng khách/ Number of Guest: </td>" +
            "<td>" + this.guestList[index].getnumOfGuest() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Số ngày thuê/ Rentdays: </td>" +
            "<td>" + this.guestList[index].getRentDays() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Loại dịch vụ/ Services: </td>" +
            "<td>" + this.guestList[index].getServices() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td>Loại phòng/ Room type: </td>" +
            "<td>" + this.guestList[index].getRoomType() + "</td>" +
            "</tr>" +
            "<tr>" +
            "<tr>" +
            "<td>Thành tiền/ Total Amount: </td>" +
            "<td class='amountstyle''>" + this.guestList[index].getAmount() + " USD</td>" +
            "</tr>" +
            "</table>"
        document.getElementById("showInformation").innerHTML = detail;
    }

    //Array of searching result index
    getGuestIndex(guestName) {
        let index = new Array()
        if (this.guestList.length > 0) {
            for (let i = 0; i < this.guestList.length; i++) {
                if (this.guestList[i].getName() === guestName) {
                    index.push(i);
                }

            }
        }
        return index;
    }

    //Input guest name for searching
    inputName() {
        let nameInputForm = "<p class='searchBox'><label class='guest-table'>Tên khách hàng:</label><input class='inputstyle' id='searchName'> " +
            "<button class='buttonstyle' onclick='searchGuest()'>Tìm kiếm</button></p>" +
            "<div class='showDiv' id='searchResult'></div>"
        document.getElementById("showInformation").innerHTML = nameInputForm
    }

    searchGuestInfo() {
        let guestName = document.getElementById("searchName");
        let index = this.getGuestIndex(guestName.value);
        if (index.length === 0) {
            document.getElementById("searchResult").innerHTML = "<p class='searchBox'>Không tìm thấy khách hàng</p>"
        } else {
            let resultTable = "<table class='showInfoTable'>" +
                "<tr>" +
                "<th>STT </th>" +
                "<th>Tên khách hàng </th>" +
                "<th>Số CMND</th>" +
                "<th>Ngày sinh</th>" +
                "<th>Email</th>" +
                "<th>Địa chỉ</th>" +
                "<th>Hạng khách hàng</th>" +
                "<th>Xác nhận đặt phòng</th>" +
                "<th>Chỉnh sửa</th>" +
                "<th>Xóa</th>" +
                "</tr>";
            for (let i = 0; i < index.length; i++) {
                resultTable += "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + this.guestList[index[i]].getName() + "</td>" +
                    "<td>" + this.guestList[index[i]].getID() + "</td>" +
                    "<td>" + this.guestList[index[i]].getDob() + "</td>" +
                    "<td>" + this.guestList[index[i]].getEmail() + "</td>" +
                    "<td>" + this.guestList[index[i]].getAddress() + "</td>" +
                    "<td>" + this.guestList[index[i]].getClass() + "</td>" +
                    "<td class='detail' onclick='bookingDetail(" + index[i] + ")'>Chi tiết</td>" +
                    "<td class='detail' onclick='guestEdit(" + index[i] + ")'>Sửa</td>" +
                    "<td class='detail' onclick='guestDelete(" + index[i] + ")'>Xóa</td></tr>";
            }
            resultTable += "</table>";
            document.getElementById("searchResult").innerHTML = resultTable;
        }

    }

}

let listOfGuest = new Array();
let customer = new CustomerProgram(listOfGuest);

function submitInfo() {
    customer.submitGuest();
}

function updateInfo(index) {
    customer.update(index)
}

function bookingDetail(index) {
    customer.detail(index)
}

function searchGuest() {
    customer.searchGuestInfo()

}

function guestDelete(index) {
    customer.delete(index)
}

function guestEdit(index) {
    customer.edit(index)
}

//----------- Mouse event for Button --------------
function Smouseover() {
    document.getElementById("submitButton").style.color = "white";
    document.getElementById("submitButton").style.background = "#a0a0a0";
}

function Smouseout() {
    document.getElementById("submitButton").style.color = "black";
    document.getElementById("submitButton").style.background = "white"
}

function Rmouseover() {
    document.getElementById("resetButton").style.color = "white";
    document.getElementById("resetButton").style.background = "#a0a0a0";
}

function Rmouseout() {
    document.getElementById("resetButton").style.color = "Black";
    document.getElementById("resetButton").style.background = "white";
}

