cleari()
drawStage(black)


//variabile utile al vettore velocità
var x = 2



val fig1 = Picture.rectangle(50, 50)
fig1.setPenColor(blue)
fig1.setFillColor(green)
var vel1 = Vector2D(x, x)

val fig2 = Picture.rectangle(50, 50)
fig2.setPenColor(orange)
fig2.setFillColor(red)
var vel2 = Vector2D(-x, x)

val fig3 = Picture.rectangle(50, 50)
fig3.setPenColor(white)
fig3.setFillColor(yellow)
var vel3 = Vector2D(x, -x)


val fig4 = Picture.rectangle(50, 50)
fig4.setPenColor(black)
fig4.setFillColor(pink)
var vel4 = Vector2D(-x, -x)

draw(fig1,fig2,fig3,fig4)




animate {
    fig1.translate(vel1)
    if (fig1.collidesWith(stageBorder)) {
        vel1 = bouncePicOffStage(fig1, vel1)
    }
    
    fig2.translate(vel2)
    if (fig2.collidesWith(stageBorder)) {
        vel2 = bouncePicOffStage(fig2, vel2)
    }
    
    fig3.translate(vel3)
    if (fig3.collidesWith(stageBorder)) {
        vel3 = bouncePicOffStage(fig3, vel3)
    }
    
    fig4.translate(vel4)
    if (fig4.collidesWith(stageBorder)) {
        vel4 = bouncePicOffStage(fig4, vel4)
    }

    
}