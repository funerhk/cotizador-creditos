package com.cotizador.service.implementation;

import com.cotizador.entity.dto.QuoterDto;
import com.cotizador.entity.mapper.QuoterMapper;
import com.cotizador.entity.model.QuoterResponse;
import com.cotizador.exception.QuoterNotFoundException;
import com.cotizador.service.interfaces.QuoterService;
import com.cotizador.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuoterServiceImpl implements QuoterService {
    @Override
    public QuoterResponse findPrice(QuoterDto dto) {

        if (dto == null) {
            throw new QuoterNotFoundException(Message.QUOTER_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        } else if (dto.SKU() == null) {
            throw new QuoterNotFoundException(Message.QUOTER_SKU_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        } else if (dto.price() == null) {
            throw new QuoterNotFoundException(Message.QUOTER_PRICE_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        } else if (dto.deadLineId() == null) {
            throw new QuoterNotFoundException(Message.QUOTER_DEADLINEID_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        } else if (dto.deadline() == null) {
            throw new QuoterNotFoundException(Message.QUOTER_DEADLINE_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        } else if (dto.normalInterest() == null) {
            throw new QuoterNotFoundException(Message.QUOTER_NORMAL_INTEREST_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        } else if (dto.punctualInterest() == null) {
            throw new QuoterNotFoundException(Message.QUOTER_PUNCTUAL_INTEREST_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        }

        QuoterResponse response = new QuoterResponse();
        response.setNormalPayment(normalPay(dto.price(), dto.deadline()));
        response.setPunctualPayment(punctualPay(dto.price(), dto.deadline()));

        return QuoterMapper.toDto(response);
    }

    public Double normalPay(Integer price, String deadLine) {
        return ((price * Message.NORMAL_INTEREST) + price) / Double.parseDouble(deadLine);
    }

    public Double punctualPay(Integer price, String deadLine) {
        return ((price * Message.PUNCTUAL_INTEREST) + price) / Double.parseDouble(deadLine);
    }

}
