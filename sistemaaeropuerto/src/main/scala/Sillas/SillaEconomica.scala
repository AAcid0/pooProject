package Sillas
import Servicios.GeneradorCodigo
import Personas.Pasajero

class SillaEconomica extends Silla
{
    override var _numSilla = 0
    override var _clase : String = "Clase económica"
    override var _codigoSilla : String = "CE".concat(GeneradorCodigo.crearCodigo())
    override var _disponible : Boolean = true
    override var _pasajeroAsignado : Pasajero = _ 
    override var _precio : Int = 20000

    /*Métodos*/
    def calcularCosto() = _precio
    override def numSilla = _numSilla

    def this(num : Int)
    {
        this()
        _numSilla = num
    }
}