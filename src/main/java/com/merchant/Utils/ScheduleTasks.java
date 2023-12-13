package com.merchant.Utils;


import com.merchant.Data.Entity.Merchant;
import com.merchant.Data.Repository.MerchantRepository;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class ScheduleTasks {

    @Autowired
    MerchantRepository merchantRepository;
    @Autowired
    private MailSenderClass mailSenderClass;



    @Scheduled(cron = "0 27 17 * * ? ")
    public void findAllMerchant() throws InterruptedException, IOException {
        List<Merchant> merchantList = merchantRepository.findAll();
        String fileName="MerchantDetails.csv";
        if(!merchantList.isEmpty()){
            writeDataToCsv(merchantList,fileName);

        try{
            mailSenderClass.sendMailWithAttachment("rohit2154045@gmail.com","CSV File","Merchant Details","C:\\Users\\NVP\\Downloads\\Java Projects\\MerchantRelationshipManagment\\MerchantDetails.csv");
        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        }
    }
    public void writeDataToCsv(List<Merchant> merchantList, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Email", "PhoneNumber", "BusinessName", "MerchantType", "UniqueId", "isActive");
            for (Merchant entity : merchantList) {
                csvPrinter.printRecord(entity.getEmail(), entity.getPhonenumber(), entity.getBusinessname(),
                        entity.getMerchanttype(), entity.getUniqueid(), entity.getIsactive());
            }
        }
    }

}
