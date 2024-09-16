package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class StartByTestingThisTest {

    private static final Product produit = new Product("sku", "name", 0);
    private static final String EMAIL = "abc@gmail.com";
    private static final String SKU = "sku";
    private StartByTestingThis service;
    private ProductRepository repository;
    private CartFactory cartFactory;

    @BeforeEach
    public void setUp() {

        cartFactory = mock(CartFactory.class);

        repository = mock(ProductRepository.class);
        when(repository.findBySku("sku")).thenReturn(produit);

        service = new StartByTestingThis(cartFactory, repository);
    }

    @Test
    public void verifierCreationCartFactory() {
        service.oneClickBuy(EMAIL, SKU);

        verify(cartFactory, times(1)).create(EMAIL);
    }

    @Test
    public void verifierTrouveProduct(){
        service.oneClickBuy(EMAIL, SKU);

        verify(repository, times(1)).findBySku(SKU);
    }

    @Test
    public void verifierAjoutProduct(){
        service.oneClickBuy(EMAIL, SKU);

        verify(repository, times(1)).findBySku(SKU);
    }

    @Test
    public void ajoutNouveauProduitCreePanierEtRetourneFacture() {
        Invoice invoice = service.oneClickBuy(EMAIL, SKU);


    }
}
