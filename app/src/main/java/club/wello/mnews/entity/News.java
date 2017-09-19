package club.wello.mnews.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;

/**
 * entity class for GreenDao
 * Created by maweihao on 2017/9/16.
 */
@Entity
public class News {
    @Property
    public String date;
    @Property
    private String jsonString;
    @Property
    private Long createdTime;

    @Transient
    public ArrayList<Story> stories;
    @Transient
    public ArrayList<TopStory> top_stories;
    @Generated(hash = 1726809169)
    public News(String date, String jsonString, Long createdTime) {
        this.date = date;
        this.jsonString = jsonString;
        this.createdTime = createdTime;
    }
    @Generated(hash = 1579685679)
    public News() {
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getJsonString() {
        return this.jsonString;
    }
    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }
    public Long getCreatedTime() {
        return this.createdTime;
    }
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }
}
