package com.robzyy.Collecta_server.api;

import com.robzyy.Collecta_server.models.FrequencyType;
import com.robzyy.Collecta_server.models.RecurrencePattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.robzyy.Collecta_server.models.Membership;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class Memberships {

    private final List<Membership> ms = new ArrayList<>(List.of(
            new Membership("Spotify", "Family plan", new Date(), new RecurrencePattern(FrequencyType.monthly, 1, 4, new Date()), 12.99, "USD", "Robzyy"),
            new Membership("Netflix", "Premium plan", new Date(), new RecurrencePattern(FrequencyType.monthly, 1, 4, new Date()), 15.59, "USD", "Robzyy")
    ));

    @GetMapping
    public List<Membership> getAllMemberships() {
        return ms;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembershipById(@PathVariable String id) {
        Membership membership = ms.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (membership != null) {
            return ResponseEntity.ok(membership);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
