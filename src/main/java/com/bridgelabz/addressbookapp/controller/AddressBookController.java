package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.services.AddressBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);
    @Autowired
    AddressBookService addressBookService;

    //To get all the addresses stored in the database
    @GetMapping("/getall")
    public List<AddressBookDto> getAllAddress(){
        logger.info("All address endpoint called ");
        return addressBookService.getAllAddresses();
    }

    //To get the address by id
    @GetMapping("/get/{id}")
    public AddressBookDto getAddressById(@PathVariable Long id){
        logger.info("By id address endpoint called ");
        return addressBookService.getAddressById(id);
    }

    //To store the new address in database
    @PostMapping("/create")
    public AddressBook saveAddress(@RequestBody AddressBook addressBook){
        logger.info("Create address endpoint called ");
        return addressBookService.addAddress(addressBook);
    }

    //To update the existing address in the database
    @PutMapping("/update/{id}")
    public AddressBookDto updateAddress(@PathVariable Long id, @RequestBody AddressBook addressBook){
        logger.info("update address end point called");
        return addressBookService.updateAddress(id,addressBook);
    }

    //To delete the address from db
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteAddress(@PathVariable Long id){
        logger.info("Delete address end point called");
        return addressBookService.deleteAddressById(id);
    }
}
