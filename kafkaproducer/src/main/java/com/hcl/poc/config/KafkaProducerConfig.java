package com.hcl.poc.config;

import com.hcl.poc.model.LaneEquipments;
import com.hcl.poc.model.LaneTransaction;
import com.hcl.poc.model.Vehicle;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;


    @Bean
    public ProducerFactory<String, Vehicle> producerFactory()
    {
        Map<String, Object> config = new HashMap<String, Object>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public ProducerFactory<String, LaneTransaction> producerFactoryTx()
    {
        Map<String, Object> config = new HashMap<String, Object>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public ProducerFactory<String, LaneEquipments> producerFactoryEquipments()
    {
        Map<String, Object> config = new HashMap<String, Object>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public KafkaTemplate<String, Vehicle> kafkaTemplateVehicle()
    {
        return new KafkaTemplate<String,Vehicle>(
                producerFactory());
    }

    @Bean
    public KafkaTemplate<String, LaneTransaction> kafkaTemplateTx()
    {
        return new KafkaTemplate<String,LaneTransaction>(
                producerFactoryTx());
    }

    @Bean
    public KafkaTemplate<String, LaneEquipments> kafkaTemplateEquipments()
    {
        return new KafkaTemplate<String,LaneEquipments>(
                producerFactoryEquipments());
    }

}
