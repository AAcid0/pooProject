package Sillas
import Personas.Pasajero

abstract class Silla
{
    protected var _clase : String
    protected var _codigoSilla : String
    protected var _disponible : Boolean
    protected var _pasajeroAsignado : Pasajero //Cambiar por Pasajero
    protected var _precio : Int

    def clase = _clase
    def codigoSilla = _codigoSilla
    def disponible = _disponible
    def pasajeroAsignado = _pasajeroAsignado

    def clase_=(nuevaClase : String) = _clase = nuevaClase
    def codigoSilla_=(nuevoCodigo : String) = _codigoSilla = nuevoCodigo
    def disponible_=(nuevoEstado : Boolean) = _disponible = nuevoEstado
    def pasajeroAsignado_=(nuevoPasajero : Pasajero) = _pasajeroAsignado = nuevoPasajero //cambiar String por Pasajero
}