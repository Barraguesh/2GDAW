<?php
class Animal
{
    private $especie;
    // Constructor
    public function __construct($especie)
    {
        $this->especie = $especie;
    }

    public function saberAnimal()
    {
        return "El animal es un/a " . $this->especie . ".<br/>";
    }
}
