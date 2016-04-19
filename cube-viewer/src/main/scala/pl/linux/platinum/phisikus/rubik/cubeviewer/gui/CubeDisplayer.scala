package pl.linux.platinum.phisikus.rubik.cubeviewer.gui

import com.jme3.scene.Node

import pl.linux.platinum.phisikus.rubik.cube.Cube


trait CubeDisplayer {
  def getCubeNode(cube: Cube): Node

  def displayCube(cube: Cube): Node
}
