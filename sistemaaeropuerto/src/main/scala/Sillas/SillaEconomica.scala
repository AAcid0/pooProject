package Sillas
import Servicios.GeneradorCodigo
import Personas.Pasajero

class SillaEconomica extends Silla
{
    override var _clase : String = "Clase económica"
    override var _codigoSilla : String = "CE".concat(GeneradorCodigo.crearCodigo())
    override var _disponible : Boolean = true
    override var _pasajeroAsignado : Pasajero = _ 
    override var _precio : Int = _

    /*Métodos*/
    def calcularCosto() = _precio
}