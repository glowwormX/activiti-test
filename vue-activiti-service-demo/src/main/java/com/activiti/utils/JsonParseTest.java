package com.activiti.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * @author xqw
 * @description:
 * @date 2020/6/3
 */
public class JsonParseTest {

    public static void main(String[] args) {
        new JsonParseTest().parseObjectTest3();
    }

    /**
     * json 转对象
     * json转对象：ClassHome(className=九三班, woman=Woman(beauty=非常漂亮), man=Man(house=价值200万的房子))
     */
    public void parseObjectTest() {
        String source = "{\n" +
                "\t\"className\": \"九三班\",\n" +
                "\t\"woman\": {\n" +
                "\t\t\"beauty\": \"非常漂亮\",\n" +
                "\t\t\"name\": \"谢静静\",\n" +
                "\t\t\"age\": \"20\",\n" +
                "\t\t\"type\": \"WOMAN\"\n" +
                "\t},\n" +
                "\t\"man\": {\n" +
                "\t\t\"house\": \"价值200万的房子\",\n" +
                "\t\t\"name\": \"谢静静\",\n" +
                "\t\t\"age\": \"20\",\n" +
                "\t\t\"type\": \"MAN\"\n" +
                "\t}\n" +
                "}";

        ClassHome slassHome = JSONObject.parseObject(source, ClassHome.class);
        System.out.println("json转对象：" + slassHome);
    }


    /**
     * json 转对象
     * <p>
     * woman Woman(beauty=非常漂亮)
     * <p>
     * 父类转之类失败
     * <p>
     * java.lang.ClassCastException: com.lcc.fastjson.Person cannot be cast to com.lcc.fastjson.Woman
     */
    public void parseObjectTest2() {
        String source = "{\n" +
                "\t\"className\": \"九三班\",\n" +
                "\t\"woman\": {\n" +
                "\t\t\"beauty\": \"非常漂亮\",\n" +
                "\t\t\"name\": \"谢静静\",\n" +
                "\t\t\"age\": \"20\",\n" +
                "\t\t\"type\": \"WOMAN\"\n" +
                "\t},\n" +
                "\t\"man\": {\n" +
                "\t\t\"house\": \"价值200万的房子\",\n" +
                "\t\t\"name\": \"谢静静\",\n" +
                "\t\t\"age\": \"20\",\n" +
                "\t\t\"type\": \"MAN\"\n" +
                "\t}\n" +
                "}";


        ClassHome slassHome = JSONObject.parseObject(source, ClassHome.class);
        System.out.println("json转对象：" + slassHome);
        // 不对啊  我的数据呢
        Woman woman = (Woman) slassHome.getWoman();
        System.out.println("woman" + woman);
    }


    /**
     * 特定的序列化
     */
    public void parseObjectTest3() {
        ParserConfig globalInstance = ParserConfig.getGlobalInstance();
        globalInstance.putDeserializer(Person.class, new PersonDeserializer());

        String source = "{\n" +
                "\t\"className\": \"九三班\",\n" +
                "\t\"woman\": {\n" +
                "\t\t\"beauty\": \"非常漂亮\",\n" +
                "\t\t\"name\": \"谢静静\",\n" +
                "\t\t\"age\": \"20\",\n" +
                "\t\t\"type\": \"WOMAN\"\n" +
                "\t},\n" +
                "\t\"man\": {\n" +
                "\t\t\"house\": \"价值200万的房子\",\n" +
                "\t\t\"name\": \"谢静静\",\n" +
                "\t\t\"age\": \"20\",\n" +
                "\t\t\"type\": \"MAN\"\n" +
                "\t}\n" +
                "}";

        ClassHome slassHome = JSONObject.parseObject(source, ClassHome.class);
        System.out.println("json转对象：" + slassHome);
        // 不对啊  我的数据呢
        Woman woman = (Woman) slassHome.getWoman();
        // woman Woman(beauty=非常漂亮)
        System.out.println("woman:" + woman);

        // 这里有个注意点  想获取子类的需要调用才能看到
        System.out.println("woman:" + woman.getName());

    }


    /**
     * Description:
     *
     * @author: lcc
     * Version: 1.0
     * Create Date Time: 2019-07-05 12:05.
     * Update Date Time:
     */
    public static class PersonDeserializer implements ObjectDeserializer {

        private static final String CONN_TYPE = "type";

        @Override
        public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
            JSONObject jsonObj = parser.parseObject();
            String personType = jsonObj.getString(CONN_TYPE);


            Person connectParam;
            switch (personType) {
                case "WOMAN":
                    connectParam = jsonObj.toJavaObject(Woman.class);
                    break;
                case "MAN":
                    connectParam = jsonObj.toJavaObject(Man.class);
                    break;
                default:
                    throw new IllegalArgumentException("not support connector type found");
            }
            return (T) connectParam;

        }

        @Override
        public int getFastMatchToken() {
            return 0;
        }
    }

    @Data
    public static class Person {
        private String name;
        private String age;

        private String type;
    }


    @Data
    public static class Man extends Person {

        private String house;
    }

    @Data
    public static class Woman extends Person {

        private String beauty;
    }


    @Data
    public static class ClassHome {

        private String className;

        private Person woman;
        private Person man;

    }


}
