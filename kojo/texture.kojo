clear()
setBackground(white)
setSpeed(superFast)
setPenColor(cm.gray)
// Si impostano tutte le variabili che vengono utilizzate per costruire la texture
val nx = 20
val ny = 20
val cb = canvasBounds
val dx = cb.width / nx
val dy = cb.height / ny

def shape() {
    savePosHe()
    right(random(-5, 5))
    val len = dy / 2 + randomDouble(dx)
    repeat(4) {
        forward(len)
        right(90)
    }
    restorePosHe()
}
def posx(gx: Int) = cb.x + gx * dx
def posy(gy: Int) = cb.y + gy * dy

def block(gx: Int, gy: Int) {
    setPosition(posx(gx), posy(gy))
    setFillColor(randomColor.fadeOut(0.2))
    shape()
}
    // funzione MAIN che realizza l’intera texture
repeatFor(0 until nx) { x =>
    repeatFor(0 until ny) { y =>
    block(x, y)
    }
}