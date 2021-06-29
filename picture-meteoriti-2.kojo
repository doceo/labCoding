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


// usa una immagine esterna contenuta nella stessa cartella dello script
val giocatore = Picture.image("freccia.png")

// scala l'immagine e la posiziona
giocatore.scale(0.5)   
giocatore.setPosition( cb.x + cb.width/2, cb.y + cb.height/2)
giocatore.draw()

// vettore che contiene i cuori che rappresentano le vite 
val viteCuori = ArrayBuffer.empty[Picture]

// serve a posizionare i cuori a distanza fissa l'uno dall'altro
var cPos = 0

// popola il vettore di sei vite
repeat(6){

    val c = cuore
    
    c.setPosition(cb.x + cb.width - 50 - cPos*30, cb.y + cb.height-30)
    cPos += 1
    
    c.draw()
    viteCuori.append(c)
}

// definisce le palline
def nuovaPalla = {
    fillColor(red) -> Picture.circle(random(9))
}

// vettore che contiene tutte le palle generate
val ostacoli = HashSet.empty[Picture]

// generatore casuale di palline
timer(200) {
    val b = nuovaPalla
    b.setPosition(cb.x+10 , cb.y + random((cb.height).toInt))
    ostacoli.add(b)
    draw(b)
}

var vel = Vector2D(1, 0)
var velG = 2 
var vite = 6
var punti = 0

// velocità del cuore che vola e relativo vettore e funzioni
var velVita = Vector2D(6,6)

val volaV = HashSet.empty[Picture]
  
def volaVita(){
  var c = cuore
  c.scale(3)
  c.setPosition(giocatore.position)
  c.draw()
  volaV.add(c)
  }

// funzione che sottrae la vita ed il cuore
def perdeVita() {
      vite = vite - 1
      
      viteCuori(vite).erase()
      if (vite == 0){
        var fine = punti + " punti"
        gameOver(fine)
      }
}

// immagine che gestisce il punteggio
val nPunti = Picture.textu(punti,30)
    nPunti.translate(cb.x + cb.width - 50, cb.y + cb.height-50)
    nPunti.setPenColor(yellow)
    draw(nPunti)

timer(1000){
      punti = punti + 1
      nPunti.update(punti)  
}

// incremento della velocità ogni 3 secondi
timer(3000){
  vel = vel + Vector2D(0.2,0)
}

// aumenta la grandezza del giocatore ogni 10 secondi
timer(10000){
  giocatore.scale(1.2)
}

// restituisce i punti finali

 def gameOver(msg: String) {
      val pmsg = Picture {
          setPenFontSize(80)
          setPenColor(white)
          write(msg)
      }
      
      drawCentered(pmsg)
      stopAnimation()

  }

// gestione dell'animazione di tutte le immagini
animate {

    volaV.foreach { c =>
      c.translate(velVita)
    }


    volaV.foreach { c =>
        if (c.collidesWith(stageBorder)) {
            volaV.remove(c)
            c.erase()            
        }

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
          perdeVita()
          volaVita()
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