package com.codegym.demoaop;

public class Hello {
    private String message;

    public Hello() {
        this.message = "Hello CodeGym";
    }

    public void method1() {
        System.out.println("Bắt đầu method 1");
        System.out.println("Thực thi method 1");
        System.out.println("Kết thúc method 1");
    }
    public void method2() {
        System.out.println("Bắt đầu method 2");
        System.out.println("Thực thi method 2");
        System.out.println("Kết thúc method 2");
    }
    public void method3() {
        System.out.println("Bắt đầu method 3");
        System.out.println("Thực thi method 3");
        System.out.println("Kết thúc method 3");
        throw new IllegalArgumentException("Lỗi tham số truyền vào");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
