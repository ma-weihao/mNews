package club.wello.mnews.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import club.wello.mnews.R;
import club.wello.mnews.listener.RefreshListener;

public class MainActivity extends AppCompatActivity implements RefreshListener {

    @BindView(R.id.story_list_fragment)
    FrameLayout storyList;

    private static final String TAG = MainActivity.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private RefreshListener refreshListener;
    private boolean dualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View detailsFrame = findViewById(R.id.story_detail_frame_layout);
        dualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        ButterKnife.bind(this);

        initFragment();
    }

    private void initFragment() {
        Bundle bundle = new Bundle();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StoryListFragment storyListFragment = new StoryListFragment();
        bundle.putBoolean("dual_pane", dualPane);
        storyListFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.story_list_fragment, storyListFragment, "storyListFragment");
        fragmentTransaction.commit();
        // init story detail fragment for land-large-screen devices
        if (dualPane) {
            FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
            StoryDetailFragment storyFragment = new StoryDetailFragment();
            refreshListener = storyFragment;
//            storyFragment.setArguments(bundle);
            fragmentTransaction2.replace(R.id.story_detail_frame_layout, storyFragment, "storyFragment");
            fragmentTransaction2.commit();
        }
    }

    @Override
    public void refreshData(Bundle bundle) {
        Log.d(TAG, "refreshData: ");
        if (dualPane) {
            refreshListener.refreshData(bundle);
        }
    }
}
