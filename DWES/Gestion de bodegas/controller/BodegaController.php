<?php
    require_once "core/Conectar.php";

    class BodegaController
    {
        //Metodos
        public function run($action)
        {
            switch ($action) {
                case "index":
                    $this->cargaBodegas();
                    break;
                case "nuevaBodegaView":
                    $this->nuevaBodegaView();
                    break;
                case "bodegaView":
                    $this->cargaBodegaView();
                    break;
                case "nueva":
                    $this->nueva();
                    break;
                case "eliminar":
                    $this->eliminar();
                    break;
                case "cambiar":
                    $this->cambiar();
                    break;
            }
        }

        /* Views */
        public function index($bodegasArray)
        {
            /* TWIG EVIROMENT */
            require_once 'vendor/autoload.php';

            $loader = new Twig_Loader_Filesystem('view');
            $twig = new Twig_Environment($loader, array(
                'cache' => false,
            ));

            echo $twig->render('indexView.html'), array("bodegas" => $bodegasArray);
            /* END TWIG EVIROMENT */
        }

        public function nuevaBodegaView()
        {
            require_once "view/nuevaBodegaView.php";
        }

        public function bodegaView($vinos, $bodega)
        {
            require_once "view/bodegaView.php";
        }

        /* DB stuff */
        public function cargaBodegas()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodegas = $bodega->cargarBodegas();

            $bodegasArray = [];

            foreach ($bodegas as $key => $bodega) {
                $x = 0;
                $bodegasArray[$x] = $bodega->getNombre();
                $bodegasArray[$x+1] = $bodega->getLocalizacion();
                $bodegasArray[$x+2] = $bodega->getEmail();
                $bodegasArray[$x+3] = $bodega->getTelefono();
                $x = $x +4;
            }

            $this->index($bodegasArray);
        }

        public function cargaBodegaView()
        {
            require_once "controller/VinoController.php";
            require_once "model/Bodega.php";
            require_once "model/Vino.php";

            $bodega = new Bodega();
            $bodegaCargada = $bodega->cargarBodega();
            $bodegaArray = [$bodegaCargada->getNombre(),$bodegaCargada->getLocalizacion(),$bodegaCargada->getEmail(),$bodegaCargada->getTelefono(),$bodegaCargada->getContacto(),$bodegaCargada->getFundacion(),$bodegaCargada->getRestaurante(),$bodegaCargada->getHotel(),$_GET["ver"]];

            $vino = new Vino();
            $vinos = $vino->cargarVinos();

            $this->bodegaView($vinos, $bodegaArray);
        }

        public function nueva()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodega->altaBodega();

            $this->cargaBodegas();
        }

        public function eliminar()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodega->eliminarBodega();

            $this->cargaBodegas();
        }

        public function cambiar()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodega->cambiarBodega();

            $this->cargaBodegaView();
        }
    }
