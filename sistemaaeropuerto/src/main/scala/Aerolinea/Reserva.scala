package Aerolinea

import Aerolinea.Aerolinea
import ControlVuelos._
import Personas._
import Servicios._
import Sillas._

class Reserva
{
    var _vueloAsignado : Vuelo =_
    var _titular : Pasajero =_
    var _listAcompañantes : List[Pasajero] =_
    var _listSillas : List[Silla] =_

    def titular = _titular
    def vueloAsignado = _vueloAsignado
    def listAcompañantes = _listAcompañantes
    def listSillas = _listSillas

    def asignarVuelo(vuel : Vuelo) : Unit =
    {
        this._vueloAsignado = vuel
    }

    def agregarAcompañante(acom : Pasajero) : Unit =
    {
        _listAcompañantes = acom :: _listAcompañantes
    }

    def escogerSilla(num : Int, pas : Pasajero) : Boolean =
    {
        for(i <- _vueloAsignado.avionAsignado.listaSillas)
        {
            if(i.numSilla == num)
            {
                i.asignarPasajero(pas)
                this._listSillas = i :: _listSillas
                return true
            }
        }
        return false
    }

}