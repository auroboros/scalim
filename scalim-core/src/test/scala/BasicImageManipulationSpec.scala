import java.awt.{Color, Component}
import java.awt.event.{WindowAdapter, WindowEvent}
import java.awt.image.BufferedImage
import java.io.{File, IOException}
import javax.imageio.ImageIO
import javax.swing.JFrame

import org.scalatest.{FlatSpec, Matchers}

import scalaz.std.int

/**
  * Created by johnmcgill on 12/13/16.
  */
class BasicImageManipulationSpec extends FlatSpec with Matchers {

  "b" should "c" in {
    val img: BufferedImage = ImageIO.read(new File("/Users/johnmcgill/Documents/leif-1-600x600.jpg"))

    val w = img.getWidth()
    val h = img.getHeight()

    val dataBuffInt = img.getRGB(0, 0, w, h, null, 0, w)

    val c = new Color(dataBuffInt(100))

    println(c.getRed)   // = (dataBuffInt[100] >> 16) & 0xFF
    println(c.getGreen) // = (dataBuffInt[100] >> 8)  & 0xFF
    println(c.getBlue)  // = (dataBuffInt[100] >> 0)  & 0xFF
    println(c.getAlpha) // = (dataBuffInt[100] >> 24) & 0xFF

    val outputfile = new File("/Users/johnmcgill/Documents/copied_image.jpg")
    ImageIO.write(img, "jpg", outputfile)

//    val f = new JFrame("Jumbled Image")
//    f.addWindowListener(new WindowAdapter() {
//      override def windowClosing(e: WindowEvent) {
//        System.exit(0)
//      }
//    })
//
//    val graphics = img.createGraphics()
//
//    Component.
//    f.add("Center", graphics)
  }
}
