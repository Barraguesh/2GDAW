<?php
    require_once "core/Conectar.php";

    class VinoController
    {
        //Metodos
        public function run($action)
        {
            switch ($action) {
                case "index":
                    $this->cargarVinoView();
                    break;
                case "nuevoVinoView":
                    $this->nuevoVinoView();
                    break;
                case "nuevo":
                    $this->nuevo();
                    break;
                case "eliminar":
                    $this->eliminar();
                    break;
            }
        }

        /* Views */
        public function vinoView($vino)
        {
            require_once "view/vinoView.php";
        }

        public function nuevoVinoView()
        {
            require_once "view/nuevoVinoView.php";
        }

        /* DB stuff */
        public function cargarVinoView()
        {
            require_once "model/Vino.php";

            $vino = new Vino();
            $vinoCargado = $vino->cargarVino();

            $this->vinoView($vinoCargado);
        }

        public function nuevo()
        {
            require_once "model/Vino.php";
            require_once "controller/BodegaController.php";

            $vino = new Vino();
            $vino->altaVino();

            $bodega = new BodegaController();
            $bodega->cargaBodegaView();
        }

        public function eliminar()
        {
            require_once "model/Vino.php";

            $vino = new Vino();
            $vino->eliminarVino();

        }
    }
