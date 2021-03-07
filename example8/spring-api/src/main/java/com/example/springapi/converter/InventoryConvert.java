package com.example.springapi.converter;

import com.example.springapi.dto.InventoryDTO;
import com.example.springapi.entity.Inventory;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


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
