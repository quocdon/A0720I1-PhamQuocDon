class Info {
    constructor(id, name, birthday, gender, studentClass, studentGrade) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.studentClass = studentClass;
        this.studentGrade = studentGrade
    }
}

class Program {
    constructor(list) {
        this.list = list
    }

    addStudent() {
        inputForm = "<form action='student.info.html' method='post' id='inputInfo'>" +
            "<table class='formTable'>" +
            "   <tr>" +
            "       <td>" +
            "           <label>Mã số sinh viên: <label>" +
            "       </td>" +
            "       <td>" +
            "           <input type='text' id='studentId'>" +
            "       </td>" +
            "   </tr>" +
            "   <tr>" +
            "       <td>" +
            "           <label>Tên sinh viên: <label>" +
            "       </td>" +
            "       <td>" +
            "           <input type='text' id='studentName'>" +
            "       </td>" +
            "   </tr>" +
            "   <tr>" +
            "       <td>" +
            "           <label>Ngày sinh: <label>" +
            "       </td>" +
            "       <td>" +
            "           <input type='date' id='birthday'>" +
            "       </td>" +
            "   </tr>" +
            "   <tr>" +
            "       <td>" +
            "           <label>Giới tính: <label>" +
            "       </td>" +
            "       <td>" +
            "           <select id='gender'>" +
            "               <option>Nam</option>" +
            "               <option>Nữ</option>" +
            "           </select>" +
            "       </td>" +
            "   </tr>" +
            "   <tr>" +
            "       <td>" +
            "           <label>Lớp: <label>" +
            "       </td>" +
            "       <td>" +
            "           <input type='text' id='studentClass'>" +
            "       </td>" +
            "   </tr>" +
            "   <tr>" +
            "       <td>" +
            "           <label>Khóa: <label>" +
            "       </td>" +
            "       <td>" +
            "           <input type='text' id='grade'>" +
            "       </td>" +
            "   </tr>" +
            "   <tr>" +
            "       <td>" +
            "       </td>" +
            "       <td>" +
            "           <input type='button' onclick='studentManagement.submitInfo()' value='Submit'>" +
            "           <input type='reset'>" +
            "       </td>" +
            "   </tr>" +
            "</table>" +
            "</form>";
        document.getElementById("showingDivison").innerHTML = inputForm;
    }

    getInfo() {
        let studentId = document.forms["inputInfo"]["studentId"];
        let studentName = document.forms["inputInfo"]["studentName"];
        let birthday = document.forms["inputInfo"]["birthday"];
        let gender = document.forms["inputInfo"]["gender"];
        let studentClass = document.forms["inputInfo"]["studentClass"];
        let studentGrade = document.forms["inputInfo"]["grade"];
        let tempInfo = new Info(studentId.value, studentName.value, birthday.value, gender.value, studentClass.value, studentGrade.value);
        return tempInfo;
    }

    checkInfo(student) {
        messageAlert = "";
        if (student.id === "") {
            messageAlert += "MSSV: Chưa nhập thông tin\n"
        }
        if (student.name === "") {
            messageAlert += "Tên sinh viên: Chưa nhập thông tin\n"
        }
        if (student.birthday === "") {
            messageAlert += "Ngày sinh: Chưa nhập thông tin\n"
        }
        if (student.studentClass === "") {
            messageAlert += "Lớp: Chưa nhập thông tin\n"
        }
        if (student.studentGrade === "") {
            messageAlert += "Khóa: Chưa nhập thông tin\n"
        }
        if (messageAlert === "") {
            return true
        } else return false
    }

    submitInfo() {
        let student = this.getInfo();
        if (this.checkInfo(student)) {
            this.list.push(student);
            alert("Nhập thành công");
            document.getElementById("inputInfo").reset()
        } else {
            alert(messageAlert)
        }
    }

    searchId(id) {
        let i;
        if (this.list.length === 0) {
            return -1
        } else {
            for (i = 0; i < this.list.length; i++) {
                if (this.list[i].id === id) {
                    break
                }
            }
            return i;
        }
    }

    searchName(name) {
        let i;
        if (this.list.length === 0) {
            return -1
        } else {
            for (i = 0; i < this.list.length; i++) {
                if (this.list[i].name === name) {
                    break
                }
            }
            return i
        }
    }

    removeId(id) {
        let index = this.searchId(id);
        if (index === -1) {
            alert("Danh sách sinh viên rỗng")
        } else {
            if (index === this.list.length) {
                alert("Không tìm thấy sinh viên")
            } else {
                if (confirm("Bạn có muốn xóa MSSV " + id + " không?")) {
                    this.list.splice(index, 1)
                    alert("Xóa thành công")
                }

            }
        }
    }

    removePos(pos) {
        if (this.list.length === 0) {
            alert("Danh sách sinh viên rỗng")
        } else {
            if (pos > this.list.length) {
                alert("Chỉ được nhập từ 1 đến " + this.list.length)
            } else {
                if (confirm("Bạn có muốn xóa sinh viên thứ " + pos + " trong DSSV không?")) {
                    this.list.splice(pos - 1, 1);
                    alert("Xóa thành công")
                }

            }
        }
    }
    print(start, end) {
        let printtable = "<table class='studentList'><" +
            "tr>" +
            "<th>STT</th>" + "<th>MSSV</th>" + "<th>Tên Sinh viên</th>" + "<th>Ngày sinh</th>" + "<th>Giới tính</th>" + "<th>Lớp</th>" + "<th>Khóa</th>" +
            "</tr>"
        for (let i = start; i <= end; i++) {
            printtable += "<tr><td>" + (i + 1) + "</td><td>" + this.list[i].id + "</td><td>" + this.list[i].name + "</td>" +
                "<td>" + this.list[i].birthday + "</td><td>" + this.list[i].gender + "</td><td>" + this.list[i].studentClass + "</td><td>" + this.list[i].studentGrade + "</td></tr>"
        }
        printtable += "</table>";
        document.getElementById("showingDivison").innerHTML = printtable;
    }
    searchStudent(info) {
        let index = this.searchId(info);
        if (index === -1 || index === this.list.length) {
            index = this.searchName(info);
            if (index === -1 || index === this.list.length) {
                alert("Không tìm thấy sinh viên")
            } else {
                this.print(index, index)
            }
        } else {
            this.print(index, index)
        }


    }
    sort() {
        this.list.sort(function (a, b) {
            return a.id - b.id
        })
        this.print(0, this.list.length - 1);
    }
}
let messageAlert;
let studentList = new Array();
let studentManagement = new Program(studentList);
let inputForm;
function mainMenu() {
    let menu = "<h2>STUDENT MANAGEMENT SOFTWARE</h2><hr>" +
        "    <label onclick='studentManagement.addStudent()'>Add Student</label>" +
        "    <label onclick='removeById()'>Remove by ID</label>" +
        "    <label onclick='removeByNo()'>Remove by No</label>" +
        "    <label onclick='studentSearch()'>Search</label>" +
        "    <label onclick='printList()'>Print</label>" +
        "    <label onclick='studentManagement.sort()'>Sort</label>" +
        "<hr>";
    document.getElementById("mainMenu").innerHTML = menu;

}

function removeById() {
    let id = prompt("Nhập mã số sinh viên");
    studentManagement.removeId(id);
    studentManagement.print(0, studentManagement.list.length - 1);
}

function removeByNo() {
    let pos;
    while (!Number.isInteger(pos) || parseFloat(pos) < 1) {
        pos = parseFloat(prompt("Nhập số thứ tự sinh viên muốn xóa"))
    }
    studentManagement.removePos(pos);
    studentManagement.print(0, studentManagement.list.length - 1);
}

function studentSearch() {
    let info = "";
    while (info === "") {
        info = prompt("Nhập thông tin sinh viên")
    }
    studentManagement.searchStudent(info)
}

function printList() {
    studentManagement.print(0, studentManagement.list.length - 1)
}







