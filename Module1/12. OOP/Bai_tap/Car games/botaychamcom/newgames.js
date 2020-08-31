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
    turn(){
        this.image = "img/" + this.orientation + ".png"
    }
    move(){
        let img = new Image();
        img.src = this.image;
        switch (this.orientation) {
            case LEFTORNT:{
                if (this.xPos >= this.speed){
                    this.xPos -= this.speed;
                }
                break
            }
            case RIGHTORNT: {
                if (this.xPos <= 1000 - img.width - this.speed){
                    this.xPos += this.speed;
                }
                break
            }
            case UPORNT: {
                if (this.yPos >= this.speed){
                    this.yPos -= this.speed;
                }
                break
            }
            case DOWNORNT: {
                if (this.yPos <= 500-img.height - this.speed){
                    this.yPos += this.speed;
                }
                break
            }
        }
    }
}
class GamePlay {
    constructor(vehicle, obstacle, gift, ctx){
        this.vehicle = vehicle;
        this.ctx = ctx;
    }
    render(object){
        let img = new Image();
        img.src = object.image;
        this.ctx.drawImage(img, object.xPos, object.yPos);
    }
    obstacleRender(){
        for (let i = 0; i )
    }
    vehicleMove(event){
        let ornt = 0;
        let multikeys = new Array();
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
        if (this.vehicle.orientation !== ornt){
            this.vehicle.orientation = ornt;
            this.vehicle.turn();
            this.render(this.vehicle)
        } else {
                if (event.keyCode >= 37 && event.keyCode <= 40 && event.ctrlKey){
                    this.vehicle.move();
                    this.vehicle.move();
                    this.vehicle.move();
                    this.vehicle.move();
                } else {
                    this.vehicle.move()
                }
        }

        this.ctx.clearRect(0,0,1000,500);
        this.render(this.vehicle)
        multikeys[event.keyCode] = false;
    }
}
let ctx = document.getElementById("gameBoard").getContext("2d");
let car = new GameObject(0,0,"left",20,"img/left.png");
let brick = new Array(5);
for let
let startgame = new GamePlay(car, ctx);
