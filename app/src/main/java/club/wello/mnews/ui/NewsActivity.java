package club.wello.mnews.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import club.wello.mnews.R;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.story_detail_frame_layout)
    FrameLayout frameLayout;

    private SharedPreferences sharedPreferences;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        initFragment(getIntent().getExtras());
    }

    private void initFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StoryDetailFragment storyFragment = new StoryDetailFragment();
        storyFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.story_detail_frame_layout, storyFragment, "storyFragment");
        fragmentTransaction.commit();
    }
}
