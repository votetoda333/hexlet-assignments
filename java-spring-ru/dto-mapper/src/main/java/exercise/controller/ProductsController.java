package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired ProductMapper productMapper;

    // BEGIN
    @GetMapping(path = "")
    public List<ProductDTO> showAll(){
        var posts = productRepository.findAll();
        var postsDTO = productMapper.map(posts);
        return postsDTO;
    }
    @GetMapping(path = "/{id}")
    public ProductDTO showindex(@PathVariable long id){
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
var postDTO = productMapper.map(product);
return postDTO;
    }
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO productCreateDTO){
        var product = productMapper.map(productCreateDTO);
        productRepository.save(product);
        var prodDTO = productMapper.map(product);
        return prodDTO;
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody @Validated ProductUpdateDTO productUpdateDTO, @PathVariable long id){
        var prod = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        productMapper.update(productUpdateDTO,prod);
        productRepository.save(prod);
        var prodDTO = productMapper.map(prod);
        return prodDTO;
    }
    // END
}
