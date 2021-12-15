# springboot-cassandra-api
**Purpose**
```
The purpose of this project is to expose endpoints for the cassandra and kafka data to share across.
```
**Endpoint exposed**
```
1. host:port/vehicle/getAllVehicles : Getting all the vehilces from the cassandra schema
2. host:port/vehicle/aggVehicle : Getting all the aggregated values from the kafka.
```
**Configurable**
```
spring.data.cassandra.keyspace-name=vehicle
spring.data.cassandra.contact-points=127.0.0.1
spring.data.cassandra.port=9042
spring.data.cassandra.local-datacenter=datacenter1

kafka.bootstrap.server=localhost:9092
kafka.groupId=poc
```
**Cassandra configs**
```
Keyspace name: vehicle
table name : vehicleinfo
table desc: 
vehicle.vehicleinfo (
            uuid uuid PRIMARY KEY,
            accountstatus text,
            enginenumber text,
            fileurl text,
            laneid int,
            registeredcity text,
            taginstitution text,
            tagnumber text,
            tagstatus text,
            tagtype text,
            tollplazaid text,
            txntime timestamp,
            vehicleid int,
            vehiclenumber text,
            vehicleseqnumber bigint,
            vehiclespeed int,
            vehicletype text
        )
```
