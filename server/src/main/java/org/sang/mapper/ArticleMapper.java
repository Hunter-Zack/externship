package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Article;

import java.util.List;


@Mapper
public interface ArticleMapper {
    int addNewArticle(Article article);

    int updateArticle(Article article);

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid, @Param("keywords") String keywords, @Param("keyname") String keyname, @Param("keycat") String keycat);


    List<Article> getArticleByStateByAdmin(@Param("start") int start, @Param("count") Integer count, @Param("keywords") String keywords);
    List<Article> getArticleByCompany(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid, @Param("keywords") String keywords, @Param("keyname") String keyname, @Param("keycat") String keycat, @Param("upracticecompany") String upracticecompany);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

    int getArticleCountByStatePra(@Param("state") Integer state, @Param("upracticecompany") String upracticecompany, @Param("keywords") String keywords);

    int updateArticleState(@Param("aids") Long aids[], @Param("state") Integer state);

    int deleteArticleById(@Param("aids") Long[] aids);

    Article getArticleById(Long aid);

    void pvIncrement(Long aid);

    //INSERT INTO pv(countDate,pv,uid) SELECT NOW(),SUM(pageView),uid FROM article GROUP BY uid
    void pvStatisticsPerDay();

    List<String> getCategories();

    List<Integer> getDataStatistics();

    int getArticleCounts(@Param("cid") int cid,@Param("upracticecompany") String upracticecompany);
    Integer getDataArticlesT(@Param("week") String week,@Param("upracticecompany") String upracticecompany);
    Integer getDataArticlesP(@Param("week") String week,@Param("upracticecompany") String upracticecompany);
    Integer getDataArticlesE(@Param("week") String week,@Param("upracticecompany") String upracticecompany);
}