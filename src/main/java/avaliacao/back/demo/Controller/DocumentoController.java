package avaliacao.back.demo.Controller;

import avaliacao.back.demo.Model.Documento;
import avaliacao.back.demo.Service.DocumentoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/documentos")
@CrossOrigin(value = "*")
public class DocumentoController {

    private final DocumentoService serv;

    public DocumentoController(DocumentoService serv){
        this.serv = serv;
    }

    //------------------------------------------------------------------------

    @GetMapping("/{id}")
    public List<Documento> GetDocumentos(Long id){
        return serv.GetAllByBeneficiarioId(id);
    }
}
