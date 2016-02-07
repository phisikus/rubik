package pl.linux.platinum.phisikus

import com.jme3.app.SimpleApplication
import pl.linux.platinum.phisikus.gui.SimpleMonkeyDisplayer


object EntryPoint extends SimpleApplication {
  val cubeDisplayer = new SimpleMonkeyDisplayer(this)

  def main(args: Array[String]) {
    this.start()
  }

  def entryPoint = {
    cubeDisplayer.displayCube()
  }

  @Override
  def simpleInitApp(): Unit = {
    this.entryPoint
  }
}
