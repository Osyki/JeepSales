package com.promineotech.jeep.dao;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DefaultJeepSalesDao implements JeepSalesDao{
    @Override
    public List<Jeep> fetchJeeps(JeepModel model, String trim) {
        log.info("DAO: model={},trim={}", model, trim);
        return null;
    }
}
