package com.quanglv.utils.customError;

import com.quanglv.constant.Constants;
import org.zalando.problem.AbstractThrowableProblem;

import java.util.*;

public class CustomRestException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 2773490240923183518L;

    private static final String ERRORS_NAME = "errors";

    /**
     * The extensions
     */
    private Map<String, Object> attributes;

    public CustomRestException(Map<String, Object> errorsItem) {
        if (errorsItem.get(ERRORS_NAME) == null) {
            List<Map<String, Object>> errList = new ArrayList<>();
            errList.add(errorsItem);
            this.attributes = new HashMap<>();
            this.attributes.put(ERRORS_NAME, errList);
        } else {
            this.attributes = errorsItem;
        }
    }

    /**
     * Constructor
     * 
     * @param message the message error
     * @param errorsItem Map error
     */
    public CustomRestException(String message, Map<String, Object> errorsItem) {
        this.attributes = new LinkedHashMap<>();
        List<Map<String, Object>> errList = new ArrayList<>();
        if (errorsItem != null && errorsItem.get(Constants.ROW_ID) != null) {
            errorsItem.put(Constants.ROW_ID, Double.valueOf(errorsItem.get(Constants.ROW_ID).toString()).longValue());
        }
        errList.add(errorsItem);
        attributes.put(ERRORS_NAME, errList);
    }

    /**
     * Constructor
     * 
     * @param message the message error
     * @param errorsItems Map error
     */
    public CustomRestException(String message, List<Map<String, Object>> errorsItems) {
        this.attributes = new LinkedHashMap<>();
        if (errorsItems != null) {
            for (Map<String, Object> item : errorsItems) {
                if (item.get(Constants.ROW_ID) != null) {
                    item.put(Constants.ROW_ID, Double.valueOf(item.get(Constants.ROW_ID).toString()).longValue());
                }
            }
        }
        attributes.put(ERRORS_NAME, errorsItems);
    }

    public CustomRestException() {

    }

    /**
     * @See graphql.GraphQLError.getExtensions()
     */
    public Map<String, Object> getExtensions() {
        return this.attributes;
    }

    public void setExtensions(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
