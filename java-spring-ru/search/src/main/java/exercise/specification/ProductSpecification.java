package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO params){
        return withTitleCont(params.getTitleCont())
                .and(withPriceGt(params.getPriceGt()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withCategoryId(params.getCategoryId()))
                .and(withRatingGt(params.getRatingGt()));
    }

    private Specification<Product> withTitleCont(String substring) {
        return (root, query, cb) -> substring == null
                ? cb.conjunction()
                : cb.like(cb.lower(root.get("title")), "%" + substring + "%");
    }
    public Specification<Product> withCategoryId(Long categoryId){
        return (root, query, cb) -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"),categoryId);
    }
    public Specification<Product> withPriceLt(Integer priceLt){
        return (root, query, cb) -> priceLt == null ? cb.conjunction() : cb.lessThan(root.get("price"), priceLt);
    }
    public Specification<Product> withPriceGt(Integer priceGt){
        return (root, query, cb) -> priceGt == null ? cb.conjunction() : cb.greaterThan(root.get("price"), priceGt);
    }
    public Specification<Product> withRatingGt(Double ratingGt){
        return (root, query, cb) -> ratingGt == null ? cb.conjunction() : cb.greaterThan(root.get("rating"),ratingGt);
    }

}
// END
