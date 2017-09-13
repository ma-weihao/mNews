package club.wello.mnews.utils.api;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


/**
 * entity class for retrofit
 * Created by ma on 17-8-11.
 */

public interface ZhihuApi {

    @GET("start-image/480*800")
    Observable<String> getWelcomeImage();

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

    @GET("users/show.json")
    Observable<User> getUserInfo(@QueryMap HashMap<String, String> params);
}
