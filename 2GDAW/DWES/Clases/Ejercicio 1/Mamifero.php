<?php
class Mamifero
{
    private $tipo;
    // Constructor
    public function __construct($tipo)
    {
        $this->tipo = $tipo;
    }

    public function saberMamifero()
    {
        return "El mamifero es un/a " . $this->tipo . ".<br/>";
    }
}
