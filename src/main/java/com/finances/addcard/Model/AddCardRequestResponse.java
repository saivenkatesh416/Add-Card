package com.finances.addcard.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddCardRequestResponse {
    @NotEmpty(message = "First Name must not be empty")
    @JsonProperty("name")
    private String Name;

    @JsonProperty("bank")
    private String Bank;

    @JsonProperty("cardType")
    private String CardType;

    @JsonProperty("cardNo")
    private String CardNumber;

    @JsonProperty("limit")
    private String Limit;

    @JsonProperty("amountUsed")
    private String AmountUsed;

    @JsonProperty("overDraftMoney")
    private String overDraftMoney;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getLimit() {
        return Limit;
    }

    public void setLimit(String limit) {
        Limit = limit;
    }

    public String getAmountUsed() {
        return AmountUsed;
    }

    public void setAmountUsed(String amountUsed) {
        AmountUsed = amountUsed;
    }

    public String getOverDraftMoney() {
        return overDraftMoney;
    }

    public void setOverDraftMoney(String overDraftMoney) {
        this.overDraftMoney = overDraftMoney;
    }


    }




