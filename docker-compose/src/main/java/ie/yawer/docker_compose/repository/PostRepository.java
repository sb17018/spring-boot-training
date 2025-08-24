package ie.yawer.docker_compose.repository;

import org.springframework.data.repository.ListCrudRepository;

import ie.yawer.docker_compose.model.Post;

public interface PostRepository extends ListCrudRepository<Post, Integer> {
}
