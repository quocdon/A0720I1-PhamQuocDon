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

    getName() {
        return this.name;
    }

    getId() {
        return this.id;
    }

    getDob() {
        return this.dob;
    }

    getTel() {
        return this.tel;
    }

    getEmail() {
        return this.email;
    }

    getAddress() {
        return this.address;
    }

    getLiteracy() {
        return this.literacy;
    }

    getDepartment() {
        return this.department;
    }

    getSalary() {
        switch (this.department) {
            case "Manager": {
                return 500;
                break
            }
            case "Sales": {
                return 300;
                break
            }
            case "Marketing": {
                return 200;
                break
            }

        }
    }

    setName(name) {
        this.name = name;
    }
}

class employeeProgram {
    constructor(staffList) {
        this.staffList = staffList;
    }

    inputEmployeeInfo() {
        let inputTable = "<p class='header'>THÔNG TIN NHÂN VIÊN <br></p><br><br><br><br><br><br>" +
            "<form action='guest.info.html' method='post' id='employeeInfo'>" +
            "        <table class='guest-table'>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Tên nhân viên: <label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='employeeName'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số CMND:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='employeeId'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Ngày sinh: </label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='employeeDob' placeholder='DD/MM/YYYY'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Số điện thoại: </label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='employeeTel'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Email: </label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='employeeEmail'>" +
            "                </td>" +
            "            </tr>" +
            "            <tr>" +
            "                <td>" +
            "                    <label>Địa chỉ:</label>" +
            "                </td>" +
            "                <td>" +
            "                    <input class='inputstyle' type='text' id='employeeAddress'>" +
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
            "                    <input type='button' class='buttonstyle' value='Submit' onclick='submitEmployee()' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
            "                    &#160 &#160 &#160 &#160\n" +
            "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
            "                </td>" +
            "            </tr>" +
            "        </table>" +
            "    </form>";
        document.getElementById("showInformation").innerHTML = inputTable
    }

    getEmployeeData() {
        let employeeName = document.forms["employeeInfo"]["employeeName"];
        let employeeId = document.forms["employeeInfo"]["employeeId"];
        let employeeDob = document.forms["employeeInfo"]["employeeDob"];
        let employeeTel = document.forms["employeeInfo"]["employeeTel"];
        let employeeEmail = document.forms["employeeInfo"]["employeeEmail"];
        let employeeAddress = document.forms["employeeInfo"]["employeeAddress"];
        let literacy = document.forms["employeeInfo"]["literacy"];
        let department = document.forms["employeeInfo"]["department"];
        let employeeData = new Employee(employeeName.value, employeeId.value, employeeDob.value, employeeTel.value, employeeEmail.value, employeeAddress.value, literacy.value, department.value);
        return employeeData
    }

    getAlertMessage(employee) {
        let temp = "";
        let messageAlert = "";
// Check employee name
        if (employee.getName() === "") {
            messageAlert += "Tên nhân viên: Chưa nhập thông tin \n";
        } else {
            for (let i = 0; i < employee.getName().length; i++) {
                if (employee.getName().charAt(i) === " " && employee.getName().charAt(i + 1) === " ") {
                    continue;
                }
                temp += employee.getName().charAt(i);
            }
            employee.setName(temp);
        }
//Check employeeID format
        let regexID = /^[\d]{8,8}$/;
        if (employee.getId() === "") {
            messageAlert += "Số CMND: Chưa nhập thông tin \n"
        } else if (!regexID.test(employee.getId())) {
            messageAlert += "Số CMND: Phải là dãy số có 8 chữ số \n";
        }
// Check DoB format
        let checkdob = false;
        let regexDob = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
        if (employee.getDob() === "") {
            messageAlert += "Ngày sinh: Chưa nhập thông tin \n";
        } else if (!regexDob.test(employee.getDob())) {
            messageAlert += "Ngày sinh: Phải đúng định dạng DD/MM/YYYY \n "
        }
//Check telephone format
        let regexTel = /^[\d]{10,10}$/;
        if (employee.getTel() === "") {
            messageAlert += "Số điện thoại: Chưa nhập thông tin \n"
        } else if (!regexTel.test(employee.getTel())) {
            messageAlert += "Số điện thoại: Phải là dãy số có 10 chữ số \n";
        }
// Check email format
        let regexEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (employee.getEmail() === "") {
            messageAlert += "Email: Chưa nhập thông tin \n"
        } else if (!regexEmail.test(employee.getEmail())) {
            messageAlert += "Email: Phải đúng định dạng abc@def.xyz \n";
        }
// Check address
        if (employee.getAddress() === "") {
            messageAlert += "Địa chỉ: Chưa nhập thông tin \n";
        }
        return messageAlert;
    }

    checkEmployeeInfo(employee) {
        if (this.getAlertMessage(employee) === "") {
            return true
        } else {
            return false
        }
    }

    submitEmployeeInfo() {
        let employee = this.getEmployeeData();
        if (this.checkEmployeeInfo(employee)) {
            this.staffList.push(employee);
            alert("Thông tin được nhập thành công");
            document.getElementById("employeeInfo").reset();
        } else {
            alert(this.getAlertMessage(employee))
        }
    }

    getEmployeeIndex(employeeName) {
        let i = 0;
        if (this.staffList.length > 0) {
            while (this.staffList[i].getName() !== employeeName) {
                i++;
                if (i === this.staffList.length) {
                    break;
                }
            }
        }
        return i;
    }

    inputName() {
        return prompt("Nhập tên nhân viên")
    }

    edit(employeeName) {
        let index = this.getEmployeeIndex(employeeName);
        if (index === this.staffList.length) {
            alert("Không tìm thấy tên nhân viên");
        } else {
            let employee = this.staffList[index];
            let editTable = "<p CLASS='header'>THÔNG TIN NHÂN VIÊN <br>" +
                "EMPLOYEE INFORMATION" +
                "</p><br><br><br><br><br><br>" +
                "<form action='staff.info.html' method='post' id='employeeInfo'>" +
                "<table class='guest-table'>" +
                "            <tr>" +
                "                <td>" +
                "                    <label>Tên nhân viên: <label>" +
                "                </td>" +
                "                <td>" +
                "                    <input class='inputstyle' type='text' id='employeeName' value ='" + employee.getName() + "'>" +
                "                </td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>" +
                "                    <label>Số CMND:</label>" +
                "                </td>" +
                "                <td>" +
                "                    <input class='inputstyle' type='text' id='employeeId' value = '" + employee.getId() + "'>" +
                "                </td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>" +
                "                    <label>Ngày sinh: </label>" +
                "                </td>" +
                "                <td>" +
                "                    <input class='inputstyle' type='text' id='employeeDob' placeholder='DD/MM/YYYY' value='" + employee.getDob() + "'>" +
                "                </td>" +
                "            </tr>" +
                "<tr>" +
                "                <td>" +
                "                    <label>Số điện thoại: </label>" +
                "                </td>" +
                "                <td>" +
                "                    <input class='inputstyle' type='text' id='employeeTel' value='" + employee.getTel() + "'>" +
                "                </td>" +
                "            </tr>" +
                "<tr>" +
                "                <td>" +
                "                    <label>Email: </label>" +
                "                </td>" +
                "                <td>" +
                "                    <input class='inputstyle' type='text' id='employeeEmail' value='" + employee.getEmail() + "'>" +
                "                </td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>" +
                "                    <label>Địa chỉ:</label>" +
                "                </td>" +
                "                <td>" +
                "                    <input class='inputstyle' type='text' id='employeeAddress' value='" + employee.getAddress() + "'>" +
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
                "                    <input type='button' class='buttonstyle' value='Submit' onclick='updateEmployee(" + index + ")' onmouseover='Smouseover()' onmouseout='Smouseout()' id='submitButton'>" +
                "                    &#160 &#160 &#160 &#160\n" +
                "                    <input type='reset' class='buttonstyle' value='Reset' onmouseover='Rmouseover()' onmouseout='Rmouseout()' id='resetButton'>" +
                "                </td>" +
                "            </tr>" +
                "        </table>" +
                "    </form>";
            document.getElementById("showInformation").innerHTML = editTable;
            let temp = employee.getLiteracy();
            let mySelect = document.getElementById("literacy");
            for (let i, j = 0; i = mySelect.options[j]; j++) {
                if (i.value === temp) {
                    mySelect.selectedIndex = j;
                    break;
                }
            }
            temp = employee.getDepartment();
            mySelect = document.getElementById("department");
            for (let i, j = 0; i = mySelect.options[j]; j++) {
                if (i.value === temp) {
                    mySelect.selectedIndex = j;
                    break;
                }
            }
        }

    }

    editEmployeeInfo() {
        let employeeName = this.inputName();
        this.edit(employeeName);
    }

    delete(employeeName) {
        let index = this.getEmployeeIndex(employeeName);
        if (index === this.staffList.length) {
            alert("Không tìm thấy tên nhân viên");
        } else {
            if (confirm("Bạn có muốn xóa nhân viên " + this.staffList[index].getName() + " - Số CMND " + this.staffList[index].getId() +" không?")) {
                this.staffList.splice(index, 1);
                alert("Đã xóa nhân viên");
            }
        }
    }

    deleteEmployeeInfo() {
        let employeeName = this.inputName();
        this.delete(employeeName);
        this.showEmployeeInfo();
    }

    update(employeeIndex) {
        let employee = this.getEmployeeData();
        if (this.checkEmployeeInfo(employee)) {
            this.staffList.splice(employeeIndex, 1)
            this.staffList.push(employee);
            alert("Chỉnh sửa thành công");
        } else {
            alert(this.getAlertMessage(employee))
        }
    }

    sort() {
        this.staffList.sort(function (a, b) {
            if (a.getName().toLowerCase() < b.getName().toLowerCase()) {
                return -1
            }
            if (a.getName().toLowerCase() > b.getName().toLowerCase()) {
                return 1
            }
            return 0;
        });
    }

    showEmployeeInfo() {
        this.sort();
        let staffInfoTable = "<table class='showInfoTable'>" +
            "<tr>" +
            "<th>STT </th>" +
            "<th>Tên khách hàng </th>" +
            "<th>Số CMND</th>" +
            "<th>Ngày sinh</th>" +
            "<th>Điện thoại</th>" +
            "<th>Email</th>" +
            "<th>Địa chỉ</th>" +
            "<th>Trình độ học vấn</th>" +
            "<th>Bộ phận</th>" +
            "<th>Lương</th>" +
            "</tr>";
        for (let i = 0; i < this.staffList.length; i++) {
            staffInfoTable += "<tr>" +
                "<td>" + parseInt(i + 1) + "</td>" +
                "<td>" + this.staffList[i].getName() + "</td>" +
                "<td>" + this.staffList[i].getId() + "</td>" +
                "<td>" + this.staffList[i].getDob() + "</td>" +
                "<td>" + this.staffList[i].getTel() + "</td>" +
                "<td>" + this.staffList[i].getEmail() + "</td>" +
                "<td>" + this.staffList[i].getAddress() + "</td>" +
                "<td>" + this.staffList[i].getLiteracy() + "</td>" +
                "<td>" + this.staffList[i].getDepartment() + "</td>" +
                "<td class='detail' onclick='allStaffDetail(" + i + ")'>Chi tiết</td></tr>";
        }
        staffInfoTable += "</table>";
        document.getElementById("showInformation").innerHTML = staffInfoTable;
    }

    detail(index) {
        let detailTable = "<table class='confirmationTable'>" +
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
        document.getElementById("showInformation").innerHTML = detailTable
    }
}

let listOfStaff = new Array();
let staff = new employeeProgram(listOfStaff);

function allStaffDetail(index) {
    staff.detail(index)
}

function updateEmployee(index) {
    staff.update(index)
}

function submitEmployee() {
    staff.submitEmployeeInfo()
}
