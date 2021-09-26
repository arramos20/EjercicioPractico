package com.salesianos.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class initData {

    private final MonumentRepository repository;

    @PostConstruct
    public void init() {
        repository.saveAll(
                Arrays.asList(
                        new Monument("CO", "Colombia", "Bogotá", "1480, 928", "Monumento a las banderas", "Monumento creado para commemorar la creación de las naciones Pan-Americanas en torno a un anillo de columnas esculpidas, creado en una conferencia en 1948.","https://i.ytimg.com/vi/haJE07Haqxs/maxresdefault.jpg"),
                        new Monument("CM", "Camerún", "Duala", "-1090, 290", "Nachtigal", "Creado para commemorar al Doctor Gustav Nachtigal en 1886, médico militar y explorador de la África central y occidental.","https://upload.wikimedia.org/wikipedia/commons/b/b4/Monument_Gustave_Nachtigal_2.JPG")
                )
        );
    }
}
