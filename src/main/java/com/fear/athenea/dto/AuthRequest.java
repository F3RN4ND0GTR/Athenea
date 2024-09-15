/**
 * 
 */
package com.fear.athenea.dto;

/**
 * @author Usuario
 *
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}
