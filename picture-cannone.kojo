cleari()
drawStage(black)
val cb = canvasBounds

def nuovaPalla = {
    fillColor(red) -> Picture.circle(5)
}


val ostacoli = HashSet.empty[Picture]

timer(1000) {
    val b = nuovaPalla
    b.setPosition(cb.x+5, cb.y + 5)
    b.setHeading( - random(45))
    ostacoli.add(b)
    draw(b)
}

var vel = Vector2D(5, 5)

animate {
    ostacoli.foreach { b =>
        
        b.translate(vel)
    }

    ostacoli.foreach { b =>
        if (b.collidesWith(stageBorder)) {
            ostacoli.remove(b)
            b.erase()
        }
    }
}