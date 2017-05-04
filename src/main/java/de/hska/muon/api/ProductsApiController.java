package de.hska.muon.api;


import de.hska.muon.model.Product;
import de.hska.muon.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-04T12:49:09.193Z")

@RestController
public class ProductsApiController {
    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = "/products",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> productsGet(
            @RequestParam(value = "query", required = false) String query,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice) {
        // TODO add query / minPrice / maxPrice
        Iterable<Product> allPolls = repo.findAll();
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
        // TODO userId // NO detection if productId is valid
        repo.delete(productId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{productId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Product> productsProductIdGet(@PathVariable Integer productId) {
         Product result = repo.findOne(productId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
