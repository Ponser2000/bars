package com.ponser2000.appclient;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

import java.time.LocalDateTime;

public class ContractViewController {

    @FXML
    private TableView<Contract> contractTableView;
    @FXML
    private TableColumn<Contract, LocalDateTime> createDateColumn;
    @FXML
    private TableColumn<Contract, Integer> revisionColumn;
    @FXML
    private TableColumn<Contract, LocalDateTime> updateDateColumn;
    @FXML
    private TableColumn<Contract, Boolean> actualColumn;

    private ContractViewApplication contractViewApplication;

    public ContractViewController() {

    }

    @FXML
    private void initialize() {
        createDateColumn.setCellValueFactory(cellData -> cellData.getValue().createDateProperty());
        revisionColumn.setCellValueFactory(cellDate -> cellDate.getValue().revisionProperty().asObject());
        updateDateColumn.setCellValueFactory(cellData -> cellData.getValue().updateDateProperty());
        //actualColumn.setCellValueFactory(cellData -> cellData.getValue().actualProperty());
        actualColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contract, Boolean>, ObservableValue<Boolean>>() {
                                             @Override
                                             public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Contract, Boolean> contractBooleanCellDataFeatures) {
                                                 Contract contract = contractBooleanCellDataFeatures.getValue();
                                                 SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(contract.isActual());

                                                 return booleanProperty;
                                             }
                                         }

        );

        actualColumn.setCellFactory(new Callback<TableColumn<Contract, Boolean>, TableCell<Contract, Boolean>>() {
            @Override
            public TableCell<Contract, Boolean> call(TableColumn<Contract, Boolean> contractBooleanTableColumn) {
                CheckBoxTableCell<Contract, Boolean> cell = new CheckBoxTableCell<Contract, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

    }

    public void setContractViewController(ContractViewApplication contractViewApplication) {
        this.contractViewApplication = contractViewApplication;
        contractTableView.setItems(contractViewApplication.getContractData());
    }

}