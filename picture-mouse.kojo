clear()
setBackground(cm.black)
val cb = canvasBounds

val pic = fillColor(red) -> Picture.rectangle(400, 400)
drawCentered(pic)

pic.onMouseClick { (x, y) =>
    pic.erase()
    val msg = Picture.text("Done", 30)
    draw(msg)
}