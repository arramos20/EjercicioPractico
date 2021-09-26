package com.salesianos.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controler + ResponseBody
@RequestMapping("/task")
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentRepository repository;

    @GetMapping("/monumento")
    public List<Monument> findAll() {
        return repository.findAll();
    }

    @GetMapping("/monumento/{id}")
    public Monument findOne(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/monumento")
    public ResponseEntity<Monument> create(@RequestBody Monument monument){
        //return repository.save(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(monument));
    }

    @PutMapping("/monumento/{id}")
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

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
        //return ResponseEntity.status(204).build();
    }


}
