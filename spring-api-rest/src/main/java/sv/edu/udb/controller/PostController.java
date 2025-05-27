package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.PostRequest;
import sv.edu.udb.controller.response.PostResponse;
import sv.edu.udb.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAll() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostResponse create(@Valid @RequestBody PostRequest request) {
        return postService.createPost(request);
    }
}
