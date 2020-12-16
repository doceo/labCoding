def quadrato{

    repeat(4) {
        forward(100)
        right(90)
    }
  
}

clear()
setSpeed(fast) // speed up the turtle
setPenColor(cm.gray)
var clr = cm.rgba(255, 0, 0, 150) // start with a semi transparent red color
repeat(15) {
    setFillColor(clr)
    quadrato
    clr = clr.spin(360 / 15) // change color hue
    right(360 / 15)
}
