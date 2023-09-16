package com.example.test.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@Component
public class RedisUtils {
    protected static Logger logger= LoggerFactory.getLogger(RedisUtils.class);
    private static  RedisTemplate redisTemplate = null;

    public RedisUtils() {

    }

    /**
     *
     */
    public static void setRedisTemplate(RedisTemplate template) {
         redisTemplate=template;
    }
    /**
     *
     */
    public static RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 写入缓存
     */
    public static boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("写入Redis异常：{}",e);
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     */
    public static boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            logger.error("写入Redis异常,设定失效时间：{}",e);
        }
        return result;
    }

    /**
     * 批量删除对应的value
     */
    public static void remove(final String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }
       /* for (String key : keys) {
            //remove(key);
            redisTemplate.delete(key);
        }*/
    }

    /**
     * 批量删除key
     */
    public static void removePattern(final String pattern) {
        if (pattern.substring(pattern.length() - 1, pattern.length()).equals("*")) {
            removeByKeys(pattern.substring(0, pattern.length() - 1));
        } else {
            Set<Serializable> keys = redisTemplate.keys(pattern);
            if (keys.size() > 0) {
                redisTemplate.delete(keys);
            }
        }

    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public static void removeByPattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if(!CollectionUtils.isEmpty(keys))
            redisTemplate.delete(keys);
    }


    /**
     * 批量删除key 集群模式
     */
    public static void removeByKeys(final String pattern) {
        List<Object> objectList = RedisUtils.getListByKey(pattern);
        if (objectList != null) {
            String keys[] = ((List<String>) (List) objectList).toArray(new String[objectList.size()]);
            if (keys.length > 0) {
                RedisUtils.remove(keys);
                logger.debug("出现新增、修改、删除操作，清空对应Mapper所有缓存--》" + (keys.length));
            }
        }
    }

    /**
     * 删除对应的value
     */
    public static void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     */
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     */
    public static Object get(final String key) {
        Object result = null;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            result = operations.get(key);
        } catch (Exception e) {
            logger.error("获取Redis缓存key：{}，异常：{}", key, e);
            //throw new RuntimeException("redis连接失败，请查看redis是否启动");
        }

        return result;
    }

    /**
     * @annotation hash里的key以及Field都存在时返回true否则返回fasle
     * @param key hash里的key
     * @param hashKey hash里的Field
     * @return
     */
    public static boolean existshKeyField(Object key,Object hashKey){
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * @annotation 根据Key获取Hash里的所有的Value
     * @param key
     * @return
     */
    public static List getAllHashValues(String key){
        List result = redisTemplate.opsForHash().values(key);
        return result;
    }

    /**
     * @annotation 根据Hash里的Key和Field删除对应的Value
     * @param key
     * @param field
     * @return
     */
    public static Long deleteHashValueByKeyField(String key,String field){
        Long result = redisTemplate.opsForHash().delete(key, field);
        return result;
    }

    /**
     * 哈希 添加
     */
    public static void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * 哈希获取数据
     */
    public static Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 修改Hash里的值
     * @param key
     * @param hashKey
     * @param hashValue
     * @return
     */
    public static void hmUpdate(String key,Object hashKey,Object hashValue){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        Long aLong = deleteHashValueByKeyField(key, hashKey.toString());
        if (aLong>0) {
            hmSet(key, hashKey, hashValue);
        }
    }

    /**
     * 列表添加(追加)
     */
    public static void rightPush(String k, Object v) {
        List<Object> objectList = RedisUtils.getListByKey(k);
        boolean flag = false;
        if (objectList != null && v != null) {
            for (Object o : objectList) {
                if (v instanceof String && o.toString().equals(v.toString())) {
                    flag = true;
                    break;
                }
            }
        }
        if (v != null && !flag) {
            ListOperations<String, Object> list = redisTemplate.opsForList();
            list.rightPush(k, v);
        }

    }
    /**
     * 列表添加(在顶部追加)
     */
    public static void leftPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }
    /**
     * @param k  主键
     * @author zhaozw
     * @date 2020/3/31 11:01
     * @description 通过主键获取所有集合
     */
    public static List<Object>  getListByKey(String k) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        List<Object> valueList= list.range(k,0l,10000l);
        return valueList;
    }

    /**
     * 列表获取
     */
    public static List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * 集合添加
     */
    public static void add(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     */
    public static Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     */
    public static void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     */
    public static Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * @author zhaozw
     * @date 2020/3/31 13:09
     * @description 获取所有keys
     */
    public static Set<Object> getKeysBykey(String key) {
        Set<Object> setKey= redisTemplate.keys(key);
        return setKey;
    }

    /**
     * 当key不存在时插入数据
     *
     * @param key        键
     * @param value      值
     * @param expireTime 有效期
     * @param timeUnit   时间单位
     * @return boolean
     * @author xuan
     * @date 2020/8/28 10:13
     */
    public static boolean setIfAbsent(String key, String value, int expireTime, TimeUnit timeUnit) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Boolean aBoolean = valueOperations.setIfAbsent(key, value, expireTime, timeUnit);
        return null == aBoolean ? false : aBoolean;
    }

    /**
     * 加锁  默认10s
     *
     * @param key   seckillId
     * @param value 当前时间+超时时间 currentTimeMillis
     * @return
     */
    public static boolean lock(String key, String value) {
        // 可以设置返回true
        Boolean isLock = redisTemplate.opsForValue().setIfAbsent(key, value, 10, TimeUnit.SECONDS);
        if (isLock != null && isLock) {//不存在
            return true;
        }
        return false;
    }

    /**
     * 加锁
     *
     * @param key        seckillId
     * @param value      当前时间+超时时间 currentTimeMillis
     * @param expireTime 有效期
     * @param timeUnit   时间单位
     * @return
     */
    public static boolean lock(String key, String value, int expireTime, TimeUnit timeUnit) {
        // 可以设置返回true
        Boolean isLock = redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, timeUnit);
        if (isLock != null && isLock) {
            //不存在
            return true;
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @return
     */
    public static void unlock(String key, String value) {
        try {
            Object currentValue = redisTemplate.opsForValue().get(key);
            if (currentValue != null && !StringUtils.isEmpty(currentValue.toString())
                    && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            logger.error("redis分布式锁，解锁异常, {}", e);
        }

    }
    public static String lockWithTimeout(String key, String value, int expireTime, TimeUnit timeUnit) throws InterruptedException {
        while (true){
            Boolean isLock = redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, timeUnit);
            if (isLock != null && isLock) {
                return "";
            }else {
                Thread.sleep(1000);
            }
        }
    }

}
