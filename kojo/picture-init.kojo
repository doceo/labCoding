// pulisce l'ambiente di lavoro
cleari()

// costruiamo le immagini. Ogni immagini viene salvata in una variabile
val pic1 = Picture {
    setPenColor(red)
    setPenThickness(6)
    setFillColor(yellow)
    repeat(6) {
        forward(150)
        right(60)
    }
} 
// seconda immagine
val pic2 = Picture {
    setPenColor(yellow)
    setPenThickness(6)
    setFillColor(red)
    repeat(4) {
        forward(160)
        right(90)
    }
} 

// crea una immagine con una scritta
val scritta = Picture {
    setPenFontSize(25)
    setPenColor(cm.darkRed)
    write("Kojo Picture!")
}

// crea una immagine con solo una cornice
val cerchio = Picture {
    setPenColor(orange)
    setPenThickness(4)
    right(360, 50)
}


// crea una immagine trasparente per lasciare uno spazio tra le immagini
val gap = Picture {
    setPenColor(noColor)
    repeat(4) {
        forward(100)
        right(90)
    }
}

// sovrappone le immagini, nell'ordine in cui vengono passate come input
val sovrapponi = picStackCentered(pic1, pic2, cerchio)

// allinea le immagini passate in input rispetto al centro
val allinea = picColCentered(scritta, sovrapponi, gap)

// disegna la colonna creata al centro della scena
drawCentered(allinea)
