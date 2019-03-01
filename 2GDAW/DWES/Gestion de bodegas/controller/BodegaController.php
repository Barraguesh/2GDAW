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
        public function index($bodegas)
        {
            /* TWIG EVIROMENT */
            require_once 'vendor/autoload.php';

            $loader = new Twig_Loader_Filesystem('view');
            $twig = new Twig_Environment($loader, array(
                'cache' => false,
            ));

            echo $twig->render('indexView.html', array("bodegas"=> $bodegas));
            /* END TWIG EVIROMENT */
        }

        public function nuevaBodegaView()
        {
            require_once "view/nuevaBodegaView.php";
        }

        public function bodegaView($vinos, $bodega)
        {
            /* TWIG EVIROMENT */
            require_once 'vendor/autoload.php';

            $loader = new Twig_Loader_Filesystem('view');
            $twig = new Twig_Environment($loader, array(
                'cache' => false,
            ));

            echo $twig->render('bodegaView.html', array("vinos"=>$vinos, "bodega"=>$bodega, "ver"=>$_GET["ver"]));
            /* END TWIG EVIROMENT */
        }

        /* DB stuff */
        public function cargaBodegas()
        {
            require_once "model/Bodega.php";

            $bodega = new Bodega();
            $bodegas = $bodega->cargarBodegas();

            $this->index($bodegas);
        }

        public function cargaBodegaView()
        {
            require_once "controller/VinoController.php";
            require_once "model/Bodega.php";
            require_once "model/Vino.php";

            $bodega = new Bodega();
            $bodegaCargada = $bodega->cargarBodega();

            $vino = new Vino();
            $vinos = $vino->cargarVinos();

            $this->bodegaView($vinos, $bodegaCargada);
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
