package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentsRepository;

    @GetMapping(path = "")
    private List<PostDTO> showAllPosts() {
        var allPosts = postRepository.findAll();
        var result = allPosts.stream()
                .map(this::toPostDTO)
                .collect(Collectors.toList());
        return result;
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        var comments = commentsRepository.findByPostId(post.getId());
        var commentsDto = comments.stream()
                .map((comment) -> {
                    var commentDto = new CommentDTO();
                    commentDto.setBody(comment.getBody());
                    commentDto.setId(comment.getId());
                    return commentDto;
                })
                .toList();
        dto.setComments(commentsDto);
        return dto;
    }


    @GetMapping(path = "/{id}")
    private PostDTO showPost(@PathVariable long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toPostDTO(post);
    }


}
// END
