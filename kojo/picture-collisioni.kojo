cleari()
drawStage(black)


//variabile utile al vettore velocità
var x = 2



val fig1 = Picture.rectangle(50, 50)
fig1.setPenColor(blue)
fig1.setFillColor(green)
fig1.setPosition(-100,-100)
var vel1 = Vector2D(x, x)

val fig2 = Picture.rectangle(50, 50)
fig2.setPenColor(orange)
fig2.setFillColor(red)
fig1.setPosition(100,100)
var vel2 = Vector2D(-x, -x)

draw(fig1)
draw(fig2)

def urto() {
    drawCenteredMessage("boom!", cm.pink, 40)
}



animate {
    fig1.translate(vel1)
    fig2.translate(vel2)

    
    if (fig1.collidesWith(stageBorder)) {
        vel1 = bouncePicOffStage(fig1, vel1)
    }

    
    if (fig2.collidesWith(stageBorder)) {
        vel2 = bouncePicOffStage(fig2, vel2)
    }

    if (fig1.collidesWith(fig2)) {
        vel1 = bouncePicOffPic(fig1, vel1, fig2)
        urto()
    }
 
    if (fig2.collidesWith(fig1)) {
        vel2 = bouncePicOffPic(fig2, vel2, fig1)
        urto()
    }
  
}