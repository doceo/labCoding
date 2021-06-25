cleari()
drawStage(black)

val vels = HashMap.empty[Picture, Vector2D]

timer(1000) {
  val pic = fillColor(red) -> Picture.rectangle(40, 40)
  vels(pic) = Vector2D(random(1, 5), 2)
  draw(pic)
}

animate {
    vels.foreach { pic_vel =>
      val pic = pic_vel._1
      val vel = pic_vel._2
      pic.translate(vel)
      if (pic.collidesWith(stageBorder)) {
        val newPicVel = bouncePicVectorOffStage(pic, vel)
        vels(pic) = newPicVel
      }
    }
}