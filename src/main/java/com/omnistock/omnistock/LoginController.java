package com.omnistock.omnistock;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    @FXML private ToggleButton adminToggle;
    @FXML private ToggleButton staffToggle;
    @FXML private Label welcomeLabel;
    @FXML private Label welcomeSubtext;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    private double dragOffsetX;
    private double dragOffsetY;

    @FXML
    private void onAdminSelected() {
        if (!adminToggle.isSelected()) {
            adminToggle.setSelected(true);
            return;
        }
        welcomeLabel.setText("Welcome back, Admin");
        welcomeSubtext.setText("Manage products, staff accounts, and store reports.");
        usernameField.setPromptText("e.g. admin");
    }

    @FXML
    private void onStaffSelected() {
        if (!staffToggle.isSelected()) {
            staffToggle.setSelected(true);
            return;
        }
        welcomeLabel.setText("Welcome back, Staff");
        welcomeSubtext.setText("Ring up sales and check today's stock levels.");
        usernameField.setPromptText("e.g. staff");
    }

    @FXML
    private void onLoginClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean isAdmin = adminToggle.isSelected();

        if (isAdmin && "admin".equals(username) && "admin123".equals(password)) {
            System.out.println("Admin login successful");
        } else if (!isAdmin && "staff".equals(username) && "staff123".equals(password)) {
            System.out.println("Staff login successful");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    @FXML
    private void onCloseClick() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onRootMousePressed(MouseEvent event) {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        dragOffsetX = event.getScreenX() - stage.getX();
        dragOffsetY = event.getScreenY() - stage.getY();
    }

    @FXML
    private void onRootMouseDragged(MouseEvent event) {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setX(event.getScreenX() - dragOffsetX);
        stage.setY(event.getScreenY() - dragOffsetY);
    }
}