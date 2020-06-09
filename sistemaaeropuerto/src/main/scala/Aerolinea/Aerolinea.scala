package Aerolinea
import scala.util._
import ControlVuelos._
import Personas._
import Servicios._
import Sillas._

class Aerolinea
{
    var _nombreAerolinea : String = _
    var _listaVuelos : List[Vuelo] = List()
    var _listaSocios : List[Pasajero] = List()
    var _listaReservas : List[Reserva] = List()
    var _listaAviones : List[Avion] = List()

    def nombreAerolinea = _nombreAerolinea
    def listaVuelos = _listaVuelos
    def listaSocios = _listaSocios
    def listaAviones = _listaAviones
    
    def this(nombre : String)
    {
        this()
        _nombreAerolinea = nombre
    }

    def mostrarVuelos() : Unit =
    {
        println("Dia salida -- Hora salida -- Ciudad Origen -- Ciudad destino")
        for(i <- listaVuelos)
        {
            println(i.diaSalida + " " + i.horaSalida + " " + i.ciudadOrigen + " " + i.ciudadDestino)
        }
    }

    def mostrarVuelo(diaSal : String, ciudadOri : String, ciudadDe : String) : Boolean = 
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

    def buscarVuelo(cod : String) : Option[Vuelo] =
    {
        var vue : Option[Vuelo] = None
        if(listaVuelos.nonEmpty)
        {
            vue = listaVuelos.filter(i => i.codigoVuelo == cod).headOption
        }
        else
        {
            println("No se encontraron vuelos con el código ingresado, por favor verifique.")
        }
        return vue
    }
    def crearVuelo(ciuOr : String, ciuDe : String, diaSal : String, horSa : String, tipVuelo : Int, aerol : String) : Try[Unit] =
    {
        Try
        {
            var nuevoVuelo = new Vuelo(ciuOr, ciuDe, diaSal, horSa, tipVuelo, aerol)
            if(!(ciuOr == "" || ciuDe == "" || diaSal == "" || horSa == "" || tipVuelo == "" || aerol == ""))
            {
                _listaVuelos = nuevoVuelo :: _listaVuelos
                println("Código de vuelo: " + nuevoVuelo.codigoVuelo)
            }
            else
            {
                throw new Exception("Ingrese la información completa para crear el vuelo.")
            }
        }
    }
    def crearAvion(tipoVuelos : Int, nombre : String, aerol : String) : Try[Unit] = //1 -> Nacional  / 2 -> internacional
    {
        Try
        {
            var nuevoAvion = new Avion(tipoVuelos, nombre, aerol)
            if(nombre != "")
            {
                _listaAviones = nuevoAvion :: _listaAviones 
            }
            else
            {
                throw new Exception("Ingrese un nombre válido para el avión.")
            }
        }
    }
    def comprobarAviones() : Try[Unit] =
    {
        Try
        {
            if(listaAviones.isEmpty)
            {
                throw new Exception("No hay aviones para mostrar, empiece creando uno.")
            }
        }
    }
    def mostrarAviones() : List[Avion] = {
        return listaAviones
    }






}