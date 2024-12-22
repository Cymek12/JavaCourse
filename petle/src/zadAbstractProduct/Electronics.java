package zadAbstractProduct;

import java.util.List;
import java.util.Optional;

public class Electronics extends Product{
    private int warrantyPeriod;

    public Electronics(String name, String category, double price, double rating, boolean inStock, Optional<String> manufacturer, int warrantyPeriod) {
        super(name, category, price, rating, inStock, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String getSpecificDetails() {
        return super.toString() + " okres gwarancji = " + warrantyPeriod ;
    }

    static public List<Electronics> getElectronicsWithWarranty(List<Product> products, int minWarranty){
        return products.stream()
                .filter(s -> s instanceof Electronics)
                .filter(s -> ((Electronics) s).getWarrantyPeriod() >= minWarranty)
                .map(s -> (Electronics) s)
                .toList();
    }


}
