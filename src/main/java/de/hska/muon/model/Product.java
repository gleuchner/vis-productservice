package de.hska.muon.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product
 */
@javax.persistence.Entity
@Table(name = "product")
public class Product {
    @JsonProperty("productId")
    @Id
    @GeneratedValue
    @Column(name = "productId")
    private Integer productId;

    @JsonProperty("details")
    @Column(name = "details")
    private String details;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("price")
    @Column(name = "price")
    private Integer price;

    @JsonProperty("categoryId")
    @Column(name = "categoryId")
    private Integer categoryId;

    /**
     * Unique identifier of the product.
     *
     * @return productId
     **/
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Description of the product.
     *
     * @return details
     **/

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Name of the product.
     *
     * @return name
     **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Price of the product.
     *
     * @return price
     **/

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Id of the related category.
     *
     * @return categoryId
     **/

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(this.productId, product.productId) &&
                Objects.equals(this.details, product.details) &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.price, product.price) &&
                Objects.equals(this.categoryId, product.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, details, name, price, categoryId);
    }

    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("class Product {\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

