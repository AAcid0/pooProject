package Servicios
import scala.util.Random

object GeneradorCodigo
{
    def crearCodigo() : String =
    {
        var cod : String = Random.alphanumeric.take(4).mkString("")
        return cod
    }
}
