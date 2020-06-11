package Sillas
import Servicios.GeneradorCodigo
import Personas.Pasajero

class SillaEconomica extends Silla
{
    override var _numSilla = 1
    override var _clase : String = "Clase economica"
    override var _codigoSilla : String = "CE".concat(GeneradorCodigo.crearCodigo())
    override var _disponible : Boolean = true
    override var _pasajeroAsignado : Pasajero = _ 
    override var _precio : Int = 20000
    
    
    
    /*Métodos*/
    def calcularCosto() = _precio
    

    def this(num : Int)
    {
        this()
        _numSilla = num
    }
}