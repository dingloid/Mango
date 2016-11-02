package foogle.infomango;

public class Post {

    private String title;
    private String message;

    public Post(){
        title = "";
        message = "";
    }

    public Post(String t, String m) {
        setTitle(t);
        setMessage(m);
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setMessage(String m) {
        message = m;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }
}
