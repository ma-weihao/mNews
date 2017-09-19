package club.wello.mnews.api;

import java.util.HashMap;

import club.wello.mnews.entity.CommentList;
import club.wello.mnews.entity.News;
import club.wello.mnews.entity.NewsDetail;
import club.wello.mnews.entity.StoryExtra;
import club.wello.mnews.entity.ThemeList;
import club.wello.mnews.entity.ThemeStory;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * retrofit entity class
 * Created by maweihao on 2017/9/17.
 */

public interface ZhihuApi {

    @GET("news/latest")
    Observable<News> getNews();

    @GET("news/{id}")
    Observable<NewsDetail> getNewsDetail(@Path("id") String id);

    @GET("news/before/{date}")
    Observable<News> getBeforeNews(@Path("date") String date);

    @GET("story-extra/{id}")
    Observable<StoryExtra> getStoryExtra(@Path("id") String id);

    @GET("story/{id}/long-comments")
    Observable<CommentList> getLongComment(@Path("id") String id);

    @GET("story/{id}/short-comments")
    Observable<CommentList> getShortComment(@Path("id") String id);

    @GET("themes")
    Observable<ThemeList> getThemesList();

    @GET("theme/{id}")
    Observable<ThemeStory> getThemesStory(@Path("id") String id);

//    @GET("users/show.json")
//    Observable<User> getUserInfo(@QueryMap HashMap<String, String> params);
}
