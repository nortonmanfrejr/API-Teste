package avaliacao.back.demo.Service;

import avaliacao.back.demo.Model.Beneficiario;
import avaliacao.back.demo.Model.Documento;
import avaliacao.back.demo.Repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    private final DocumentoRepository repo;

    public DocumentoService(DocumentoRepository repo){
        this.repo = repo;
    }

    //------------------------------------------------------------------------

    public List<Documento> GetAllByBeneficiarioId(Long id){
        return repo.GetAllByBeneficiario(id);
    }

    public List<Documento> GetAllByBeneficiario(Beneficiario ben){
        return GetAllByBeneficiarioId(ben.getId());
    }

    //------------------------------------------------------------------------

    public void Delete(Documento doc){
        repo.delete(doc);
    }
}
