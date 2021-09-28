package com.salesianos.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controler + ResponseBody
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentRepository repository;

    @GetMapping("/")
    public List<Monument> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Monument findOne(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    //Si devolvemos el mismo tipo de objeto, usamos un 200;
    // Si no, usamos ResponseEntity para mandar un 201 para el creado exitosamente
    @PostMapping("/")
    public ResponseEntity<Monument> create(@RequestBody Monument monument){
        //return repository.save(monumento);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(monument));
    }

    @PutMapping("/{id}")
    public Monument edit(@RequestBody Monument monument, @PathVariable Long id){

        Monument antiguo = repository.findById(id).orElse(monument);

        antiguo.setCountryCode(monument.getCountryCode());
        antiguo.setCountryName(monument.getCountryName());
        antiguo.setCityName(monument.getCityName());
        antiguo.setLocalization(monument.getLocalization());
        antiguo.setMonumentName(monument.getMonumentName());
        antiguo.setMonumentDescription(monument.getMonumentDescription());
        antiguo.setPhotoURL(monument.getPhotoURL());

        return repository.save(antiguo);
    }

    /*
        @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(
            @RequestBody Monumento e,
            @PathVariable Long id) {

        return ResponseEntity.of(
            repository.findById(id).map(m -> {
               m.setCodigoPais(e.getCodigoPais());
               m.setPais(e.getPais());
               m.setCiudad(e.getCiudad());
               m.setDescripcion(e.getDescripcion());
               m.setLoc(e.getLoc());
               m.setNombre(e.getNombre());
               m.setUrlImagen(e.getUrlImagen());
               repository.save(m);
               return m;
            })
        );
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
        //return ResponseEntity.status(204).build();
    }
}
