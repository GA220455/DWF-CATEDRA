package sv.edu.udb.service.mapper;

import org.springframework.stereotype.Component;
import sv.edu.udb.controller.request.PostRequest;
import sv.edu.udb.controller.response.PostResponse;
import sv.edu.udb.repository.domain.Post;

@Component
public class PostMapper {

    public Post toEntity(PostRequest request) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .postDate(request.getPostDate())
                .build();
    }

    public PostResponse toResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .postDate(post.getPostDate())
                .build();
    }
}
