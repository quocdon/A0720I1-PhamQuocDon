function convertMoney(){
    let amount= document.getElementById("amount");
    let fromCurrency = document.getElementById("fromCurrency");
    let toCurrency = document.getElementById("toCurrency");
    let convertedAmount = 0;
    let result;
    if (isNaN(amount.value) || amount.value < 0) {
        result = "Số tiền nhập vào phải là số dương"
    }
    else{
        if (fromCurrency.value==="USD" && toCurrency.value==="VND") {
            convertedAmount = amount.value * 23000;
            result = convertedAmount + toCurrency.value;
        }
        else {
            if (fromCurrency.value === "VND" && toCurrency.value === "USD") {
                convertedAmount = amount.value / 23000;
                result = convertedAmount + toCurrency.value;
            }
            else {
                result = "Đơn vị tiền tệ chuyển đổi phải khác nhau";
            }
        }
    }
    alert(result)


}

