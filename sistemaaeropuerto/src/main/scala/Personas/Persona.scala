package Personas

abstract class Persona
{
    protected var _nombre : String
    protected var _cedula : Int

    def nombre = _nombre
    def cedula = _cedula

    def nombre_=(nuevoNombre : String) = _nombre = nuevoNombre
    def cedula_=(nuevaCedula : Int) = _cedula = nuevaCedula
}