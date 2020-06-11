package Personas
import Sillas._

class Pasajero extends Persona
{
    override var _nombre : String = _
    override var _cedula : String = _
    private var _tipoPlan : String = _
    private var _sillaAsignada : Silla = _
    private var _numeroMaletas : Int = _
    private var _necesidadEspecial : Boolean = _

    def tipoPlan = _tipoPlan
    def sillaAsignada = _sillaAsignada
    def numeroMaletas = _numeroMaletas
    def necesidadEspecial = _necesidadEspecial

    def tipoPlan_= (nuevoPlan : String) = _tipoPlan = nuevoPlan
    def sillaAsignada_= (nuevaSilla : Silla) = _sillaAsignada = nuevaSilla
    def numeroMaletas_= (nuevaCantidad : Int) = _numeroMaletas = nuevaCantidad
    def necesidadEspecial_= (nuevaNecesidad : Boolean) = _necesidadEspecial = nuevaNecesidad

    def this(nom : String, ced : String, plan : String, numMale : Int, necesi : Boolean) 
    {
        this()
        _nombre = nom 
        _cedula = ced
        _tipoPlan = plan
        _numeroMaletas = numMale
        _necesidadEspecial = necesi
        //_sillaAsignada = new Silla 
    }

    def agregarEspecial(espe : Boolean) : Unit =
    {
        _necesidadEspecial = espe
    }

    def asignarSilla(silla : Silla) : Unit =
    {
        this._sillaAsignada = silla
    }

}