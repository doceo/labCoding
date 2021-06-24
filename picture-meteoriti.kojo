cleari()
drawStage(black)
val cb = canvasBounds

def nuovaPalla = {
    fillColor(red) -> Picture.circle(5)
}

val giocatore = Picture.rectangle(40,40)
  giocatore.setPenColor(yellow)
  giocatore.setFillColor(yellow)
  giocatore.setPosition( cb.x + cb.width/2, cb.y + cb.height/2)

draw(giocatore)

val ostacoli = HashSet.empty[Picture]

timer(1000) {
    val b = nuovaPalla
    b.setPosition(cb.x+5 , cb.y + random((cb.height).toInt))
    ostacoli.add(b)
    draw(b)
}

var vel = Vector2D(1, 0)
var velG = 2 
var vite = 10

val punteggio = Picture.textu(vite, 30)
    punteggio.translate(cb.x + cb.width - 50, cb.y + cb.height-10)
    punteggio.setPenColor(green)
    draw(punteggio)

def perdeVita() {
        vite = vite - 1
        punteggio.update(vite)
        if (vite == 0){
          gameOver("Hai perso!!")
        }
}



timer(3000){
  vel = vel + Vector2D(0.5,0)
}

 def gameOver(msg: String) {
      val pmsg = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(msg)
      }
      val pic = picColCentered(pmsg, Picture.vgap(cb.height - 100))
      drawCentered(pic)
      stopAnimation()

  }

showGameTime(60, "Hai vinto!", green, 40)

animate {
    ostacoli.foreach { b =>
        b.translate(vel)
    }

    ostacoli.foreach { b =>
        if (b.collidesWith(stageBorder)) {
            ostacoli.remove(b)
            b.erase()            
        }

        if(b.collidesWith(giocatore)){
          
          ostacoli.remove(b)
          b.erase()
          perdeVita()
        }
    }


    if (isKeyPressed(Kc.VK_RIGHT)) {
        giocatore.translate(velG, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        giocatore.translate(-velG, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        giocatore.translate(0, velG)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        giocatore.translate(0, -velG)
    }
}