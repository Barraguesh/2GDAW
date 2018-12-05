<?php
class Gato
{
    private $tipo;
    // Constructor
    public function __construct($tipo)
    {
        $this->tipo = $tipo;
    }

    public function saberGato()
    {
        return "El gato es un/a " . $this->tipo . ".<br/>";
    }
}
