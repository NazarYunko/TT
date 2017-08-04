package sample.model;

import javafx.beans.property.*;

import java.time.LocalDateTime;

/**
 * Created by Nazar on 03.08.2017.
 */
public class Trade {

    private ObjectProperty<LocalDateTime> time;

    private StringProperty type;

    private FloatProperty price;

    private FloatProperty amount;

    private FloatProperty total;

    public Trade() {
    }

    public Trade(LocalDateTime time, String type, float price, float amount, float total) {
        this.time = new SimpleObjectProperty<LocalDateTime>(time);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleFloatProperty(price);
        this.amount = new SimpleFloatProperty(amount);
        this.total = new SimpleFloatProperty(total);
    }

    public LocalDateTime getTime() {
        return time.get();
    }

    public ObjectProperty<LocalDateTime> timeProperty() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time.set(time);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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

    public float getAmount() {
        return amount.get();
    }

    public FloatProperty amountProperty() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount.set(amount);
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

