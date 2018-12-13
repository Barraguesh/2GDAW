<?php
    class EmpleadoController {
        private $conectar;
        
        //Metodos
        public function run($action) {
            switch ($action) {
                case "index":
                    $this->index();
                    break;
            }
        }

        public function index() {
            require_once "view/empleado.php";
        }
    }