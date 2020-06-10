package Aeropuerto
import scala.io._
import scala.util._
import ControlVuelos._

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
            case 1 => {
                var sesionCliente : Boolean = true
                while(sesionCliente)
                {
                    println("\nBienvenid@ a Aeropuertocentral.com")
                    println("==================================")
                    println("Sus opciones son:")
                    println("1-> Ver vuelos disponibles.")
                    println("2-> Comprar ticket.")
                    println("0-> Volver.")
                    var opc : Int = StdIn.readInt()
                    opc match
                    {
                        case 1 => {
                            println("Visualización de Vuelos")
                            println("=======================")
                            println("1-> Consultar vuelos disponibles por aerolínea.")
                            println("2-> Consultar todos los vuelos disponibles.")
                            println("3-> Consultar vuelo por código.")
                            println("Su elección es:")
                            var opcV : Int = StdIn.readInt()
                            opcV match
                            {
                                case 1 => {
                                    var comprobarAero = aeropuerto.comprobarAerolineas()
                                    comprobarAero match
                                    {
                                        case Success(s) => {
                                            println("Ingresa aerolínea a consultar: ")
                                            var aero : String = StdIn.readLine()
                                            aeropuerto.listaAerolineas.foreach(i => {
                                                if(i.nombreAerolinea == aero)
                                                {
                                                    i.mostrarVuelos()
                                                }
                                            })
                                        }
                                        case Failure(f) => println(f)
                                    }
                                }
                                case 2 => {
                                    var comprobarAero = aeropuerto.comprobarAerolineas()
                                    comprobarAero match
                                    {
                                        case Success(s) => {
                                            aeropuerto.listaAerolineas.foreach(i => {
                                                i.mostrarVuelos
                                            })
                                        }
                                    }
                                }
                                case 3 => {
                                    var comprobarAero = aeropuerto.comprobarAerolineas()
                                    comprobarAero match
                                    { 
                                        case Success(s) => {
                                            println("Ingrese el código del vuelo:")
                                            var codIn : String = StdIn. readLine()
                                            aeropuerto.listaAerolineas.foreach(i => {
                                                var buscaVuelo : Option[Vuelo] = i.buscarVuelo(codIn)
                                                buscaVuelo match
                                                {
                                                    case Some(s) => {
                                                        println("| Dia salida |"+"\t"+"| Hora salida |"+"\t"+"| Ciudad Origen |"+"\t"+"| Ciudad destino |"+"\t"+"| Código |")
                                                        println("| " + s.diaSalida + " |\t| " + s.horaSalida + " |\t| " + s.ciudadOrigen + " |\t| " + s.ciudadDestino+ " |\t| " + s.codigoVuelo)
                                                    }
                                                    case None => println("En " + i.nombreAerolinea + " no hay vuelos con el código.")
                                                }
                                            })
                                        }
                                    }
                                }
                            }
                        }
                        case 2 => {
                            println("Aeropuertocentral.com\nCompra de Tickets")
                            println("=======================")
                            println("Por favor tener presente:\n*Código de vuelo\n*Aerolínea")
                            println("1-> Continuar")
                            println("2-> Volver para consultar vuelos.")
                            var opc : Int = StdIn.readInt()
                            opc match
                            {
                                case 1 => {
                                    var comprobarAero = aeropuerto.comprobarAerolineas()
                                    comprobarAero match
                                    {
                                        case Success(s) => {
                                            println("Ingrese la aerolínea deseada:")
                                            var aeroDec : String = StdIn.readLine()
                                            aeropuerto.listaAerolineas.foreach(i => {
                                                if(i.nombreAerolinea == aeroDec)
                                                {
                                                    println("Ingresa el código de vuelo deseado:")
                                                    var codVue : String = StdIn.readLine()
                                                    var vueloDec = i.buscarVuelo(codVue)

                                                }
                                            }) 
                                        }
                                    }
                                }
                            }
                        }
                        case 0 => {
                            sesionCliente = false
                        }
                        case default => println("Por favor ingrese una opción válida.")
                    }

                }
                
            }
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
                    println("4-> Consultar vuelos por Aerolinea.")
                    println("0 -> Volver.")
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
                                                case Success(s) => println("Avión creado con éxito.")
                                                case Failure(f) => println(f)
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
                        case 3 => {
                            var comprobarAero = aeropuerto.comprobarAerolineas()
                            comprobarAero match
                            {
                                case Success(s) => {
                                    println("\nAerolínea responsable del vuelo:")
                                    var aer : String = StdIn.readLine()
                                    aeropuerto.listaAerolineas.foreach(i => {
                                        if(i.nombreAerolinea == aer)
                                        {
                                            println("\nCreación de vuelos")
                                            println("=====================")
                                            println("Ingrese la ciudad origen del vuelo:")
                                            var ciuOr : String = StdIn.readLine()
                                            println("Ingrese la ciudad destino del vuelo:")
                                            var ciuDe : String = StdIn.readLine()
                                            println("Ingrese el día de salida:")
                                            var diaSal : String = StdIn.readLine()
                                            println("Ingrese la hora de salida:")
                                            var horSa : String = StdIn.readLine()
                                            println("Ingrese el tipo de vuelo:")
                                            println("1-> Nacional.")
                                            println("2-> Internacional.")
                                            var tipVu : Int = StdIn.readInt()
                                            var creaVuelo = i.crearVuelo(ciuOr, ciuDe, diaSal, horSa, tipVu, aer)
                                            creaVuelo match
                                            {
                                                case Success(s) => {
                                                    if(tipVu == 2)  //Si el vuelo es Intern. se especifican escalas-recorrido
                                                    {
                                                        println("Por favor ingrese el código del vuelo para especificar escalas:")
                                                        var codVuelo : String = StdIn.readLine()
                                                        var vueloTemp : Option[Vuelo] = i.buscarVuelo(codVuelo)
                                                        vueloTemp match
                                                        {
                                                            case Some(a) => {
                                                                var cont : Int = 1
                                                                println("¿Cuántas escalas debe realizar el avión para este vuelo?:")
                                                                var numEs : Int = StdIn.readInt()
                                                                while(cont <= numEs)
                                                                {
                                                                    println("Ingrese ciudad origen #" + cont + ": ")
                                                                    var ciuOrig : String = StdIn.readLine()
                                                                    println("Ingrese ciudad destino #" + cont + ": ")
                                                                    var ciudDes : String = StdIn.readLine()
                                                                    println("Ingrese distancia en km entre las 2 ciudades: ")
                                                                    var disKm : Double = StdIn.readInt()
                                                                    a.agregarConexion(ciuOrig, ciudDes, disKm)
                                                                    cont = cont + 1
                                                                }
                                                            }
                                                            case None => {
                                                                println("Código de vuelo erróneo.\n.\n.\n.")
                                                                println("Volviendo al panel...")
                                                            }
                                                        } 
                                                    }
                                                    println("Por favor ingrese el código del vuelo para asignarle un avión.")
                                                    var codVuelo : String = StdIn.readLine()
                                                    i.listaVuelos.foreach(k => {
                                                        if(k.codigoVuelo == codVuelo){
                                                            print("Listado de Aviones disponibles")
                                                            print("\n==============================\n")
                                                            i.mostrarAviones()
                                                            println("\nIngrese el nombre del avión requerido para el vuelo:")
                                                            var nomAvion : String = StdIn.readLine()
                                                            k.cambiarAvion(i.listaAviones.filter( m => m.nombreAvion == nomAvion).head)
                                                            //k._avionAsignado =  i.listaAviones.filter( m => m.nombreAvion == nomAvion).head
                                                        }
                                                    })
                                                    /*var vueloTemp1 : Option[Vuelo] = i.buscarVuelo(codVuelo)
                                                    vueloTemp1 match
                                                    {
                                                        case Some(k) => {
                                                            print("Listado de Aviones disponibles")
                                                            print("\n==============================\n")
                                                            i.mostrarAviones()
                                                            println("\nIngrese el nombre del avión requerido para el vuelo:")
                                                            var nomAvion : String = StdIn.readLine()
                                                            var asigAvi : Option[Avion] = i.buscarAvion(nomAvion)
                                                            asigAvi match{
                                                                case Some(d) => {
                                                                    k.avionAsignado = d.asInstanceOf[Avion]
                                                                }
                                                                case None => println("Ingrese un modelo o nombre de avión correcto.")
                                                            }
                                                        }
                                                        case None => {
                                                            println("Código de vuelo erróneo.\n.\n.\n.")
                                                            println("Volviendo al panel...")
                                                        }
                                                    }*/
                                                }
                                                case Failure(f) => println(f)
                                            }
                                        }
                                    })
                                }
                                case Failure(f) => println(f)
                            }
                        }
                        case 4 => {
                            var comprobarAero = aeropuerto.comprobarAerolineas()
                            comprobarAero match
                            {
                                case Success(s) => {
                                    print("\nControl Vuelos y Aviones")
                                    print("\n==========================")
                                    println("\nIngrese nombre de Aerolínea a inspeccionar:")
                                    var aer : String = StdIn.readLine()
                                    aeropuerto.listaAerolineas.foreach(i => {
                                        if(i.nombreAerolinea == aer)
                                        {
                                            i.mostrarVuelos()
                                        }
                                    })
                                }
                                case Failure(f) => println(f)
                            }

                        }
                        case 0 => {
                            sesionOperario = false
                        }
                        case default => {
                            println("Por favor ingrese una opción válida.")
                        }
                    }
                }
            }
        }
    }
}