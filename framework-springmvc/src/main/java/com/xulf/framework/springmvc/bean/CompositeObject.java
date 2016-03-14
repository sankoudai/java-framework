package com.xulf.framework.springmvc.bean;

import java.util.Map;

/**
 * Created by xuliufeng on 2016/1/21.
 */
public class CompositeObject {
    private Integer id;
    private SimpleObject simpleObject;
    private Map<String, String> mapObject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SimpleObject getSimpleObject() {
        return simpleObject;
    }

    public void setSimpleObject(SimpleObject simpleObject) {
        this.simpleObject = simpleObject;
    }

    public Map<String, String> getMapObject() {
        return mapObject;
    }

    public void setMapObject(Map<String, String> mapObject) {
        this.mapObject = mapObject;
    }

    @Override
    public String toString() {
        return "CompositeObject{" +
                        "id=" + id +
                        ", simpleObject=" + simpleObject +
                        ", mapObject=" + mapObject +
                        '}';
    }
}
