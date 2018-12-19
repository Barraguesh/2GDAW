<?php
class Empleado
{
    private $nombre;
    private $apellidos;
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
     * Get the value of apellidos
     */
    public function getApellidos()
    {
        return $this->apellidos;
    }

    /**
     * Set the value of apellidos
     *
     * @return  self
     */
    public function setApellidos($apellidos)
    {
        $this->apellidos = $apellidos;

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

    public function cargarEmpleados()
    {
        require_once "controller/EmpleadoController.php";

        $conectar = new Conectar();
        $conexion = $conectar->conexion();
        $empleados = [];

        $select = $conexion->prepare("select * from Empleados");
        $select->execute();


        if ($select->rowCount() != 0) {
            while ($fila = $select->fetchObject()) {
                $empleado = new Empleado();
                $empleado->setNombre($fila->nombre);
                $empleado->setApellidos($fila->apellidos);
                $empleado->setEmail($fila->email);
                $empleado->setTelefono($fila->telefono);
                array_push($empleados, $empleado);
            }
        }

        return $empleados;
    }

    public function altaEmpleado()
    {
        $empleado = new Empleado();
        $conectar = new Conectar();
        $conexion = $conectar->conexion();
        try {
            $insert = $conexion->prepare("INSERT INTO `Empleados` (`nombre`, `apellidos`, `email`, `telefono`) VALUES (?, ?, ?, ?)");
            $insert->bindParam(1, $_GET["nombre"]);
            $insert->bindParam(2, $_GET["apellidos"]);
            $insert->bindParam(3, $_GET["email"]);
            $insert->bindParam(4, $_GET["telefono"]);
            $insert->execute();
            
            $controlador = new EmpleadoController();
            $controlador->carga();
        } catch (PDOException $e) {
            echo "No se ha podido introducir el usuario.<br/>";
            echo $e;
        }
    }
}
