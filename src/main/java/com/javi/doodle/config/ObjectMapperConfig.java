package com.javi.doodle.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Used to avoid sending null values in the json response
 */
@Configuration
@EnableWebMvc
public class ObjectMapperConfig implements WebMvcConfigurer {

   final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(jsonConverter);
    }

}
