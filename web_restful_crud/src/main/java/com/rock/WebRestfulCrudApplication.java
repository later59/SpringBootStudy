package com.rock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class WebRestfulCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebRestfulCrudApplication.class, args);
    }

    @Bean
    public ViewResolver myViewResolver() {
        return new myViewResolver();
    }

   /* @Bean
    public myGenericConverter myGenericConverter() {
        return new myGenericConverter();
    }*/

    private static class myViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

    /*private static class myGenericConverter implements GenericConverter {
        @Override
        public Set<ConvertiblePair> getConvertibleTypes() {
            return null;
        }

        @Override
        public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
            return null;
        }
    }*/
}
