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

            System.out.println("Adding new parts and products in progress...");

            outsourcedPartRepository.save(new OutsourcedPart("Flour", 8.6, 46, "Nassma"));
            outsourcedPartRepository.save(new OutsourcedPart("Milk", 12.4, 33, "Jaouda"));
            outsourcedPartRepository.save(new OutsourcedPart("Eggs", 1.2, 375, "Super Eggs"));

            inhousePartRepository.save(new InhousePart("Butter", 10.4, 113, 10));
            inhousePartRepository.save(new InhousePart("Vanilla Extract", 13.4, 125, 11));


            productRepository.save(new Product("Birthday Cake", 65.5, 45));
            productRepository.save(new Product("Cupcakes", 12.4, 125));
            productRepository.save(new Product("Croissants", 24.3, 150));
            productRepository.save(new Product("Cookies", 10.49, 219));
            productRepository.save(new Product("Tarts", 15.4, 49));
        }

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
        System.out.println("Inhouse parts:");
        for(InhousePart part:inhouseParts){
            System.out.println("\t" + part.getName()+" with partId = "+part.getPartId());
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        System.out.println("Outsource parts:");
        for(OutsourcedPart part:outsourcedParts){
            System.out.println("\t" + part.getName()+" purchased from "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());
    }
}
