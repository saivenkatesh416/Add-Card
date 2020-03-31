package com.finances.addcard.Controller;

import com.finances.addcard.Entity.AddCardEntity;
import com.finances.addcard.Model.AddCardRequestResponse;
import com.finances.addcard.Service.AddCardsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/finances/")
@Api(tags = "Cards")
public class AddCardController {

    @Autowired
    AddCardsService addCardsService;

    private Logger logger = Logger.getLogger(AddCardController.class);

    @ApiOperation(value = "Add Card to Database")
    @PostMapping(value = "/addCard")
    @ResponseBody
    public ResponseEntity<String> addCard(@RequestBody AddCardRequestResponse addCardRequestResponse) {
        logger.info("Inside addCard Method");
        try {
            boolean savedData = addCardsService.addCard(addCardRequestResponse);
            if (savedData) {
                return new ResponseEntity("Card Added", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity("card not added", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("card already Present", HttpStatus.CREATED);

    }

    @ApiOperation(value = "get Card's from Database")
    @GetMapping(value = "/getCards")
    @ResponseBody
    public ResponseEntity<List<AddCardEntity>> getCards() {
        logger.info("Inside getCards Method");

        List<AddCardEntity> response = addCardsService.getCards();

        if (response != null)
            return new ResponseEntity(response, HttpStatus.OK);
        else
            return new ResponseEntity("Sorry the Card is not Added", HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "get Card from Database")
    @GetMapping(value = "/getCardBy/{name}")
    @ResponseBody
    public ResponseEntity<AddCardEntity> getCardByName(@PathVariable("name") String name) {
        Optional<AddCardEntity> response = addCardsService.getCardByName(name);
        if (response != null)
            return new ResponseEntity(response, HttpStatus.OK);
        else
            return new ResponseEntity("Sorry this card does not exist", HttpStatus.NOT_FOUND);
    }
}
