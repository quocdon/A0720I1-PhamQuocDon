const LEFTORNT = "left";
const RIGHTORNT = "right";
const UPORNT = "up";
const DOWNORNT = "down";
class GameObject {
    constructor(xPos, yPos, orientation, speed, image) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = orientation;
        this.speed = speed;
        this.image = image;
    }
    move(){
        let img = new Image();
        img.src = this.image;
        switch (this.orientation) {
            case LEFTORNT:{
                if (this.xPos >= 0){
                    this.xPos -= this.speed;
                }
                break
            }
            case RIGHTORNT: {
                if (this.xPos <= 1000 - img.width){
                    this.xPos += this.speed;
                }
                break
            }
            case UPORNT: {
                if (this.yPos >= 0){
                    this.yPos -= this.speed;
                }
                break
            }
            case DOWNORNT: {
                if (this.yPos <= 500-img.height){
                    this.yPos += this.speed;
                }
                break
            }
        }
    }
}
class GamePlay {
    constructor(object, ctx){
        this.object = object;
        this.ctx = ctx;
    }
    render(){
        let img = new Image();
        img.src = this.object.image;
        this.ctx.drawImage(img, this.object.xPos, this.object.yPos);
    }
    moveObject(event){
        let ornt = 0;
        switch (event.keyCode) {
            case 37: {
                ornt = LEFTORNT;
                break
            }
            case 38: {
                ornt = UPORNT;
                break
            }
            case 39: {
                ornt = RIGHTORNT;
                break
            }
            case 40: {
                ornt = DOWNORNT;
                break
            }
        }
        if (this.object.orientation !== ornt){
            this.object.orientation = ornt
        } else {
            this.object.move()
        }
        this.ctx.clearRect(0,0,1000,500);
        this.render()
    }
}
let ctx = document.getElementById("gameBoard").getContext("2d");
let chopper = new GameObject(0,0,"left",20,"img/Chopper.png");
let startgame = new GamePlay(chopper, ctx);
