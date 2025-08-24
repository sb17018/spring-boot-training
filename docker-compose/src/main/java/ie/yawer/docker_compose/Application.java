package ie.yawer.docker_compose;

import ie.yawer.docker_compose.model.Post;
import ie.yawer.docker_compose.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PostRepository postRepository){
		return args -> postRepository.save(new Post("Hello, World!", "My first post in blog"));
	}
}
