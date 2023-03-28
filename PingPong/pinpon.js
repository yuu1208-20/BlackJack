const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

document.addEventListener("keydown",keyDownHandler,false);
document.addEventListener("keyup",keyUpHandler,false);

let x = canvas.width / 2;
let y = canvas.height / 2;
let dx = 2;
let dy = -2;
const ballRadius = 10;

let paddleWidth = 100;
let paddleHeight = 20;
let paddleX = (canvas.width - paddleWidth) / 2;
let paddleY = canvas.height - paddleHeight;

let paddle2Width = 100;
let paddle2Height = 20;
let paddle2X = (canvas.width - paddle2Width) / 2;
let paddle2Y = 0;

let rightPressed = false;
let leftPressed = false;

function drawBall(){
    ctx.beginPath();
    ctx.arc(x,y,10,0,Math.PI*2);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}

function drawPaddle(){
    ctx.beginPath();
    ctx.rect(paddleX, paddleY, paddleWidth, paddleHeight);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}

function drawPaddle2(){
    ctx.beginPath();
    ctx.rect(paddle2X, paddle2Y, paddle2Width, paddle2Height);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}

function moveBall(){
    x += dx;
    y += dy;

    if(y + dy < ballRadius || y + dy > canvas.height - ballRadius){
        dy = -dy;
    }
    if(x + dx < ballRadius || x + dx > canvas.width - ballRadius){
        dx = -dx;
    }
}

function movePaddle(){
    if(rightPressed && paddleX < canvas.width - paddleWidth){
        paddleX += 7;
    } else if(leftPressed && paddleX > 0){
        paddleX -= 7;
    }
}

function movePaddle2(){
    paddle2X = x - paddleWidth / 2;
    if(paddle2X < 0){
        paddle2X = 0;
    } else if(paddle2X + paddle2Width > canvas.width){
        paddle2X = canvas.width - paddle2Width;
    }
}

function keyDownHandler(e){
    if(e.key == "Right" || e.key == "ArrowRight"){
        rightPressed = true;
    } else if(e.key == "left" || e.key == "ArrowLeft"){
        leftPressed = true;
    }
}

function keyUpHandler(e){
    if(e.key == "Right" || e.key == "ArrowRight"){
        rightPressed = false;
    } else if(e.key == "Left" || e.key == "ArrowLeft"){
        leftPressed = false;
    }
}

function collisionDetection(){
    if(y + dy > canvas.height - ballRadius){
        resetGame();
    } else if(y + dy < ballRadius){
        dy = -dy;
    } else if(x + dx < ballRadius || x + dx > canvas.width - ballRadius){
        dx = -dx;
    } else if(y + dy > canvas.height - ballRadius - paddleHeight){
        if(x + dx > paddleX && x + dx < paddleX + paddleWidth){
            dy = -dy;
            dy -= 0.5;
            dx += 0.5;
        } else {
            resetGame();
        }
    } else if(y + dy < ballRadius + paddle2Height){
        if(x + dx > paddle2X && x + dx < paddle2X + paddle2Width){
            dy = -dy;
            dy += 0.5;
            dx -= 0.5;
        } else {
            resetGame();
        }
    }
}

function resetGame(){
    x = canvas.width / 2;
    y = canvas.height / 2;
    dx = 2;
    dy = -2;
    paddleX = (canvas.width - paddleWidth) / 2;
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height);
    drawBall();
    drawPaddle();
    drawPaddle2();
    moveBall();
    movePaddle();
    movePaddle2();
    drawPaddle2();
    collisionDetection();
}
setInterval(draw,10);