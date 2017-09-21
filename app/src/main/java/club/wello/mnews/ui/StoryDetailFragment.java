package club.wello.mnews.ui;


import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import club.wello.mnews.R;
import club.wello.mnews.entity.NewsDetail;
import club.wello.mnews.entity.StoryExtra;
import club.wello.mnews.listener.OnGetListener;
import club.wello.mnews.utils.HttpUtils;

import static android.content.Context.MODE_PRIVATE;
import static club.wello.mnews.utils.Constants.PREFERENCE_NAME_STORY_DETAIL;


/**
 * story detail fragment
 */
public class StoryDetailFragment extends Fragment {

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.story_detail_image)
    ImageView storyDetailImage;
    @BindView(R.id.story_detail_title)
    TextView storyDetailDescription;
    @BindView(R.id.story_image_source)
    TextView imageSource;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.collect_iv)
    ImageView collectImageView;
    @BindView(R.id.share_iv)
    ImageView share;
    @BindView(R.id.like_tv)
    TextView like;
    @BindView(R.id.comment_tv)
    TextView comment;
    @BindView(R.id.header_image_layout)
    FrameLayout headerImageLayout;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeLayout;

    private SharedPreferences preferences;

    private String id;
    private String title;
    private String imageUrl;
    private int longCommentsCount;
    private int shortCommentsCount;
    private int likeCount;
    private int commentsCount;
    private boolean collected = false;
    private NewsDetail newsDetail;


    public StoryDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_detail, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        preferences = getActivity().getSharedPreferences(PREFERENCE_NAME_STORY_DETAIL, MODE_PRIVATE);
        id = bundle.getString("id");
        title = bundle.getString("title");
        imageUrl = bundle.getString("image");

        initToolbar();
        initWebView();
        getData();
        return view;
    }

    private void initToolbar() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        toolbar.setTitle(title);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                Toast.makeText(getActivity(), "uncompleted!", Toast.LENGTH_SHORT).show();
            }
        });
        collectImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                Toast.makeText(getActivity(), "uncompleted!", Toast.LENGTH_SHORT).show();
            }
        });
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                Toast.makeText(getActivity(), "uncompleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initWebView() {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                swipeLayout.setRefreshing(true);
                if (newProgress == 100) {
                    swipeLayout.setRefreshing(false);
                }
            }
        });
    }

    private void getData() {
        HttpUtils.getStoryExtra(id, new OnGetListener() {
            @Override
            public void onNext(Object object) {
                StoryExtra storyExtra = (StoryExtra) object;
                longCommentsCount = storyExtra.getLong_comments();
                shortCommentsCount = storyExtra.getShort_comments();
                commentsCount = storyExtra.getComments();
                likeCount = storyExtra.getPopularity();
                like.setText(String.valueOf(likeCount));
                comment.setText(String.valueOf(commentsCount));
            }
        });

        HttpUtils.getNewsDetail(id, new OnGetListener() {
            @Override
            public void onNext(Object object) {
                newsDetail = (NewsDetail) object;
                if (newsDetail.getImage() != null) {
                    SimpleTarget<Bitmap> target = new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            storyDetailImage.setImageBitmap(resource);
                            storyDetailDescription.setText(newsDetail.getTitle());
                            imageSource.setText(newsDetail.getImage_source());
                        }
                    };
                    Glide.with(getActivity())
                            .load(newsDetail.getImage() == null ? newsDetail.getImages() : newsDetail.getImage())
                            .asBitmap()
                            .into(target);
                } else {
                    storyDetailDescription.setTextColor(Color.BLACK);
                    storyDetailDescription.setText(newsDetail.getTitle());
                }

                String body = newsDetail.getBody();
                body = body.substring(body.indexOf("<div class=\"question\">"));
                final String webContent = "<!DOCTYPE html>" +
                        "<html>" +
                        "<head><meta charset=\"UTF-8\"><link rel=\"stylesheet\" href=\"style.css\"></head>" +
                        "<body>" + body + "</body>" +
                        "</html>";
                webView.loadDataWithBaseURL("file:///android_asset/", webContent, "authorText/html", "UTF-8", null);
            }
        });
    }
}
