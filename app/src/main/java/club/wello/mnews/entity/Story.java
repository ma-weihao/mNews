package club.wello.mnews.entity;

import java.util.List;

/**
 * story content
 * example: https://news-at.zhihu.com/api/4/news/9619437
 * Created by maweihao on 2017/9/16.
 */

public class Story {


    /**
     * images : ["https://pic3.zhimg.com/v2-ea1b75576f57495979eb45a1c398ad7a.jpg"]
     * type : 0
     * id : 9483544
     * ga_prefix : 092107
     * title : 希望你和家人，不是只在 9 月 21 号这天才关心这个病
     */

    private int type;
    private String id;
    private String ga_prefix;
    private String title;
    private List<String> images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
