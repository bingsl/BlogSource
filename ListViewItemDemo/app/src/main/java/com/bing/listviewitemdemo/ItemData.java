package com.bing.listviewitemdemo;

/**
 * Description
 * Created by bing on 2015/10/4.
 */
public class ItemData {
    private String firstItem;
    private String secondItemTop;
    private String secondItemBottom;
    private String thirdItemText;
    private int thirdItemImg;

    public ItemData(String firstItem) {
        this.firstItem = firstItem;
    }

    public ItemData(String secondItemTop, String secondItemBottom) {
        this.secondItemTop = secondItemTop;
        this.secondItemBottom = secondItemBottom;
    }

    public ItemData(String thirdItemText, int thirdItemImg) {
        this.thirdItemText = thirdItemText;
        this.thirdItemImg = thirdItemImg;
    }

    public String getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(String firstItem) {
        this.firstItem = firstItem;
    }

    public String getSecondItemTop() {
        return secondItemTop;
    }

    public void setSecondItemTop(String secondItemTop) {
        this.secondItemTop = secondItemTop;
    }

    public String getSecondItemBottom() {
        return secondItemBottom;
    }

    public void setSecondItemBottom(String secondItemBottom) {
        this.secondItemBottom = secondItemBottom;
    }

    public String getThirdItemText() {
        return thirdItemText;
    }

    public void setThirdItemText(String thirdItemText) {
        this.thirdItemText = thirdItemText;
    }

    public int getThirdItemImg() {
        return thirdItemImg;
    }

    public void setThirdItemImg(int thirdItemImg) {
        this.thirdItemImg = thirdItemImg;
    }
}
