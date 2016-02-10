package pl.linux.platinum.phisikus

import _root_.pl.linux.platinum.phisikus.cube.{Cube, RubiksCube}
import com.jme3.app.SimpleApplication
import com.jme3.scene.Node
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}
import pl.linux.platinum.phisikus.cube.sides.RubiksCubeSide
import pl.linux.platinum.phisikus.cube.transformations.RubiksCubeTransformer
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
    //cam.setLocation(new Vector3f(90, 90, 10))
    //cam.lookAt(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0))
    flyCam.setMoveSpeed(50f)

    val transformer = new RubiksCubeTransformer()
    var x: Cube = new RubiksCube()
    x = transformer.turnColumn(2, true, x)
    x = transformer.turnColumn(0, true, x)
    x = transformer.turnColumn(0, true, x)
    x = transformer.turnColumn(0, false, x)
    x = transformer.turnColumn(0, false, x)
    //x = transformer.turnColumn(0, false, x)
    /*x = transformer.turnColumn(0, true, x)
    x = transformer.turnColumn(0, true, x)*/
    cubeNode = cubeDisplayer.displayCube(x)
  }

  @Override
  def simpleInitApp(): Unit = {
    this.entryPoint
  }

  override def simpleUpdate(tpf: Float): Unit = {
    // cubeNode.rotate(0.01f, 0.01f, 0.02f)
  }
}
