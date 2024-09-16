package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartByTestingThisTest {

    private static final Product produit = new Product("sku", "name", 0);
    private StartByTestingThis service;
    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis();
        repository = mock(ProductRepository.class);
        when(repository.findBySku("sku")).thenReturn(produit);
    }

    @Test
    public void ajoutNouveauProduitCreePanierEtRetourneFacture() {
        Product product = new Product("sku", "name", 0);
    }
}
