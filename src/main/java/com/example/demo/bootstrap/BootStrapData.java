package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0 && partRepository.count() == 0){
            List<InhousePart> inhouseParts = Arrays.asList(
                    // Valid inputs
                    new InhousePart("Butter", 10.4,113, 10, 300,10),
                    new InhousePart("Vanilla Extract", 13.4, 10, 10, 300, 11),
                    // Test for invalid max and min inventory
                    new InhousePart("baking powder", 10.2, 9, 10, 8, 11)
                    );
            List<OutsourcedPart> outsourcedParts = Arrays.asList(
                    // Valid inputs
                    new OutsourcedPart("Flour", 8.6, 46, 10, 300, "Nassma"),
                    new OutsourcedPart("Milk", 12.4, 33, 10, 300, "Jaouda"),
                    new OutsourcedPart("Eggs", 1.2, 275, 10, 300,"Super Eggs"),
                    // Test for invalid inventory as inv < min or inv > max
                    new OutsourcedPart("sugar", 15.1, 9, 10, 300, "Socap"),
                    new OutsourcedPart("sugar", 15.1, 301, 10, 300, "Socap")
            );
            List<Product> products = Arrays.asList(
                    new Product("Birthday Cake", 65.5, 45),
                    new Product("Cupcakes", 12.4, 125),
                    new Product("Croissants", 24.3, 150),
                    new Product("Cookies", 10.49, 219),
                    new Product("Tarts", 15.4, 49)
            );

            System.out.println("Adding new parts and products in progress...");

            // Add inhouse parts
            for(InhousePart inhousePart : inhouseParts){
                try{
                    if(!inhousePart.validMinAndMaxInv()) {
                        throw new IllegalArgumentException(
                                "Invalid Min and Max inventory for " + inhousePart.getName() + ": "
                                        + "Max inventory must be greater than Min inventory");
                    }
                    else if(!inhousePart.validInv()) {
                        throw new IllegalArgumentException(
                                "Invalid inventory for " + inhousePart.getName() + ": " + "Inventory must be between "
                                        + inhousePart.getMinInv() + " and " + inhousePart.getMaxInv());
                    }
                    else{
                        inhousePartRepository.save(inhousePart);
                    }

                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
            // Add outsourse parts
            for(OutsourcedPart outsourcedPart : outsourcedParts) {
                    try{
                        if(!outsourcedPart.validMinAndMaxInv()) {
                            throw new IllegalArgumentException(
                                    "Invalid Min and Max inventory for " + outsourcedPart.getName() + ": "
                                            + "Max inventory must be greater than Min inventory");
                        }
                        else if(!outsourcedPart.validInv()) {
                            throw new IllegalArgumentException(
                                    "Invalid inventory for " + outsourcedPart.getName() + ": " + "Inventory must be between "
                                            + outsourcedPart.getMinInv() + " and " + outsourcedPart.getMaxInv());
                        }
                        else{
                            outsourcedPartRepository.save(outsourcedPart);
                        }
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }

            // Add all products
            productRepository.saveAll(products);
        }

        // List inhouse parts
        List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
        System.out.println("Inhouse parts:");
        for(InhousePart part:inhouseParts){
            System.out.println("\t" + part.getName()+" with partId = "+part.getPartId());
        }

        // List outsoursed parts
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        System.out.println("Outsource parts:");
        for(OutsourcedPart part:outsourcedParts){
            System.out.println("\t" + part.getName()+" purchased from "+part.getCompanyName());
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());
    }
}
