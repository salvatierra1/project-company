package jardin.empresa.controller;

import jardin.empresa.DTO.EmpresaDTO;
import jardin.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping()
    public ResponseEntity<EmpresaDTO>save(@RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO>get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresaDTO>delete(@PathVariable Long id){
        empresaService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO>put(@PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.put(id, empresaDTO));
    }

}
