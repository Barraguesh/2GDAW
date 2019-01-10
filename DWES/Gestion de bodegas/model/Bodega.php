<?php
class Bodega
{
    private $ID;
    private $nombre;
    private $localizacion;
    private $email;
    private $telefono;
    private $contacto;
    private $fundacion;
    private $restaurante;
    private $hotel;

    /**
     * Get the value of ID
     */
    public function getID()
    {
        return $this->ID;
    }

    /**
     * Set the value of ID
     *
     * @return  self
     */
    public function setID($ID)
    {
        $this->ID = $ID;
        return $this;
    }
    
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
     * Get the value of localizacion
     */
    public function getLocalizacion()
    {
        return $this->localizacion;
    }

    /**
     * Set the value of localizacion
     *
     * @return  self
     */
    public function setLocalizacion($localizacion)
    {
        $this->localizacion = $localizacion;

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

    public function cargarBodegas()
    {
        require_once "controller/BodegaController.php";

        $conectar = new Conectar();
        $conexion = $conectar->conexion();
        $bodegas = [];

        $select = $conexion->prepare("select * from bodega");
        $select->execute();


        if ($select->rowCount() != 0) {
            while ($fila = $select->fetchObject()) {
                $bodega = new Bodega();
                $bodega->setID($fila->ID);
                $bodega->setNombre($fila->nombre);
                $bodega->setLocalizacion($fila->localizacion);
                $bodega->setEmail($fila->email);
                $bodega->setTelefono($fila->telefono);
                array_push($bodegas, $bodega);
            }
        }

        return $bodegas;
    }

    public function cargarBodega()
    {
        require_once "controller/BodegaController.php";

        $conectar = new Conectar();
        $conexion = $conectar->conexion();
        $bodegas = [];

        $select = $conexion->prepare("select * from bodega where ID = ?");
        if (isset($_GET["ver"])) {
            $select->bindParam(1, $_GET["ver"]);
        } else {
            $select->bindParam(1, $_GET["ID"]);
        }
        $select->execute();


        $bodegaCargada = $select->fetchObject();
        $bodega = new Bodega();
        $bodega->setNombre($bodegaCargada->nombre);
        $bodega->setLocalizacion($bodegaCargada->localizacion);
        $bodega->setEmail($bodegaCargada->email);
        $bodega->setTelefono($bodegaCargada->telefono);
        $bodega->setContacto($bodegaCargada->contacto);
        $bodega->setFundacion($bodegaCargada->fundacion);
        $bodega->setRestaurante($bodegaCargada->restaurante);
        $bodega->setHotel($bodegaCargada->hotel);

        return $bodega;
    }

    public function altaBodega()
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
        } catch (PDOException $e) {
            echo "No se ha podido introducir la bodega.<br/>";
            echo $e;
        }
    }

    public function cambiarBodega()
    {
        $bodega = new Bodega();
        $conectar = new Conectar();
        $conexion = $conectar->conexion();

        $update = $conexion->prepare("UPDATE `bodega` SET `nombre`= ?,`localizacion`= ?,`email`= ?,`telefono`= ?,`contacto`= ?,`fundacion`= ?,`restaurante`= ?,`hotel`= ? WHERE ID = ?");
        $update->bindParam(1, $_GET["nombre"]);
        $update->bindParam(2, $_GET["localizacion"]);
        $update->bindParam(3, $_GET["email"]);
        $update->bindParam(4, $_GET["telefono"]);
        $update->bindParam(5, $_GET["contacto"]);
        $update->bindParam(6, $_GET["fundacion"]);
        $update->bindParam(7, $_GET["restaurante"]);
        $update->bindParam(8, $_GET["hotel"]);
        $update->bindParam(9, $_GET["ID"]);
        $update->execute();
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
    }
}
