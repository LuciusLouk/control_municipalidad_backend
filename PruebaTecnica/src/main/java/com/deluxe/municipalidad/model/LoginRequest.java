package com.deluxe.municipalidad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor @AllArgsConstructor
public class LoginRequest {
	String username;
	String password;
}
