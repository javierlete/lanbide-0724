package com.ipartek.formacion.mf0492.modelos;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder // Genera una clase que construye objetos de tipo Usuario con métodos por cada campo
@Data
public class Usuario {
	private Long id;
	private String nickname;
	private String password;

	private final Map<String, String> errores = new HashMap<>();

	public void setNickname(String nickname) {
		if (nickname == null || nickname.trim().length() == 0) {
			errores.put("nickname", "Es obligatorio rellenar el nombre de usuario");
		}
		
		this.nickname = nickname;
	}
	
	public void setPassword(String password) {
		if (password == null || password.trim().length() == 0) {
			errores.put("password", "Es obligatorio rellenar la contraña de usuario");
		}
		
		this.password = password;
	}
}
