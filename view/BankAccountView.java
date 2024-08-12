package view;

import model.BankAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankAccountView {
    private Scanner scanner;

    public BankAccountView() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        while (true) {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG");
                System.out.println("Chọn chức năng theo số (để tiếp tục)");
                System.out.println("1. Thêm mới");
                System.out.println("2. Xoá");
                System.out.println("3. Xem danh sách các tài khoản ngân hàng");
                System.out.println("4. Tìm kiếm");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }





        public int getValidInt(String prompt) {
            while (true) {
                System.out.print(prompt);
                try {
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character left by nextInt()
                    if (value > 0) {
                        return value;
                    } else {
                        System.out.println("Value must be positive. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }

        public double getValidDouble(String prompt) {
            while (true) {
                System.out.print(prompt);
                try {
                    double value = scanner.nextDouble();
                    scanner.nextLine(); // Clear the newline character left by nextDouble()
                    if (value > 0) {
                        return value;
                    } else {
                        System.out.println("Value must be positive. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }

        public String getValidDate(String prompt) {
            while (true) {
                System.out.print(prompt);
                String dateStr = scanner.nextLine().trim();
                try {
                    new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                    return dateStr;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
                }
            }
        }

        public String getValidAccountHolderName(String prompt) {
            while (true) {
                System.out.print(prompt);
                String name = scanner.nextLine().trim();
                if (!name.isEmpty() && Pattern.matches("[a-zA-Z\\s]+", name)) {
                    return name;
                } else {
                    System.out.println("Invalid name. It must be non-empty and contain only letters and spaces.");
                }
            }
        }

        public String getInput(String prompt) {
            System.out.print(prompt);
            return scanner.next();
        }

        public void displayAccount(BankAccount account) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(account);
        }

        public void displayMessage(String message) {
            System.out.println(message);
        }

        public void close() {
            scanner.close();
        }
    public String getValidCardNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String cardNumber = scanner.nextLine().trim();
            if (Pattern.matches("\\d+", cardNumber) && !cardNumber.isEmpty()) {
                return cardNumber;
            } else {
                System.out.println("Invalid card number. It must be a non-empty positive number.");
            }
        }
    }
    }

