cleari()
val pic = fillColor(red) -> Picture.rectangle(400, 400)
val filter1 = new com.jhlabs.image.WeaveFilter
filter1.setXGap(10)
filter1.setXWidth(50)
val filter2 = new com.jhlabs.image.NoiseFilter
filter2.setAmount(100)
filter2.setDensity(1)
val pic2 = effect(filter1) * effect(filter2) -> pic
drawCentered(pic2)
