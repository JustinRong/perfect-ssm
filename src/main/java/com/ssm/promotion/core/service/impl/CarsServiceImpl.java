package com.ssm.promotion.core.service.impl;

import com.ssm.promotion.core.common.Constants;

import com.ssm.promotion.core.dao.CarsDao;

import com.ssm.promotion.core.entity.Cars;
import com.ssm.promotion.core.redis.RedisUtil;
import com.ssm.promotion.core.service.ArticleService;
import com.ssm.promotion.core.service.CarsService;
import com.ssm.promotion.core.util.AntiXssUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("CarsService")
public class CarsServiceImpl implements CarsService {

    private static final Logger log = Logger.getLogger(ArticleService.class);

    @Resource
    private CarsDao carsDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Cars> findCars(Map<String, Object> map) {
        return carsDao.findCars(map);
    }

    @Override
    public Long getTotalCars(Map<String, Object> map) {
        return carsDao.getTotalCars(map);
    }


}
