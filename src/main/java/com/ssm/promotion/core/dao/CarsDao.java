package com.ssm.promotion.core.dao;

import com.ssm.promotion.core.entity.Cars;

import java.util.List;
import java.util.Map;

public interface CarsDao {
	/**
	 * 返回相应的数据集合
	 * 
	 * @param map
	 * @return
	 */
	public List<Cars> findCars(Map<String, Object> map);

	/**
	 * 数据数目
	 *
	 * @param map
	 * @return
	 */
	public Long getTotalCars(Map<String, Object> map);


}
