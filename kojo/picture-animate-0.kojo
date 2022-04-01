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
