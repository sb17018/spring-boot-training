package ie.yawer.docker_compose.controller;

import ie.yawer.docker_compose.model.Post;
import ie.yawer.docker_compose.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Integer id){
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isEmpty()) return null;
        return postRepository.findById(id).get();
    }

    @PostMapping
    public Post savePost(@RequestParam("title") String title, @RequestParam("body") String body) {
        Post post = new Post(title, body);
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") Integer id, @RequestParam("title") String title, @RequestParam("body") String body){
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isEmpty()) return null;
        Post post = postOptional.get();
        post.setTitle(title);
        post.setBody(body);
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public Post deleteById(@PathVariable("id") Integer id){
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isEmpty()) return null;
        Post copyPost = new Post();
        copyPost.setId(id);
        copyPost.setTitle(postOptional.get().getTitle());
        copyPost.setBody(postOptional.get().getBody());
        postRepository.deleteById(id);
        return copyPost;
    }

}
