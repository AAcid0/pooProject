package ControlVuelos
import Sillas._
import Personas.Tripulante
import Aerolinea.Aerolinea

class Avion
{
    var _tipo : Int =_ //1 -> Nacional  / 2 -> internacional
    var _capacidadMax : Int = _  //nacional = 50 / Internacional = 100
    var _nombreAvion : String = _
    var _aerolinea : String = _
    var _listaSillas : List[Silla] = List()
    var _listaVuelos : String = _
    var _listaTripulacion : List[Tripulante] = List()

    def capacidadMax = _capacidadMax
    def nombreAvion = _nombreAvion
    def aerolinea = _aerolinea
    def listaSillas = _listaSillas
    def listaVuelos = _listaVuelos
    def listaTripulacion = _listaTripulacion
    

    def capacidadMax_= (nuevaCapacidad : Int) = _capacidadMax = nuevaCapacidad
    def nombreAvion_= (nuevoNombre : String) = _nombreAvion = nuevoNombre
    def aerolinea_= (nuevaAerolinea : String) = _aerolinea = nuevaAerolinea 

    def this(tip : Int, nom : String, aerol : String)
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
        _nombreAvion = nom
        _aerolinea = aerol
    }
}