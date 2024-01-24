package app.model;

import app.controller.PostByIdController;
import app.controller.PostsController;
import app.view.PostByIdView;
import app.view.PostsView;

public class AppModel {
    public void readPosts() {
        PostModel model = new PostModel();
        PostsView view = new PostsView();
        PostsController controller = new PostsController(model, view);
        controller.getUsers();
    }

    public void readPostById() {
        PostModel model = new PostModel();
        PostByIdView view = new PostByIdView();
        PostByIdController controller = new PostByIdController(model, view);
        controller.getUserById();
    }
}
