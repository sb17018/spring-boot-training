package ie.yawer.docker_compose.controller;

import ie.yawer.docker_compose.model.Post;
import ie.yawer.docker_compose.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
