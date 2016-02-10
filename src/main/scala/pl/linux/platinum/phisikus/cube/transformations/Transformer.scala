package pl.linux.platinum.phisikus.cube.transformations

import pl.linux.platinum.phisikus.cube.Cube

/**
  * Created by phisikus on 10.02.16.
  */
trait Transformer {

  /** It turns rubik's cube column. (Look at a cube's south side).
    *
    * @param position  speficies which column should be moved (0 .. n-1)
    * @param clockWise clockwise rotation means movement from South side through Top to North side
    * @param cube      source object to transform
    * @return
    */
  def turnColumn(position: Integer, clockWise: Boolean, cube: Cube): Cube

  /** It turns rubik's cube row.
    *
    * @param position  speficies which column should be moved (0 .. n-1)
    * @param clockWise clockwise rotation means movement from West side through Top to East side
    * @param cube      source object to transform
    * @return
    */
  def turnRow(position: Integer, clockWise: Boolean, cube: Cube): Cube

  /** It turns rubik's cube side or one of those behind it.
    *
    * @param position
    * @param clockWise
    * @param cube
    * @return
    */
  def turnSide(position: Integer, clockWise: Boolean, cube: Cube) : Cube
}
