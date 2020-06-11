package Sillas
import Personas.Pasajero

abstract class Silla
{
    protected var _numSilla : Int
    protected var _clase : String
    protected var _codigoSilla : String
    protected var _disponible : Boolean
    protected var _pasajeroAsignado : Pasajero 
    protected var _precio : Int

    def numSilla = _numSilla
    def clase = _clase
    def codigoSilla = _codigoSilla
    def disponible = _disponible
    def pasajeroAsignado = _pasajeroAsignado
    def precio = _precio

    def clase_=(nuevaClase : String) = _clase = nuevaClase
    def codigoSilla_=(nuevoCodigo : String) = _codigoSilla = nuevoCodigo
    def disponible_=(nuevoEstado : Boolean) = _disponible = nuevoEstado
    def pasajeroAsignado_=(nuevoPasajero : Pasajero) = _pasajeroAsignado = nuevoPasajero 

    def asignarPasajero(pasa : Pasajero) : Unit = 
    { 
        this._pasajeroAsignado = pasa
    }

    def ocuparSilla() : Unit =
    {
        this._disponible = false
    }
    def liberarSilla() : Unit =
    {
        this._disponible = true
    }
}