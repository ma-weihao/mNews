package club.wello.mnews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import club.wello.mnews.R;
import club.wello.mnews.entity.Story;
import club.wello.mnews.utils.ImageLoaderUtils;

/**
 * recycler adapter for news list
 * Created by maweihao on 2017/9/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private ArrayList<Story> storyList;
    private Context context;

    public NewsAdapter(@NonNull Context context, ArrayList<Story> storyList) {
        this.storyList = storyList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.title.setText(story.getTitle());
        ImageLoaderUtils.load(context, story.getImage(), null, null, holder.image);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.news_image_iv);
            title = (TextView) itemView.findViewById(R.id.news_title_tv);
        }
    }
}
