package sample.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

/**
 * Created by Nazar on 03.08.2017.
 */
public class Order {

    private FloatProperty percent;

    private FloatProperty price;

    private FloatProperty btc;

    private FloatProperty usd;

    private FloatProperty total;

    public Order() {
    }

    public Order(float percent, float price, float btc, float usd, float total) {
        this.percent = new SimpleFloatProperty(percent);
        this.price = new SimpleFloatProperty(price);
        this.btc = new SimpleFloatProperty(btc);
        this.usd = new SimpleFloatProperty(usd);
        this.total = new SimpleFloatProperty(total);
    }

    public float getPercent() {
        return percent.get();
    }

    public FloatProperty percentProperty() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent.set(percent);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public float getBtc() {
        return btc.get();
    }

    public FloatProperty btcProperty() {
        return btc;
    }

    public void setBtc(float btc) {
        this.btc.set(btc);
    }

    public float getUsd() {
        return usd.get();
    }

    public FloatProperty usdProperty() {
        return usd;
    }

    public void setUsd(float usd) {
        this.usd.set(usd);
    }

    public float getTotal() {
        return total.get();
    }

    public FloatProperty totalProperty() {
        return total;
    }

    public void setTotal(float total) {
        this.total.set(total);
    }
}
