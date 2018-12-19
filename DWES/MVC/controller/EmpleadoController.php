<?php
    require_once "core/Conectar.php";

    class EmpleadoController
    {
        //Metodos
        public function run($action)
        {
            switch ($action) {
                case "index":
                    $this->carga();
                    break;
                case "alta":
                    $this->alta();
                    break;
            }
        }

        public function index($empleados)
        {
            require_once "view/indexView.php";
        }

        public function carga()
        {
            require_once "model/Empleado.php";

            $empleados = new Empleado();
            $empleadosCargados = $empleados->cargarEmpleados();

            $this->index($empleadosCargados);
        }

        public function alta()
        {
            require_once "model/Empleado.php";

            $empleado = new Empleado();
            $empleadoAlta = $empleado->altaEmpleado();

            $this->carga();
        }
    }
