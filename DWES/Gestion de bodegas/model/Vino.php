<?php
class Vino
{
    private $ID;
    private $nombre;
    private $tipo;
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
     * Get the value of descripcion
     */
    public function getDescripcion()
    {
        return $this->descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @return  self
     */
    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;

        return $this;
    }

    /**
     * Get the value of anno
     */
    public function getAnno()
    {
        return $this->anno;
    }

    /**
     * Set the value of anno
     *
     * @return  self
     */
    public function setAnno($anno)
    {
        $this->anno = $anno;

        return $this;
    }

    /**
     * Get the value of alcohol
     */
    public function getAlcohol()
    {
        return $this->alcohol;
    }

    /**
     * Set the value of alcohol
     *
     * @return  self
     */
    public function setAlcohol($alcohol)
    {
        $this->alcohol = $alcohol;

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
                $vino->setID($fila->ID);
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


        $vinoDB = $select->fetchObject();
        $vino = new Vino();
        $vino->setNombre($vinoDB->nombre);
        $vino->setDescripcion($vinoDB->descripcion);
        $vino->setAnno($vinoDB->anno);
        $vino->setAlcohol($vinoDB->alcohol);
        $vino->setTipo($vinoDB->tipo);

        $vinoArray = [$vino->getNombre(), $vino->getDescripcion(), $vino->getAnno(), $vino->getAlcohol(), $vino->getTipo()];

        return $vinoArray;
    }

    public function altaVino()
    {
        $vino = new Vino();
        $conectar = new Conectar();
        $conexion = $conectar->conexion();

        try {
            $insert = $conexion->prepare("INSERT INTO `vino` (`nombre`, `descripcion`, `anno`, `alcohol`, `tipo`, `bodegaID`) VALUES (?, ?, ?, ?, ?, ?)");
            $insert->bindParam(1, $_GET["nombre"]);
            $insert->bindParam(2, $_GET["descripcion"]);
            $insert->bindParam(3, $_GET["anno"]);
            $insert->bindParam(4, $_GET["alcohol"]);
            $insert->bindParam(5, $_GET["tipo"]);
            $insert->bindParam(6, $_GET["ver"]);
            $insert->execute();
        } catch (PDOException $e) {
            echo "No se ha podido introducir la bodega.<br/>";
            echo $e;
        }
    }

    public function eliminarVino()
    {
        require_once "controller/BodegaController.php";

        $conectar = new Conectar();
        $conexion = $conectar->conexion();
        $delete = $conexion->prepare("DELETE FROM vino WHERE ID = ?");
        $delete->bindParam(1, $_GET["eliminar"]);
        $delete->execute();

        $reorganizar = $conexion->prepare("SET  @num := 0; UPDATE vino SET ID = @num := (@num+1); ALTER TABLE vino AUTO_INCREMENT = 1;");
        $reorganizar->execute();

        $bodega = new BodegaController();
        $bodega->cargaBodegaView();
    }
}
