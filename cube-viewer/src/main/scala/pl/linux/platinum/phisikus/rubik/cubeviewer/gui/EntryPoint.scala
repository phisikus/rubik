package pl.linux.platinum.phisikus.rubik.cubeviewer.gui

import com.jme3.app.SimpleApplication
import com.jme3.math.Vector3f
import com.jme3.scene.Node
import pl.linux.platinum.phisikus.rubik.cube.{Cube, RubiksCube}
import pl.linux.platinum.phisikus.rubik.cube.transformations.RubiksCubeTransformer


object EntryPoint extends SimpleApplication {
  val cubeDisplayer = new MonkeyCubeDisplayer(this)
  var cubeNode: Node = _

  def main(args: Array[String]) {
    this.start()
  }

  override def simpleInitApp(): Unit = {
    this.entryPoint
  }

  def entryPoint: Unit = {
    setCamera()
    val cube = getExampleCubeWithSomeTransformations
    cubeNode = cubeDisplayer.displayCube(cube)
  }

  def setCamera() = {
    cam.setLocation(new Vector3f(30, 30, 10))
    cam.lookAt(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0))
    flyCam.setMoveSpeed(50f)
  }

  def getExampleCubeWithSomeTransformations : Cube = {
    var cube : Cube = new RubiksCube(5)
    val transformer = new RubiksCubeTransformer()
    cube = transformer.getRandomCube(cube, 5)
    cube = transformer.turnColumn(0, true, cube)
    cube = transformer.turnRow(1, false, cube)
    cube = transformer.turnSide(2, true, cube)
    cube
  }
  // This function is called repeatedly
  override def simpleUpdate(tpf: Float): Unit = {
    cubeNode.rotate(0.01f, 0.01f, 0.02f)
  }

}
