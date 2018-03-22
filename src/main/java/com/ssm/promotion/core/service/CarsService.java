package com.ssm.promotion.core.service;

import com.ssm.promotion.core.entity.Cars;

import java.util.List;
import java.util.Map;


public interface CarsService {
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

/*	*//**
	 * 数据数目
	 * 
	 * @param map
	 * @return
	 *//*
	public Long getTotalArticle(Map<String, Object> map);

	*//**
	 * 添加文章
	 * 
	 * @param article
	 * @return
	 *//*
	public int addArticle(Article article);

	*//**
	 * 修改文章
	 * 
	 * @param article
	 * @return
	 *//*
	public int updateArticle(Article article);

	*//**
	 * 删除
	 * 
	 * @param id
	 * @return
	 *//*
	public int deleteArticle(String id);

	*//**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 *//*
	public Article findById(String id);*/
}
