package Aeropuerto
import Aerolinea._
import ControlVuelos._
import scala.util._

class Aeropuerto
{
    var _listaAerolineas : List[Aerolinea] = List()
    var _listaVuelos : List[Vuelo] = List()

    def listaAerolineas = _listaAerolineas
    def listaVuelos = _listaVuelos

    def crearAerolinea(nomAerolinea : String) : Try[Unit] =
    {
        Try
        {
            var nuevaAerolinea = new Aerolinea(nomAerolinea)
            if(nomAerolinea != "")
            {
                _listaAerolineas = nuevaAerolinea :: _listaAerolineas
            }
            else
            {
                throw new Exception("Ingrese un nombre válido para la aerolínea.")
            }
        }
    }
    def comprobarAerolineas() : Try[Unit] =
    {
        Try
        {
            if(listaAerolineas.isEmpty)
            {
                throw new Exception("No hay aerolíneas para mostrar, empiece creando una.")
            }
        }
    } 
    def mostrarAerolineas() : List[Aerolinea] =
    {
        return listaAerolineas
        /*var cont : Int = 1
        if(listaAerolineas.Empty == true)
        {
            listaAerolineas.foreach(i => {
                println("Nombre Aerolinea #" + cont + ": " + i.nombreAerolinea)
            })
        }*/
    }
}