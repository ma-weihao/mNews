package club.wello.mnews.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import club.wello.mnews.R;
import club.wello.mnews.SettingsActivity;
import club.wello.mnews.adapter.NewsAdapter;
import club.wello.mnews.entity.News;
import club.wello.mnews.entity.NewsDao;
import club.wello.mnews.entity.Story;
import club.wello.mnews.listener.OnGetListener;
import club.wello.mnews.utils.HttpUtils;

/**
 * Fragment for the story list
 */


public class StoryListFragment extends Fragment {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.story_recycler)
    RecyclerView storyRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private NewsAdapter adapter;
    private LinearLayoutManager layoutManager;

    private ArrayList<Story> storyList;
    private News news;
    private Gson gson;
    private NewsDao newsDao;


    public StoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_list, container, false);
        ButterKnife.bind(this, view);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new NewsAdapter(getContext(), storyList);
        storyRecyclerView.setLayoutManager(layoutManager);
        storyRecyclerView.setAdapter(adapter);

        init();
        loadData();

        return view;
    }

    private void init() {
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favourite:
                        break;
                    case R.id.action_night_mode:
                        break;
                    case R.id.action_settings:
                        Intent intent = new Intent(getActivity(), SettingsActivity.class);
                        getActivity().startActivity(intent);
                }
                return true;
            }
        });
    }

    private void loadData() {
        HttpUtils.getNews(new OnGetListener() {
            @Override
            public void onNext(Object object) {
//                news = (News) object;
//                news.setJsonString(gson.toJson(news));
//                news.setCreatedTime(new Date().getTime());
//                newsDao.deleteAll();
//                newsDao.insert(news);
//                storyList.addAll(news.stories);
//                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
