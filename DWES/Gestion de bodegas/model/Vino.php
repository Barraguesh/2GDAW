<?php
class Vino
{
    private $nombre;
    private $tipo;
    private $email;
    private $telefono;
    private $contacto;
    private $fundacion;
    private $restaurante;
    private $hotel;

    /**
     * Get the value of nombre
     */
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * Set the value of nombre
     *
     * @return  self
     */
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
        return $this;
    }

    /**
     * Get the value of tipo
     */
    public function getTipo()
    {
        return $this->tipo;
    }

    /**
     * Set the value of tipo
     *
     * @return  self
     */
    public function setTipo($tipo)
    {
        $this->tipo = $tipo;

        return $this;
    }

    /**
     * Get the value of email
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set the value of email
     *
     * @return  self
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get the value of telefono
     */
    public function getTelefono()
    {
        return $this->telefono;
    }

    /**
     * Set the value of telefono
     *
     * @return  self
     */
    public function setTelefono($telefono)
    {
        $this->telefono = $telefono;

        return $this;
    }

    /**
     * Get the value of contacto
     */
    public function getContacto()
    {
        return $this->contacto;
    }

    /**
     * Set the value of contacto
     *
     * @return  self
     */
    public function setContacto($contacto)
    {
        $this->contacto = $contacto;

        return $this;
    }

    /**
     * Get the value of fundacion
     */
    public function getFundacion()
    {
        return $this->fundacion;
    }

    /**
     * Set the value of fundacion
     *
     * @return  self
     */
    public function setFundacion($fundacion)
    {
        $this->fundacion = $fundacion;

        return $this;
    }

    /**
     * Get the value of restaurante
     */
    public function getRestaurante()
    {
        return $this->restaurante;
    }

    /**
     * Set the value of restaurante
     *
     * @return  self
     */
    public function setRestaurante($restaurante)
    {
        $this->restaurante = $restaurante;

        return $this;
    }

    /**
     * Get the value of hotel
     */
    public function getHotel()
    {
        return $this->hotel;
    }

    /**
     * Set the value of hotel
     *
     * @return  self
     */
    public function setHotel($hotel)
    {
        $this->hotel = $hotel;

        return $this;
    }

    public function cargarVinos()
    {
        require_once "controller/VinoController.php";

        $conectar = new Conectar();
        $conexion = $conectar->conexion();
        $vinos = [];

        $select = $conexion->prepare("select * from vino where bodegaID = ?");
        $select->bindParam(1, $_GET["ver"]);
        $select->execute();


        if ($select->rowCount() != 0) {
            while ($fila = $select->fetchObject()) {
                $vino = new Vino();
                $vino->setNombre($fila->nombre);
                $vino->setTipo($fila->tipo);
                array_push($vinos, $vino);
            }
        }

        return $vinos;
    }

    public function cargarVino()
    {
        require_once "controller/VinoController.php";

        $conectar = new Conectar();
        $conexion = $conectar->conexion();

        $select = $conexion->prepare("select * from vino where ID = ?");
        $select->bindParam(1, $_GET["ver"]);
        $select->execute();


        $vinoDB->fetchObject();
        $vino = new Vino();
        $vino->setNombre($fila->nombre);
        $vino->setTipo($fila->tipo);
        $vino;

        return $vino;
    }

    public function altaVino()
    {
        $bodega = new Bodega();
        $conectar = new Conectar();
        $conexion = $conectar->conexion();

        try {
            $insert = $conexion->prepare("INSERT INTO `bodega` (`nombre`, `localizacion`, `email`, `telefono`, `contacto`, `fundacion`, `restaurante`, `hotel`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            $insert->bindParam(1, $_GET["nombre"]);
            $insert->bindParam(2, $_GET["localizacion"]);
            $insert->bindParam(3, $_GET["email"]);
            $insert->bindParam(4, $_GET["telefono"]);
            $insert->bindParam(5, $_GET["contacto"]);
            $insert->bindParam(6, $_GET["fundacion"]);
            $insert->bindParam(7, $_GET["restaurante"]);
            $insert->bindParam(8, $_GET["hotel"]);
            $insert->execute();
            
            $controlador = new BodegaController();
            $controlador->carga();
        } catch (PDOException $e) {
            echo "No se ha podido introducir la bodega.<br/>";
            echo $e;
        }
    }

    public function eliminarBodega()
    {
        $bodega = new bodega();
        $conectar = new Conectar();
        $conexion = $conectar->conexion();

        $delete = $conexion->prepare("DELETE FROM bodega WHERE ID = ?");
        $delete->bindParam(1, $_GET["eliminar"]);
        $delete->execute();

        $reorganizar = $conexion->prepare("SET  @num := 0; UPDATE bodega SET ID = @num := (@num+1); ALTER TABLE bodega AUTO_INCREMENT = 1;");
        $reorganizar->execute();

        $controlador = new bodegaController();
        $controlador->carga();
    }
}
