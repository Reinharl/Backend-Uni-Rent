package com.unirent.controller;

import com.unirent.entity.Customer;
import com.unirent.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/customers")
@CrossOrigin("http://localhost:5173")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    @Qualifier("openaiRestTemplate")
    private RestTemplate restTemplate;

    @PostMapping("/matchmaking")
    public ResponseEntity<Optional<Customer>> matchmaking(@RequestBody String description) {

        String prompt =
                "Rispondimi SOLAMENTE! indicando l'id del'utente che secondo te è più adatto a vivere con me rispetto ai nostri interessi.\n" +
                        "Gli utenti sono così organizzati e descritti: (id: interesse, interesse, ...) e sono:\n" +
                        customerService.findAllLodgerAndInterests() +
                        "\nL'utente cerca: " +
                        description +
                        "\nVoglio che la risposta sia così organizzata: Id(id che hai scelto) e subito a capo il perché spiegato brevemente";

        String chatUrl = "http://localhost:8080/chat?prompt=" + prompt;

        log.info(prompt);

        try {
            String chatResponse = restTemplate.getForObject(chatUrl, String.class);

            log.info(chatResponse);

            Long id = customerService.findFirstNumberInResponse(chatResponse);

            Optional<Customer> customer = customerService.findById(id);
            if (customer.isPresent()) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Optional.empty());
            }
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Optional.empty());
        }
    }
}
