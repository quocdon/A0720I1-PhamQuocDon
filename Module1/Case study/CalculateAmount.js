function totalamount() {
    let guestname = document.forms["guestinfo"]["guestname"];
    let guestid = document.forms["guestinfo"]["guestid"];
    let guestdob = document.forms["guestinfo"]["guestdob"];
    let address = document.forms["guestinfo"]["address"];
    let guestclass = document.forms["guestinfo"]["guestclass"];
    let rentdays = document.forms["guestinfo"]["rentdays"];
    let services = document.forms["guestinfo"]["services"];
    let roomtype = document.forms["guestinfo"]["roomtype"];
    let price;
    let amount;
    if (services.value=="Villa"){price=500}
    else{
        if(services.value=="House"){price=300}
        else price=100
    }
    amount = rentdays.value * price *(1-10/100);
    document.getElementById("ketqua").innerHTML = "Tên khách hàng: "+ guestname.value +"<br>" +
        "Số CMND: " + guestid.value +"<br>"+
        "Ngày Sinh: " + guestdob.value +"<br>"+
        "Địa chỉ: " + address.value + "<br>"+
        "Hạng khách hàng: " + guestclass.value + "<br>"+
        "Số ngày thuê: " + rentdays.value +"<br>"+
        "Dịch vụ thuê: " + services.value +"<br>"+
        "Loại phòng: " + roomtype.value + "<br>"+
        "Giá tiền: " + amount +"VND";

}