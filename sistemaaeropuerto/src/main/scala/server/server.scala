package server
import scala.io._
import scala.util._
import Aerolinea._
import Aeropuerto._
import ControlVuelos._
import Personas._
import Servicios._
import Sillas._

import akka.http.scaladsl.Http
import akka.http.scaladsl.server._
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Server extends App with Directives{

    implicit val system = ActorSystem("actor-system")
    implicit val materializer : ActorMaterializer = ActorMaterializer()

    var aero = new Aeropuerto

    val routes : Route =
        concat(
            path("cliente"/"vuelo"){
                get{
                    var vuelo = new Vuelo("cali", "cartagena","22-06-2020","1:30",1, "hola")
                
                    complete(vuelo.ciudadOrigen + " " + vuelo.ciudadDestino + " " + vuelo.diaSalida + " " + vuelo.horaSalida + " " + vuelo.tipoVuelo)     
                }
            },

            path("operario"/"aerolinea"/Segment){ (data) =>
                post{
                    aero.crearAerolinea(data)
                    complete("se creo la aerolinea " + aero.listaAerolineas.head.nombreAerolinea)
                }
            
            },

            path("operario"/"aerolinea"/"agregarAvion"/Segment){ (data) =>
                post{
                    var av = new Avion(5, "boing 7", new Aerolinea(data), 50)
                    
                    complete("se creo el avion " + av.nombreAvion + "\naerolinea: " + av.aerolinea.nombreAerolinea + "\ncapacidad: " + av.capacidadMax)
                }
            }

        

        )
    
    Http().bindAndHandle(routes, "0.0.0.0", 8004)

}