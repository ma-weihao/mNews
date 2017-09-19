package club.wello.mnews.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

import club.wello.mnews.R;

/**
 * utils class for loading image
 * Created by maweihao on 2017/9/18.
 */

public class ImageLoaderUtils {

    public static void load(Context context, String url, @Nullable Drawable placeholder, @Nullable Drawable error, ImageView view) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(placeholder)
                .error(error)
                .into(view);
    }

    public static void load(Context context, String url, int placeholder, ImageView view) {
        if (url.endsWith(".gif")) {
            Glide.with(context)
                    .load(url)
                    .asGif()
                    .placeholder(R.drawable.message_image_default)
                    .into(view);

        } else {
            Glide.with(context)
                    .load(url)
                    .placeholder(placeholder)
                    .into(view);
        }
    }

    public static void load(Context context, String url, @Nullable Drawable placeholder, @Nullable Drawable error, SimpleTarget<Bitmap> target) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(placeholder)
                .error(error)
                .into(target);
    }
}
