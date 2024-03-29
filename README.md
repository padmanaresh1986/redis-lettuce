# redis-lettuce

https://github.com/redis-developer/redis-bike-co

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

To scan the keys based on index
>MSET key1 1 key2 2 key3 3 key4 4 key5 5 key6 6 key7 7 key8 8 key9 9 key10 10 key11 11 key12 12 key13 13    
>SCAN 0  
>SCAN 13  

To specify the count in scan (default 10)  
>SCAN 0 COUNT 3  

To scan match specific keys  
>SCAN 0 MATCH key1*  

To see all keys at a time which matching the pattern  
>KEYS *  
>KEYS key1*  

**Client and Config Commands**  
To get the server configuration 
>CONFIG GET \*    
>CONFIG GET \*max\*  
>CONFIG GET PORT  

To set the server configuration with out restart redis
>CONFIG SET lua-time-limit 6000  

To see all information about server  memory,clients,cpu..  
>INFO  
>INFO memory  

To see the all commands 
>COMMAND  
>COMMAND INFO readonly  

To see the list of clients connected to server  
>CLIENT LIST  
>CLIENT SETNAME bar  
>CLIENT GETNAME  
>CLINET KILL ip:port  

**Data types in Redis**  
Lists are the common data type in redis to hold list of values  
To create List , LPUSH create new list for first time  
> LPUSH friends bob  

To add element to existing list , do LPUSH again on existing list  or RPUSH to add from right side  
>LPUSH friends fred  
>RPUSH friends tom 

To see all elements in the list   
>LRANGE friends 0 -1  

To see specific elements in a range  
>LRANGE friends 1 2  

To find the length of list 
>LLEN friends  

To remove elements from list from left side and right side  
>LPOP friends
>RPOP friends

To insert element at specific index of the list 
>LINSERT friends BEFORE "bob" "kevin"  

Sets are un-ordered collection of elements and no duplicates allowed  

To create a new set 
>SADD carmakes "Toyota"    
>SADD carmakes "Ford"  
>SADD carmakes "Chevy"  
>SADD carmakes "Honda"  

To check if a member exists in the set 
>SISMEMBER carmakes "Honda"  
>SISMEMBER carmakes "Hondas"  

To see the all the members in the set
>SMEMBERS carmakes  

To find the size of the set 
>SCARD carmakes  

To move member from one set to another set
>SADD mycars "Acura"  
>SMOVE carmakes mycars "Toyota"  
>SMEMBERS mycars  

To union and intersect two sets 
>SUNION carmakes mycars  
>SDIFF carmakes mycars  

To get the random member from the set 
>SRANDMEMBER carmakes  
>SRANDMEMBER carmakes 2  

To remove the random member from the set
>SPOP carmakes  

Sorted sets are sorted based on score , which every member associates with score.  
Score is required.  
if you add member without score will throw error.  

To create new Sorted set 
>ZADD people 1970 "john Doe"  
>ZADD people 1985 "sAM SIMITH"  
>ZADD people 1990 "jen"  

To see the all the members in sorted set                                                                   
>ZRANGE people 0 -1    
>ZRANGEBYSCORE people 1970 1986    

To see the rank of member    
>ZRANK people "john Doe"  

To see the size of sorted set     
>ZCARD people  

To increment the score of member  
>ZINCRBY people 1 "john Doe"  
>ZSCORE  people "john Doe"  

Hashes are maps between string key and string value , similar to JSON  

To create a new hash  
>HSET user:john name "John Doe"  
>HGET user:john name

To set multiple fields to hash  
> HMSET user:kate name "Kate Simith" email "kate@gamil.com" age "30"    
>HGET user:kate age  
>HGET user:kate name  
>HMGET user:kate name email age 
>HGETALL user:kate  

To get only keys or values  
>HKEYS user:kate  
>HVALS user:kate  

To increment any field value  
>HINCRBY user:kate age 1  

To delete a field from hash  
>HDEL user:kate age  

To get the size of the hash
> HLEN user:kate     



**Useful Links**  
https://docs.spring.io/spring-data/redis/docs/2.2.7.RELEASE/reference/html/#redis  
https://medium.com/@hulunhao/how-to-use-redis-template-in-java-spring-boot-647a7eb8f8cc  


Credits to Rockey Bhatia for below blog post

𝐖𝐡𝐚𝐭 𝐦𝐚𝐤𝐞𝐬 𝐑𝐞𝐝𝐢𝐬 𝐢𝐧𝐜𝐫𝐞𝐝𝐢𝐛𝐥𝐲 𝐟𝐚𝐬𝐭?


Redis (Remote Dictionary Server) is known for its exceptional speed and performance. There are several reasons why Redis is considered fast:

𝙄𝒏-𝒎𝙚𝒎𝙤𝒓𝙮 𝙙𝒂𝙩𝒂 𝒔𝙩𝒐𝙧𝒂𝙜𝒆: Redis is primarily an in-memory data store, which is stored and accessed directly from the server's RAM, eliminating disk I/O operations significantly slower than memory access, resulting in faster data retrieval and manipulation.

𝙎𝒊𝙢𝒑𝙡𝒆 𝒅𝙖𝒕𝙖 𝙨𝒕𝙧𝒖𝙘𝒕𝙪𝒓𝙚𝒔: Redis supports various data structures like strings, lists, sets, hashes, and sorted sets. These data structures are optimized for performance and allow for efficient operations, making Redis a highly performant key-value store.

𝙎𝒊𝙣𝒈𝙡𝒆-𝒕𝙝𝒓𝙚𝒂𝙙𝒆𝙙 𝙖𝒓𝙘𝒉𝙞𝒕𝙚𝒄𝙩𝒖𝙧𝒆: Redis follows a single-threaded, event-driven architecture eliminating the need for context switching and locking mechanisms, reducing overhead and improving overall performance. It also allows Redis to handle many concurrent requests without the overhead of managing multiple threads.

𝘼𝒔𝙮𝒏𝙘𝒉𝙧𝒐𝙣𝒐𝙪𝒔 𝒐𝙥𝒆𝙧𝒂𝙩𝒊𝙤𝒏𝙨: Redis supports asynchronous operations, allowing clients to send multiple commands without waiting for a response, and improves throughput by reducing the time spent waiting for network round trips.

𝙈𝒊𝙣𝒊𝙢𝒂𝙡 𝙙𝒊𝙨𝒌 𝒑𝙚𝒓𝙨𝒊𝙨𝒕𝙚𝒏𝙘𝒆: Although Redis is primarily an in-memory database, it provides options for disk persistence to ensure data durability. However, Redis uses an append-only file (AOF) and point-in-time snapshots rather than continuously writing data to disk, minimising disk I/O and maintaining high performance.

𝙊𝒑𝙩𝒊𝙢𝒊𝙯𝒆𝙙 𝙙𝒂𝙩𝒂 𝒔𝙩𝒓𝙪𝒄𝙩𝒖𝙧𝒆𝙨 𝙖𝒏𝙙 𝙖𝒍𝙜𝒐𝙧𝒊𝙩𝒉𝙢𝒔: Redis is designed with performance in mind. It utilise efficient data structures and algorithms to achieve high-speed operations. For example, Redis cleverly uses data structures like skip lists and hash tables, which provide fast access and search capabilities.

𝙉𝒐𝙣-𝙗𝒍𝙤𝒄𝙠𝒊𝙣𝒈 𝑰/𝑶: Redis uses non-blocking I/O operations, leveraging the asynchronous nature of modern operating systems, allowing Redis to efficiently handle many concurrent connections without being limited by traditional blocking I/O mechanisms.

Overall, Redis combines several performance-oriented design choices, including in-memory storage, a single-threaded architecture, asynchronous operations, optimised data structures, and non-blocking I/O, to deliver exceptional speed and responsiveness.












