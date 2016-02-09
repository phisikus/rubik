package pl.linux.platinum.phisikus.gui

import com.jme3.scene.Node
import pl.linux.platinum.phisikus.cube.Cube

/**
  * Created by phisikus on 07.02.16.
  */
trait CubeDisplayer {
  def getCubeNode(cube: Cube) : Node
  def displayCube(cube: Cube) : Node
}
