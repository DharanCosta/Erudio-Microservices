package br.com.erudio.bookservice.response;

import java.io.*;
import java.math.*;
import java.util.*;

public class CambioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;

    private Double conversionFactor;
    private Double convertedValue;

    private String enviroment;

    public CambioDTO() {}

    public CambioDTO(Long id, String from, String to, Double conversionFactor, Double convertedValue, String enviroment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.enviroment = enviroment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CambioDTO cambio = (CambioDTO) o;
        return id.equals(cambio.id) && from.equals(cambio.from) && to.equals(cambio.to) && conversionFactor.equals(cambio.conversionFactor) && convertedValue.equals(cambio.convertedValue) && enviroment.equals(cambio.enviroment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, convertedValue, enviroment);
    }
}
