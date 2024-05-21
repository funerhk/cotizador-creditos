package com.cotizador.entity.dto;

public record QuoterDto(
        String SKU,
        String name,
        String description,
        Integer price,
        String deadLineId,
        String deadline,
        String normalInterest,
        String punctualInterest
) { }
