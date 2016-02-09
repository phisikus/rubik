package pl.linux.platinum.phisikus.gui

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.{ColorRGBA, FastMath}
import com.jme3.scene.shape.Box
import com.jme3.scene.{Geometry, Node}
import com.jme3.system.AppSettings
import pl.linux.platinum.phisikus.cube.Cube
import pl.linux.platinum.phisikus.cube.cubies.CubieColor.CubieColor
import pl.linux.platinum.phisikus.cube.cubies.{Cubie, CubieColor}
import pl.linux.platinum.phisikus.cube.sides.CubeSide

/**
  * Created by phisikus on 07.02.16.
  */
class SimpleMonkeyDisplayer(val jMonkeyApplication: SimpleApplication) extends CubeDisplayer {

  def setupGraphicsEngine: Unit = {
    val settings = new AppSettings(true)
    settings.setResolution(1024, 768)
    settings.setFrameRate(50)
    settings.setTitle("Rubik's Cube")
    jMonkeyApplication.setDisplayStatView(false)
    jMonkeyApplication.setShowSettings(false)
    jMonkeyApplication.setDisplayFps(false)
    jMonkeyApplication.setSettings(settings)
  }

  def getColorRGBA(color: CubieColor): ColorRGBA = {

    color match {
      case x if x == CubieColor.GREEN => ColorRGBA.Green
      case x if x == CubieColor.RED => ColorRGBA.Red
      case x if x == CubieColor.YELLOW => ColorRGBA.Yellow
      case x if x == CubieColor.BLUE => ColorRGBA.Blue
      case x if x == CubieColor.ORANGE => ColorRGBA.Orange
      case x if x == CubieColor.WHITE => ColorRGBA.White
      case _ => ColorRGBA.Pink
    }

  }

  def getCubieNode(name: String, x: Float, y: Float, z: Float, material: Material, colorRGBA: ColorRGBA): Node = {
    val box = new Box(0.99f, 0.99f, 0)
    val geometry = new Geometry(name + "_g", box)
    val cubeMaterial = material.clone()
    cubeMaterial.setColor("Color", colorRGBA)
    geometry.setMaterial(cubeMaterial)
    val node = new Node(name)
    node.move(x.toFloat * 2, y.toFloat * 2, z)
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
          val y = (position / sideSize)
          val x = (position % sideSize)
          getCubieNode(name + "_cubie_" + x.toString + ":" + y.toString, x.toFloat, y.toFloat, 0.0f, cubeMaterial, getColorRGBA(head.color)) :: getCubieNodes(sideSize, cubieListSize, tail)
        case _ => Nil
      }
    }

    val cubieNodes = getCubieNodes(side.size, listOfCubies.length, listOfCubies.reverse)
    cubieNodes.foreach(cubieNode => wall.attachChild(cubieNode))
    wall
  }


  def getInsideBox(size: Float, material: Material): Node = {
    val box = new Box(size * 0.99f, size * 0.99f, size * 0.99f)
    val geometry = new Geometry("insideBox_g", box)
    val cubeMaterial = material.clone()
    cubeMaterial.setColor("Color", ColorRGBA.Black)
    geometry.setMaterial(cubeMaterial)
    val node = new Node("insideBox")
    node.move(size - 1f, size - 1f, size)
    node.attachChild(geometry)
    node
  }

  override def getCubeNode(cube: Cube): Node = {
    val assetManager = jMonkeyApplication.getAssetManager
    val parentNode = new Node("rubiksCube")
    val cubeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
    val northSide = getCubeSideSceneNode("northSide", cubeMaterial, cube.north)
    val southSide = getCubeSideSceneNode("southSide", cubeMaterial, cube.south)
    val eastSide = getCubeSideSceneNode("eastSide", cubeMaterial, cube.east)
    val westSide = getCubeSideSceneNode("westSide", cubeMaterial, cube.west)
    val topSide = getCubeSideSceneNode("topSide", cubeMaterial, cube.top)
    val bottomSide = getCubeSideSceneNode("bottomSide", cubeMaterial, cube.bottom)
    val insideBox = getInsideBox(cube.size.toFloat, cubeMaterial)

    // nod down and levitate
    topSide.rotate(FastMath.PI / 2, 0, 0.0f)
    topSide.move(0.0f, cube.size.toFloat * 2.0f - 1f, 1f)


    eastSide.rotate(FastMath.PI, -FastMath.PI / 2, FastMath.PI)
    eastSide.move(-1f, 0f, cube.size.toFloat * 2 - 1f)

    westSide.rotate(-FastMath.PI, FastMath.PI / 2, -FastMath.PI)
    westSide.move(cube.size.toFloat * 2 - 1f, 0f, 1f)

    // move down fall back
    bottomSide.rotate(-FastMath.PI / 2, 0, 0.0f)
    bottomSide.move(0.0f, -1f, cube.size.toFloat * 2.0f - 1f)

    // move left twice turn right double
    northSide.rotate(0.0f, FastMath.PI, 0.0f)
    northSide.move(cube.size.toFloat * 2 - 2f, 0f, cube.size.toFloat * 2f)

    parentNode.attachChild(northSide)
    parentNode.attachChild(southSide)
    parentNode.attachChild(eastSide)
    parentNode.attachChild(westSide)
    parentNode.attachChild(topSide)
    parentNode.attachChild(bottomSide)
    parentNode.attachChild(insideBox)
    parentNode
  }

  override def displayCube(cube: Cube): Node = {
    val rootNode = jMonkeyApplication.getRootNode
    val cubeNode = getCubeNode(cube)
    rootNode.attachChild(cubeNode)
    cubeNode
  }

  setupGraphicsEngine


}
