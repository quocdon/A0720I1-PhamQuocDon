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
    loadImage(){
        this.image  = "img/"+ this.orientation + ".png"
    }
    move(){
        switch (this.orientation) {
            case LEFTORNT:{
                this.xPos -= this.speed;
                break
            }
            case RIGHTORNT: {
                this.xPos += this.speed;
                break
            }
            case UPORNT: {
                this.yPos -= this.speed;
                break
            }
            case DOWNORNT: {
                this.yPos += this.speed;
                break
            }
        }
    }
    turn(ornt){
        this.orientation = ornt;
        this.loadImage()
    }
    drawImage(ctx){
        let image = new Image();
        ctx.drawImage(image, this.xPos, this.yPos);
        image.src = this.image
    }
}
class GamePlay {
    constructor(object, ctx){
        this.object = object;
        this.ctx = ctx;
    }
    start(){
        this.ctx = document.getElementById("gameBoard").getContext("2d");
        this.object.drawImage(this.ctx);
    }
    render(){
        this.ctx.clearRect(0,0,500,500);
        this.object.drawImage(this.ctx)
    }
    moveObject(event){
        let ornt;
        switch (event.which) {
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
        if (ornt)
    }
}

    /*this.car = new GameObject(50,50, RIGHTORNT, 20,"right");
    this.ctx = undefined;
    this.start = function(){
        this.ctx = document.getElementById("gameBoard").getContext("2d");
        this.car.drawImage(this.ctx);
    }
    this.render = function(){
        this.ctx.clearRect(0,0,500,500);
        this.car.drawImage()
    }


}

