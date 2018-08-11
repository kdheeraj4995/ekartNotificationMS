package controllers;

import com.dheeraj.utility.helper.Response;
import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import services.IMail;

/**
 * @author Dheeraj Reddy
 */

public class EmailController extends Controller {

    private IMail mailService;

    @Inject
    public EmailController(IMail mailService) {
        this.mailService = mailService;
    }

    public Result sendSimpleEmail() {
        mailService.sendSimpleMail();
        return Response.okAsJSON("Mail Sent");
    }

}
