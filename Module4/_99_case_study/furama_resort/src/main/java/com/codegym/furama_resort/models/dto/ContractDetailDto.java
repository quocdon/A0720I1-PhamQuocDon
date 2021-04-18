package com.codegym.furama_resort.models.dto;

import com.codegym.furama_resort.models.AttachService;
import com.codegym.furama_resort.models.Contract;
import sun.awt.image.ImageWatched;

import javax.validation.constraints.Min;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContractDetailDto {
    private Contract contract;
    private Map<AttachService, Integer> attachServices = new LinkedHashMap<>();

    public ContractDetailDto() {
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Map<AttachService, Integer> getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(Map<AttachService, Integer> attachServices) {
        this.attachServices = attachServices;
    }
}
