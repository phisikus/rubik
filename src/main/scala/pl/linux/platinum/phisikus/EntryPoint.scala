package pl.linux.platinum.phisikus

import com.jme3.app.SimpleApplication
import pl.linux.platinum.phisikus.cube.RubiksCube
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}
import pl.linux.platinum.phisikus.cube.sides.RubiksCubeSide
import pl.linux.platinum.phisikus.gui.SimpleMonkeyDisplayer


object EntryPoint extends SimpleApplication {
  val cubeDisplayer = new SimpleMonkeyDisplayer(this)

  def main(args: Array[String]) {
    this.start()
  }

  def entryPoint = {
    val cube = new RubiksCube(new RubiksCubeSide(List(
      List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(List(
      List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(List(
      List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(List(
      List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(List(
      List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(List(
      List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    ))
    )
    cubeDisplayer.displayCube(cube)
  }

  @Override
  def simpleInitApp(): Unit = {
    this.entryPoint
  }
}
