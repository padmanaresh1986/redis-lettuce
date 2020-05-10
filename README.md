# redis-lettuce

**Basic Redis Commands**  
Connect redis-cli  
To check server is up or not , run below command should get PONG as response  
>ping  

To set key value pair in redis , response should be OK  
>SET foo 100    
>SET server:name redis  
>SET server:port 8000  

To get value from redis , response should be value
>GET foo  
>GET server:name  
>GET server:port  

To increment and decrement  values in redis , this will change data type to numeric if required  
>INCR foo  
>DECR foo

To check if key exists , 0 means not exists , 1 means exists
>EXISTS foo  

To delete key value pair, 0 means not deleted , 1 means deleted successfully   
>DEL foo  

To write output to file, come out of redis-cli and run below command from terminal  
>redis-cli INCR foo > command.txt  

To monitor the running commands , connect to redis-cli in new terminal  and run below command  
this will monitor the all running commands  
>MONITOR   

To clear all data in redis  
>FLUSHALL  

To set time limit or expiration for a key in seconds  
>SET resource:foo  foovalue  
>EXPIRE resource:foo 120    

To see how much time left for expiry   
>TTL resource:foo  




