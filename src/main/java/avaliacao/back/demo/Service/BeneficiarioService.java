package avaliacao.back.demo.Service;

import avaliacao.back.demo.Model.Beneficiario;
import avaliacao.back.demo.Repository.BeneficiarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository repo;

    public BeneficiarioService(BeneficiarioRepository repo){
        this.repo = repo;
    }

    //------------------------------------------------------------------------

    public List<Beneficiario> FindAll(){
        return repo.findAll();
    }

    public Optional<Beneficiario> FindById(Long id){
        return repo.findById(id);
    }

    //------------------------------------------------------------------------

    public Beneficiario Create(Beneficiario obj){
        return repo.save(obj);
    }

    public void Update(Beneficiario obj){
        if (!repo.existsById(obj.getId())) return;
        repo.save(obj);
    }

    //------------------------------------------------------------------------

    public void Delete(Long id){
        repo.deleteById(id);
    }

}
