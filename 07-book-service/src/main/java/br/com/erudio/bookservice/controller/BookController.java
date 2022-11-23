package br.com.erudio.bookservice.controller;

import br.com.erudio.bookservice.model.*;
import br.com.erudio.bookservice.proxy.*;
import br.com.erudio.bookservice.repository.*;
import br.com.erudio.bookservice.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

@RestController
@RequestMapping("book-service")
public class BookController {
    @Autowired
    private Environment environment;

    @Autowired
    private CambioProxy cambioProxy;

    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ){
        var book = repository.getReferenceById(id);
        if (book == null) throw  new RuntimeException("Book not Found");

        var cambio = cambioProxy.getCambio(book.getPrice(),"USD", currency);

        String port = environment.getProperty("local.server.port");
        book.setEnviroment(port + " FEIGN");
        book.setPrice(cambio.getConvertedValue());

        return book;
    }
//    @GetMapping(value = "/{id}/{currency}")
//    public Book findBook(
//            @PathVariable("id") Long id,
//            @PathVariable("currency") String currency
//    ){
//        var book = repository.getReferenceById(id);
//        if (book == null) throw  new RuntimeException("Book not Found");
//
//        HashMap<String, String> params = new HashMap<>();
//        params.put("amount", book.getPrice().toString());
//        params.put("from", "USD");
//        params.put("to",currency);
//        ResponseEntity<CambioDTO> response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
//                CambioDTO.class, params);
//        var cambio = response.getBody();
//
//        String port = environment.getProperty("local.server.port");
//        book.setEnviroment(port);
//        book.setPrice(cambio.getConvertedValue());
//
//        return book;
//    }
}
