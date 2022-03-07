cleari()
drawStage(black)
val pic = Picture.rectangle(50, 50)
draw(pic)

val js = joystick(25)
val cb = canvasBounds
js.setPostiion(cb.x + cb.width / 2, cb.y + 25 + 10)
js.draw()

animate {
    js.movePlayer(pic, 1)
}