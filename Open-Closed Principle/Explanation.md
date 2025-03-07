`Explanation`: The OCP States that Software entities should be open for extension but closed for modification.
-----
### Open/Closed Principle (OCP) Violation and Fix

#### OCP Violation
The original `PaymentService` class violates OCP because adding new payment methods requires modifying the existing code:
```java
class PaymentService {
    public void processPayment(String type) {
        if (type.equals("CreditCard")) {
            System.out.println("Processing credit card payment...");
        } else if (type.equals("PayPal")) {
            System.out.println("Processing PayPal payment...");
        }
    }
}
```
Modifying existing code increases the risk of bugs.
Breaks the "Open for extension, closed for modification" rule.
----------
## The Fix:
```
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
```
Extensible: New payment methods (e.g., Bitcoin) can be added as new classes.
Maintains OCP: PaymentService depends on the Payment interface, making it flexible and scalable.
