package com.oauth.controller;

import com.oauth.core.openapi.ApiPayloads;
import com.oauth.core.openapi.ApiSecuritySchemes;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@Controller("/auth")
@Secured(SecurityRule.IS_AUTHENTICATED)
@Slf4j
public class PubController {

    @Get()
    @ApiPayloads
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            summary = "Test Authentication",
            description = "Test Authentication",
            security = @SecurityRequirement(
                    name = ApiSecuritySchemes.JWT_SECURITY_SCHEME))
    @ApiResponse(
            responseCode = "200",
            description = "Operation Successful",
            content = @Content(
                    mediaType = MediaType.TEXT_PLAIN,
                    schema = @Schema(implementation = String.class)))
    public String testAuthentication() {
        return "Authentication working...";
    }
}
