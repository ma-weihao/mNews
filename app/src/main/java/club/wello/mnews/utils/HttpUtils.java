package club.wello.mnews.utils;

import android.util.Log;

import club.wello.mnews.api.ZhihuApi;
import club.wello.mnews.entity.CommentList;
import club.wello.mnews.entity.News;
import club.wello.mnews.entity.NewsDetail;
import club.wello.mnews.entity.StoryExtra;
import club.wello.mnews.entity.ThemeList;
import club.wello.mnews.entity.ThemeStory;
import club.wello.mnews.listener.OnGetListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * utility class for network
 * Created by ma on 17-8-11.
 */

public class HttpUtils {

    public static final String TAG = HttpUtils.class.getSimpleName();

    private static ZhihuApi zhihuApi;

    private static ZhihuApi getAPIService() {
        if (zhihuApi == null){
            String storyBaseUrl = "http://news-at.zhihu.com/api/4/";
            zhihuApi = getService(storyBaseUrl).create(ZhihuApi.class);
        }
        return zhihuApi;
    }

    private static Retrofit getService(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Observable<News> getNews() {
        return getAPIService().getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void getNews(final OnGetListener listener) {
        getAPIService().getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<News>() {
                    @Override
                    public void accept(News news) throws Exception {
                        listener.onNext(news);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch news failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch news succeeded");
                    }
                });
    }

    public static Observable<NewsDetail> getNewsDetail(String id) {
        return getAPIService().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void getNewsDetail(String id, final OnGetListener listener) {
        getAPIService().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsDetail>() {
                    @Override
                    public void accept(NewsDetail newsDetail) throws Exception {
                        listener.onNext(newsDetail);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch news detail failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch news detail succeeded");
                    }
                });
    }

    public static Observable<News> getBeforeNews(String date) {
        return getAPIService().getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void getBeforeNews(String date, final OnGetListener listener) {
        getAPIService().getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<News>() {
                    @Override
                    public void accept(News news) throws Exception {
                        listener.onNext(news);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch news history failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch news history succeeded");
                    }
                });
    }

    public static void getStoryExtra(String id, final OnGetListener listener) {
        getAPIService().getStoryExtra(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StoryExtra>() {
                    @Override
                    public void accept(StoryExtra storyExtra) throws Exception {
                        listener.onNext(storyExtra);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch news extra failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch news extra succeeded");
                    }
                });
    }

    public static void getLongComment(String id,final OnGetListener listener) {
        getAPIService().getLongComment(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommentList>() {
                    @Override
                    public void accept(CommentList commentList) throws Exception {
                        listener.onNext(commentList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch long comment failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch long comment succeeded");
                    }
                });
    }

    public static void getShortComment(String id, final OnGetListener listener) {
        getAPIService().getShortComment(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommentList>() {
                    @Override
                    public void accept(CommentList commentList) throws Exception {
                        listener.onNext(commentList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch short comment failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch short comment succeeded");
                    }
                });
    }

    public static void getThemesList(final OnGetListener listener) {
        getAPIService().getThemesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ThemeList>() {
                    @Override
                    public void accept(ThemeList themeList) throws Exception {
                        listener.onNext(themeList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch theme list failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch theme list succeeded");
                    }
                });
    }

    public static Observable<ThemeStory> getThemeStory(String id) {
        return getAPIService().getThemesStory(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void getThemeStory(String id, final OnGetListener listener) {
        getAPIService().getThemesStory(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ThemeStory>() {
                    @Override
                    public void accept(ThemeStory themeStory) throws Exception {
                        listener.onNext(themeStory);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: fetch theme story failed " + throwable.getLocalizedMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: fetch theme story succeeded");
                    }
                });
    }
}
