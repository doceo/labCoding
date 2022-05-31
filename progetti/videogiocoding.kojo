cleari()
drawStage(black)
val giocatore = Picture.image("razzo.png")
drawCentered(giocatore)

var speed = 5
val contVite = ArrayBuffer.empty[Picture]

val cb = canvasBounds

var vel1 = Vector2D(0, -0.5)
var vel = Vector2D(1, 1)
var punteggio = 0
var gioco = true


def cuore = {
  fillColor(red) -> Picture{

      left (45)
      forward (15)
      repeat (4) {
      right (45)
      forward (5)

       }

      left (90)
      forward (5)
      repeat (3) {
        right (45)
        forward (5)
      }
      right (45)
      forward (15)
  }
}

val nPunti = Picture.textu(punteggio,30)
    nPunti.translate(cb.x + cb.width - 50, cb.y + cb.height-50)
    nPunti.setPenColor(yellow)
    draw(nPunti)



def nuovaPalla = {
    fillColor(red) -> Picture.circle(5)
}

var nVite = 6
var cPos = 0

var vite = HashSet.empty[Picture]
repeat(nVite){

  val cuor = cuore
  cuor.setPosition(cb.x + cb.width - 50 - cPos*30, cb.y + cb.height-30)
  cPos+=1
  cuor.draw()
  contVite.append(cuor)
  }

val ostacoli = HashSet.empty[Picture]
val b = nuovaPalla

val sfondo = HashSet.empty[Picture]
val c = Picture.image("saturno.png")
val d = Picture.image("marte.png")

timer(16000) {
    val c = Picture.image("saturno.png")
    c.setPosition(random(-(cb.width).toInt/2, (cb.width).toInt/2) , ((cb.height).toInt/2))
    c.setHeading(224)
    sfondo.add(c)
    draw(c)
}
timer(8000) {
    val d = Picture.image("marte.png")
    c.setPosition(random(-(cb.width).toInt/2, (cb.width).toInt/2) , ((cb.height).toInt/2))
    c.setHeading(70)
    sfondo.add(d)
    draw(d)
}
timer(230) {
    val b = nuovaPalla
    b.setPosition(random(-(cb.width).toInt/2, (cb.width).toInt/2) , ((cb.height).toInt/2)-6)
    b.setHeading(224)
    ostacoli.add(b)
    draw(b)
}


timer(5000){
  vel = vel + Vector2D(0.2,0.2)
}

timer(2000){

  punteggio = punteggio + 1
  nPunti.update(punteggio)
}

def p(msg: String) {
  val pmsg = Picture {
    setPenFontSize(60)
    write(msg)
  }
}

def aggiornaVite(){
  nVite = nVite-1
  contVite(nVite).erase()

  print(nVite)
  if(nVite == 0){
   
    gameOver("HAI PERSO")
  }
 
}
 def gameOver(msg: String) {
      val pmsg = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(msg)
      }
      val punteggioFinale = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(punteggio.toString())
      }
      val score = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(" Punti")
      }

      val scoreTot = picRowCentered(punteggioFinale, score)
      val picGameOver = picColCentered(scoreTot,pmsg)      
      drawCentered(picGameOver)
      stopAnimation()

  }


activateCanvas()
animate {
    if (isKeyPressed(Kc.VK_RIGHT)) {
        giocatore.translate(speed, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        giocatore.translate(-speed, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        giocatore.translate(0, speed)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        giocatore.translate(0, -speed)
    }

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
        aggiornaVite()
      }
  }

    sfondo.foreach { c =>
      c.translate(vel1)
     
      if (c.collidesWith(stageBorder)) {
        sfondo.remove(c)
        c.erase()
      }
    }
        sfondo.foreach { c =>
      d.translate(vel1)
     
      if (c.collidesWith(stageBorder)) {
        sfondo.remove(d)
        d.erase()
      }
    }    
}