package com.japhy.sample.security.web.interfaces.http;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/8 13:58
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
@Tag(name = "demo")
public class DemoApi {

    @Operation(summary = " PreAuthorize hasRole ADMIN")
    @GetMapping("/preAuthorize/hasRole")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> hasRole() {
        return ResponseEntity.ok("@PreAuthorize(\"hasRole('ADMIN')\")");
    }

    @Operation(summary = "RolesAllowed ADMIN")
    @GetMapping("/rolesAllowed/admin")
    @RolesAllowed("ADMIN")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<String> rolesAllowed() {
        return ResponseEntity.ok("@RolesAllowed(\"ADMIN\")");
    }

    @Operation(summary = "PreAuthorize hasAuthority ROLE_ADMIN")
    @GetMapping("/preAuthorize/hasAuthority")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> hasAuthority(Principal principal) {
        return ResponseEntity.ok("PreAuthorize hasAuthority ROLE_ADMIN");
    }

    @Operation(summary = "PreAuthorize id", description = "authentication.name 为jwt中sub字段")
    @GetMapping("/preAuthorize/id")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("#id == authentication.name")
    public ResponseEntity<String> hasAuthority(String id) {
        return ResponseEntity.ok("PreAuthorize id: " + id);
    }

}
