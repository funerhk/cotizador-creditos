package com.cotizador.service.interfaces;

import com.cotizador.entity.dto.QuoterDto;
import com.cotizador.entity.model.QuoterResponse;

public interface QuoterService {
    QuoterResponse findPrice(QuoterDto dto);
}
