`Explanation`: This Sattes That Abstraction Should depend upon Details, Details Should depend on abstractions, in other words, High-Level Modules should not depend on Low-Level Modules, Both should depend on Abstractions.
---
### Dependency Inversion Principle (DIP) Violation and Fix

#### DIP Violation
The original code violates DIP because the high-level `NotificationService` class directly depends on the low-level `Email` class:
```java
class Email {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NotificationService {
    private Email email;

    public NotificationService() {
        this.email = new Email();
    }

    public void notifyUser(String message) {
        email.sendEmail(message);
    }
}
```
`Issue`: `NotificationService` is tightly coupled to `Email`, making it hard to extend with new messaging options (e.g., SMS).
`Breaks DIP`: High-level modules should not depend on low-level modules; both should depend on abstractions.
----
## The Fix:
```java
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class NotificationService {
    private MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message) {
        messageService.sendMessage(message);
    }
}
```
Now, `NotificationService` depends on the M`essageService abstraction `instead of a concrete class.
New message services (e.g., SMS, Push Notifications) can be added without modifying NotificationService.
`DIP is maintained`: Both high-level and low-level modules depend on the abstraction.
