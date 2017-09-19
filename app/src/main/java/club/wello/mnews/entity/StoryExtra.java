package club.wello.mnews.entity;

/**
 * story extra like comments
 * example: https://news-at.zhihu.com/api/4/story-extra/9617915
 * Created by maweihao on 2017/9/17.
 */

public class StoryExtra {

    /**
     * long_comments : 4
     * popularity : 473
     * short_comments : 44
     * comments : 48
     */

    private int long_comments;
    private int popularity;
    private int short_comments;
    private int comments;

    public int getLong_comments() {
        return long_comments;
    }

    public void setLong_comments(int long_comments) {
        this.long_comments = long_comments;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getShort_comments() {
        return short_comments;
    }

    public void setShort_comments(int short_comments) {
        this.short_comments = short_comments;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}
