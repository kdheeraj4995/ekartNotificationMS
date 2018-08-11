package services;

/**
 * @author Dheeraj Reddy
 */

public interface IMail {
    public void sendSimpleMail(String subject, String message, String email);
}
