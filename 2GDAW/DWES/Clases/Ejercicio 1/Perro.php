<?php
class Perro
{
    private $tipo;
    // Constructor
    public function __construct($tipo)
    {
        $this->tipo = $tipo;
    }

    public function saberPerr()
    {
        return "El perro es un/a " . $this->tipo . ".<br/>";
    }
}
