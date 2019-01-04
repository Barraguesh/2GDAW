<?php
    require_once "core/Conectar.php";

    class BodegaController
    {
        //Metodos
        public function run($action)
        {
            switch ($action) {
                case "index":
                    $this->carga();
                    break;
                case "nuevaBodegaView":
                    $this->nuevaBodegaView();
                    break;
                case "nueva":
                    $this->nueva();
                    break;
                case "eliminar":
                    $this->eliminar();
                    break;
            }
        }

        /* Views */
        public function index($bodegas)
        {
            require_once "view/indexView.php";
        }

        public function nuevaBodegaView()
        {
            require_once "view/nuevaBodegaView.php";
        }

        /* DB stuff */
        public function carga()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodegas = $bodega->cargarBodegas();

            $this->index($bodegas);
        }

        public function nueva()
        {
            require_once "model/bodega.php";

            $bodega = new Bodega();
            $bodega->altaBodega();

            $this->carga();
        }

        public function eliminar()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodega->eliminarBodega();

            $this->carga();
        }
    }
