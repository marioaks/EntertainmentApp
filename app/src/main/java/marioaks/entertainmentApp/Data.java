package marioaks.entertainmentApp;

/**
 * Created by rajmehta on 2/23/16.
 */
public class Data {
    public String title;
    public int progress;
    public int imageId;
    public String percentNumber;
    public String date;

    Data(String title, String percentNumber, int progress, int imageId, String date) {
        this.title = title;
        this.imageId = imageId;
        this.progress = progress;
        this.percentNumber = percentNumber;
        this.date = date;
    }
}
