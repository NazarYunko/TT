package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.Order;
import sample.model.Trade;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Controller {

    @FXML
    private TableView<Trade> tradesTable;

    @FXML
    private TableColumn<Trade, LocalDateTime> tradeTime;

    @FXML
    private TableColumn<Trade, String> tradeType;

    @FXML
    private TableColumn<Trade, Float> tradePrice;

    @FXML
    private TableColumn<Trade, Float> tradeAmount;

    @FXML
    private TableColumn<Trade, Float> tradeTotal;

    @FXML
    private TableView<Order> buyOrdersTable;

    @FXML
    private TableColumn<Order, Float> buyOrderPercent;

    @FXML
    private TableColumn<Order, Float> buyOrderPrice;

    @FXML
    private TableColumn<Order, Float> buyOrderBTC;

    @FXML
    private TableColumn<Order, Float> buyOrderUSD;

    @FXML
    private TableColumn<Order, Float> buyOrderTotal;

    @FXML
    private TableView<Order> sellOrdersTable;

    @FXML
    private TableColumn<Order, Float> sellOrderPercent;

    @FXML
    private TableColumn<Order, Float> sellOrderPrice;

    @FXML
    private TableColumn<Order, Float> sellOrderBTC;

    @FXML
    private TableColumn<Order, Float> sellOrderUSD;

    @FXML
    private TableColumn<Order, Float> sellOrderTotal;

    private static boolean stopThread;

    public static void stopThread() {
        stopThread = true;
    }

    @FXML
    private void initialize() {
        tradeInitialize();
        orderInitialize();
        setData();
    }

    public void tradeInitialize() {
        tradeTime.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        tradeType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        tradePrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        tradeAmount.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        tradeTotal.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());
    }

    public void orderInitialize() {
        buyOrderPercent.setCellValueFactory(cellData -> cellData.getValue().percentProperty().asObject());
        buyOrderPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        buyOrderBTC.setCellValueFactory(cellData -> cellData.getValue().btcProperty().asObject());
        buyOrderUSD.setCellValueFactory(cellData -> cellData.getValue().usdProperty().asObject());
        buyOrderTotal.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());

        sellOrderPercent.setCellValueFactory(cellData -> cellData.getValue().percentProperty().asObject());
        sellOrderPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        sellOrderBTC.setCellValueFactory(cellData -> cellData.getValue().btcProperty().asObject());
        sellOrderUSD.setCellValueFactory(cellData -> cellData.getValue().usdProperty().asObject());
        sellOrderTotal.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());
    }

    public void setData() {

        Runnable runnable = () -> {
            while(!stopThread) {

                Trade trade = new Trade(LocalDateTime.now(), "B",
                        new BigDecimal(Math.random()).setScale(3, RoundingMode.UP).floatValue(),
                        new BigDecimal(Math.random()).setScale(3, RoundingMode.UP).floatValue(),
                        new BigDecimal(Math.random()).setScale(3, RoundingMode.UP).floatValue());

                tradesTable.getItems().add(trade);

                Thread thread = Thread.currentThread();
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();

    }

}
