package Personas

class Tripulante extends Persona
{
    override var _nombre : String = _
    override var _cedula : String = _
    private var _cargo : String = _
    private var _pasajeroAsignado : Boolean = false

    def cargo = _cargo
    def pasajeroAsignado = _pasajeroAsignado

    def cargo_= (nuevoCargo : String) = _cargo = nuevoCargo
    def pasajeroAsignado_= (nuevoEstado : Boolean) = _pasajeroAsignado = nuevoEstado

    /*Métodos*/
    def asignarPasajero() : Unit =
    {
        _pasajeroAsignado = true
    }

    def this(nom : String, ced : String, car : String)
    {
        this()
        _nombre = nom
        _cedula = ced 
        _cargo = car
    }
}