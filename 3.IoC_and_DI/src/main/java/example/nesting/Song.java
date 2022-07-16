package example.nesting;

import lombok.ToString;

@ToString
public class Song {
    private String title;
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
