package com.finances.addcard.Service;

import com.finances.addcard.Entity.AddCardEntity;
import com.finances.addcard.Model.AddCardRequestResponse;
import com.finances.addcard.Repository.AddCardRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddCardsService {

    private Logger logger = Logger.getLogger(AddCardsService.class);


    @Autowired
    AddCardRepository addCardRepository;

    public boolean addCard(AddCardRequestResponse addCardRequestResponse) {
        Optional<AddCardEntity> card = getCardByName(addCardRequestResponse.getName());

        if (addCardRequestResponse != null && !card.isPresent()) {
            AddCardEntity entity = new AddCardEntity();
            entity.setId(addCardRequestResponse.getName());
            entity.setName(addCardRequestResponse.getName());
            entity.setAmountUsed(addCardRequestResponse.getAmountUsed());
            entity.setBank(addCardRequestResponse.getBank());
            entity.setCardNumber(addCardRequestResponse.getCardNumber());
            entity.setCardType(addCardRequestResponse.getCardType());
            entity.setOverDraftMoney(addCardRequestResponse.getOverDraftMoney());
            entity.setLimit(addCardRequestResponse.getLimit());

            try {
                addCardRepository.save(entity);
                return true;
            } catch (Exception e) {
                logger.info("Error Occurred during saving the data. Exception is: ", e);
            }
        }
        return false;
    }

    public List<AddCardEntity> getCards() {
        List<AddCardEntity> response = new ArrayList<>();
        try {
            response = addCardRepository.findAll();
        } catch (Exception e) {
            logger.info("Errored Amma. Exception is: ", e);
        }

        return response;
    }

    public Optional<AddCardEntity> getCardByName(String name) {
        Optional<AddCardEntity> response = null;

        try {
            response = addCardRepository.findByName(name);
        } catch (Exception e) {
            logger.info("Errored Amma. Exception is: ", e);
        }
        return response;
    }

}
