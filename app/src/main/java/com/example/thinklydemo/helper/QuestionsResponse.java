package com.example.thinklydemo.helper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuestionsResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("error")
    private String error;


    @Expose
    @SerializedName("categories")
    ArrayList<Categories> categories;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    public  class Categories
    {
        @SerializedName("id")
        private String id;

        @SerializedName("productId")
        private String productId;

        @SerializedName("categoryName")
        private String categoryName;


        @SerializedName("categoryImg")
        private String categoryImg;

        @SerializedName("productCategoryDescription")
        private String productCategoryDescription;

        @SerializedName("isdeleted")
        private String isdeleted;

        @SerializedName("addedon")
        private String addedon;

        @SerializedName("updatedon")
        private String updatedon;


        public Categories(String id, String productId, String categoryName, String categoryImg, String productCategoryDescription, String isdeleted, String addedon, String updatedon) {
            this.id = id;
            this.productId = productId;
            this.categoryName = categoryName;
            this.categoryImg = categoryImg;
            this.productCategoryDescription = productCategoryDescription;
            this.isdeleted = isdeleted;
            this.addedon = addedon;
            this.updatedon = updatedon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryImg() {
            return categoryImg;
        }

        public void setCategoryImg(String categoryImg) {
            this.categoryImg = categoryImg;
        }

        public String getIsdeleted() {
            return isdeleted;
        }

        public void setIsdeleted(String isdeleted) {
            this.isdeleted = isdeleted;
        }

        public String getAddedon() {
            return addedon;
        }

        public void setAddedon(String addedon) {
            this.addedon = addedon;
        }

        public String getUpdatedon() {
            return updatedon;
        }

        public void setUpdatedon(String updatedon) {
            this.updatedon = updatedon;
        }

        public String getProductCategoryDescription() {
            return productCategoryDescription;
        }

        public void setProductCategoryDescription(String productCategoryDescription) {
            this.productCategoryDescription = productCategoryDescription;
        }
    }


}
