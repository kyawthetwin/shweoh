package moneytransfer.miracle.com.shweoh.Model;

import java.util.ArrayList;

/**
 * Created by user on 5/23/17.
 */

public class CourseDataModel {
    private String headerTitle;
    private ArrayList<CourseItemModel> allItemsInSection;


    public CourseDataModel() {

    }
    public CourseDataModel(String headerTitle, ArrayList<CourseItemModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<CourseItemModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<CourseItemModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
