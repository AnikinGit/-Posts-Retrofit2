package app.controller;

import app.entity.Post;
import app.model.PostModel;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.PostsView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import retrofit2.Response;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PostsController {

    PostModel model;
    PostsView view;

    public PostsController(PostModel model, PostsView view) {
        this.model = model;
        this.view = view;
    }

    public void getUsers() {
        view.getOutput(readUsers());
        AppStarter.startApp();
    }

    private String readUsers() {
        Optional<Response<List<Post>>> optional = model.fetchUsers();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {

            Gson gson = new Gson();
            List<Post> posts = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<List<Post>>() {}.getType());

            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);
            String str;

            for (Post post : posts) {
                str = cnt.incrementAndGet() + ") UserId :" + post.getUserId() +
                         "\nPostId: "+  post.getId() + "\nTitle: " + post.getTitle() + "\nBody: " +
                        post.getBody() + "\n" + "\n";
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }
}
