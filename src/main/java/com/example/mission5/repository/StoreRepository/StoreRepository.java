package com.example.demo.repository.StoreRepository;

import com.example.demo.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID>, StoreRepositoryCustom {
}
