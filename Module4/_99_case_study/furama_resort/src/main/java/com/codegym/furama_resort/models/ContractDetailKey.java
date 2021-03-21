package com.codegym.furama_resort.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContractDetailKey implements Serializable {
    @Column(name = "contract_id")
    private String contractId;
    @Column(name = "attach_service_id")
    private int attachServiceId;

    public ContractDetailKey() {
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }
}
