let arrOfproducts = new Array()
let product;
let index;
let productTable="";
let oldTable;

function addProduct() {
    product = document.getElementById("product");
    if (product.value === ""){
        alert("Không được để trống")
    }else {
        arrOfproducts.push(product.value);
        listOfProduct();
    }
}
function listOfProduct() {
    if (arrOfproducts.length === 0){
        document.getElementById("listOfProducts").innerHTML="";
    }else{
        productTable = "<table id='currentTable'><tr><th>Product Name</th><th colspan='2'>" + arrOfproducts.length + " product(s) </th></tr>" ;
        for (index = 0; index < arrOfproducts.length; index++){
            productTable += "<tr><td class='editinput'>" + arrOfproducts[index] + "</td>" +
                            "<td><button onclick='editProduct("+ index + ")'>Edit</button></td>"+
                            "<td><button onclick='deleteProduct(" + index +")'>Delete</button></td>"+
                            "</tr>"
            }
        productTable += "</table>";
        if (document.getElementById("currentTable") !== null){
            clearTable()
        }
        document.getElementById("listOfProducts").innerHTML = productTable;
    }
}
function clearTable() {
    oldTable = document.getElementById("currentTable");
    oldTable.remove();
}

function editProduct(temp){
        productTable = "<table id='currentTable'><tr><th>Product Name</th><th colspan='2'>" + arrOfproducts.length + " product(s) </th></tr>";
        for (index = 0; index < arrOfproducts.length; index++){
            if (index === temp){
                productTable += "<tr><td><input type='text' id='editedProduct' value='"+arrOfproducts[index]+"'></td>" +
                    "<td><button onclick='updateProduct("+ index + ")'>Update</button></td>"+
                    "<td><button onclick='deleteProduct(" + index + ")'>Delete</button></td>"+
                    "</tr>"
            } else {
                productTable += "<tr><td>" + arrOfproducts[index] + "</td>" +
                    "<td><button onclick='editProduct(" + index + ")'>Edit</button></td>"+
                    "<td><button onclick='deleteProduct(" + index + ")'>Delete</button></td>"+
                    "</tr>"
            }
        }
        productTable += "</table>";
        clearTable();
        document.getElementById("listOfProducts").innerHTML = productTable;
}
function updateProduct(temp) {
    product = document.getElementById("editedProduct");
    if (product.value ===""){
        alert("Không được để trống")
    } else {
        arrOfproducts[temp] = product.value;
        listOfProduct();
    }

}
function deleteProduct(temp) {
    if (confirm("Bạn có muốn xóa sản phẩm " + arrOfproducts[temp] + " không?")){
        arrOfproducts.splice(temp,1);
        listOfProduct();
    }
}


