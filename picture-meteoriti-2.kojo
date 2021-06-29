cleari()
drawStage(black)
val cb = canvasBounds

// il cuore è realizzato da Marzia de Magistris
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


//var corpo = fillColor(yellow) -> Picture.rectangle(20,30)

var corpo = Picture.rectangle(30,40)
    corpo.setPenColor(yellow)
    corpo.setFillColor(yellow)

var testa = Picture{
    left(60)
    forward(30)
    left(60)
    forward(30)
    left(150)
    forward(50)    
  
}

testa.setFillColor(red)
val giocatore = picColCentered(corpo,testa)
    giocatore.rotate(90)
    giocatore.setPosition( cb.x + cb.width/2, cb.y + cb.height/2)

draw(giocatore)

val viteCuori = ArrayBuffer.empty[Picture]

var cPos = 0

repeat(6){

    val c = cuore
    
    c.setPosition(cb.x + cb.width - 50 - cPos*30, cb.y + cb.height-30)
    cPos += 1
    
    c.draw()
    viteCuori.append(c)
}


def nuovaPalla = {
    fillColor(red) -> Picture.circle(random(9))
}


val ostacoli = HashSet.empty[Picture]

timer(200) {
    val b = nuovaPalla
    b.setPosition(cb.x+5 , cb.y + random((cb.height).toInt))
    ostacoli.add(b)
    draw(b)
}

var vel = Vector2D(1, 0)
var velG = 2 
var vite = 6
var punti = 0

def perdeVita() {
      vite = vite - 1
      
      viteCuori(vite).erase()
      if (vite == 0){
        var fine = punti + " punti"
        gameOver(fine)
      }
}

val nPunti = Picture.textu(punti,30)
    nPunti.translate(cb.x + cb.width - 50, cb.y + cb.height-50)
    nPunti.setPenColor(yellow)
    draw(nPunti)

timer(1000){
      punti = punti + 1
      nPunti.update(punti)  
}


timer(3000){
  vel = vel + Vector2D(0.2,0)
}

 def gameOver(msg: String) {
      val pmsg = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(msg)
      }
      
      drawCentered(pmsg)
      stopAnimation()

  }


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
        giocatore.translate(0, -velG)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        giocatore.translate(0, velG)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        giocatore.translate(velG, 0)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        giocatore.translate(-velG, 0)
    }
}