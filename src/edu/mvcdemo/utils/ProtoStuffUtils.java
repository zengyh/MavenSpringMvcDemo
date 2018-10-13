package edu.mvcdemo.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-12 下午10:43:26
 * @文件描述: 序列化和反序列化工具类
 */
public class ProtoStuffUtils {

	/**
	 * 序列化对象
	 * @param o
	 * @return
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> byte[] serializer(T o) {
        Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));
    }
 
    /**
     * 反序列化对象
     * @param bytes
     * @param clazz
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T deserializer(byte[] bytes, Class<T> clazz) {
 
        T obj = null;
        try {
            obj = clazz.newInstance();
            Schema schema = RuntimeSchema.getSchema(obj.getClass());
            ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
 
        return obj;
    }


}
