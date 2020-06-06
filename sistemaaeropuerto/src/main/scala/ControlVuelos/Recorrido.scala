package ControlVuelos

class Recorrido
{
    var _ciudadOrigen : String = _
    var _ciudadDestino : String = _

    def ciudadOrigen = _ciudadOrigen
    def ciudadDestino = _ciudadDestino

    def ciudadOrigen_= (nuevoOrigen : String) = _ciudadOrigen = nuevoOrigen
    def ciudadDestino_= (nuevoDestino : String) = _ciudadDestino = nuevoDestino
}