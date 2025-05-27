package sv.edu.udb.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.PostRequest;
import sv.edu.udb.controller.response.PostResponse;
import sv.edu.udb.repository.PostRepository;
import sv.edu.udb.repository.domain.Post;
import sv.edu.udb.service.PostService;
import sv.edu.udb.service.mapper.PostMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse createPost(PostRequest request) {
        Post post = postMapper.toEntity(request);
        return postMapper.toResponse(postRepository.save(post));
    }
}
