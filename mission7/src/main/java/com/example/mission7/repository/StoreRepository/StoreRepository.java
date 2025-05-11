package com.example.mission7.repository.StoreRepository;

import com.example.mission7.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID>, StoreRepositoryCustom {
}
