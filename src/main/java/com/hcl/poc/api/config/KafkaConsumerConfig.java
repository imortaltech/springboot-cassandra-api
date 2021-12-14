package com.hcl.poc.api.config;

import com.hcl.poc.api.model.AggVehicle;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${kafka.bootstrap.server}")
    String bootstrapServer;

    @Value("${kafka.groupId}")
    String groupId;

    @Bean
    public ConsumerFactory<String, AggVehicle> vehicleConsumerFactory(){
        Map<String,Object> configs=new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);

        return new DefaultKafkaConsumerFactory<>(configs,new StringDeserializer(),new JsonDeserializer<>(AggVehicle.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,AggVehicle> vehicleKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,AggVehicle> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(vehicleConsumerFactory());
        return  factory;
    }
}
