package com.rookies.ecommerceapi.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products", indexes = { @Index(name = "pr_ci_index", columnList = "category_id"),
        @Index(name = "pr_mulitIndex1", columnList = "create_date, update_date"),
        @Index(name = "pr_bi_index", columnList = "brand_id"), @Index(name = "pr_oi_index", columnList = "origin_id") })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "product_sequence"),
            @Parameter(name = "increment_size", value = "1") })
    private Long id;

    @Column(name = "product_name")
    @NotBlank
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String model;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private Origin origin;

    private String standard;

    private String size;

    private Float weight;

    private String material;

    private String description;

    private Short warranty;

    private Short img;

    @Column(name = "create_date")
    @NotNull
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<ProductDetail> productDetails;

    public Product(@NotBlank String productName, Category category, String model, Brand brand, Origin origin,
            String standard, String size, Float weight, String material, String description, Short warranty, Short img,
            @NotNull LocalDateTime createDate) {
        this.productName = productName;
        this.category = category;
        this.model = model;
        this.brand = brand;
        this.origin = origin;
        this.standard = standard;
        this.size = size;
        this.weight = weight;
        this.material = material;
        this.description = description;
        this.warranty = warranty;
        this.img = img;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product [createDate=" + createDate + ", description=" + description + ", id=" + id + ", img=" + img
                + ", material=" + material + ", model=" + model + ", productName=" + productName + ", size=" + size
                + ", standard=" + standard + ", updateDate=" + updateDate + ", warranty=" + warranty + ", weight="
                + weight + "]";
    }

}
