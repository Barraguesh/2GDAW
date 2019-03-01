<?php
    namespace AppBundle\Form;

    use Symfony\Component\Form\AbstractType;
    use Symfony\Component\Form\FormBuilderInterface;

    class OfertaType extends AbstractType {
        public function builderForm(FormBuilderInterface $builder, array $options){
            $builder
            ->add("name");
        }
    }