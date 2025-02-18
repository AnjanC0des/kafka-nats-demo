# kafka-nats-demo
Although Kafka can handle a high volume of data, its doesn't scale well when we want to split data into specific groups.
Considering the use case when the categories of data scales in a huge manner, we will be forced to manage different category data in the same topic/partition.
Using NATS on top of Kafka, we can scale highly categorised data, without sacrificing throughput, durability and order.
