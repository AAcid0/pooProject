package ControlVuelos
import Sillas._
import Personas.Tripulante

class Avion
{
    var _tipo : Int =_ //1 -> Nacional  / 2 -> internacional
    var _capacidadMax : Int = _  //nacional = 50 / Internacional = 100
    var _listaSillas : List[Silla] = _
    var _listaVuelos : String = _
    var _listaTripulacion : List[Tripulante] = _

    def capacidadMax = _capacidadMax
    def listaSillas = _listaSillas
    def listaVuelos = _listaVuelos
    def listaTripulacion = _listaTripulacion

    def capacidadMax_= (nuevaCapacidad : Int) = _capacidadMax = nuevaCapacidad

    def this(tip : Int)
    {
        this()
        var n : Int = 0
        while(n < (12 * tip)) 
        {
            _listaSillas = new SillaPrimeraClase(n) :: _listaSillas
            n += 1
        }
        while(n < (38 * tip))
        {
            _listaSillas = new SillaEconomica(n) :: _listaSillas
            n += 1
        }
    }
}