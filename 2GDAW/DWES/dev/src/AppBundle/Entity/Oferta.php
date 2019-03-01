<?php
    // src/Entity/Oferta.php
    namespace AppBundle\Entity;

    use Doctrine\ORM\Mapping as ORM;

    /**
    * @ORM\Entity(repositoryClass="AppBundle\Entity\OfertaRepository")
    * @ORM\Table(name="oferta")
    */
    class Oferta{

    /**
    * @ORM\Id
    * @ORM\Column(type="integer")
    */
    private $id;

    /**
    * @ORM\Column(type="string", length=255)
    */
    private $name;

    /**
    * Oferta constructor.
    * @param $id
    */
    public function __construct()
    {
    }

    /**
    * @return mixed
    */
    public function getId()
    {
    return $this->id;
    }

    /**
    * @param mixed $id
    */
    public function setId($id): void
    {
    $this->id = $id;
    }

    /**
    * @return mixed
    */
    public function getName()
    {
    return $this->name;
    }

    /**
    * @param mixed $name
    */
    public function setName($name): void
    {
    $this->name = $name;
    }
    public function __toString(){
        return $this->name;
    }

}