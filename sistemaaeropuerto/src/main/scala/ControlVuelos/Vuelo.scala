package ControlVuelos
import Servicios.GeneradorCodigo

class Vuelo
{
    var _ciudadOrigen : String = _
    var _ciudadDestino : String = _
    var _horaSalida : String = _
    var _horaLlegada : String = _
    var _conexiones : List[Recorrido] = _
    var _tipoVuelo : String = _
    var _avionAsignado : Avion = _
    var _codigoVuelo : String = GeneradorCodigo.crearCodigo()

    def ciudadOrigen = _ciudadOrigen
    def ciudadDestino = _ciudadDestino
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
    def tipoVuelo_= (nuevoTipo : String) = _tipoVuelo = nuevoTipo
    def avionAsignado_= (nuevoAvion : Avion) = _avionAsignado = nuevoAvion
}