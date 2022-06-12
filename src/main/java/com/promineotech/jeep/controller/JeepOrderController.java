package com.promineotech.jeep.controller;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Jeep Order Service"), servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@Validated
public interface JeepOrderController {
    @Operation(
            summary = "Returns an order for a Jeep",
            description = "Returns the created Jeep",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The created Jeep is returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Order.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Request parameters are invalid",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "A Jeep component was found with given criteria",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred",
                            content = @Content(mediaType = "application/json"))
            },
            parameters = {
                    @Parameter(
                            name = "orderRequest",
                            required = false,
                            description = "The order as JSON")
            }

    )

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Order createOrder(@Valid @RequestBody OrderRequest orderRequest);
}