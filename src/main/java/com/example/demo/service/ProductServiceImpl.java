package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(long theId) {
        Long theIdl=(long)theId;
        Optional<Product> result = productRepository.findById(theIdl);

        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(Product theProduct) {
        productRepository.save(theProduct);

    }

    @Override
    public void deleteById(long theId) {
        Long theIdl=(long)theId;
        productRepository.deleteById(theIdl);
    }
    public List<Product> listAll(String keyword){
        if(keyword !=null){
            return productRepository.search(keyword);
        }
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public void decrementInv(long productId, int decQty) {
        Product theProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Product with id " + productId + " does not exist"));
        if (decQty < 0) {
            throw new IllegalArgumentException("You cannot reduce inventory by a negative quantity. The quantity should be positive.");
        }
        else if(theProduct.getInv() < decQty) {
            throw new IllegalArgumentException("Insufficient inventory: The requested quantity exceeds the available stock.");
        }
        theProduct.setInv(theProduct.getInv() - decQty);
    }
}
