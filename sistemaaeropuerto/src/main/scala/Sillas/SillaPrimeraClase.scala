package Sillas
import Servicios.GeneradorCodigo
import Personas.Pasajero

class SillaPrimeraClase extends Silla
{
    override var _clase : String = "Primera Clase"
    override var _codigoSilla : String = "PC".concat(GeneradorCodigo.crearCodigo())
    override var _disponible : Boolean = true
    override var _pasajeroAsignado : Pasajero = _ 
    override var _precio : Int = _

    /*Métodos*/
    def calcularCosto() = _precio
}