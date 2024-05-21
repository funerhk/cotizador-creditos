package com.cotizador.entity.mapper;

import com.cotizador.entity.model.QuoterResponse;

public class QuoterMapper {
    public static QuoterResponse toDto(QuoterResponse response) {
        return new QuoterResponse(
                response.getNormalPayment(),
                response.getPunctualPayment()
        );
    }
}
