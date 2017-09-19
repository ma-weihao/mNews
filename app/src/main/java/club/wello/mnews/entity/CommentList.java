package club.wello.mnews.entity;

import java.util.List;

/**
 * comments list
 * example: https://news-at.zhihu.com/api/4/story/9617915/long-comments
 * Created by maweihao on 2017/9/17.
 */

public class CommentList {

    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * author : 江北
         * content : 日报评论区现在的素质真是…… 不看完或没理解就评论的人，除了现身说法让大家理解你为什么穷（这一点，文章本身反而没讲，当然，标题的问题很大，编辑有一定责任）之外，还有什么意义？

         以后真是懒得看日报评论区，也奉劝和我有近似想法的人别看评论区了，只会让人恼火

         知乎本体虽然随着用户体量的扩大，也有向贴吧靠拢的趋势，但至少管理相对严格，屏蔽也好用……日报的打开频次已经不到过去的一半，希望日报的pm能够早点意识到现在用户增长的繁荣背后潜在的隐忧吧
         * avatar : http://pic2.zhimg.com/v2-df63cb50cfdd92520c9eeea9c870b215_im.jpg
         * time : 1505569917
         * id : 30266147
         * likes : 5
         */

        private String author;
        private String content;
        private String avatar;
        private long time;
        private int id;
        private int likes;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
    }
}
