package com.hcl.poc.utils;

import java.io.IOException;
import java.util.Calendar;

import com.hcl.poc.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.poc.model.Vehicle;

@Component
public class SchedulePublish {
	
	@Value(value = "${topic.name}")
    private  String TOPIC;

	@Value("${minio.bucket.name}")
	private String bucketName;
	
	
	@Autowired
	private KafkaTemplate<String, Vehicle> kafkaTemplate;
	
	@Autowired
	private PerturbData perturbData;
	
	@Autowired
	private ServiceUtils util;

	@Autowired
	private MinioService minioService;

	/**
	 * Randomizing the fields of the object and publishing to the kafka topic
	 * @throws IOException
	 * @throws InterruptedException
	 */
//	@Scheduled(fixedRate = 5000)
    	public void buildAndPublish(){

		// Uploading file to the bucket
		String fileUrl=minioService.upload(bucketName);
		/**
		*Randomizing the field values
		*/
            Vehicle vehicle=new Vehicle(
					util.getRandomElementFromString(perturbData.typeList),
					util.getString(7),
					util.getInteger(1, 5),
					util.getString(10),
					util.getRandomElementFromString(perturbData.cityList),
					util.getRandomElementFromString(perturbData.tagTypes),
					util.getInteger(1, 9),
					util.getInteger(20, 60),
					Calendar.getInstance().getTimeInMillis(),
					util.getString(4),
					util.getRandomElementFromString(perturbData.tagInstituion),
					util.getString(11),
					util.getRandomElementFromString(perturbData.statusList),
					util.getInteger(1, 10),
					util.getRandomElementFromString(perturbData.statusList),
					fileUrl
			);
            System.out.println(vehicle.toString());
            //Publishing to topic
            kafkaTemplate.send(TOPIC,vehicle);
	}

	
}
