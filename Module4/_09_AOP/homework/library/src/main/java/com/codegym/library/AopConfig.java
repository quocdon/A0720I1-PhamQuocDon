package com.codegym.library;

import com.codegym.library.concern.BookLogger;
import com.codegym.library.concern.LibraryLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AopConfig {
    @Bean
    public BookLogger bookLogger() {
        return new BookLogger();
    }
    @Bean
    public LibraryLogger libraryLogger() {
        return new LibraryLogger();
    }
}
