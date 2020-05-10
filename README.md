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
>INCRBY foo 100  
>DECR foo  
>DECRBY foo 100  

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

**Key Value pair commands**    
To set multiple keys to values at once    
if value already exists for specific key then it will override, use second command to skip override        
>MSET key1 "Hello" key2 "World"      
>MSETNX key1 "Hello" key2 "World"    

To get multiple values at once    
>MGET key1 key2    

To append value to existing value , create new if key does not exists    
>SET greeting "Hello"    
>APPEND greeting " World"    
>GET greeting  

To get the substring of value ,-1 is unbounded to read all string    
>SET mystring "This is my string"    
>GETRANGE mystring  0 -1      
>GETRANGE mystring  0 5      

To rename a key,  NX version only works when new key does not exists    
>RENAME greeting greet  
>GET greet  
>RENAMENX greet greet1  

To get the old value and set the new value  
>GETSET mystring "newstring"  
"This is my string"    


To set value along with expiry , NX works only when key does not exists  
>SETEX key1 10 "value1"   
>SETNX key1 10 "value1"  
>TTL key1  

To remove expiry on key 
>PERSIST key1 










