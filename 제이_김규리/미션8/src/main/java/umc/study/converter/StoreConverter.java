package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toEntity(String name, Region region) {
        return Store.builder()
                .name(name)
                .region(region)
                .build();
    }

    public static StoreResponseDTO toDTO(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .regionId(store.getRegion().getId())
                .build();
    }
}