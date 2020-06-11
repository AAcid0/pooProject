package Aeropuerto
import scala.io._
import scala.util._
import ControlVuelos._
import ControlVuelos._
import Personas._
import Servicios._
import Sillas._

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
        println("0-> Salir.")
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
                    println("3-> Consultar vuelo infantil")
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
                                            println("Compra de Ticket")
                                            println("=================")
                                            println("Registro de Pasajero")
                                            println("Ingrese su nombre:")
                                            var nombreUs : String = StdIn.readLine()
                                            println("Ingrese # de documento:")
                                            var cedulaUs : String = StdIn.readLine()
                                            println("Planes Disponibles")
                                            println("==================")
                                            println("M -> Máx: 2 Maletas\nL -> Máx: 4 Maletas\nXL -> Máx 6 Maletas")
                                            println("Ingrese su tipo de plan deseado:")
                                            var planUs : String = StdIn.readLine()
                                            println("Ingrese el número de maletas:")
                                            var maletUs : Int = StdIn.readInt()
                                            if(planUs == "M" && maletUs > 2)
                                            {
                                                println("Excede el número de maletas para su plan.")
                                                println("Confirme el número de maletas.")
                                                var maletUs : Int = StdIn.readInt()
                                            } 
                                            if(planUs == "L" && maletUs > 4)
                                            {
                                                println("Excede el número de maletas para su plan.")
                                                println("Confirme el número de maletas.")
                                                var maletUs : Int = StdIn.readInt()
                                            }
                                            if(planUs == "XL" && maletUs > 6)
                                            {
                                                println("Excede el número de maletas permitido por persona.")
                                                println("Confirme el número de maletas.")
                                                var maletUs : Int = StdIn.readInt()
                                            }
                                            println("¿Requiere algún servicio especial?")
                                            println("Por ejemplo: Silla de ruedas,  muletas, es gestante")
                                            println("1-> Si.")
                                            println("2-> No.")
                                            var especialDes : Boolean = false
                                            var dec : Int = StdIn.readInt()
                                            dec match
                                            {
                                                case 1 => especialDes = true
                                                case 2 => especialDes = especialDes
                                                case default => println("Ingrese opción válida.")
                                            }
                                            var pasajeroFull = new Pasajero(nombreUs, cedulaUs, planUs, maletUs, especialDes) //Se crea usurio al cual se asignará silla en el vuelo (Compra ticket)
                                            println("Usuario creado, procediendo con compra.\n")
                                            println("Ingrese la aerolínea deseada:")
                                            var aeroDec : String = StdIn.readLine()
                                            aeropuerto.listaAerolineas.foreach(i => {
                                                if(i.nombreAerolinea == aeroDec)
                                                {
                                                    println("Ingresa el código de vuelo deseado:")
                                                    var codVue : String = StdIn.readLine()
                                                    var vueloDec = i.buscarVuelo(codVue)
                                                    vueloDec match
                                                    { 
                                                        case Some(vuelo) => {
                                                            println("Ingrese la clase deseada:")
                                                            println("1-> Primera Clase")
                                                            println("2-> Clase Económica")
                                                            println("3-> Clase Infantil")
                                                            println("Su elección es:")
                                                            var opCla : Int = StdIn.readInt()
                                                            opCla match
                                                            {
                                                                case 1 => {
                                                                    var cont : Int = 1
                                                                    println("| Numeración |\t| Código |")
                                                                    vuelo.avionAsignado.listaSillas.foreach(sil => {
                                                                        if(sil.clase == "Primera Clase" && sil.disponible == true)
                                                                        {
                                                                            println("| Silla #" + sil.numSilla +"|\t| " + sil.codigoSilla + " |")               
                                                                        }
                                                                        cont = cont + 1
                                                                    })
                                                                    println("Por favor ingrese el código de su asiento deseado: ")
                                                                    var sillaDec : String = StdIn.readLine()
                                                                    var comSilla : Option[Silla] = vuelo.avionAsignado.buscarSilla(sillaDec)
                                                                    comSilla match {
                                                                        case Some(sillaPC) => {
                                                                            sillaPC.asignarPasajero(pasajeroFull)
                                                                            sillaPC.ocuparSilla()                   //En esta parte se asigna una silla a un pasajero
                                                                            pasajeroFull.asignarSilla(sillaPC)      //y un pasajero a una silla, de esta manera se compra.
                                                                            println("Compra realizada con éxito.\n.\n.")
                                                                        }
                                                                        case None => println("Verifique su código de asiento.\nVolviendo.")
                                                                    }
                                                                }
                                                                case 2 => {
                                                                    var cont : Int = 1
                                                                    var r : Random = new Random
                                                                    var ran : Int = r.nextInt(vuelo.avionAsignado.capacidadMax)
                                                                    vuelo.avionAsignado.listaSillas.foreach(sillaEC => {
                                                                        if(sillaEC.numSilla == ran)
                                                                        {
                                                                            if(sillaEC.disponible == true && sillaEC.clase == "Clase economica")
                                                                            {
                                                                                sillaEC.asignarPasajero(pasajeroFull)
                                                                                sillaEC.ocuparSilla()
                                                                                pasajeroFull.asignarSilla(sillaEC)
                                                                                println("El código de su silla es: " + sillaEC.codigoSilla)
                                                                                println("Compra realizada con éxito.\n.\n.")
                                                                            }
                                                                            else
                                                                            {
                                                                                ran = r.nextInt(vuelo.avionAsignado.capacidadMax)
                                                                            }
                                                                        }
                                                                    })
                                                                }
                                                                case 3 => {
                                                                    var cont : Int = 1
                                                                    println("| Numeración |\t| Código |")
                                                                    vuelo.avionAsignado.listaSillas.foreach(sil => {
                                                                        if(sil.clase == "Primera Clase" && sil.disponible == true)
                                                                        {
                                                                            println("| Silla #" + sil.numSilla +"|\t| " + sil.codigoSilla + " |")               
                                                                        }
                                                                        cont = cont + 1
                                                                    })
                                                                    println("Ingrese el código del asiento para su niñ@: ")
                                                                    var sillaDec : String = StdIn.readLine()
                                                                    var comSilla : Option[Silla] = vuelo.avionAsignado.buscarSilla(sillaDec)
                                                                    comSilla match {
                                                                        case Some(sillaPC) => {
                                                                            sillaPC.asignarPasajero(pasajeroFull)
                                                                            sillaPC.ocuparSilla()                   //En esta parte se asigna una silla a un pasajero
                                                                            pasajeroFull.asignarSilla(sillaPC)      //y un pasajero a una silla, de esta manera se compra.
                                                                            println("Compra realizada con éxito.\n.\n.")
                                                                        }
                                                                        case None => println("Verifique su código de asiento.\nVolviendo.")
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        case None => println("No hay vuelos relacionados con el código ingresado.")
                                                    }

                                                }
                                            }) 
                                        }
                                    }
                                }
                            }
                        }
                        case 3 => {
                            println("Aeropuertocentral.com\nModulo menor de edad")
                            println("Que desea saber del viaje de su hijo:")
                            println("1 -> recepción del niño")
                            println("2 -> Estado del niño")
                            var opc : Int = StdIn.readInt()
                            opc match
                            {
                                case 1 => {
                                    var comprobarAero = aeropuerto.comprobarAerolineas()
                                    var vueloDec : Vuelo = new Vuelo
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
                                                var vueloDeseado = i.buscarVuelo(codVue)
                                                vueloDec = vueloDeseado.asInstanceOf[Vuelo]

                                            }
                                            }) 
                                        }
                                        case Failure(f) => println(f)
                                    }
                                    if(vueloDec._estadoVuelo != 3)
                                    {
                                        println("Su hijo no ha sido recogido, ya que no se ha finalizado el vuelo")
                                        println("Espere a que el vuelo finalize para confirmar la recogida de su menor")
                                    }
                                    else
                                    {
                                        ("Su hijo ya ha sido recogido")
                                    }
                                }
                                case 2 => 
                                {
                                    var comprobarAero = aeropuerto.comprobarAerolineas()
                                    var vueloDec : Vuelo = new Vuelo
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
                                                var vueloDeseado = i.buscarVuelo(codVue)
                                                vueloDec = vueloDeseado.asInstanceOf[Vuelo]

                                            }
                                            }) 
                                        }
                                        case Failure(f) => println(f)
                                    }
                                    vueloDec._estadoVuelo match
                                    {
                                        case 0 => println("El vuelo no ha iniciado")
                                        case 1 => println("El vuelo se encuentra en progreso")
                                        case 2 => println("El menor se encuentra realizando una escala acompañado de un tripulante")
                                        case 3 => println("El menor ya ha sido recogido en el aerpuerto")
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
                    println("1-> Crear una nueva aerolínea.")
                    println("2-> Asignar nuevo avión a aerolínea.")
                    println("3-> Crear un nuevo vuelo disponible.")
                    println("4-> Consultar vuelos por Aerolinea.")
                    println("5 -> Modulo de pasajero")
                    println("6 -> Gestionar menor de edad")
                    println("7-> Consultar viaje específico")
                    println("0 -> Volver.")
                    println("Su elección: ")
                    var opc : Int = StdIn.readInt()
                    opc match
                    {
                        case 7 => {
                            var comprobarAero = aeropuerto.comprobarAerolineas()
                            comprobarAero match
                            {
                                case Success(s) => {
                                    println("Ingrese el código del vuelo a buscar:")
                                    var vueloBus : String = StdIn.readLine()
                                    aeropuerto.listaAerolineas.foreach(aeroL => {
                                        println("Buscando vuelo en " + aeroL.nombreAerolinea)
                                        aeroL.listaVuelos.foreach(vueL => {
                                            if(vueL.codigoVuelo == vueloBus){
                                                println("Vuelo encontrado.\nIngrese una opción.")
                                                println("1-> Ver info principal.\n2-> Ver sillas del vuelo.")
                                                var elec : Int = StdIn.readInt()
                                                elec match
                                                {
                                                    case 1 => {
                                                        println("| Dia salida |\t| Hora salida |\t| Ciudad Origen |\t| Ciudad destino |\t| Código |\t| Avión |")
                                                        println("| " + vueL.diaSalida + " |\t| " + vueL.horaSalida + " |\t| " + vueL.ciudadOrigen + " |\t| " + vueL.ciudadDestino+ " |\t| " + vueL.codigoVuelo+ " |\t|\t" + vueL.avionAsignado.nombreAvion)
                                                    }
                                                    case 2 => {
                                                        var avionPro : Avion = vueL.avionAsignado
                                                        println("| # |\t| Código |\t| Disponibilidad |")
                                                        avionPro.listaSillas.foreach(sillaAv => {
                                                            println("| " +sillaAv.numSilla+ " |\t| " + sillaAv.codigoSilla + " |\t| " + sillaAv.disponible)
                                                        })
                                                    }
                                                }
                                            }
                                        })
                                    })
                                }
                            }
                        }
                        case 2 => {
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
                                            var capacity : Int = 0
                                            if(tipoV == 1){capacity = 8}        //MODIFICAR CUANDO SE 
                                            if(tipoV == 2){capacity = 16}       //COLOQUEN LAS CAPACIDADES REALES
                                            println("Ingrese un nombre o modelo para el avión:")
                                            var nomA : String = StdIn.readLine()
                                            var crea = i.crearAvion(tipoV, nomA, i, capacity)
                                            crea match
                                            {
                                                case Success(s) => {
                                                    //println("Tipo avion : " + s.tipo)
                                                    println("\nAvión creado con éxito.")
                                                }
                                                case Failure(f) => println(f)
                                            }
                                            
                                        }
                                    })
                                }
                                case Failure(f) => println(f)
                            }
                        }
                        case 1 => {
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
                                    aeropuerto.listaAerolineas.foreach(aerolynea => {
                                        if(aerolynea.nombreAerolinea == aer)
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
                                            var creaVuelo = aerolynea.crearVuelo(ciuOr, ciuDe, diaSal, horSa, tipVu, aer)
                                            creaVuelo match
                                            {
                                                case Success(s) => {
                                                    if(tipVu == 2)  //Si el vuelo es Intern. se especifican escalas-recorrido
                                                    {
                                                        println("Por favor ingrese el código del vuelo para especificar escalas:")
                                                        var codVuelo : String = StdIn.readLine()
                                                        var vueloTemp : Option[Vuelo] = aerolynea.buscarVuelo(codVuelo)
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
                                                    aerolynea.listaVuelos.foreach(k => {
                                                    
                                                            if(k.codigoVuelo == codVuelo){
                                                                print("Listado de Aviones disponibles")
                                                                print("\n==============================\n")
                                                                println("| Nombre |\t| Tipo Vuelo |")
                                                                aerolynea.listaAviones.foreach(avion =>{
                                                                    if(avion.capacidadMax == 8 && tipVu == 1){ //CAMBIAR 8 por numero de sillas totales para v. Nacionales
                                                                        aerolynea.mostrarAvion(avion) 
                                                                    }
                                                                    if(avion.capacidadMax == 16 && tipVu == 2){ //CAMBIAR 16 por numero de sillas totales para v. Nacionales
                                                                        aerolynea.mostrarAvion(avion)
                                                                    }
                                                                })
                                                                println("\nIngrese el nombre del avión requerido para el vuelo:")
                                                                var nomAvion : String = StdIn.readLine()
                                                                var asigAvi : Option[Avion] = aerolynea.buscarAvion(nomAvion)
                                                                asigAvi match
                                                                {
                                                                    case Some(d) => {
                                                                        d.agregarVuelo(k) //agregar el vuelo a la listaVUelos del avion seleccionado
                                                                        k.avionAsignado = d //se asigna un avión para que relice este vuelo
                                                                    }
                                                                    case None => println("Ingrese un modelo o nombre de avión correcto.")
                                                                }
                                                            }
                                                            else{
                                                                println("Buscando... ")
                                                            }
                                                    })
                                                    /*var vueloTemp1 : Option[Vuelo] = i.buscarVuelo(codVuelo)
                                                    vueloTemp1 match
                                                    {
                                                        case Some(k) => {
                                                            print("Listado de Aviones disponibles")
                                                            print("\n==============================\n")
                                                            aerolynea.mostrarAviones()
                                                            println("\nIngrese el nombre del avión requerido para el vuelo:")
                                                            var nomAvion : String = StdIn.readLine()
                                                            var asigAvi : Option[Avion] = aerolynea.buscarAvion(nomAvion)
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
                        /*case 5 => {
                            println("Modulo de pasajero")
                            println("=========================")
                            var costoSilla : Double = 0
                            var comprobarAero = aeropuerto.comprobarAerolineas()
                            var costoVuelo : Double = 0
                            var vueloDec : Vuelo = new Vuelo
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
                                        var vueloDeseado = i.buscarVuelo(codVue)
                                        vueloDec = vueloDeseado.asInstanceOf[Vuelo]
                                        costoVuelo = vueloDec.costoVuelo

                                    }
                                    }) 
                                }
                                case Failure(f) => println(f)
                            }
                            if(vueloDec._cupoCompleto == false)
                            {
                                println("Ingrese nombre del pasajero")
                                var nombrePas : String = StdIn.readLine()
                                println("Ingrese documento del pasajero")
                                var docum : String = StdIn.readLine()
                                println("Ingrese silla en la cual quiere viajar")
                                var sill : Int = StdIn.readInt()
                                for(i <- vueloDec.avionAsignado.listaSillas)
                                {
                                    if(i.numSilla == sill)
                                    {
                                        if(i.disponible == false)
                                        {
                                            println("Silla ocupada por otro usuario")
                                        }
                                        else
                                        {
                                            i.cambiarEstado()
                                            var pasa : Pasajero = new Pasajero(nombrePas,docum)
                                            costoSilla = i.precio 
                                            i.asignarPasajero(pasa)
                                            println("Silla asignada correctamente")
                                            println("Ingrese número de maletas las cuales llevara en su viaje")
                                            var numMal : Int = StdIn.readInt()
                                            if(numMal > 3)
                                            {
                                                println("Mas maletas de las permitidas por la aerolinea, por favor saque algunas")
                                                println("¿Necesitas algun servicio especial?")
                                                var espe : String = StdIn.readLine()
                                                pasa.agregarEspecial(docum)

                                            }
                                            else
                                            {   
                                                println("Número de maletas permitido por la Aerolinea")
                                                println("¿Necesitas algun servicio especial?")
                                                var espe : String = StdIn.readLine()
                                                pasa.agregarEspecial(docum)
                                            }
                                        }
                                    }
                                }
                                println("El costo de su vuelo es:")
                                var cos : Double = costoVuelo + costoSilla                                 
                            }
                            else
                            {
                                println("El vuelo esta completo")
                            }
                            

                        }
                        case 6 => {
                            println("Modulo de pasajero menor de edad")
                            println("=========================")
                            var costoSilla : Double = 0
                            var comprobarAero = aeropuerto.comprobarAerolineas()
                            var costoVuelo : Double = 0
                            var vueloDec : Vuelo = new Vuelo
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
                                        var vueloDeseado = i.buscarVuelo(codVue)
                                        vueloDec = vueloDeseado.asInstanceOf[Vuelo]
                                        costoVuelo = vueloDec.costoVuelo

                                    }
                                    }) 
                                }
                                case Failure(f) => println(f)
                            }
                            if(vueloDec._cupoCompleto == false)
                            {
                                println("Ingrese nombre del menor")
                                var nombrePas : String = StdIn.readLine()
                                println("Ingrese documento del menor")
                                var docum : String = StdIn.readLine()
                                println("Ingrese silla en la cual quiere viajar")
                                var sill : Int = StdIn.readInt()
                                for(i <- vueloDec.avionAsignado.listaSillas)
                                {
                                    if(i.numSilla == sill)
                                    {
                                        if(i.disponible == false)
                                        {
                                            println("Silla ocupada por otro usuario")
                                        }
                                        else
                                        {
                                            var sillaNino : SillaInfantil = new SillaInfantil(i.numSilla)
                                            sillaNino.cambiarEstado()
                                            var pasa : Pasajero = new Pasajero(nombrePas,docum)
                                            costoSilla = sillaNino.precio 
                                            sillaNino.asignarPasajero(pasa)
                                            println("Nombre tripulante que acompañara al menor")
                                            var nomTri : String = StdIn.readLine()
                                            println("Cedula del tripulante que acompañara al menor")
                                            var cedu : String = StdIn.readLine()
                                            var tripu : Tripulante = new Tripulante(nomTri,cedu,"Personal infantil")
                                            tripu.asignarPasajero()
                                            println("Datos tripulante encargado de su menor:")
                                            println("Nombre : " + nomTri)
                                            println("Cedula : "+ cedu)
                                            sillaNino.agregarPersonal(tripu)
                                            println("Silla asignada correctamente")
                                            println("Ingrese número de maletas las cuales llevara el menor en su viaje")
                                            var numMal : Int = StdIn.readInt()
                                            if(numMal > 3)
                                            {
                                                println("Mas maletas de las permitidas por la aerolinea, por favor saque algunas")
                                                pasa.agregarEspecial("clase infantil")

                                            }
                                            else
                                            {   
                                                println("Número de maletas permitido por la Aerolinea")
                                                pasa.agregarEspecial("clase infantil")
                                            }
                                        }
                                    }
                                }
                                println("El costo de su vuelo es:")
                                var cos : Double = costoVuelo + costoSilla                                 
                            }
                            else
                            {
                                println("El vuelo esta completo")
                            }

                        }*/
                       
                        case 0 => {
                            sesionOperario = false
                        }
                        case default => {
                            println("Por favor ingrese una opción válida.")
                        }
                    }
                }
            }
        case 0 => {
                cerrarSistema = true 
            }
        }
    }
}