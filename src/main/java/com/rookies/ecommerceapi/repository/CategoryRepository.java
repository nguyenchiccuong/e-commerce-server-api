package com.rookies.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.rookies.ecommerceapi.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByCategoryIsNull();

    @Query("FROM Category c WHERE c.category.id = ?1")
    List<Category> findSubCategoryByParentCategoryId(Integer parentId);

    Optional<Category> findByCategoryName(String categoryName);

    Optional<Category> findByIdAndCategoryIsNull(Integer id);

}
