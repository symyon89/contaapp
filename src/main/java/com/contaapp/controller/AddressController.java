package com.contaapp.controller;

import com.contaapp.dto.AddressDto;
import com.contaapp.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressesService;

    public AddressController(AddressService addressesService) {
        this.addressesService = addressesService;
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        List<AddressDto> address = addressesService.findAll();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable UUID id) {
        AddressDto addressDto = addressesService.findById(id);
        return new ResponseEntity<>(addressDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
        AddressDto responseAddressDto = addressesService.add(addressDto);
        return new ResponseEntity<>(responseAddressDto,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDto) {
        AddressDto responseAddressDto = addressesService.update(addressDto);
        return new ResponseEntity<>(responseAddressDto,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable UUID id) {
        addressesService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
