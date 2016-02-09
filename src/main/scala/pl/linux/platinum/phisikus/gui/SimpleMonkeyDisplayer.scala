package pl.linux.platinum.phisikus.gui

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.{ColorRGBA, Vector3f}
import com.jme3.scene.shape.Box
import com.jme3.scene.{Geometry, Node}
import com.jme3.system.AppSettings
import pl.linux.platinum.phisikus.cube.Cube
import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.cubies.CubieColor.CubieColor
import pl.linux.platinum.phisikus.cube.sides.CubeSide

/**
  * Created by phisikus on 07.02.16.
  */
class SimpleMonkeyDisplayer(val jMonkeyApplication: SimpleApplication) extends CubeDisplayer {

  def setupGraphicsEngine = {
    val settings = new AppSettings(true)
    settings.setResolution(800, 600)
    settings.setFrameRate(500)
    settings.setTitle("Rubik's Cube")
    jMonkeyApplication.setDisplayStatView(false)
    jMonkeyApplication.setShowSettings(false)
    jMonkeyApplication.setDisplayFps(false)
    jMonkeyApplication.setSettings(settings)
  }

  def getColorRGBA(color: CubieColor): ColorRGBA = {

    //    color match {
    //      case x if x == CubieColor.GREEN => ColorRGBA.Green
    //      case x if x == CubieColor.RED => ColorRGBA.Red
    //      case x if x == CubieColor.YELLOW => ColorRGBA.Yellow
    //      case x if x == CubieColor.BLUE => ColorRGBA.Blue
    //      case x if x == CubieColor.ORANGE => ColorRGBA.Orange
    //      case x if x == CubieColor.WHITE => ColorRGBA.White
    //      case _ => ColorRGBA.Pink
    //    }
    // TODO uncomment for real color
    ColorRGBA.randomColor()
  }

  def getCubieNode(name: String, x: Float, y: Float, z: Float, material: Material, colorRGBA: ColorRGBA): Node = {
    val box = new Box(1, 1, 0)
    val geometry = new Geometry(name + "_g", box)
    geometry.setLocalTranslation(new Vector3f(x * 2, y * 2, z))
    geometry.setMaterial(material.clone())
    material.setColor("Color", colorRGBA)
    val node = new Node(name)
    node.attachChild(geometry)
    node
  }


  def getCubeSideSceneNode(name: String, cubeMaterial: Material, side: CubeSide): Node = {
    val wall = new Node(name)
    val listOfCubies = side.elements.flatten

    def getCubieNodes(sideSize: Int, cubieListSize: Int, cubies: List[Cubie]): List[Node] = {
      cubies match {
        case head :: tail =>
          val position = cubieListSize - cubies.length
          val x = position / sideSize
          val y = position % sideSize
          getCubieNode(name + "_cubie_" + x.toString + ":" + y.toString, x.toFloat, y.toFloat, 0.0f, cubeMaterial, getColorRGBA(head.color)) :: getCubieNodes(sideSize, cubieListSize, tail)
        case _ => Nil
      }
    }

    val cubieNodes = getCubieNodes(side.size, listOfCubies.length, listOfCubies)
    cubieNodes.foreach(cubieNode => wall.attachChild(cubieNode))
    wall
  }


  override def displayCube(cube: Cube): Unit = {
    val assetManager = jMonkeyApplication.getAssetManager
    val rootNode = jMonkeyApplication.getRootNode
    val cubeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
    val northSide = getCubeSideSceneNode("northSide", cubeMaterial, cube.north)
    rootNode.attachChild(northSide)
  }

  setupGraphicsEngine


}
