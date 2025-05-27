package sv.edu.udb.service;

import sv.edu.udb.controller.request.PostRequest;
import sv.edu.udb.controller.response.PostResponse;

import java.util.List;

public interface PostService {
    List<PostResponse> getAllPosts();
    PostResponse createPost(PostRequest request);
}
