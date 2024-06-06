package com.oauth.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Controller()
@Secured(SecurityRule.IS_ANONYMOUS)
@Slf4j
@Hidden
public class CoreController {

    @Get
    @View("home")
    public Map<String, Object> home(HttpRequest<?> httpRequest) {
        httpRequest.getAttribute("micronaut.TOKEN").ifPresent(token -> log.info("ACCESS TOKEN : " + token));
        return new HashMap<>();
    }

    @Get("/swagger")
    @View("swagger-ui/swagger")
    public HttpResponse<?> getSwagger() {
        return HttpResponse.ok();
    }
}