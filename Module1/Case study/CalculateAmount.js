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
    let discountprice;
    if (services.value=="Villa"){price=500}
    else{
        if(services.value=="House"){price=300}
        else price=100
    }
    discountprice = price*(1-10/100)
    amount = rentdays.value * discountprice;
    document.getElementById("ketqua").innerHTML = "<table class='confirmationTable'>" +
        "<tr>" +
            "<td colspan='2' style='text-align: center'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</td>"+
        "</tr>"+
        "<tr>" +
            "<td>Tên khách hàng/ Guest name: </td>"+
            "<td>" + guestname.value +"</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Số CMND/ID Number: </td>"+
            "<td>" + guestid.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Ngày sinh: </td>"+
            "<td>" + guestdob.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Địa chỉ: </td>"+
            "<td>" + address.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Hạng khách hàng/ Customer class: </td>"+
            "<td>" + guestclass.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Số ngày thuê/ Rentdays: </td>"+
            "<td>" + rentdays.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Loại dịch vụ/ Services: </td>"+
            "<td>" + services.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Loại phòng/ Room type: </td>"+
            "<td>" + roomtype.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Đơn giá/ Price: </td>"+
            "<td>"+ discountprice + " USD/đêm - (Giá gốc: "+ price + " USD/Đêm)" + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Thành tiền/ Total Amount: </td>"+
            "<td style='color: red'>" + amount + "  USD</td>"+
        "</tr>"+
        "</table>"







    /*"<p class='gueststyle'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</p>"+ "<br>"+
        "Tên khách hàng: "+ guestname.value +"<br>" +
        "Số CMND: " + guestid.value +"<br>"+
        "Ngày Sinh: " + guestdob.value +"<br>"+
        "Địa chỉ: " + address.value + "<br>"+
        "Hạng khách hàng: " + guestclass.value + "<br>"+
        "Số ngày thuê: " + rentdays.value +"<br>"+
        "Dịch vụ thuê: " + services.value +"<br>"+
        "Loại phòng: " + roomtype.value + "<br>"+
        "Giá tiền: " + amount +"VND";*/

}