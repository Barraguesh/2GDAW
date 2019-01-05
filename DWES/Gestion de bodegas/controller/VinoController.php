<?php
    require_once "core/Conectar.php";

    class VinoController
    {
        //Metodos
        public function run($action)
        {
            switch ($action) {
                case "index":
                    $this->vinoView();
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
            $vinos = $vino->cargarVino();

            $this->vinoView($vino);
        }

        public function cargarVinos()
        {
            require_once "model/Vino.php";

            $vino = new Vino();
            $vinos = $vino->cargarVinos();

            return $vinos;
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
            require_once "model/Bodega.php";

            $vino = new Bodega();
            $vino->eliminarBodega();

            $this->cargarVinoView();
        }
    }
