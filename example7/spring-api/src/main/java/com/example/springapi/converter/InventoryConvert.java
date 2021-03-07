package com.example.springapi.converter;

import com.example.springapi.dto.InventoryDTO;
import com.example.springapi.dto.ProductDTO;
import com.example.springapi.entity.Inventory;
import com.example.springapi.entity.Product;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Component
public class InventoryConvert {
    public InventoryDTO entityToDto(Inventory inventory) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inventory, InventoryDTO.class);
    }

    public Inventory dtoToEntity(InventoryDTO inventoryDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(inventoryDTO, Inventory.class);
    }


}
