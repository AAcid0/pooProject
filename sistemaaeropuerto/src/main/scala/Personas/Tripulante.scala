package Personas

class Tripulante extends Persona
{
    override var _nombre : String = _
    override var _cedula : Int = _
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
}