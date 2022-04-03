def shape() {
    // savePosHe() not needed here as turtle ends up at its starting state
    repeat(5) {
        forward(100)
        right(360/5)
    }
}

def block() {
    setFillColor(randomColor.fadeOut(0.7))
    shape()
    right(20)
}

clear()
setSpeed(fast)
setPenColor(cm.darkSlateGray)
repeat(18) {
    block()
}