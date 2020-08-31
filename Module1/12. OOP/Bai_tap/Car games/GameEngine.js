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
        if ([LEFTORNT,RIGHTORNT,DOWNORNT,UPORNT].indexOf(this.orientation) !== -1){
            this.image = "img/" + this.orientation + ".png"
        }
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
    constructor(vehicle, ctx){
        this.vehicle = vehicle;
        this.ctx = ctx;
    }
    render(){
        let img = new Image();
        let tempCtx = this.ctx;
        let tempVehicle = this.vehicle;
        img.src = this.vehicle.image;
        img.onload = function () {
            tempCtx.drawImage(img, tempVehicle.xPos, tempVehicle.yPos);
        }
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
            default: break
        }
        if (this.vehicle.orientation !== ornt){
            this.vehicle.orientation = ornt;
            this.vehicle.turn();
        } else {
                if (event.keyCode >= 37 && event.keyCode <= 40 && event.ctrlKey){
                    this.vehicle.move();
                    this.vehicle.move();
                    this.vehicle.move();
                } else {
                    this.vehicle.move()
                }
        }
        this.ctx.clearRect(0,0,1000,500);
        this.render()
        multikeys[event.keyCode] = false;
    }
}
let ctx = document.getElementById("gameBoard").getContext("2d");
let car = new GameObject(400,200,"up",20,"img/up.png");
let startgame = new GamePlay(car, ctx);
startgame.render();
