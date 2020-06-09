package Aeropuerto
import scala.io._
import scala.util._

object Interfaz extends App
{
    var aeropuerto : Aeropuerto = new Aeropuerto
    var cerrarSistema : Boolean = false

    while(!cerrarSistema)
    {
        println("Bienvenido al Aeropuerto Central")
        println("================================")
        println("Ingresa la opción que se adapte a tu perfil:")
        println("1-> Soy Cliente.")
        println("2-> Soy Operario.")
        println("3-> Salir.")
        println("Su elección: ")
        var perfil : Int = StdIn.readInt()
        perfil match
        {
            case 2 => {
                var sesionOperario : Boolean = true
                while(sesionOperario)
                {
                    println("\nPanel de Control : Aeropuerto Central")
                    println("=====================================")
                    println("Sus opciones son:")
                    println("1-> Asignar nuevo avión a aerolínea.")
                    println("2-> Crear una nueva aerolínea.")
                    println("3-> Crear un nuevo vuelo disponible.")
                    println("4-> ver aviones de aerolinea especifica.")
                    println("Su elección: ")
                    var opc : Int = StdIn.readInt()
                    opc match
                    {
                        case 1 => {
                            var comprobarAero = aeropuerto.comprobarAerolineas()
                            comprobarAero match
                            {
                                case Success(s) => {
                                    println("\nAerolínea a la cual se asignará avión:")
                                    var aer : String = StdIn.readLine()
                                    aeropuerto.listaAerolineas.foreach(i => {
                                        if(i.nombreAerolinea == aer)
                                        {
                                            println("Tipo de vuelos que hará el avión:")
                                            println("1-> Nacionales")
                                            println("2-> Internacionales")
                                            var tipoV : Int = StdIn.readInt()
                                            println("Ingrese un nombre o modelo para el avión:")
                                            var nomA : String = StdIn.readLine()
                                            var crea = i.crearAvion(tipoV, nomA, aer)
                                            crea match
                                            {
                                                case Success(d) => println("Avión creado con éxito.")
                                                case Failure(g) => println(g)
                                            }
                                            
                                        }
                                    })
                                }
                                case Failure(f) => println(f)
                            }
                        }
                        case 2 => {
                            println("\nEscriba el nombre de la nueva aerolínea: ")
                            var nomAero : String = StdIn.readLine()
                            var nueva = aeropuerto.crearAerolinea(nomAero)
                            nueva match
                            {
                                case Success(s) => println("\nAerolinea creada con éxito.")
                                case Failure(f) => println(f)
                            }
                        }
                    }
                }
            }
        }
    }
}