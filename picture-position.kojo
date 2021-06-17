cleari()
drawStage(black)

var pos = 60
var x = 3
var raggio = 10

val fig1 = Picture.circle(raggio*2)
fig1.setPenColor(red)
fig1.setFillColor(red)
fig1.setPosition(-pos,pos)


var vel1 = Vector2D(x*2,x/2)

val fig2 = Picture.circle(raggio * 2.5)
fig2.setPenColor(red)
fig2.setFillColor(red)
fig2.setPosition(pos,pos)

var vel2 = Vector2D(-x*2,x/2)

val fig3 = Picture.circle(raggio * 3)
fig3.setPenColor(red)
fig3.setFillColor(red)
fig3.setPosition(pos,-pos)


var vel3 = Vector2D(x*2,-x/2)

val giocatore = Picture.rectangle(50,50)
giocatore.setPenColor(blue)
giocatore.setFillColor(blue)
giocatore.setPosition(-pos,-pos)

var velG = Vector2D(-x/2,-x/2)

draw(fig1,fig2,fig3,giocatore)

animate {
  fig1.translate(vel1)

  if(fig1.collidesWith(stageBorder)){

      vel1 = bouncePicOffStage(fig1,vel1)
  }
  
  fig2.translate(vel2)
  
  if(fig2.collidesWith(stageBorder)){

      vel2 = bouncePicOffStage(fig2,vel2)
  }
  
  fig3.translate(vel3)  
    if(fig3.collidesWith(stageBorder)){

      vel3 = bouncePicOffStage(fig3,vel3)
  }
  
  giocatore.translate(velG)
  
  if(giocatore.collidesWith(stageBorder)){

      velG = bouncePicOffStage(giocatore,velG)
  }
  // verifica l'urto
  if (giocatore.collidesWith(fig1)){
    // aggiorno la velocità del giocatore dopo l'urto
    // con un'altra figura
    velG = bouncePicOffPic(giocatore, velG, fig1)

    // aggiorno la velocità dell'oggetto con cui
    // è urtato il giocatore
    vel1 = bouncePicOffPic(fig1, vel1, giocatore)
  }


  if (giocatore.collidesWith(fig2)){
    velG = bouncePicOffPic(giocatore, velG, fig2)
    vel2 = bouncePicOffPic(fig2, vel2, giocatore)
  }

  
  if (giocatore.collidesWith(fig3)){
    velG = bouncePicOffPic(giocatore, velG, fig3)
    vel3 = bouncePicOffPic(fig3, vel3, giocatore)
  }

  if (fig1.collidesWith(fig2)){
    vel1 = bouncePicOffPic(fig1, vel1, fig2)
    vel2 = bouncePicOffPic(fig2, vel2, fig1)
  }

   if (fig1.collidesWith(fig3)){
    vel1 = bouncePicOffPic(fig1, vel1, fig3)
    vel3 = bouncePicOffPic(fig3, vel3, fig1)
  }

     if (fig3.collidesWith(fig2)){
    vel3 = bouncePicOffPic(fig2, vel2, fig3)
    vel2 = bouncePicOffPic(fig3, vel3, fig2)
  }
}

