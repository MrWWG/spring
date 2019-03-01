package org.blueberry.springboot.service;


import org.blueberry.springboot.model.TbArticle;

/**
 * @author admin
 * @Title: TbArticleService
 * @ProjectName springboot
 * @Description: TODO
 * @date 2019-2-2515:25
 */
public interface TbArticleService {

    public int insert(TbArticle tbArticle);

    public TbArticle selectOne(long id);
}
