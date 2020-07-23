function totalamount() {
    let guestname = document.forms["guestinfo"]["guestname"];                   /*Get data from input form*/
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
    if (services.value=="Villa"){price=500}                                     /*Get the price based on services*/
    else{
        if(services.value=="House"){price=300}
        else price=100
    }
    discountprice = price*(1-10/100)                                            /*Calculate discount price*/
    amount = rentdays.value * discountprice;
                                                                                /*Display booking confirmation with total amount to screen*/
    document.getElementById("ketqua").innerHTML = "<table class='confirmationTable'>" +
        "<tr>" +
            "<td colspan='2' class='confirmationHeader'>XÁC NHẬN ĐẶT PHÒNG/ BOOKING CONFIRMATION</td>"+
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
            "<td>Ngày sinh/ Date of birth: </td>"+
            "<td>" + guestdob.value + "</td>"+
        "</tr>"+
        "<tr>"+
            "<td>Địa chỉ/ Address: </td>"+
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
            "<td class='amountstyle''>" + amount + "  USD</td>"+
        "</tr>"+
        "</table>"
}