package pl.linux.platinum.phisikus.gui

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

/**
  * Created by phisikus on 07.02.16.
  */
class SimpleMonkeyDisplayer(val jMonkeyApplication: SimpleApplication) extends CubeDisplayer {

  override def displayCube(): Unit = {
    val assetManager = jMonkeyApplication.getAssetManager
    val rootNode = jMonkeyApplication.getRootNode
    val box = new Box(1, 1, 1)
    val boxGeometry = new Geometry("Box", box)
    val cubeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
    cubeMaterial.setColor("Color", ColorRGBA.Blue)
    boxGeometry.setMaterial(cubeMaterial)
    rootNode.attachChild(boxGeometry)
  }


}
