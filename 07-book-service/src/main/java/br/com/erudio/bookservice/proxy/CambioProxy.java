package br.com.erudio.bookservice.proxy;

import br.com.erudio.bookservice.response.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;

@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface CambioProxy {

    @GetMapping(value = "cambio-service/{amount}/{from}/{to}")
    public CambioDTO getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from")String from,
            @PathVariable("to") String to );

}
