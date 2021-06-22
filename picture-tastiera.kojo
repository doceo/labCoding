cleari()

val pic = Picture.rectangle(50, 50)
draw(pic)

val speed = 5
animate {
    if (isKeyPressed(Kc.VK_RIGHT)) {
        pic.translate(speed, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        pic.translate(-speed, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        pic.translate(0, speed)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        pic.translate(0, -speed)
    }
}
activateCanvas()