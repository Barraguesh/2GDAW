<?php
class Bodega
{
    private $nombre;
    private $localizacion;
    private $email;
    private $telefono;

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
                $bodega->setNombre($fila->nombre);
                $bodega->setLocalizacion($fila->localizacion);
                $bodega->setEmail($fila->email);
                $bodega->setTelefono($fila->telefono);
                array_push($bodegas, $bodega);
            }
        }

        return $bodegas;
    }

    public function altaBodega()
    {
        $bodega = new Bodega();
        $conectar = new Conectar();
        $conexion = $conectar->conexion();

        try {
            $insert = $conexion->prepare("INSERT INTO `bodega` (`nombre`, `apellidos`, `email`, `telefono`) VALUES (?, ?, ?, ?)");
            $insert->bindParam(1, $_GET["nombre"]);
            $insert->bindParam(2, $_GET["localizacion"]);
            $insert->bindParam(3, $_GET["email"]);
            $insert->bindParam(4, $_GET["telefono"]);
            $insert->execute();
            
            $controlador = new bodegaController();
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
