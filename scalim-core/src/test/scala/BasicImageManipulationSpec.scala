import java.awt.{Color, Component, Graphics}
import java.awt.event.{WindowAdapter, WindowEvent}
import java.awt.image.BufferedImage
import java.io.{File, IOException}
import javax.imageio.ImageIO
import javax.swing.{ImageIcon, JFrame, JLabel, JPanel}

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

    val dataBuffInt: Array[Int] = img.getRGB(0, 0, w, h, null, 0, w)

    //    dataBuffInt.foreach { i =>
    //      val c = new Color(i)
    //      println(s"r ${c.getRed} g ${c.getGreen} b ${c.getBlue} a ${c.getAlpha}")
    //    }

    println(s"${dataBuffInt.length} w $w h $h")

    dataBuffInt.indices foreach { ind =>
      val c = new Color(dataBuffInt(ind))
      val newC = new Color(
        (c.getRed * 2) % 255,
        (c.getGreen * 2) % 255,
        (c.getBlue * 2) % 255
      )
      dataBuffInt.update(ind, newC.getRGB)
    }

    img.setRGB(0, 0, w, h, dataBuffInt, 0, 1)

//    val jPanel = new JPanel{
//      override def paintComponent(g: Graphics) {
//        super.paintComponent(g)
//        g.drawImage(img, 0, 0, this) // see javadoc for more info on the parameters
//      }
//    }

    val picLabel = new JLabel(new ImageIcon(img))

//    val jPanel = new JPanel()
//    jPanel.setBounds(100, 100, w, h)
//    jPanel.setVisible(true)
//    jPanel.add(picLabel)
//    picLabel.setVisible(true)

//    jPanel.

    val snakeFrame = new JFrame()
    snakeFrame.setBounds(100, 200, w, h)
    snakeFrame.setVisible(true)
    snakeFrame.add(picLabel)
    snakeFrame.pack()

    Thread.sleep(10000)

    // red = (dataBuffInt[100] >> 16) & 0xFF
    //    println(c.getGreen) // = (dataBuffInt[100] >> 8)  & 0xFF
    //    println(c.getBlue) // = (dataBuffInt[100] >> 0)  & 0xFF
    //    println(c.getAlpha) // = (dataBuffInt[100] >> 24) & 0xFF

      // WRITE TO FILE
//    val outputfile = new File("/Users/johnmcgill/Documents/ruined_image.jpg")
//    ImageIO.write(img, "jpg", outputfile)

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
