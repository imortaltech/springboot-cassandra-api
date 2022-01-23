package com.hcl.poc.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

import com.hcl.poc.model.*;
import com.hcl.poc.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulePublishLaneTx {

    @Value(value = "${topic.name}")
    private  String TOPIC;

    @Value("${minio.bucket.name}")
    private String bucketName;


    @Autowired
    private KafkaTemplate<String, LaneTransaction> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, LaneEquipments> kafkaTemplateEquipment;


    @Autowired
    private ServiceUtils util;


    /**
     * Randomizing the fields of the object and publishing to the kafka topic
     */
	@Scheduled(fixedRate = 10000)
    public void buildAndPublish(){

        /**
         *Randomizing the field values of the lane transaction object
         */
        LaneTransaction laneTransaction=new LaneTransaction(
                new Header(
                        util.getInteger(100000,150000),
                        util.getRandomElementFromString(Arrays.asList("NT01","NT02","NT03","NT04")),
                        util.getInteger(0,2),
                        Calendar.getInstance().getTimeInMillis(),
                        "SOV",
                        Integer.parseInt(util.getRandomElementFromString(Arrays.asList("10","16"))),
                        util.getInteger(0,1),
                        util.getRandomElementFromString(Arrays.asList("OPEN","HOLD","WORK IN PROGRESS")),
                        util.getString(13),
                        util.getRandomElementFromString(Arrays.asList("YES","NO")),
                        util.getRandomElementFromString(Arrays.asList("YES","NO"))
                ),
                new TransactionBody(
                        util.getInteger(10000,20000),
                        util.getInteger(0,2),
                        util.getInteger(40,60),
                        util.getInteger(1,5),
                        util.getInteger(0,1),
                        util.getInteger(0,1),
                        util.getString(5),
                        util.getInteger(900,999),
                        util.getRandomElementFromString(Arrays.asList("HOME","AWAY")),
                        util.getRandomElementFromString(Arrays.asList("LCVT","LCVD","NONREV","LOSTSTOLEN","INVALID","LOWBAL","GOOD")),
                        util.getInteger(1,9),
                        util.getRandomElementFromString(Arrays.asList("REGULAR","HOV-3","HOV-2","SOV")),
                        util.getRandomElementFromString(Arrays.asList("YES","NO")),
                        util.getInteger(1,3),
                        util.getInteger(1,3),
                        util.getRandomElementFromString(Arrays.asList("UNKNOWN","RUNT","ROUGH","ETC_VIOL","EXEMPT","TICKET","UNPAIDTOLL","NONREV","CREDITCARD","CASH","VIOLATION","ETC"))
                )
        );
        System.out.println(laneTransaction.toString());

        //Publishing the lane transaction object to topic
        kafkaTemplate.send(TOPIC,laneTransaction);

        /**
         *Randomizing the field values of the lane equipment error object
         */
        LaneEquipments laneEquipments=new LaneEquipments(
                new Header(
                        util.getInteger(100000,150000),
                        util.getRandomElementFromString(Arrays.asList("NT01","NT02","NT03","NT04")),
                        util.getInteger(0,1),
                        Calendar.getInstance().getTimeInMillis(),
                        "SOV",
                        100, // error Record type
                        util.getInteger(0,1),
                        util.getRandomElementFromString(Arrays.asList("OPEN","HOLD","WORK IN PROGRESS")),
                        util.getString(13),
                        util.getRandomElementFromString(Arrays.asList("YES","NO")),
                        util.getRandomElementFromString(Arrays.asList("YES","NO"))
                ),
                new ErrorMessage(
                        util.getInteger(10000,30000),
                        util.getInteger(40,50),
                        util.getString(15)
                )
        );
        System.out.println(laneEquipments.toString());

        //Publishing lane equipment error message to topic
        kafkaTemplateEquipment.send(TOPIC,laneEquipments);
    }


}
