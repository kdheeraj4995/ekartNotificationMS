package controllers;

import com.dheeraj.utility.helper.JsonHelper;
import com.dheeraj.utility.helper.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.IMail;

/**
 * @author Dheeraj Reddy
 */

public class EmailController extends Controller {

    Logger logger = LoggerFactory.getLogger(EmailController.class);

    private IMail mailService;

    @Inject
    public EmailController(IMail mailService) {
        this.mailService = mailService;
    }

    public Result sendSimpleEmail() {
        try {
            JsonNode mail = request().body().asJson();
            JsonHelper.requestHasRequiredParameters(mail, "subject", "message", "email");
            String subject = JsonHelper.getJsonDataAsText(mail, "subject");
            String message = JsonHelper.getJsonDataAsText(mail, "message");
            String email = JsonHelper.getJsonDataAsText(mail, "email");
            mailService.sendSimpleMail(subject, message, email);
            return Response.okAsJSON("Processing email, usually it takes a few mins to send the email");
        } catch (IllegalArgumentException e) {
            logger.warn("Illegal Argument in email body reason: {}",e.getMessage());
            return Response.errorAsJSON("Invalid email content reason : " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error while sending email reason : {}",e.getMessage());
            return Response.errorAsJSON("Error while sending email , please try after some time");
        }
    }

}
