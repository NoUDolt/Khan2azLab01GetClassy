public class Product {
    private String id;
    private String product_name ;
    private String product_description;
    private double product_cost;

    public Product (String id, String product_name, String product_description, double product_cost) {
        this.id = id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_cost = product_cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(double product_cost) {
        this.product_cost = product_cost;
    }

    public String toCSV() {
        return id + ", " +
                product_name + ", " +
                product_description + ", " +
                product_cost;
    }

    public String toJSON(){
        return id + ":" +
                product_name + ":" +
                product_description + ":" +
                product_cost;
    }

    public String toXML(){
        return String.format("<Product><ID>%s</ID><ProductName>%s</ProductName><ProductDescription>%s</ProductDescription><ProductCost>%.2f</ProductCost></Product>",
                id, product_name, product_description, product_cost);
    }

    @Override
    public String toString() {
        return id + "     " +
                product_name + "     " +
                product_description + "     " +
                product_cost;
    }
}
