package exercise.controller.users;

import exercise.Application;
import exercise.Data;
import exercise.model.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


// BEGIN

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable Integer id) {
        int oneId = (int) id;
        var post = posts.stream()
                .filter(p -> oneId==(p.getUserId()))
                .collect(Collectors.toList());
        return post;


    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable Integer id, @RequestBody Post post) {
        Post newPost = new Post();
        newPost.setSlug(post.getSlug());
        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        newPost.setUserId(id);
        posts.add(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);

    }
}
