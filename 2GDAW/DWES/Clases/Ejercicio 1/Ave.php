<?php
class Ave
{
    private $tipo;
    // Constructor
    public function __construct($tipo)
    {
        $this->tipo = $tipo;
    }

    public function saberAve()
    {
        return "El ave es un/a " . $this->tipo . ".<br/>";
    }
}
