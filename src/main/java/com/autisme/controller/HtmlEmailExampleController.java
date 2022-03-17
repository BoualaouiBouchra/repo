package com.autisme.controller;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import com.autisme.MyConstants;
import com.autisme.modal.User;
import com.autisme.payload.request.ContactRequest;
import com.autisme.payload.response.MessageResponse;
import com.autisme.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200/")
public class HtmlEmailExampleController {

	
	@Autowired
	UserService userService;
	
   @Autowired
   public  @Qualifier("primarySender") JavaMailSender emailSender;

   @Autowired
   public  @Qualifier("secondarySender")  JavaMailSender emailSenderContact;

   @ResponseBody
   @GetMapping("/sendHtmlEmail")
   public ResponseEntity<?> sendHtmlEmail(User user) throws MessagingException {
	   
	   
	   List<User> users = userService.findAllUsersNotifier();
	   for (int i = 0; i < users.size(); i++) {
		     
		      sendmail(users.get(i));
		    }
	
	   
	   return new ResponseEntity<>(HttpStatus.OK);
   }
   
   private void sendmail(User user) throws MessagingException {

       MimeMessage message = emailSender.createMimeMessage();

       boolean multipart = true;
        
       MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        
       String htmlMsg = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
       		+ "<html>\r\n"
       		+ "<head>\r\n"
       		+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" >\r\n"
       		+ "<title>Mailto</title>\r\n"
       		+ "<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n"
       		+ "<style type=\"text/css\">\r\n"
       		+ "html { -webkit-text-size-adjust: none; -ms-text-size-adjust: none;}\r\n"
       		+ "\r\n"
       		+ "	@media only screen and (min-device-width: 750px) {\r\n"
       		+ "		.table750 {width: 750px !important;}\r\n"
       		+ "	}\r\n"
       		+ "	@media only screen and (max-device-width: 750px), only screen and (max-width: 750px){\r\n"
       		+ "      table[class=\"table750\"] {width: 100% !important;}\r\n"
       		+ "      .mob_b {width: 93% !important; max-width: 93% !important; min-width: 93% !important;}\r\n"
       		+ "      .mob_b1 {width: 100% !important; max-width: 100% !important; min-width: 100% !important;}\r\n"
       		+ "      .mob_left {text-align: left !important;}\r\n"
       		+ "      .mob_soc {width: 50% !important; max-width: 50% !important; min-width: 50% !important;}\r\n"
       		+ "      .mob_menu {width: 50% !important; max-width: 50% !important; min-width: 50% !important; box-shadow: inset -1px -1px 0 0 rgba(255, 255, 255, 0.2); }\r\n"
       		+ "      .mob_btn {width: 100% !important; max-width: 100% !important; min-width: 100% !important;}\r\n"
       		+ "      .mob_card {width: 88% !important; max-width: 88% !important; min-width: 88% !important;}\r\n"
       		+ "      .mob_title1 {font-size: 36px !important; line-height: 40px !important;}\r\n"
       		+ "      .mob_title2 {font-size: 26px !important; line-height: 33px !important;}\r\n"
       		+ "      .top_pad {height: 15px !important; max-height: 15px !important; min-height: 15px !important;}\r\n"
       		+ "      .mob_pad {width: 15px !important; max-width: 15px !important; min-width: 15px !important;}\r\n"
       		+ "      .top_pad2 {height: 40px !important; max-height: 40px !important; min-height: 40px !important;}\r\n"
       		+ " 	}\r\n"
       		+ "   @media only screen and (max-device-width: 550px), only screen and (max-width: 550px){\r\n"
       		+ "      .mod_div {display: block !important;}\r\n"
       		+ "   }\r\n"
       		+ "	.table750 {width: 750px;}\r\n"
       		+ "</style>\r\n"
       		+ "</head>\r\n"
       		+ "<body style=\"margin: 0; padding: 0;\">\r\n"
       		+ "\r\n"
       		+ "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"background: #f5f8fa; min-width: 340px; font-size: 1px; line-height: normal;\">\r\n"
       		+ " 	<tr>\r\n"
       		+ "   	<td align=\"center\" valign=\"top\">   			\r\n"
       		+ "   		<!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "         <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
       		+ "         <tr><td align=\"center\" valign=\"top\" width=\"750\"><![endif]-->\r\n"
       		+ "   		<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"750\" class=\"table750\" style=\"width: 100%; max-width: 750px; min-width: 340px; background: #f5f8fa;\">\r\n"
       		+ "   			<tr>\r\n"
       		+ "               <td class=\"mob_pad\" width=\"25\" style=\"width: 25px; max-width: 25px; min-width: 25px;\">&nbsp;</td>\r\n"
       		+ "   				<td align=\"center\" valign=\"top\" style=\"background: #ffffff;\">\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"width: 100% !important; min-width: 100%; max-width: 100%; background: #f5f8fa;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"right\" valign=\"top\">\r\n"
       		+ "                           <div class=\"top_pad\" style=\"height: 25px; line-height: 25px; font-size: 23px;\">&nbsp;</div>\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"88%\" style=\"width: 88% !important; min-width: 88%; max-width: 88%;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"left\" valign=\"top\">\r\n"
       		+ "                           <div style=\"height: 30px; line-height: 30px; font-size: 28px;\">&nbsp;</div>\r\n"
       		+ "                           <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "                           <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
       		+ "                           <tr><td align=\"center\" valign=\"top\" width=\"460\"><![endif]-->\r\n"
       		+ "                           <div style=\"display: inline-block; vertical-align: top; width: 74%; min-width: 270px;\">\r\n"
       		+ "                              <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"width: 100% !important; min-width: 100%; max-width: 100%;\">\r\n"
       		+ "                                 <tr>\r\n"
       		+ "                                    <td align=\"left\" valign=\"top\">\r\n"
       		+ "                                       <div style=\"height: 10px; line-height: 10px; font-size: 8px;\">&nbsp;</div>\r\n"
       		+ "                                       <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 128px;\">\r\n"
       		+ "                                          <img src='cid:logo' alt=\"img\" width=\"128\" border=\"0\" style=\"display: block; width: 128px;\" />\r\n"
       		+ "                                       </a>\r\n"
       		+ "                                    </td>\r\n"
       		+ "                                 </tr>\r\n"
       		+ "                              </table>\r\n"
       		+ "                           </div><!--[if (gte mso 9)|(IE)]></td><td align=\"center\" valign=\"top\" width=\"150\"><![endif]--><div style=\"display: inline-block; vertical-align: top; width: 150px;\">\r\n"
       		+ "                              <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"width: 100% !important; min-width: 100%; max-width: 100%;\">\r\n"
       		+ "                                 <tr>\r\n"
       		+ "                                    <td class=\"mob_left\" align=\"right\" valign=\"top\">\r\n"
       		+ "                                       <div style=\"height: 15px; line-height: 15px; font-size: 13px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#949494\" style=\"font-size: 14px; line-height: 18px; font-weight: 700;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #949494; font-size: 14px; line-height: 18px; font-weight: 700;\">FEB 20 — FEB 27</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                    </td>\r\n"
       		+ "                                 </tr>\r\n"
       		+ "                              </table>\r\n"
       		+ "                           </div>\r\n"
       		+ "                           <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "                           </td></tr>\r\n"
       		+ "                           </table><![endif]-->                           \r\n"
       		+ "                           <div class=\"top_pad2\" style=\"height: 70px; line-height: 70px; font-size: 68px;\">&nbsp;</div>\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"88%\" style=\"width: 88% !important; min-width: 88%; max-width: 88%;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"left\" valign=\"top\">\r\n"
       		+ "                           <font class=\"mob_title1\" face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 52px; line-height: 55px; font-weight: 300; letter-spacing: -1.5px;\">\r\n"
       		+ "                              <span class=\"mob_title1\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 52px; line-height: 55px; font-weight: 300; letter-spacing: -1.5px;\">The most popular posts of the last week on Mailto</span>\r\n"
       		+ "                           </font>\r\n"
       		+ "                           <div style=\"height: 22px; line-height: 22px; font-size: 20px;\">&nbsp;</div>\r\n"
       		+ "                           <font class=\"mob_title2\" face=\"'Source Sans Pro', sans-serif\" color=\"#5e5e5e\" style=\"font-size: 36px; line-height: 45px; font-weight: 300; letter-spacing: -1px;\">\r\n"
       		+ "                              <span class=\"mob_title2\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #5e5e5e; font-size: 36px; line-height: 45px; font-weight: 300; letter-spacing: -1px;\">Ready-to-use email templates converting prospects into paying customers</span>\r\n"
       		+ "                           </font>\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"width: 100% !important; min-width: 100%; max-width: 100%;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"center\" valign=\"top\">\r\n"
       		+ "                           <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "                           <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
       		+ "                           <tr><td align=\"center\" valign=\"top\" width=\"325\"><![endif]-->\r\n"
       		+ "                           <div class=\"mob_btn\" style=\"display: inline-block; vertical-align: top; width: 325px;\">\r\n"
       		+ "                              <table class=\"mob_card\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"295\" style=\"width: 295px !important; min-width: 295px; max-width: 295px;\">\r\n"
       		+ "                                 <tr>\r\n"
       		+ "                                    <td align=\"left\" valign=\"top\">\r\n"
       		+ "                                       <div style=\"height: 35px; line-height: 35px; font-size: 33px;\">&nbsp;</div>\r\n"
       		+ "                                       <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 100%;\">\r\n"
       		+ "                                          <img src='cid:logo' alt=\"img\" width=\"100%\" border=\"0\" style=\"display: block; width: 100%;\" />\r\n"
       		+ "                                       </a>\r\n"
       		+ "                                       <div style=\"height: 22px; line-height: 22px; font-size: 20px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#3f51b5\" style=\"font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #3f51b5; font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">Email campaigns</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#101010\" style=\"font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #101010; font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">Effective email marketing techniques backed by data.</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#767676\" style=\"font-size: 17px; line-height: 21px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #767676; font-size: 17px; line-height: 21px;\">230 comments&nbsp;&nbsp;&bull;&nbsp;&nbsp;54,000 views</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 8px; line-height: 8px; font-size: 6px;\">&nbsp;</div>\r\n"
       		+ "                                    </td>\r\n"
       		+ "                                 </tr>\r\n"
       		+ "                              </table>\r\n"
       		+ "                           </div><!--[if (gte mso 9)|(IE)]></td><td align=\"center\" valign=\"top\" width=\"325\"><![endif]--><div class=\"mob_btn\" style=\"display: inline-block; vertical-align: top; width: 325px;\">\r\n"
       		+ "                              <table class=\"mob_card\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"295\" style=\"width: 295px !important; min-width: 295px; max-width: 295px;\">\r\n"
       		+ "                                 <tr>\r\n"
       		+ "                                    <td align=\"left\" valign=\"top\">\r\n"
       		+ "                                       <div style=\"height: 35px; line-height: 35px; font-size: 33px;\">&nbsp;</div>\r\n"
       		+ "                                       <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 100%;\">\r\n"
       		+ "                                          <img src=\"img/pic_2.jpg\" alt=\"img\" width=\"100%\" border=\"0\" style=\"display: block; width: 100%;\" />\r\n"
       		+ "                                       </a>\r\n"
       		+ "                                       <div style=\"height: 22px; line-height: 22px; font-size: 20px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#ff9800\" style=\"font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #ff9800; font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">Marketing</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#101010\" style=\"font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #101010; font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">Elements of a good email permission reminder.</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#767676\" style=\"font-size: 17px; line-height: 21px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #767676; font-size: 17px; line-height: 21px;\">60 comments&nbsp;&nbsp;&bull;&nbsp;&nbsp;25,000 views</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 8px; line-height: 8px; font-size: 6px;\">&nbsp;</div>\r\n"
       		+ "                                    </td>\r\n"
       		+ "                                 </tr>\r\n"
       		+ "                              </table>\r\n"
       		+ "                           </div>\r\n"
       		+ "                           <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "                           </td></tr>\r\n"
       		+ "                           </table><![endif]-->\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"width: 100% !important; min-width: 100%; max-width: 100%;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"center\" valign=\"top\">\r\n"
       		+ "                           <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "                           <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
       		+ "                           <tr><td align=\"center\" valign=\"top\" width=\"325\"><![endif]-->\r\n"
       		+ "                           <div class=\"mob_btn\" style=\"display: inline-block; vertical-align: top; width: 325px;\">\r\n"
       		+ "                              <table class=\"mob_card\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"295\" style=\"width: 295px !important; min-width: 295px; max-width: 295px;\">\r\n"
       		+ "                                 <tr>\r\n"
       		+ "                                    <td align=\"left\" valign=\"top\">\r\n"
       		+ "                                       <div style=\"height: 35px; line-height: 35px; font-size: 33px;\">&nbsp;</div>\r\n"
       		+ "                                       <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 100%;\">\r\n"
       		+ "                                          <img src=\"img/pic_3.jpg\" alt=\"img\" width=\"100%\" border=\"0\" style=\"display: block; width: 100%;\" />\r\n"
       		+ "                                       </a>\r\n"
       		+ "                                       <div style=\"height: 22px; line-height: 22px; font-size: 20px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#ff9800\" style=\"font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #ff9800; font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">Marketing</span>\r\n"
       		+ "                                       </font>                                       \r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#101010\" style=\"font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #101010; font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">15 of the best email marketing case studies you've ever seen.</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#767676\" style=\"font-size: 17px; line-height: 21px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #767676; font-size: 17px; line-height: 21px;\">24 comments&nbsp;&nbsp;&bull;&nbsp;&nbsp;4,200 views</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 8px; line-height: 8px; font-size: 6px;\">&nbsp;</div>\r\n"
       		+ "                                    </td>\r\n"
       		+ "                                 </tr>\r\n"
       		+ "                              </table>\r\n"
       		+ "                           </div><!--[if (gte mso 9)|(IE)]></td><td align=\"center\" valign=\"top\" width=\"325\"><![endif]--><div class=\"mob_btn\" style=\"display: inline-block; vertical-align: top; width: 325px;\">\r\n"
       		+ "                              <table class=\"mob_card\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"295\" style=\"width: 295px !important; min-width: 295px; max-width: 295px;\">\r\n"
       		+ "                                 <tr>\r\n"
       		+ "                                    <td align=\"left\" valign=\"top\">\r\n"
       		+ "                                       <div style=\"height: 35px; line-height: 35px; font-size: 33px;\">&nbsp;</div>\r\n"
       		+ "                                       <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 100%;\">\r\n"
       		+ "                                          <img src=\"img/pic_4.jpg\" alt=\"img\" width=\"100%\" border=\"0\" style=\"display: block; width: 100%;\" />\r\n"
       		+ "                                       </a>\r\n"
       		+ "                                       <div style=\"height: 22px; line-height: 22px; font-size: 20px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#3f51b5\" style=\"font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #3f51b5; font-size: 16px; line-height: 22px; font-weight: 700; text-transform: uppercase;\">Email campaigns</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#101010\" style=\"font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #101010; font-size: 26px; line-height: 33px; font-weight: 300; letter-spacing: -1px;\">Connect with your customers and make more sales.</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 12px; line-height: 12px; font-size: 10px;\">&nbsp;</div>\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#767676\" style=\"font-size: 17px; line-height: 21px;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #767676; font-size: 17px; line-height: 21px;\">60 comments&nbsp;&nbsp;&bull;&nbsp;&nbsp;54,000 views</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                       <div style=\"height: 8px; line-height: 8px; font-size: 6px;\">&nbsp;</div>\r\n"
       		+ "                                    </td>\r\n"
       		+ "                                 </tr>\r\n"
       		+ "                              </table>\r\n"
       		+ "                           </div>\r\n"
       		+ "                           <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "                           </td></tr>\r\n"
       		+ "                           </table><![endif]-->\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"88%\" style=\"width: 88% !important; min-width: 88%; max-width: 88%; border-width: 1px; border-style: solid; border-color: #e8e8e8; border-top: none; border-left: none; border-right: none;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"center\" valign=\"top\">\r\n"
       		+ "                           <div style=\"height: 40px; line-height: 40px; font-size: 38px;\">&nbsp;</div>\r\n"
       		+ "                           <table class=\"mob_btn\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background: #27cbcc; border-radius: 4px;\">\r\n"
       		+ "                              <tr>\r\n"
       		+ "                                 <td align=\"center\" valign=\"top\"> \r\n"
       		+ "                                    <a href=\"#\" target=\"_blank\" style=\"display: block; border: 1px solid #27cbcc; border-radius: 4px; padding: 19px 26px; font-family: 'Source Sans Pro', Arial, Verdana, Tahoma, Geneva, sans-serif; color: #ffffff; font-size: 26px; line-height: 30px; text-decoration: none; white-space: nowrap; font-weight: 600;\">\r\n"
       		+ "                                       <font face=\"'Source Sans Pro', sans-serif\" color=\"#ffffff\" style=\"font-size: 26px; line-height: 30px; text-decoration: none; white-space: nowrap; font-weight: 600;\">\r\n"
       		+ "                                          <span style=\"font-family: 'Source Sans Pro', Arial, Verdana, Tahoma, Geneva, sans-serif; color: #ffffff; font-size: 26px; line-height: 30px; text-decoration: none; white-space: nowrap; font-weight: 600;\">More&nbsp;Articles</span>\r\n"
       		+ "                                       </font>\r\n"
       		+ "                                    </a>\r\n"
       		+ "                                 </td>\r\n"
       		+ "                              </tr>\r\n"
       		+ "                           </table>\r\n"
       		+ "                           <div style=\"height: 50px; line-height: 50px; font-size: 48px;\">&nbsp;</div>\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"88%\" style=\"width: 88% !important; min-width: 88%; max-width: 88%;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td class=\"mob_left\" align=\"center\" valign=\"top\">\r\n"
       		+ "                           <div style=\"height: 25px; line-height: 25px; font-size: 23px;\">&nbsp;</div>\r\n"
       		+ "                           <font face=\"'Source Sans Pro', sans-serif\" color=\"#767676\" style=\"font-size: 17px; line-height: 23px;\">\r\n"
       		+ "                              <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #767676; font-size: 17px; line-height: 23px;\">From time to time, we send new hot collections to all members of Mailto. We hope you find them useful. If not, you can <a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 23px; text-decoration: none;\">unsubscribe</a> from our digest.</span>\r\n"
       		+ "                           </font>\r\n"
       		+ "                           <div style=\"height: 28px; line-height: 28px; font-size: 26px;\">&nbsp;</div>\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>\r\n"
       		+ "\r\n"
       		+ "                  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"width: 100% !important; min-width: 100%; max-width: 100%; background: #f5f8fa;\">\r\n"
       		+ "                     <tr>\r\n"
       		+ "                        <td align=\"center\" valign=\"top\">\r\n"
       		+ "                           <div style=\"height: 34px; line-height: 34px; font-size: 32px;\">&nbsp;</div>\r\n"
       		+ "                           <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"88%\" style=\"width: 88% !important; min-width: 88%; max-width: 88%;\">\r\n"
       		+ "                              <tr>\r\n"
       		+ "                                 <td align=\"center\" valign=\"top\">\r\n"
       		+ "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"78%\" style=\"min-width: 300px;\">\r\n"
       		+ "                                       <tr>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\" width=\"23%\">                                             \r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">\r\n"
       		+ "                                                <font face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">\r\n"
       		+ "                                                   <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">HELP&nbsp;CENTER</span>\r\n"
       		+ "                                                </font>\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\" width=\"10%\">\r\n"
       		+ "                                             <font face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 17px; line-height: 17px; font-weight: bold;\">\r\n"
       		+ "                                                <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 17px; font-weight: bold;\">&bull;</span>\r\n"
       		+ "                                             </font>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\" width=\"23%\">\r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">\r\n"
       		+ "                                                <font face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">\r\n"
       		+ "                                                   <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">SUPPORT&nbsp;24/7</span>\r\n"
       		+ "                                                </font>\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\" width=\"10%\">\r\n"
       		+ "                                             <font face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 17px; line-height: 17px; font-weight: bold;\">\r\n"
       		+ "                                                <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 17px; font-weight: bold;\">&bull;</span>\r\n"
       		+ "                                             </font>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\" width=\"23%\">\r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">\r\n"
       		+ "                                                <font face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">\r\n"
       		+ "                                                   <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 14px; line-height: 20px; text-decoration: none; white-space: nowrap; font-weight: bold;\">ACCOUNT</span>\r\n"
       		+ "                                                </font>\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                       </tr>\r\n"
       		+ "                                    </table>\r\n"
       		+ "                                    <div style=\"height: 34px; line-height: 34px; font-size: 32px;\">&nbsp;</div>\r\n"
       		+ "                                    <font face=\"'Source Sans Pro', sans-serif\" color=\"#868686\" style=\"font-size: 17px; line-height: 20px;\">\r\n"
       		+ "                                       <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #868686; font-size: 17px; line-height: 20px;\">Copyright &copy; 2017 Mailto. All&nbsp;Rights&nbsp;Reserved. We&nbsp;appreciate&nbsp;you!</span>\r\n"
       		+ "                                    </font>\r\n"
       		+ "                                    <div style=\"height: 3px; line-height: 3px; font-size: 1px;\">&nbsp;</div>\r\n"
       		+ "                                    <font face=\"'Source Sans Pro', sans-serif\" color=\"#1a1a1a\" style=\"font-size: 17px; line-height: 20px;\">\r\n"
       		+ "                                       <span style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 20px;\"><a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 20px; text-decoration: none;\">help@mailto.com</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 20px; text-decoration: none;\">1(800)232-90-26</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a href=\"#\" target=\"_blank\" style=\"font-family: 'Source Sans Pro', Arial, Tahoma, Geneva, sans-serif; color: #1a1a1a; font-size: 17px; line-height: 20px; text-decoration: none;\">Unsubscribe</a></span>\r\n"
       		+ "                                    </font>\r\n"
       		+ "                                    <div style=\"height: 35px; line-height: 35px; font-size: 33px;\">&nbsp;</div>\r\n"
       		+ "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
       		+ "                                       <tr>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\">\r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 19px;\">\r\n"
       		+ "                                                <img src=\"img/soc_1.png\" alt=\"img\" width=\"19\" border=\"0\" style=\"display: block; width: 19px;\" />\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td width=\"45\" style=\"width: 45px; max-width: 45px; min-width: 45px;\">&nbsp;</td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\">\r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 18px;\">\r\n"
       		+ "                                                <img src=\"img/soc_2.png\" alt=\"img\" width=\"18\" border=\"0\" style=\"display: block; width: 18px;\" />\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td width=\"45\" style=\"width: 45px; max-width: 45px; min-width: 45px;\">&nbsp;</td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\">\r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 21px;\">\r\n"
       		+ "                                                <img src=\"img/soc_3.png\" alt=\"img\" width=\"21\" border=\"0\" style=\"display: block; width: 21px;\" />\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                          <td width=\"45\" style=\"width: 45px; max-width: 45px; min-width: 45px;\">&nbsp;</td>\r\n"
       		+ "                                          <td align=\"center\" valign=\"top\">\r\n"
       		+ "                                             <a href=\"#\" target=\"_blank\" style=\"display: block; max-width: 25px;\">\r\n"
       		+ "                                                <img src=\"img/soc_4.png\" alt=\"img\" width=\"25\" border=\"0\" style=\"display: block; width: 25px;\" />\r\n"
       		+ "                                             </a>\r\n"
       		+ "                                          </td>\r\n"
       		+ "                                       </tr>\r\n"
       		+ "                                    </table>\r\n"
       		+ "                                    <div style=\"height: 35px; line-height: 35px; font-size: 33px;\">&nbsp;</div>\r\n"
       		+ "                                 </td>\r\n"
       		+ "                              </tr>\r\n"
       		+ "                           </table>\r\n"
       		+ "                        </td>\r\n"
       		+ "                     </tr>\r\n"
       		+ "                  </table>  \r\n"
       		+ "\r\n"
       		+ "               </td>\r\n"
       		+ "               <td class=\"mob_pad\" width=\"25\" style=\"width: 25px; max-width: 25px; min-width: 25px;\">&nbsp;</td>\r\n"
       		+ "            </tr>\r\n"
       		+ "         </table>\r\n"
       		+ "         <!--[if (gte mso 9)|(IE)]>\r\n"
       		+ "         </td></tr>\r\n"
       		+ "         </table><![endif]-->\r\n"
       		+ "      </td>\r\n"
       		+ "   </tr>\r\n"
       		+ "</table>\r\n"
       		+ "</body>\r\n"
       		+ "</html><h1>Im testing send a HTML email</h1>"
               +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
        
      
    // helper.addInline("logo",new File("C:/img/logo.png"));
    // helper.addInline("logo", new ClassPathResource("img/logo.png"));
       helper.addAttachment("logo", new ClassPathResource("logo.png"));
       
       //helper.addInline("rad", new File("C:/img/rad.png"));
       
       message.setContent(htmlMsg, "text/html");
       
       helper.setTo(user.getEmail());
        
       helper.setSubject("Test send HTML email");
    
       this.emailSender.send(message);

      
   }
   
   
   @PostMapping("/contactUs")
	public ResponseEntity<?> contact(@Valid @RequestBody ContactRequest contactRequest)throws MessagingException {
	   MimeMessage message = emailSenderContact.createMimeMessage();

       boolean multipart = true;
        
       MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        
       String htmlMsg ="<!DOCTYPE html>\r\n"
       		+ "<html>\r\n"
       		+ "<head>\r\n"
       		+ "<style>\r\n"
       		+ "table {\r\n"
       		+ "  font-family: arial, sans-serif;\r\n"
       		+ "  border-collapse: collapse;\r\n"
       		+ "  width: 100%;\r\n"
       		+ "}\r\n"
       		+ "\r\n"
       		+ "td, th {\r\n"
       		+ "  border: 1px solid #dddddd;\r\n"
       		+ "  text-align: left;\r\n"
       		+ "  padding: 8px;\r\n"
       		+ "}\r\n"
       		+ "\r\n"
       		+ "tr:nth-child(even) {\r\n"
       		+ "  background-color: #dddddd;\r\n"
       		+ "}\r\n"
       		+ "</style>"
       		+ "</head>\r\n"
       		+ "<body>\r\n"
       		+ "\r\n"
       		+ "<h2>Message Client</h2>\r\n"
       		+ "\r\n"
       		+ "<table>\r\n"
       		+ "  <tr>\r\n"
       		+ "    <th>Nom</th>\r\n"
       		+ "    <td>"+contactRequest.getNom()+"</td>\r\n"
       		+ "  </tr>\r\n"	
       		+ "  <tr>\r\n"
       		+ "    <th>Prénom</th>\r\n"
       		+ "    <td>"+contactRequest.getPrenom()+"</td>\r\n"
       		+ "  </tr>\r\n"	
       		+ "  <tr>\r\n"
       		+ "    <th>Email</th>\r\n"
       		+ "    <td>"+contactRequest.getEmail()+"</td>\r\n"
       		+ "  </tr>\r\n"	
       		+ "  <tr>\r\n"
       		+ "    <th>Sujet</th>\r\n"
       		+ "    <td>"+contactRequest.getSubject()+"</td>\r\n"
       		+ "  </tr>\r\n"	
       		+ "  <tr>\r\n"
       		+ "    <th>Message</th>\r\n"
       		+ "    <td>"+contactRequest.getMessage()+"</td>\r\n"
       		+ "  </tr>\r\n"	
       		+ "</table>\r\n"
       		+ "\r\n"
       		+ "</body>\r\n"
       		+ "</html>\r\n"
       		+ "";
       
       message.setContent(htmlMsg, "text/html");
       
       helper.setTo(MyConstants.MY_EMAIL);
       
       helper.setSubject(contactRequest.getSubject());
    
       this.emailSenderContact.send(message);


		return ResponseEntity.ok(new MessageResponse("Email Envoyer avec succès !"));
	}
}