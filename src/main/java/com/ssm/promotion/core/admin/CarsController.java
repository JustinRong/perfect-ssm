package com.ssm.promotion.core.admin;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.Article;
import com.ssm.promotion.core.entity.Cars;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.service.ArticleService;
import com.ssm.promotion.core.service.CarsService;
import com.ssm.promotion.core.util.DateUtil;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/cars")
public class CarsController {
    @Resource
    private CarsService carsService;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(CarsController.class);// 日志文件

    /**
     * 查找相应的数据集合
     *
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/carid", method = RequestMethod.POST)
    public String list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Cars cars, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (cars != null) {
            //ToDo
           /* map.put("articleTitle",
                    StringUtil.formatLike(cars.getArticleTitle()))*/;
        }
        List<Cars> carsList = carsService.findCars(map);
        Long total = carsService.getTotalCars(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(carsList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: cars/list , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 查找相应的数据集合
     *
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Result list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Cars cars) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (cars != null) {
            /*map.put("articleTitle",
                    StringUtil.formatLike(article.getArticleTitle()))*/;
        }
        List<Cars> carsList = carsService.findCars(map);
        Long total = carsService.getTotalCars(map);

        Result result = ResultGenerator.genSuccessResult();
        Map data = new HashMap();
        data.put("rows", carsList);
        data.put("total", total);
        result.setData(data);
        return result;
    }

   /* *//**
     * 添加
     *
     * @param article
     * @return
     * @throws Exception
     *//*
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Article article)
            throws Exception {
        int resultTotal = 0;

        article.setArticleCreateDate(DateUtil.getCurrentDateStr());

        resultTotal = articleService.addArticle(article);

        log.info("request: article/save , " + article.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    *//**
     * 修改
     *
     * @param article
     * @return
     * @throws Exception
     *//*
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Article article)
            throws Exception {
        int resultTotal = 0;

        resultTotal = articleService.updateArticle(article);

        log.info("request: article/update , " + article.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    *//**
     * 删除
     *
     * @param ids
     * @return
     * @throws Exception
     *//*
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids) throws Exception {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            articleService.deleteArticle(idsStr[i]);
        }

        log.info("request: article/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    **/

    /**
     * 根据id查找
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@PathVariable("id") String id) throws Exception {
        //todo 需要将表改为明细表
        Cars cars = carsService.findById(id);
        Result result = ResultGenerator.genSuccessResult();
        result.setData(cars);
        log.info("request: cars/findById");
        return result;
    }
}