package Aerolinea

import ControlVuelos._
import Personas._
import Servicios._
import Sillas._

class Aerolinea
{
    var _listaVuelos : List[Vuelo] = _
    var _listaSocios : List[Pasajero] = _
    var _listaReservas : List[Reserva] = _

    def listaVuelos = _listaVuelos
    def listaSocios = _listaSocios

    def mostrarVuelos() : Unit =
    {
        println("Dia salida -- Hora salida -- Ciudad Origen -- Ciudad destino")
        for(i <- listaVuelos)
        {
            println(i.diaSalida + " " + i.horaSalida + " " + i.ciudadOrigen + " " + i.ciudadDestino)
        }
    }

    def mostrarVuelos(diaSal : String, ciudadOri : String, ciudadDe : String) : Boolean = 
    {
        var encontrado : Boolean = false
        for(i <- _listaVuelos)
        {
            if(i.diaSalida == diaSal)
            {
                if(i.ciudadOrigen == ciudadOri)
                {
                    if(i.ciudadDestino == ciudadDe)
                    {
                        println(i.diaSalida + " " + i.horaSalida + " " + i.ciudadOrigen + " " + i.ciudadDestino + " " + i.codigoVuelo)
                        encontrado = true
                    }
                }
            }
        }
        return encontrado
    }

    def buscarVuelo(cod : String) : Vuelo =
    {
        for(i <- _listaVuelos)
        {
            if(cod == i.codigoVuelo)
            {
                return i
            }
        }
        return new Vuelo(0)
    }






}