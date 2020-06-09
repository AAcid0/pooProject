package ControlVuelos

class Recorrido
{
    var _ciudadOrigenRec : String = _
    var _ciudadDestinoRec : String = _
    var _distancia : Double =_ // en km

    def ciudadOrigenRec = _ciudadOrigenRec
    def ciudadDestinoRec = _ciudadDestinoRec
    def distancia = _distancia

    def ciudadOrigenRec_= (nuevoOrigen : String) = _ciudadOrigenRec = nuevoOrigen
    def ciudadDestinoRec_= (nuevoDestino : String) = _ciudadDestinoRec = nuevoDestino
    def distancia_= (nuevaDistancia : Double) = _distancia = nuevaDistancia

    def this(ciuO : String, ciuD : String, dis : Double)
    {
        this()
        _ciudadDestinoRec = ciuD
        _ciudadOrigenRec = ciuO
        _distancia = dis
    }
    
    def calcularCosto() : Double =
    {
        return _distancia * 1000
    } 
}