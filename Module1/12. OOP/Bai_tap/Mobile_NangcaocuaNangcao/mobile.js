class Mobile {
    constructor(mobileNumber, battery, inbox, outbox, draft, power) {
        this.mobileNumber = mobileNumber;
        this.battery = battery;
        this.inbox = inbox;
        this.outbox = outbox;
        this.draft = draft;
        this.power =  power;
    }
    status(){
        if (this.battery > 0 && this.power){
            return true
        } else return false;
    }
    powerbutton(){
        this.power = !this.power
    }
    charging(){
        while (this.battery < 100){
            this.battery++;
        }
    }
    sendMessage(toMobile){
        if (this.status()){
            let message = prompt("Soạn tin nhắn");
            let isSend = confirm("Bạn có muốn gửi tin nhắn đi không?");
            if (isSend){
                this.outbox.push(message);
                this.battery--;
                if (toMobile.status()){
                    toMobile.inbox.push([this.mobileNumber, message])
                    toMobile.battery--
                }
            }else {
                this.draft.push(message);
                this.battery--
            }
        } else {
            alert("Điện thoại đang tắt")
        }
    }
    queryInbox(){
        if (this.status()){
            let temp = "";
            let index;
            if (this.inbox.length !== 0){
                for (let i = 0; i < this.inbox.length; i++){
                    temp += i + ": " + this.inbox[i][0] + " - " + this.inbox[i][1].substr(0,15) + "\n"
                }
                do {
                    index = prompt(temp)
                } while (index >= this.inbox.length || index < 0 || isNaN(index) || !Number.isInteger(parseFloat(index)));
                alert(this.inbox[index][1]);
            } else {
                alert("Hộp thư trống")
            }
            this.battery--;
        } else {
            alert("Điện thoại đang tắt")
        }
    }
    queryOutbox(){
        if (this.status()) {
            let temp = "";
            let index;
            if (this.outbox.length !== 0){
                for (let i = 0; i < this.outbox.length; i++) {
                    temp += i + ": " + this.outbox[i].substr(0, 15) + "\n"
                }
                do {
                    index = prompt(temp)
                } while (index >= this.outbox.length || index < 0 || isNaN(index) || !Number.isInteger(parseFloat(index)));
                alert(this.outbox[index]);
            } else {
                alert("Hộp thư trống")
            }
            this.battery--;
        } else {
            alert("Điện thoại đang tắt")
        }
    }
    queryDraft(){
        if (this.status()) {
            let temp = "";
            let index;
            if (this.draft.length !== 0){
                for (let i = 0; i < this.draft.length; i++) {
                    temp += i + ": " + this.draft[i].substr(0, 15) + "\n"
                }
                do {
                    index = prompt(temp)
                } while (index >= this.draft.length || index < 0 || isNaN(index) || !Number.isInteger(parseFloat(index)));
                alert(this.draft[index]);
            } else {
                alert("Hộp thư trống")
            }
            this.battery--;
        } else {
            alert("Điện thoại đang tắt")
        }
    }
}

function selectMobile(){
     let temp = prompt("Chọn điện thoại sử dụng \n 0. Nokia \n 1. Iphone\n 2. Thoát chương trình");
     switch (temp) {
         case "0": {
             return "nokia";
             break
         }
         case "1": {
             return "iphone";
             break
         }
         case "2": {
             return "finish";
             break
         }
         default: {
             alert("Chỉ được nhập số 0, 1 hoặc 2")
         }
     }
}
function mobileInterface(mobileName, funcIndex){
    switch (funcIndex) {
        case "0": {
            mobileName.powerbutton();
            if (mobileName.power){
                alert("Đã bật điện thoại")
            } else {
                alert("Đã tắt điện thoại")
            }
            break
        }
        case "1": {
            if (mobileName.status()){
                alert("Điện thoại đang bật")
            } else {
                alert("Điện thoại đang tắt")
            }
            break
        }
        case "2": {
            if (mobileName.status()){
                alert(mobileName.battery);
            } else {
                alert("Điện thoại đang tắt")
            }
            break
        }
        case "3": {
            mobileName.charging();
            alert("Điện thoại đã sạc đầy " + mobileName.battery);
            break
        }
        case "4": {
            if (mobileName === nokia){
                mobileName.sendMessage(iphone);
            } else mobileName.sendMessage(nokia);
            break
        }
        case "5": {
            mobileName.queryInbox();
            break
        }
        case "6": {
            mobileName.queryOutbox();
            break;
        }
        case "7": {
            mobileName.queryDraft();
            break
        }
        case "8": {
            mobileChosen = selectMobile();
            break
        }
    }
}

let nokia = new Mobile("Đôn Student", 100, [],[], [], true);
let iphone = new Mobile("Hải Tutor", 100, [],[], [], true);
let mobileChosen;
while (mobileChosen !== "finish"){
    while (mobileChosen !=="nokia" && mobileChosen !=="iphone"){
        mobileChosen = selectMobile();
    }
    let menu ="Điện thoại đang sử dụng: " + mobileChosen + "\nNhập chức năng cần dùng: \n" +
        " 0. Tắt/bật nguồn\n 1. Trạng thái điện thoại \n 2. Dung lượng pin\n 3. Sạc pin \n 4. Gửi tin nhắn \n 5. Hộp thư đến\n" +
        " 6. Hộp thư đi\n 7. Hộp thư nháp\n 8. Thoát ";
    let funcChosen;
    while (!Number.isInteger(parseFloat(funcChosen)) || parseInt(funcChosen) > 8 || parseInt(funcChosen) < 0){
        funcChosen = prompt(menu);
    }
    switch (mobileChosen) {
        case "nokia": {
            mobileInterface(nokia, funcChosen);
            break;
        }
        case "iphone": {
            mobileInterface(iphone, funcChosen);
            break
        }
    }
}
