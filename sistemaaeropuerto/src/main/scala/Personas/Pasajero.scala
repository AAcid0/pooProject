package Personas
import Sillas._

class Pasajero extends Persona
{
    override var _nombre : String = _
    override var _cedula : Int = _
    private var _tipoPlan : String = _
    private var _sillaAsignada : Silla = _
    private var _numeroMaletas : Int = _
    private var _necesidadEspecial : String = _

    def tipoPlan = _tipoPlan
    def sillaAsignada = _sillaAsignada
    def numeroMaletas = _numeroMaletas
    def necesidadEspecial = _necesidadEspecial

    def tipoPlan_= (nuevoPlan : String) = _tipoPlan = nuevoPlan
    def sillaAsignada_= (nuevaSilla : Silla) = _sillaAsignada = nuevaSilla
    def numeroMaletas_= (nuevaCantidad : Int) = _numeroMaletas = nuevaCantidad
    def necesidadEspecial_= (nuevaNecesidad : String) = _necesidadEspecial = nuevaNecesidad

}