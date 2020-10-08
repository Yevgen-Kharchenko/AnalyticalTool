package com.analyticTool.model;

public class ServiceDTO {
    int serviceId;
    int variationId;

    public ServiceDTO() {
        this.serviceId = 0;
        this.variationId = 0;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                '}';
    }
}
