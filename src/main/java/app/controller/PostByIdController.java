package app.controller;

import app.entity.Post;
import app.model.PostModel;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.PostByIdView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import retrofit2.Response;

import java.util.Optional;

public class PostByIdController {
    PostModel model;
    PostByIdView view;

    public PostByIdController(PostModel model, PostByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getUserById() {
        view.getOutput(readUserById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readUserById(int id) {
        Optional<Response<Post>> optional = model.fetchUserById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            Post post = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<Post>() {}.getType());
            return "UserId: " + post.getUserId() + ", " + "\nPostId: "+ post.getId() +
                    "\nTitle: " + post.getTitle() + ". " +  "\nBody: " + post.getBody();
        }
    }
}
