package Sillas
import Servicios.GeneradorCodigo
import Personas._

class SillaInfantil extends Silla
{
    override var _clase : String = "Clase Infantil"
    override var _codigoSilla : String = "CI".concat(GeneradorCodigo.crearCodigo())
    override var _disponible : Boolean = true
    override var _pasajeroAsignado : Pasajero = _ 
    override var _precio : Int = _
    private var _personalAsignado : Tripulante = _

    def personalAsignado = _personalAsignado

    def personalAsignado_= (nuevoPersonal : Tripulante) = _personalAsignado = nuevoPersonal

    /*Métodos*/

    def calcularCosto() = _precio
}