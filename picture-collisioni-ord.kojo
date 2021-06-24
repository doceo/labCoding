cleari()
drawStage(black)
val pic1 = fillColor(red) -> Picture.rectangle(40, 40)
val pic2 = fillColor(red) -> Picture.circle(20)
draw(pic1, pic2)

val vels = HashMap(
    pic1 -> Vector2D(3, 2),
    pic2 -> Vector2D(-2, 3)
)

val pics = Seq(pic1, pic2)

animate {
    pics.foreach { pic =>
        val picVel = vels(pic)
        pic.translate(picVel)
        if (pic.collidesWith(stageBorder)) {
            val newPicVel = bouncePicVectorOffStage(pic, picVel)
            vels(pic) = newPicVel
        }
    }
}