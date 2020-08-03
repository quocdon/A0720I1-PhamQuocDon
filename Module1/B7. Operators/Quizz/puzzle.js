function randomImage(pos){
    let part1 = Math.floor((Math.random())*3);
    let part2 = Math.floor((Math.random())*3);
    let part3 = Math.floor((Math.random())*3);
    let part4 = Math.floor((Math.random())*3);
    let part5 = Math.floor((Math.random())*3);
    document.getElementById("pos1").innerHTML="<img src='img/image1" + "-" + part1 + ".jpg' width='400px' id='image1'>";
    document.getElementById("pos2").innerHTML="<img src='img/image2" + "-" + part2 + ".jpg' width='400px' id='image2'>";
    document.getElementById("pos3").innerHTML="<img src='img/image3" + "-" + part3 + ".jpg' width='400px' id='image3'>";
    document.getElementById("pos4").innerHTML="<img src='img/image4" + "-" + part4 + ".jpg' width='400px' id='image4'>";
    document.getElementById("pos5").innerHTML="<img src='img/image5" + "-" + part5 + ".jpg' width='400px' id='image5'>";

}
/*function changeImage() {
    let linkImg = document.getElementById("image1").src;
    switch (linkImg) {
        case "img/image1-0.jpg":
            document.getElementById("image1").src = "img/image1-1.jpg";
            break;
        case "img/image1-1.jpg":
            document.getElementById("image1").src = "img/image1-2.jpg";
            break;
        case "img/image1-2.jpg":
            document.getElementById("image1").src = "img/image1-0.jpg";
            break;
    }
}*/

function changeImage() {
    let linkImg = document.getElementById("image1").src;
    switch (linkImg.value) {
        case "img/image1-0.jpg":
            document.getElementById("image1").src = "img/image1-1";
            break;
        case "img/image1-1.jpg":
            document.getElementById("image1").src = "img/image1-2";
            break;
        case "img/image1-2.jpg":
            document.getElementById("image1").src = "img/image1-0";
            break;
    }
}


