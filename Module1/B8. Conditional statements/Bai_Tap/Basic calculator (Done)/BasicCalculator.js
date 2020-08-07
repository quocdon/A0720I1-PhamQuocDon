let formula = document.getElementById("formula");
let leftBrkt = 0;                                                                                                       /*Biến đếm dấu mở ngoặc*/
let rightBrkt = 0;                                                                                                      /*Biến đếm dấu đóng ngoặc*/

function inpNumber(number) {                                                                                            /*Nhập toán hạng vào công thức tính toán*/
    formula.value = formula.value + number;
}

function inpOperator(operator) {                                                                                        //Nhập toán tử vào công thức tính toán
    if (((operator === "*")||(operator === "/"))&&
        ((formula.value === "+")||(formula.value === "-")||(formula.value.substr(formula.value.length - 1, 1) === "(")
            ||(formula.value.substr(formula.value.length - 2, 2) === "(+")
            ||(formula.value.substr(formula.value.length - 2, 2) === "(-"))) {                              //Fix lỗi trong trường hợp nhập 2 toán tử liên tục khiến phép tính bắt đầu bằng dấu nhân và chia và lỗi nhập dấu nhân chia sau dấu mở ngoặc
    }else {
        if (((operator === "*") || (operator === "/") || (operator === "+") || (operator === "-")) &&                   //Trường hợp nhập liên tục 2 toán tử thì công thức tự động thay bằng toán tử nhập sau
            ((formula.value.substr(formula.value.length - 1, 1) === "+")
                || (formula.value.substr(formula.value.length - 1, 1) === "-")
                || (formula.value.substr(formula.value.length - 1, 1) === "*")
                || (formula.value.substr(formula.value.length - 1, 1) === "/"))) {
            formula.value = formula.value.substr(0, formula.value.length - 1) + operator;
        } else if (((formula.value.substr(formula.value.length - 1, 1) === ""))                             //Nhân và chia khi bắt đầu công thức hoặc trong ngoặc thì tự động thêm số 0 phía trước
            && ((operator === "*") || (operator === "/"))) {
            formula.value = "0" + operator;
        } else formula.value = formula.value + operator;
    }
}

function leftBracket() {                                                                                                //Nhập dấu mở ngoặc
    if ((formula.value !== "") && (parseInt(formula.value.substr(formula.value.length-1,1))>=0)            //Trường hợp trước dấu ngoặc là số thì công thức hiểu là phép nhân
        && (parseInt(formula.value.substr(formula.value.length-1,1))<=9)){
        formula.value = formula.value + "*(";
    } else {
        formula.value = formula.value + "(";
    }
    leftBrkt++;                                                                                                         //Đếm số dấu mở ngoặc trong công thức
}
function rightBracket(){                                                                                                //Nhập dấu đóng ngoặc
    if ((leftBrkt > rightBrkt)&&(parseInt(formula.value.substr(formula.value.length-1,1))>=0)              //Chỉ được nhập dấu đóng ngoặc khi phía trước có dấu mở ngoặc và phía sau toán hạng
        && (parseInt(formula.value.substr(formula.value.length-1,1))<=9)){
        formula.value = formula.value + ")";
        rightBrkt++;                                                                                                    //Đếm số dấu đóng ngoặc trong công thức
    }

}
function calculate() {

    if (((formula.value.substr(formula.value.length - 1, 1)) === ")") ||
        ((parseInt(formula.value.substr(formula.value.length - 1, 1)) >= 0)                               //Chỉ tính toán khi công thức kết thúc là dấu đóng ngoặc hoặc toán hạng
            && (parseInt(formula.value.substr(formula.value.length - 1, 1)) <= 9))) {
        if (formula.value.substr(formula.value.length - 1, 1) !== "("){
            if (leftBrkt - rightBrkt > 0) {                                                                             //Trong trường hợp chưa đóng hết ngoặc thì công thức tự điền đóng ngoặc rồi mới tính toán
                for (i = 1; i <= (leftBrkt - rightBrkt); i++) {
                    formula.value += ")";
                }
            }
        }
        formula.value = eval(formula.value);
        leftBrkt = 0;                                                                                                   //Sau khi tính toán thì gán lại số dấu mở ngoặc, đóng ngoặc về 0
        rightBrkt = 0;
    }
}
function clearformula() {
    formula.value = "";
}

function backspace() {
    formula.value = formula.value.substr(0,formula.value.length - 1 )
}