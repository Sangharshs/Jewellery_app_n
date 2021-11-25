package com.example.jewelleryapp.Retrofit;

import com.example.jewelleryapp.Model.CategoryData;
import com.example.jewelleryapp.Model.ChildCategoryList;
import com.example.jewelleryapp.Model.HorizontalProductImage;
import com.example.jewelleryapp.Model.P_Details_A;
import com.example.jewelleryapp.Model.P_Details_B;
import com.example.jewelleryapp.Model.Product;
import com.example.jewelleryapp.Model.ProductImages;
import com.example.jewelleryapp.Model.SliderItem;
import com.example.jewelleryapp.Model.Subcategory;
import com.example.jewelleryapp.Model.User;
import com.example.jewelleryapp.Model.UserLogin;
import com.google.android.material.slider.Slider;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("/jewellery/capi/p_user_login.php")
    Call<Res> login(@Body User user);

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("p_reg_user.php")
    Call<Res> register_User(@Body UserLogin jsonBody);

    @GET("p_cat_list.php")
    Call<List<CategoryData>> getCategoriesData();

    @POST("p_scat_list.php/{cid}")
    Call<List<Subcategory>> getSubcategories(@Path("cid")int cid);

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("p_child_c_list.php")
    Call<List<ChildCategoryList>> fetchChildCategories(@Body String jsonBody);

    @GET("p_get_products.php")
    Call<List<Product>> getAllProducts();

    @GET("p_get_slider.php")
    Call<ArrayList<SliderItem>> getAllSliders();

    @GET("p_product_images.php/{id}")
    Call<ArrayList<HorizontalProductImage>> getProductImages(@Path("id") int id);

    @GET("p_details_a.php/{id}")
    Call<ArrayList<P_Details_A>> getProductDetailsA(@Path("id") int id);

    @GET("p_details_b.php/{id}")
    Call<ArrayList<P_Details_B>> getProductDetailsB(@Path("id") int id);


}
