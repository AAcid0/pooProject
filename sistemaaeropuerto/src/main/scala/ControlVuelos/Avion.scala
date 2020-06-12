package ControlVuelos
import Sillas._
import Personas.Tripulante
import Aerolinea.Aerolinea

class Avion
{
    var _tipo : Int = _ //1 -> Nacional  / 2 -> internacional
    var _capacidadMax : Int = _  //nacional = 50 / Internacional = 100
    var _nombreAvion : String = _
    var _aerolinea : Aerolinea = new Aerolinea
    var _listaSillas : List[Silla] = List()
    var _listaVuelos : List[Vuelo] = List()
    var _listaTripulacion : List[Tripulante] = List()

    def tipo = _tipo
    def capacidadMax = _capacidadMax
    def nombreAvion = _nombreAvion
    def aerolinea = _aerolinea
    def listaSillas = _listaSillas
    def listaVuelos = _listaVuelos
    def listaTripulacion = _listaTripulacion
    

    def capacidadMax_= (nuevaCapacidad : Int) = _capacidadMax = nuevaCapacidad
    def nombreAvion_= (nuevoNombre : String) = _nombreAvion = nuevoNombre
    def aerolinea_= (nuevaAerolinea : Aerolinea) = _aerolinea = nuevaAerolinea 

    def this(tip : Int, nom : String, aerol : Aerolinea, capacidad : Int)
    {
        this()
        var n : Int = 1
        while(n <= (3 * tip)) 
        {
            _listaSillas = new SillaPrimeraClase(n) :: _listaSillas
            n += 1
        }
        while(n <= (5 * tip))
        {
            _listaSillas = new SillaEconomica(n) :: _listaSillas
            n += 1
        }
        _nombreAvion = nom
        _aerolinea = aerol
        _capacidadMax = capacidad
    }

    def buscarSilla(codigo : String) : Option[Silla] =
    {
        var sillaTemp : Option[Silla] = None
        if(listaSillas.nonEmpty)
        {
            sillaTemp = listaSillas.filter(silla => silla.codigoSilla == codigo).headOption
        }
        return sillaTemp
    }

    def cambiarCapacidad(nuevaCap : Int) : Unit =
    {
        capacidadMax = nuevaCap
    }

    def agregarVuelo(nuevoVuelo : Vuelo) : Unit =
    {
        _listaVuelos = nuevoVuelo :: _listaVuelos
    }

    def actualizarVuelos(newListVue : List[Vuelo]) : Unit =
    {
        this._listaVuelos = newListVue
    }
}