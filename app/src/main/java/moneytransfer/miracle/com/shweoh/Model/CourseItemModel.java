package moneytransfer.miracle.com.shweoh.Model;

/**
 * Created by user on 5/23/17.
 */

public class CourseItemModel {

    private String name;
    private String url;
    private String description;


    public CourseItemModel() {
    }

    public CourseItemModel(String name, String url) {
        this.name = name;
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
