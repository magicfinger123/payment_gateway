/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.shared;

import com.cwg.payment.payment_gateway.exceptions.UserServiceException;
import com.cwg.payment.payment_gateway.io.SuccessMessage;
import com.cwg.payment.payment_gateway.io.entity.UserEntity;
import com.cwg.payment.payment_gateway.model.response.ApiResponse;
import com.cwg.payment.payment_gateway.model.response.ResponseBuilder;
import com.cwg.payment.payment_gateway.repository.UserRepository;
import com.cwg.payment.payment_gateway.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;

@Component
public class Utils {
    private Random RANDOM = new SecureRandom();
    private   final String ALPHABETS = "0123456789abcdefghijklmnopqrstuvwxyz";
    private   final int ITERATIONS = 1000;
    private   final int KEY_LENGTH = 256;

    @Autowired
    ResponseBuilder responseBuilder;

    @Autowired
    private UserRepository userRepository;

    public String generateId(int length){
        return generateRandomString(length);
    }
    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i <= length; i++){
            returnValue.append(ALPHABETS.charAt(RANDOM.nextInt(ALPHABETS.length())));
        }
        return new String(returnValue);
    }
    public ApiResponse sucessApiResponse(String s) {
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        SuccessMessage successMessage = SuccessMessage.builder().message(s).build();
        apiResponse.responseEntity = ResponseEntity.ok(successMessage);
        return apiResponse;
    }
    public String getDate(){
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return date;*/
        LocalDateTime dateStart = LocalDateTime.now().plusHours(1);
        String d2 = dateStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return d2;
    }
    public String getTime(){
      /*  SimpleDateFormat sdhf = new SimpleDateFormat("HH:mm");
        String time = sdhf.format(new Date());
        return time;*/
        LocalDateTime dateStart = LocalDateTime.now().plusHours(1);
        String d2 = dateStart.format(DateTimeFormatter.ofPattern("HH:mm"));
        return d2;
    }
  /*  public EmailsDto getEmails(String type){
        EmailRecipentEntity emailRecipentEntity = emailsRepository.findByType(type);
        EmailsDto emailsDto = new EmailsDto();
        if (emailRecipentEntity == null){
            emailsDto.setType("");
            emailsDto.setEmailAddress("chops@kreer.ng");
        }else {
            BeanUtils.copyProperties(emailRecipentEntity, emailsDto);
        }
        return emailsDto;
    }*/
    public UserDto getUserDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getPrincipal().toString();
        System.out.println(username);
        UserEntity userId = userRepository.findByUsername(username);
        UserDto userDto = new UserDto();
        if (userId == null){
            throw new UserServiceException("Action successful but could not send notification","could not get user details");
        }
        BeanUtils.copyProperties(userId, userDto);
        return userDto;
    }
    public static String toSentenceCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
    public String currencyFormat(Double amount){
        NumberFormat formatter = new DecimalFormat("#,###.##");
        String formattedNumber = formatter.format(amount);
        return "&#8358; "+formattedNumber;
    }
    /*public static void generatePDFFromHTML(String path,String filename, String html,String pdfPath) throws IOException, DocumentException {
        //Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(pdfPath));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(path));
        //XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));
        document.close();
    }
    public static void htmlGenerator(Map<String, Object> model, Template t, String path) throws IOException {
        Writer file = new FileWriter(new File(path));
        try {
            t.process(model, file);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        file.flush();
        file.close();
    }*/
    public  static void deleteFile(File fil) {
        try {
            fil.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static void deleteFile2(String f) {
        File fil = new File(f);
        try {
            fil.delete();
            //Files.deleteIfExists(fil.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
