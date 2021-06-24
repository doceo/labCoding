cleari()
drawStage(black)
val cb = canvasBounds

def nuovaPalla = {
    fillColor(red) -> Picture.circle(5)
}


val ostacoli = HashSet.empty[Picture]

timer(1000) {
    val b = nuovaPalla
    b.setPosition(cb.x+5 , cb.y + 5)
    b.setHeading(-random(30))
    ostacoli.add(b)
    draw(b)
}

var vel = Vector2D(1, 1)
var punteggio = 0
var gioco = true


timer(3000){
  vel = vel + Vector2D(0.5,0.5)
}
 def gameOver(msg: String) {
      val pmsg = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(msg)
      }
      val pic = picColCentered(pmsg, Picture.vgap(cb.height - 100))
      drawCentered(pic)

      gioco = false
  }


animate {
    ostacoli.foreach { b =>
        if(gioco){
        b.translate(vel)
        }
    }

    ostacoli.foreach { b =>
        if (b.collidesWith(stageBorder)) {
            ostacoli.remove(b)
            b.erase()
            punteggio = punteggio + 1
            println(vel)
            
            gameOver("hai perso!")   
        }
    }
}