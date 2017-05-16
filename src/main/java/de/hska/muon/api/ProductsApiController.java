package de.hska.muon.api;

import de.hska.muon.model.Product;
import de.hska.muon.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsApiController {
    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = "/products",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> productsGet(
            @RequestParam(value = "query", required = false) String query,
            @RequestParam(value = "minPrice", required = false) Integer minPrice,
            @RequestParam(value = "maxPrice", required = false) Integer maxPrice) {
        Iterable<Product> allPolls;
        if (query != null) {
            allPolls = repo.findProductFilterWithQuery(query, minPrice != null ? minPrice : 0, maxPrice != null ? maxPrice : Integer.MAX_VALUE);
        } else {
            allPolls = repo.findProductFilter(minPrice != null ? minPrice : 0, maxPrice != null ? maxPrice : Integer.MAX_VALUE);
        }
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @RequestMapping(value = "/products",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Product> productsPost(
            @RequestBody Product newProduct,
            @RequestHeader(value = "userId", required = true) Integer userId) {
        // TODO userId

        Product ret = repo.save(newProduct);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{productId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> productsProductIdDelete(
            @PathVariable("productId") Integer productId,
            @RequestHeader(value = "userId", required = true) Integer userId) {
        // TODO userId

        Product result = repo.findOne(productId);
        if (result != null) {
            repo.delete(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/products/{productId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<?> productsProductIdGet(@PathVariable Integer productId) {
        Product result = repo.findOne(productId);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
