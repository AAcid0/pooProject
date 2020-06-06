package ControlVuelos
import Sillas.Silla
import Personas.Tripulante

class Avion
{
    var _capacidadMax : Int = _    
    var _listaSillas : List[Silla] = _
    var _listaVuelos : String = _
    var _listaTripulacion : List[Tripulante] = _

    def capacidadMax = _capacidadMax
    def listaSillas = _listaSillas
    def listaVuelos = _listaVuelos
    def listaTripulacion = _listaTripulacion

    def capacidadMax_= (nuevaCapacidad : Int) = _capacidadMax = nuevaCapacidad
}