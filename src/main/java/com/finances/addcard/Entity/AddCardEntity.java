package com.finances.addcard.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "cards")
public class AddCardEntity {

    @Id
    private String id;

    private String name;

    private String bank;

    private String cardType;

    private String cardNumber;

    private String limit;

    private String amountUsed;

    private String overDraftMoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(String amountUsed) {
        this.amountUsed = amountUsed;
    }

    public String getOverDraftMoney() {
        return overDraftMoney;
    }

    public void setOverDraftMoney(String overDraftMoney) {
        this.overDraftMoney = overDraftMoney;
    }
}
