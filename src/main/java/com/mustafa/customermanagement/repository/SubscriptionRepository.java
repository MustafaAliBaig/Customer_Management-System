package com.mustafa.customermanagement.repository;

import com.mustafa.customermanagement.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
}
