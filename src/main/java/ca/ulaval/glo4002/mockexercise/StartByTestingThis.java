package ca.ulaval.glo4002.mockexercise;

import java.util.ArrayList;
import java.util.List;
import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class StartByTestingThis {
    private final CartFactory cartFactory;
    private final ProductRepository productRepository;

    public  StartByTestingThis(CartFactory cartFactory, ProductRepository productRepository){
        this.cartFactory = cartFactory;
        this.productRepository = productRepository;
    }
    public Invoice oneClickBuy(String clientEmail, String productSku) {
        // Étape 1 : Créer le cart avec le CartFactory
        Cart cart = cartFactory.create(clientEmail);
        // Étape 2 : Trouver le produit avec le ProductRepository
        Product product = productRepository.findBySku(productSku);
        // Étape 3 : Ajouter le produit au cart
        cart.addProduct(product);
        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        List<Product> products = cart.getProducts();
        List <InvoiceLine> invoiceLines = new ArrayList<>();
        for(Product p : products) {
            invoiceLines.add(new InvoiceLine(p.getName(), p.getPrice()));
        }
        // Étape 5 : Retourner l'invoice
        return new Invoice(clientEmail, invoiceLines);

    }
}
