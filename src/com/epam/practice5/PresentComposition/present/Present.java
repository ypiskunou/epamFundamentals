package com.epam.practice5.PresentComposition.present;

public abstract class Present{
    protected PresentWrapper wrapper;
    protected PresentProduct product;
    //region setters/getters
    public void setWrapper(PresentWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public void setProduct(PresentProduct product) {
        this.product = product;
    }

    public PresentWrapper getWrapper() {
        return wrapper;
    }

    public PresentProduct getProduct() {
        return product;
    }
    //endregion

    @Override
    public String toString() {
        return "Present{" +
                "wrapper=" + wrapper +
                ", product=" + product +
                '}';
    }
}
