package pl.linux.platinum.phisikus

import com.jme3.app.SimpleApplication
import com.jme3.math.Vector3f
import com.jme3.scene.Node
import pl.linux.platinum.phisikus.cube.RubiksCube
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}
import pl.linux.platinum.phisikus.cube.sides.RubiksCubeSide
import pl.linux.platinum.phisikus.gui.SimpleMonkeyDisplayer


object EntryPoint extends SimpleApplication {
  val cubeDisplayer = new SimpleMonkeyDisplayer(this)
  var cubeNode: Node = _

  def main(args: Array[String]) {
    this.start()
  }

  def entryPoint: Unit = {
    val cube = new RubiksCube(new RubiksCubeSide(Vector(
      Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(Vector(
      Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(Vector(
      Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(Vector(
      Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(Vector(
      Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    )), new RubiksCubeSide(Vector(
      Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.GREEN)),
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW))
    ))
    )
    //  cubeNode = cubeDisplayer.displayCube(cube)
    cam.setLocation(new Vector3f(90, 90, 10))
    cam.lookAt(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0))
    flyCam.setMoveSpeed(50f)
    cubeNode = cubeDisplayer.displayCube(new RubiksCube(30))
  }

  @Override
  def simpleInitApp(): Unit = {
    this.entryPoint
  }

  override def simpleUpdate(tpf: Float): Unit = {
      cubeNode.rotate(0.01f, 0.01f, 0.02f)
  }
}
