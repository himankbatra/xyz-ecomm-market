package com.sapient.XYZecommmarket.api.rest.resources;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Global error handler
 */
@RestController
public class ErrorHandlerResource implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Some unexpected error occurred";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}