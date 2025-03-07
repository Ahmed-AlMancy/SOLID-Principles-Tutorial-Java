// Violates OCP: Modifying existing class to add new payment methods
class PaymentService {
    public void processPayment(String type) {
        if (type.equals("CreditCard")) {
            System.out.println("Processing credit card payment...");
        } else if (type.equals("PayPal")) {
            System.out.println("Processing PayPal payment...");
        }
    }
}

// Corrected OCP: Use inheritance to extend functionality
interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class PayPalPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}

class PaymentService {
    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}
