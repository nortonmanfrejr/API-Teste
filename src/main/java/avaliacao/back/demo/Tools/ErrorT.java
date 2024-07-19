package avaliacao.back.demo.Tools;

import avaliacao.back.demo.Exception.NotFoundException;

public class ErrorT {

    public ErrorT(){
        super();
    }

    //------------------------------------------------------------------------

    public NotFoundException BeneficiarioNotFound(Long id){
        return new NotFoundException(String.format("O Beneficiário %d não foi encontrado.", id));
    }
}
