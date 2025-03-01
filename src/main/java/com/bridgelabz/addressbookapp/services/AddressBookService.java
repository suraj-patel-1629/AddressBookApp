package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepo addressBookRepository;

    public List<AddressBookDto> getAllAddresses(){

        List<AddressBook> adB= addressBookRepository.findAll();
        List<AddressBookDto> adDto =adB.stream().map(addresses->new AddressBookDto(addresses.getName(),addresses.getPhoneNo(),addresses.getEmail(),addresses.getAddress())).collect(Collectors.toList());
        return adDto;
    }

    //get address by id
    public AddressBookDto getAddressById(Long id) {
        return addressBookRepository.findById(id)
                .map(adB -> new AddressBookDto(adB.getName(), adB.getPhoneNo(), adB.getEmail(), adB.getAddress()))
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
            addressBook.setEmail(updateAddressBook.getEmail());
            AddressBook adB= addressBookRepository.save(addressBook);
            AddressBookDto adDto= new AddressBookDto(adB.getName(), adB.getPhoneNo(), adB.getEmail(), adB.getAddress());
            return adDto;
        }
        else{
            return  null;
        }
    }

    //Delete Address
    public String deleteAddressById(Long id){
        Optional<AddressBook> optionalAddressBook = addressBookRepository.findById(id);
        if(optionalAddressBook.isPresent()) {
            addressBookRepository.deleteById(id);
            return "Address Delete Successful";
        }
        else{
            return null;
        }
    }
}
