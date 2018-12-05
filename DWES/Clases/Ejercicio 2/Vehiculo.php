<?php
class Vehiculo
{
    // atributo de clase 
    private static $cantidadTotal = 0;
    // método de clase 
    public static function cantidadTotal() { return Vehiculo::$cantidadTotal; }


    private $marca;
    private $cantidad;
    private $km;
    // Constructor
    public function __construct($marca)
    {
        $this->marca = $marca;
        $this->catidad = $cantidad;
        $this->km = $km;
    }

    public function getVehiculosCreados()
    {
        return $this->cantidad;
    }

    public function getKmTotales() {

    }
}
