package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepo addressBookRepository;

    public List<AddressBookDto> getAllAddresses(){

        List<AddressBook> adB= addressBookRepository.findAll();
        List<AddressBookDto> adDto =adB.stream().map(addresses->new AddressBookDto(addresses.getId(),addresses.getName(),addresses.getPhoneNo(),addresses.getAddress(),addresses.getCity(),addresses.getState(),addresses.getZipcode())).collect(Collectors.toList());
        return adDto;
    }

    //get address by id
    public AddressBookDto getAddressById(Long id) {
        return addressBookRepository.findById(id)
                .map(adB -> new AddressBookDto(adB.getId(),adB.getCity(),adB.getState(),adB.getZipcode(),adB.getName(), adB.getPhoneNo(),  adB.getAddress()))
                .orElseThrow(() -> new RuntimeException("AddressBook entry not found for ID: " + id));
    }


    //save the address
    public AddressBook addAddress(AddressBook addressBook){
        return addressBookRepository.save(addressBook);
    }

    //Update address
    public AddressBookDto updateAddress(Long id, AddressBook updateAddressBook){
        Optional<AddressBook> optionalAddressBook = addressBookRepository.findById(id);
        if(optionalAddressBook.isPresent()){
            AddressBook addressBook = optionalAddressBook.get();
            addressBook.setName(updateAddressBook.getName());
            addressBook.setAddress(updateAddressBook.getAddress());
            addressBook.setPhoneNo(updateAddressBook.getPhoneNo());

            AddressBook addresses= addressBookRepository.save(addressBook);
            AddressBookDto adDto= new AddressBookDto(addresses.getId(),addresses.getName(),addresses.getPhoneNo(),addresses.getAddress(),addresses.getCity(),addresses.getState(),addresses.getZipcode());
            return adDto;
        }
        else{
            return  null;
        }
    }

    //Delete Address
    public ResponseEntity<Map<String, String>> deleteAddressById(Long id) {
        Optional<AddressBook> optionalAddressBook = addressBookRepository.findById(id);

        Map<String, String> response = new HashMap<>();

        if (optionalAddressBook.isPresent()) {
            addressBookRepository.deleteById(id);
            response.put("message", "Address Delete Successful");
            return ResponseEntity.ok(response); // Returns JSON response
        } else {
            response.put("error", "Address not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
