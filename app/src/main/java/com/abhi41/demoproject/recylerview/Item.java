package com.abhi41.demoproject.recylerview;

public class Item {
    String itemName,itemDesc,itemImg;

    public Item(String itemImg, String itemName, String itemDesc) {
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
