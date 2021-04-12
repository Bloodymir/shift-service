package com.vladimiro.shift.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladimiro.shift.provider.resource.ShiftResourceApi;
import feign.Feign;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {

    @Value("${shift-resource.url}")
    private String shiftResourceUrl;

    @Bean
    public ShiftResourceApi shiftResourceApi(ObjectMapper objectMapper) {
        ObjectFactory<HttpMessageConverters> objectFactory =
                () -> new HttpMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper));

        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new ResponseEntityDecoder(new SpringDecoder(objectFactory)))
                .target(ShiftResourceApi.class, shiftResourceUrl);
    }
}
