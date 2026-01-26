package model;

public class Post {
    private int id;
    private String content;
    private String time;

    public Post(int id, String content, String time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public String getTime() { return time; }

    public void setContent(String content) {
        this.content = content;
    }
}
