package app.network;

import app.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();
    //Call<PostsResponse> getPosts();

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);
}
