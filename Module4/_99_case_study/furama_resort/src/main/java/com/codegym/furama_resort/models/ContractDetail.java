package com.codegym.furama_resort.models;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @EmbeddedId
    private ContractDetailKey id;

    @ManyToOne
    @MapsId("contractId")
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @MapsId("attachServiceId")
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    private int quantity;

    public ContractDetail() {
    }

    public ContractDetailKey getId() {
        return id;
    }

    public void setId(ContractDetailKey id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
