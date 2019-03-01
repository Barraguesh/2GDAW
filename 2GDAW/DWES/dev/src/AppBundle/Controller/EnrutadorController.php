<?php

namespace AppBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\Request;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Template;
use AppBundle\Entity\Oferta;
use AppBundle\Form\OfertaType;


    /**
     * @Route("/enrutador")
     */
class EnrutadorController extends Controller
{
    /**
     * @Route("/", name="enrutador")
     * @Template
     */
    public function indexAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $doc = $this->getDoctrine()->getManager()->getRepository("AppBundle:Oferta");
        $oferta = $doc->find(1);
        $oferta->setName("Nuevo");
        $em->flush();
        return array();        
    }

    /**
     * @Route("/newOferta", name="newOferta")
     * @Template
     */
    public function newOferta(){
        $oferta = new Oferta();
        $form = $this->ofertaBuilder($oferta);
        return array("form" => $form->createView());
    }

     /**
     * @Route("/newOferta", name="createOferta")
     */
    public function createOferta(){
        
    }

    private function ofertaBuilder(Oferta $oferta){
        $form = $this->createForm(OfertaType::class, array(
            "action"=> $this->generateUrl("createOferta"),
            "method" => "POST"
        ));
        return $form;
    }
}
