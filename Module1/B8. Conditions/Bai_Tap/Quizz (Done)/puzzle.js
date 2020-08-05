let image1;
let image2
let image3;
let image4;
let image5;

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

function changeImage(image) {
    image1 = document.getElementById("image1");
    image2 = document.getElementById("image2");
    image3 = document.getElementById("image3");
    image4 = document.getElementById("image4");
    image5 = document.getElementById("image5");
    switch (image) {
        case 1: {
            if (image1.getAttribute('src') === "img/image1-0.jpg") {
                image1.src = "img/image1-1.jpg";
            } else {
                if (image1.getAttribute('src') === "img/image1-1.jpg") {
                    image1.src = "img/image1-2.jpg";
                } else if (image1.getAttribute('src') === "img/image1-2.jpg") {
                    image1.src = "img/image1-0.jpg";
                }
            }
            break;
        }
        case 2: {
            if (image2.getAttribute('src') === "img/image2-0.jpg") {
                image2.src = "img/image2-1.jpg";
            } else {
                if (image2.getAttribute('src') === "img/image2-1.jpg") {
                    image2.src = "img/image2-2.jpg";
                } else if (image2.getAttribute('src') === "img/image2-2.jpg") {
                    image2.src = "img/image2-0.jpg";
                }
            }
            break;
        }
        case 3: {
            if (image3.getAttribute('src') === "img/image3-0.jpg") {
                image3.src = "img/image3-1.jpg";
            } else {
                if (image3.getAttribute('src') === "img/image3-1.jpg") {
                    image3.src = "img/image3-2.jpg";
                } else if (image3.getAttribute('src') === "img/image3-2.jpg") {
                    image3.src = "img/image3-0.jpg";
                }
            }
            break;
        }
        case 4: {
            if (image4.getAttribute('src') === "img/image4-0.jpg") {
                image4.src = "img/image4-1.jpg";
            } else {
                if (image4.getAttribute('src') === "img/image4-1.jpg") {
                    image4.src = "img/image4-2.jpg";
                } else if (image4.getAttribute('src') === "img/image4-2.jpg") {
                    image4.src = "img/image4-0.jpg";
                }
            }
            break;
        }
        case 5: {
            if (image5.getAttribute('src') === "img/image5-0.jpg") {
                image5.src = "img/image5-1.jpg";
            } else {
                if (image5.getAttribute('src') === "img/image5-1.jpg") {
                    image5.src = "img/image5-2.jpg";
                } else if (image5.getAttribute('src') === "img/image5-2.jpg") {
                    image5.src = "img/image5-0.jpg";
                }
            }
            break;
        }
    }
    checkimage()
}
function checkimage() {
    if ((image1.getAttribute('src') === "img/image1-0.jpg")
        && (image2.getAttribute('src') === "img/image2-0.jpg")
        && (image3.getAttribute('src') === "img/image3-0.jpg")
        && (image4.getAttribute('src') === "img/image4-0.jpg")
        && (image5.getAttribute('src') === "img/image5-0.jpg")){
        alert("Portgas D. Ace: tên thật Gol D. Ace, có biệt danh Ace Hỏa Quyền.\n " +
            "Ace là đội trưởng Đội 2 của băng hải tặc Râu Trắng và từng là đội trưởng của băng Spade, " +
            "anh đã ăn trái Mera Mera no Mi trở thành người sử dụng năng lực chuyển hóa thành lửa cũng như tạo ra và điều khiển lửa.")
    }
    if ((image1.getAttribute('src') === "img/image1-1.jpg")
        && (image2.getAttribute('src') === "img/image2-1.jpg")
        && (image3.getAttribute('src') === "img/image3-1.jpg")
        && (image4.getAttribute('src') === "img/image4-1.jpg")
        && (image5.getAttribute('src') === "img/image5-1.jpg")){
        alert("Sabo là Tổng tham mưu Trưởng của Quân Cách mạng và là anh em kết nghĩa với Luffy và Ace.\n" +
            "Sau này anh trở thành thành viên Quân Cách mạng. Sabo bất ngờ xuất hiện ở Dressrosa và hỗ trợ cho Luffy cùng băng Mũ Rơm.\n " +
            "Sabo đã kế thừa ý chí của Ace, anh trở thành người sở hữu đời tiếp theo của trái ác quỷ Mera Mera hệ Logia.");
    }
    if ((image1.getAttribute('src') === "img/image1-2.jpg")
        && (image2.getAttribute('src') === "img/image2-2.jpg")
        && (image3.getAttribute('src') === "img/image3-2.jpg")
        && (image4.getAttribute('src') === "img/image4-2.jpg")
        && (image5.getAttribute('src') === "img/image5-2.jpg")){
        alert("Monkey D. Luffy (Mũ Rơm) là người sáng lập và là thuyền trưởng của băng Hải tặc Mũ Rơm, sở hữu sức mạnh của trái ác quỷ Gomu Gomu. \n" +
            "Luffy là người duy nhất hiện tại trong nhóm sử dụng thành thục được ba loại sức mạnh của Haki. \n" +
            "Ước mơ của cậu là trở thành Vua Hải Tặc (Pirate King), người tự do nhất trên biển, bằng cách tìm ra kho báu huyền thoại của Gold D. Roger (Vua Hải Tặc) đời trước.");
    }

}


