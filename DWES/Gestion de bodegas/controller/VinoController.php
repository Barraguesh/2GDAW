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



        /* DB stuff */
        public function cargarVinoView()
        {
            require_once "model/Vino.php";

            $vino = new Vino();
            $vinoCargado = $vino->cargarVino();

            $this->vinoView($vinoCargado);
        }

        public function nueva()
        {
            require_once "model/Vino.php";

            $vino = new Vino();
            $vino->altaVino();

            $this->cargarVinoView();
        }

        public function eliminar()
        {
            require_once "model/Vino.php";

            $vino = new Vino();
            $vino->eliminarVino();

        }
    }
