package ControlVuelos
import Servicios.GeneradorCodigo

class Vuelo
{
    var _ciudadOrigen : String = _
    var _ciudadDestino : String = _
    var _horaSalida : String = _
    var _horaLlegada : String = _
    var _diaSalida : String = _
    var _conexiones : List[Recorrido] = _
    var _tipoVuelo : Int = _ //1 -> Nacional / 2 -> Internacional
    var _avionAsignado : Avion = _
    var _codigoVuelo : String = GeneradorCodigo.crearCodigo()
    var _costoVuelo : Double = 0
    var _cupoCompleto : Boolean = false

    def ciudadOrigen = _ciudadOrigen
    def ciudadDestino = _ciudadDestino
    def diaSalida = _diaSalida
    def horaSalida = _horaSalida
    def horaLlegada = _horaLlegada
    def conexiones = _conexiones
    def tipoVuelo = _tipoVuelo
    def avionAsignado = _avionAsignado
    def codigoVuelo = _codigoVuelo

    def ciudadOrigen_= (nuevoOrigen : String) = _ciudadOrigen = nuevoOrigen
    def ciudadDestino_= (nuevoDestino : String) = _ciudadDestino = nuevoDestino
    def horaSalida_= (nuevaHoraS : String) = _horaSalida = nuevaHoraS
    def horaLlegada_= (nuevaHoraL : String) = _horaLlegada = nuevaHoraL
    def tipoVuelo_= (nuevoTipo : Int) = _tipoVuelo = nuevoTipo
    def avionAsignado_= (nuevoAvion : Avion) = _avionAsignado = nuevoAvion

    def this(num : Int)
    {
        this()
        _codigoVuelo = "0"
    }

    def this(hoSal : String, hoLl : String, diaSal : String, tipVuelo : Int)
    {
        this()
        _horaSalida = hoSal
        _horaLlegada = hoLl
        _diaSalida = diaSal
        _tipoVuelo = tipVuelo
        _avionAsignado = new Avion(tipVuelo)

    }

    def agregarConexion(ciuO : String, ciuD : String, dis : Double) : Unit =
    {
        var reco : Recorrido = new Recorrido(ciuO, ciuD, dis)
        if(this._conexiones.nonEmpty == false)
        {
            _ciudadOrigen = ciuO
        }
        _conexiones = reco :: _conexiones
        _ciudadDestino = ciuD
        for(i <- this._conexiones)
        {
            _costoVuelo += i.calcularCosto()
        } 
    }

    def agregarConexion(reco : Recorrido) : Unit =
    {
        if(this._conexiones.nonEmpty == false)
        {
            _ciudadOrigen = reco._ciudadOrigenRec
        }
        _conexiones = reco :: _conexiones
        _ciudadDestino = reco._ciudadDestinoRec
        for(i <- this._conexiones)
        {
            _costoVuelo += i.calcularCosto()
        } 
    }
}