package avaliacao.back.demo.Controller;

import avaliacao.back.demo.Model.Beneficiario;
import avaliacao.back.demo.Service.BeneficiarioService;
import avaliacao.back.demo.Service.DocumentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/beneficiarios")
@CrossOrigin(value = "*")
public class BeneficiarioController {

    private final BeneficiarioService serv;
    private final DocumentoService docServ;

    public BeneficiarioController(BeneficiarioService serv, DocumentoService docServ){
        this.serv = serv;
        this.docServ = docServ;
    }

    //------------------------------------------------------------------------
    // GET

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Beneficiario> FindAll(){
        return serv.FindAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Beneficiario> FindById(@PathVariable Long id){
        return serv.FindById(id);
    }

    //------------------------------------------------------------------------
    // DELETE

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Delete(@PathVariable Long id){

        serv.Delete(id);
    }


    //------------------------------------------------------------------------
    // POST/PUT

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void Update(@RequestBody Beneficiario obj, @PathVariable Long id){

        Beneficiario origObj = serv.FindById(id).orElse(new Beneficiario());
        if (origObj.getId() == null) return;

        // ----------------------------------------------
        // Campos não alteráveis
        obj.setId(origObj.getId());
        obj.setDataInclusao(origObj.getDataInclusao());
        obj.setDataAtualizacao(LocalDate.now());

        // ----------------------------------------------
        // Campos alteráveis
        if (obj.getDataNascimento() != origObj.getDataNascimento()) obj.setDataNascimento(origObj.getDataNascimento());
        if (!obj.getNome().equals(origObj.getNome())) obj.setNome(origObj.getNome());
        if (!obj.getTelefone().equals(origObj.getTelefone())) obj.setTelefone(origObj.getTelefone());

        // ----------------------------------------------
        serv.Update(obj);
    }

}
