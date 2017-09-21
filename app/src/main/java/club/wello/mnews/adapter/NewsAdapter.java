package club.wello.mnews.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import club.wello.mnews.R;
import club.wello.mnews.entity.Story;
import club.wello.mnews.listener.RefreshListener;
import club.wello.mnews.ui.NewsActivity;
import club.wello.mnews.utils.Constants;
import club.wello.mnews.utils.ImageLoaderUtils;

/**
 * recyclerView adapter for news list
 * Created by maweihao on 2017/9/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private static final String TAG = NewsAdapter.class.getSimpleName();

    private ArrayList<Story> storyList;
    private Context context;
    private SharedPreferences sharedPreferences;
    private boolean dualPane;

    public NewsAdapter(@NonNull Context context, ArrayList<Story> storyList, boolean dualPane) {
        this.storyList = storyList;
        this.context = context;
        this.dualPane = dualPane;
        sharedPreferences = context.getSharedPreferences(Constants.SAVE_FILE_NAME, Activity.MODE_PRIVATE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Story story = storyList.get(position);
        if (sharedPreferences.getBoolean(story.getId(), false)) {
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.item_selected_color));
        } else {
            Resources.Theme theme = context.getTheme();
            TypedValue customTextColor = new TypedValue();//自定义字体颜色
            theme.resolveAttribute(R.attr.customTextColor, customTextColor, true);
//            holder.title.setTextColor(context.getResources().getColor(customTextColor.resourceId));
        }
        holder.title.setText(story.getTitle());
        if (story.getImages().size() != 0) {
            ImageLoaderUtils.load(context, story.getImages().get(0), null, null, holder.image);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(story.getId(), true);
                editor.apply();
                holder.title.setTextColor(ContextCompat.getColor(context, R.color.item_selected_color));

                if (dualPane) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.MAIN_TO_STORY_DETAIL_INTENT_KEY_ID, story.getId());
                    bundle.putString("title", story.getTitle());
                    bundle.putString("image", story.getImages().get(0));
                    ((RefreshListener) context).refreshData(bundle);
                } else {
                    Intent intent = new Intent(context, NewsActivity.class);
                    intent.putExtra(Constants.MAIN_TO_STORY_DETAIL_INTENT_KEY_ID, story.getId());
                    intent.putExtra("title", story.getTitle());
                    intent.putExtra("image", story.getImages().get(0));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image;
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.news_image_iv);
            title = itemView.findViewById(R.id.news_title_tv);
            cardView = itemView.findViewById(R.id.story_card);
        }
    }
}
