package com.example.jewelleryapp.Model;

public class SelectedData {

    int mainVariantId;
    int selectedItemId;

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected = true;


    public SelectedData(int mainVariantId, int selectedItemId, boolean isSelected) {
        this.mainVariantId = mainVariantId;
        this.selectedItemId = selectedItemId;
        this.isSelected = isSelected;
    }

    public SelectedData(int mainVariantId, int selectedItemId) {
        this.mainVariantId = mainVariantId;
        this.selectedItemId = selectedItemId;
    }

    public SelectedData() {

    }

    public int getMainVariantId() {
        return mainVariantId;
    }

    public void setMainVariantId(int mainVariantId) {
        this.mainVariantId = mainVariantId;
    }

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }
}
