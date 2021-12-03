package com.ponser2000.appclient;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractViewApplication extends Application {

    private final ObservableList<Contract> contractData = FXCollections.observableArrayList();

    public ContractViewApplication() {

        List<Contract> contractList = new ArrayList<>();

        ContractRepository contractRepository = new ContractRepository();
        try {
            contractList = contractRepository.getAllContracts();
        } catch (Exception e) {
            e.printStackTrace();
        }

        contractData.addAll(contractList);
/*
        contractData.add(new Contract("2020-01-30T10:00:00",0,"2020-01-30T10:00:00",false));
        contractData.add(new Contract("2020-01-30T13:00:00", 2,  "2020-02-15T09:00:00", false));
        contractData.add(new Contract("2020-01-30T20:00:00", 10, "2020-11-30T20:00:00", false));
        contractData.add(new Contract("2020-01-31T09:00:00", 10, "2020-12-14T08:00:00", false));
        contractData.add(new Contract("2020-01-31T10:00:00", 3,  "2020-06-21T10:00:00", false));
        contractData.add(new Contract("2020-01-31T13:00:00", 2,  "2020-02-23T13:00:00", false));
        contractData.add(new Contract("2020-01-31T20:00:00", 8,  "2020-10-15T17:00:00", false));
        contractData.add(new Contract("2020-01-31T14:00:00", 1,  "2020-02-10T14:00:00", false));
        contractData.add(new Contract("2020-01-31T21:00:00", 0,  "2020-01-31T21:00:00", false));
        contractData.add(new Contract("2021-01-31T11:00:00", 5,  "2021-11-30T12:00:00", false));
        contractData.add(new Contract("2021-02-12T10:00:00", 2,  "2021-05-31T08:00:00", false));
        contractData.add(new Contract("2021-05-23T13:00:00", 4,  "2021-08-11T12:00:00", false));
        contractData.add(new Contract("2021-06-24T08:00:00", 3,  "2021-08-30T17:00:00", false));
        contractData.add(new Contract("2021-11-21T14:30:00", 1,  "2021-11-22T10:00:00", false));
        contractData.add(new Contract("2021-12-01T12:00:00", 0,  "2021-12-01T12:00:00", false));
*/

    }

    public static void main(String[] args) {
        launch();
    }

    public ObservableList<Contract> getContractData() {
        return contractData;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ContractViewApplication.class.getResource("contract-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 300);
        stage.setTitle("Contract table");
        stage.setScene(scene);

        ContractViewController contractViewController = fxmlLoader.getController();
        contractViewController.setContractViewController(this);

        stage.show();
    }
}