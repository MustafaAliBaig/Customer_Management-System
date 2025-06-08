package com.mustafa.customermanagement.service;

import com.mustafa.customermanagement.model.Subscription;
import com.mustafa.customermanagement.repository.SubscriptionRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> findAll(){
        return subscriptionRepository.findAll();
    }

    public Subscription save(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }
    public Optional<Subscription> findById(String id){
        return subscriptionRepository.findById(id);
    }
    public Optional<Subscription> update(String id,Subscription subscription) {
        return subscriptionRepository.findById(id).map(existing -> {
            existing.setPlanType(subscription.getPlanType());
            existing.setPrice(subscription.getPrice());
            return subscriptionRepository.save(existing);
        });
    }
    public boolean delete (String id){
        if(subscriptionRepository.existsById(id)){
            subscriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
