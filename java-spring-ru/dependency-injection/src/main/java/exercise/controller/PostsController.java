package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")

public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Post showPost(@PathVariable long id) {
        var post = postRepository.findById(id).orElseThrow(()  -> new ResourceNotFoundException("Post with id "+id+" not found."));
return post;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        var newPost = postRepository.save(post);
        return post;
    }

    @PutMapping(path = "/{id}")
    public Post updatePost(@PathVariable long id, @RequestBody Post updatePost) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        post.setTitle(updatePost.getTitle());
        post.setBody(updatePost.getBody());
        post.setCreatedAt(updatePost.getCreatedAt());
        postRepository.save(post);
        return post;
    }

    @DeleteMapping(path = "/{id}")
    public void deletePost(@PathVariable long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);

    }


}
// END
