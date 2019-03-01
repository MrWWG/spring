package org.blueberry.springboot.service.Impl;/**
 * @Title: TbArticleServiceImpl
 * @ProjectName springboot
 * @Description: TODO
 * @author admin
 * @date 2019-2-2515:26
 */

import com.alibaba.dubbo.config.annotation.Service;
import org.blueberry.springboot.mapper.TbArticleMapper;
import org.blueberry.springboot.model.TbArticle;
import org.blueberry.springboot.service.TbArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


/**
 * @program: springboot
 *
 * @description:
 *
 * @author: wwg
 *
 * @create: 2019-02-25 15:26
 **/
@Service(version = "1.0.0")
public class TbArticleServiceImpl implements TbArticleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TbArticleServiceImpl.class);

    @Autowired
    private TbArticleMapper tbArticleMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int insert(TbArticle tbArticle) {
        return tbArticleMapper.insert(tbArticle);
    }

    @Override
    public TbArticle selectOne(long id) {

        LOGGER.info("调用服务端的服务-----------》selectOne");
        String key = "TbArticle_" +id;
        ValueOperations<String, TbArticle> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey){
            TbArticle tbArticle = operations.get(key);
            LOGGER.info("从缓存获取-----------------------》" + tbArticle);
            return tbArticle;
        }

        TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(id);
        LOGGER.info("插入缓存-----------------------》" + tbArticle);
        operations.set(key, tbArticle);
        return tbArticle;
    }
}
