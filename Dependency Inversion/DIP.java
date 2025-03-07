// Violates DIP: High-level module (NotificationService) depends on low-level module (Email)
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

// Corrected DIP: Use abstraction (interface)
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
